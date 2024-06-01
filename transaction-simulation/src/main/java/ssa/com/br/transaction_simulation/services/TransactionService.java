package ssa.com.br.transaction_simulation.services;

import ssa.com.br.transaction_simulation.dtos.TransactionRequestDTO;
import ssa.com.br.transaction_simulation.dtos.TransactionResponseDTO;

import java.util.List;

public interface TransactionService {

    TransactionResponseDTO insert(TransactionRequestDTO transacao);
    List<TransactionResponseDTO> getById(Long clienteId);
}
