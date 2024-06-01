package ssa.com.br.transaction_simulation.dtos;

import ssa.com.br.transaction_simulation.entities.Transaction;
import ssa.com.br.transaction_simulation.enums.TypeTransaction;

import java.util.Optional;

public class TransactionConvert {

    public static TransactionResponseDTO toDto(Transaction entity) {
        return TransactionResponseDTO.builder()
                .id(entity.getId())
                .idCliente(entity.getCliente().getId())
                .tipo(Optional.ofNullable(entity.getTipo())
                        .map(TypeTransaction::getDescription)
                        .orElse(null))
                .valor(entity.getValor())
                .descricao(entity.getDescricao())
                .data(entity.getData())
                .build();
    }

    public static TransactionResponseDTO toDto(Transaction entity, Double saldoAtualizado) {
        return TransactionResponseDTO.builder()
                .id(entity.getId())
                .idCliente(entity.getCliente().getId())
                .tipo(Optional.ofNullable(entity.getTipo())
                        .map(TypeTransaction::getDescription)
                        .orElse(null))
                .valor(entity.getValor())
                .descricao(entity.getDescricao())
                .saldo(saldoAtualizado)
                .data(entity.getData())
                .build();
    }

    public static Transaction toDto(TransactionRequestDTO transactionRequestDTO) {
        var entity = new Transaction();

        entity.setTipo(Optional.ofNullable(transactionRequestDTO.getTipo())
                .map(TypeTransaction::fromDescription)
                .orElse(null));
        entity.setDescricao(transactionRequestDTO.getDescricao());
        entity.setValor(transactionRequestDTO.getValor());
        entity.setData(transactionRequestDTO.getData());

        return entity;

    }
}