package ssa.com.br.transaction_simulation.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "email")
    private String email;

    @Column(name = "saldo")
    private Double saldo;

    @Column(name = "numero_conta")
    private String numeroConta;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Transaction> transactionList;
}
