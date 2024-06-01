package ssa.com.br.transaction_simulation.dtos;

import ssa.com.br.transaction_simulation.entities.Client;

public class ClientConvert {

    public static ClientResponseDTO toDto(Client entity) {
        return ClientResponseDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .saldo(entity.getSaldo())
                .idade(entity.getIdade())
                .numeroConta(entity.getNumeroConta())
                .build();
    }

    public static Client toDto(ClientRequestDTO clientRequestDTO) {
        var entity = new Client();

        entity.setNome(clientRequestDTO.getNome());
        entity.setEmail(clientRequestDTO.getEmail());
        entity.setIdade(clientRequestDTO.getIdade());
        entity.setSaldo(clientRequestDTO.getSaldo());
        entity.setNumeroConta(clientRequestDTO.getConta());

        return entity;

    }
}