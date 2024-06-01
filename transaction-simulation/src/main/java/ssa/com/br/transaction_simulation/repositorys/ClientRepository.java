package ssa.com.br.transaction_simulation.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssa.com.br.transaction_simulation.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByNumeroConta(String conta);
}
