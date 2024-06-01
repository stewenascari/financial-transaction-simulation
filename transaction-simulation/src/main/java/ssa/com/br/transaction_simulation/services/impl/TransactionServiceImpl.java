package ssa.com.br.transaction_simulation.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssa.com.br.transaction_simulation.dtos.TransactionConvert;
import ssa.com.br.transaction_simulation.dtos.TransactionRequestDTO;
import ssa.com.br.transaction_simulation.dtos.TransactionResponseDTO;
import ssa.com.br.transaction_simulation.repositorys.TransactionRepository;
import ssa.com.br.transaction_simulation.services.ClientService;
import ssa.com.br.transaction_simulation.services.TransactionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl  implements TransactionService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private TransactionRepository repository;
    @Override
    public TransactionResponseDTO insert(TransactionRequestDTO dto) {
        var entity = TransactionConvert.toDto(dto);
        var clientEntity = clientService.findByIdAndUpdateBalance(dto.getIdCliente(), dto.getTipo(), dto.getValor());

        entity.setCliente(clientEntity);

        return Optional.ofNullable(entity)
                .map(repository::save)
                .map(requestDTO -> TransactionConvert.toDto(requestDTO, clientEntity.getSaldo()))
                .orElseThrow();

    }

    @Override
    public List<TransactionResponseDTO> getById(Long clienteId) {
        return repository.findByClienteId(clienteId).stream()
                .map(TransactionConvert::toDto).collect(Collectors.toList());
    }
}
