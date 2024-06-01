package ssa.com.br.transaction_simulation.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Builder
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("idade")
    private Integer idade;

    @JsonProperty("email")
    private String email;

    @JsonProperty("saldo")
    private Double saldo;

    @JsonProperty("numero_conta")
    private String numeroConta;

    @JsonProperty("transacoes")
    private List<TransactionResponseDTO> transactions;
}