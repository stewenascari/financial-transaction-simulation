package ssa.com.br.transaction_simulation.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException  extends TransactionSimulationAbstractRuntimeException {

    public ResourceNotFoundException(String notFoundMessage) {
        super("Recurso não encontrado. " + notFoundMessage);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
