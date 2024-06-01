package ssa.com.br.transaction_simulation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssa.com.br.transaction_simulation.dtos.ClientConvert;
import ssa.com.br.transaction_simulation.dtos.ClientRequestDTO;
import ssa.com.br.transaction_simulation.dtos.ClientResponseDTO;
import ssa.com.br.transaction_simulation.entities.Client;
import ssa.com.br.transaction_simulation.enums.TypeTransaction;
import ssa.com.br.transaction_simulation.exceptions.ResourceNotFoundException;
import ssa.com.br.transaction_simulation.repositorys.ClientRepository;
import ssa.com.br.transaction_simulation.services.ClientService;
import ssa.com.br.transaction_simulation.services.TransactionService;

import java.util.Objects;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private TransactionService transactionService;
    @Override
    public ClientResponseDTO insert(ClientRequestDTO dto) {
        var entity = ClientConvert.toDto(dto);

        return Optional.ofNullable(entity)
                .map(repository::save)
                .map(ClientConvert::toDto)
                .orElseThrow();
    }

    @Override
    public ClientResponseDTO getById(Long id) {
        var entityClient = this.findById(id);
        var responseTransaction = transactionService.getById(id);

        var clientResponse = ClientConvert.toDto(entityClient);

        clientResponse.setTransactions(responseTransaction);

        return clientResponse;
    }

    @Override
    public ClientResponseDTO getByConta(String conta){
        var entityClient = repository.findByNumeroConta(conta);
        var responseTransaction = transactionService.getById(entityClient.getId());

        var clientResponse = ClientConvert.toDto(entityClient);

        clientResponse.setTransactions(responseTransaction);

        return clientResponse;
    }

    public Client findByIdAndUpdateBalance(Long clientId, String typeTransaction, Double valor){
        var entity = repository.findById(clientId).get();
        if (Objects.nonNull(entity.getSaldo()) && !entity.getSaldo().equals(0)){
            if(TypeTransaction.CRED.getDescription().equals(typeTransaction)) {
                entity.setSaldo(entity.getSaldo() + valor);
            }
            else{
                if(entity.getSaldo().compareTo(valor) > 0){
                    entity.setSaldo(entity.getSaldo() - valor);
                }
            }
        }

        repository.save(entity);

        return entity;
    }

    @Override
    public void delete(Long id){
        Optional.ofNullable(this.findById(id))
            .ifPresent(repository::delete);
    }

    @Override
    public ClientResponseDTO update(Long id, ClientRequestDTO dto) {
        return Optional.ofNullable(dto)
                .map(cadastro -> this.setNewData(id, cadastro))
                .map(repository::save)
                .map(ClientConvert::toDto)
                .orElseThrow();
    }

    private Client setNewData(Long id, ClientRequestDTO dto){
        var entity = this.findById(id);


        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setIdade(dto.getIdade());
        entity.setSaldo(dto.getSaldo());
        entity.setNumeroConta(dto.getConta());

        return entity;

    }
    public Client findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("[Cliente] id: " + id));
    }
}
