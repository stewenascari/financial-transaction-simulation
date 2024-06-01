package ssa.com.br.transaction_simulation.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ssa.com.br.transaction_simulation.enums.TypeTransaction;
import ssa.com.br.transaction_simulation.enums.TypeTransactionEnumConvert;

import java.time.LocalDateTime;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Table(name = "tb_transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Client cliente;

    @Column(name = "descricao")
    private String descricao;

    @Convert(converter = TypeTransactionEnumConvert.class)
    @Column(name = "tipo_transacao")
    private TypeTransaction tipo; // "DEBITO" ou "CREDITO"

    @Column(name = "valor")
    private Double valor;

    @Column(name = "data_transacao")
    private LocalDateTime data;
}