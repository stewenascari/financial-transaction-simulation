package ssa.com.br.transaction_simulation.services;

import ssa.com.br.transaction_simulation.dtos.ClientRequestDTO;
import ssa.com.br.transaction_simulation.dtos.ClientResponseDTO;
import ssa.com.br.transaction_simulation.entities.Client;

public interface ClientService {
    ClientResponseDTO insert(ClientRequestDTO dto);

    ClientResponseDTO getById(Long id);

    ClientResponseDTO getByConta(String conta);

    void delete(Long id);

    Client findById(Long id);

    Client findByIdAndUpdateBalance(Long clientId, String typeTransaction, Double valor);

    ClientResponseDTO update(Long id, ClientRequestDTO dto);
}
