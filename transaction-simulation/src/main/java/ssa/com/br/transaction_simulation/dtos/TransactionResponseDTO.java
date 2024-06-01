package ssa.com.br.transaction_simulation.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("id_cliente")
    private Long idCliente;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("valor")
    private Double valor;

    @JsonProperty("saldo_atualizado")
    private Double saldo;

    @JsonProperty("data")
    private LocalDateTime data;

}