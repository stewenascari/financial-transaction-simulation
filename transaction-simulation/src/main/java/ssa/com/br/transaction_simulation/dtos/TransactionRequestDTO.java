package ssa.com.br.transaction_simulation.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Builder
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequestDTO {

    @NotNull
    @JsonProperty("id_cliente")
    private Long idCliente;

    @NotNull
    @JsonProperty("tipo")
    private String tipo;

    @NotNull
    @JsonProperty("descricao")
    private String descricao;

    @NotNull
    @JsonProperty("valor")
    private Double valor;

    @NotNull
    @JsonProperty("data")
    private LocalDateTime data;
}
