package ssa.com.br.transaction_simulation.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Builder
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDTO {

    @NotNull
    @JsonProperty("nome")
    private String nome;

    @NotNull
    @JsonProperty("idade")
    private Integer idade;

    @NotNull
    @JsonProperty("email")
    private String email;

    @JsonProperty("saldo")
    private Double saldo;

    @NotNull
    @JsonProperty("numero_conta")
    private String conta;
}
