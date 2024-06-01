package ssa.com.br.transaction_simulation.exceptions;

import org.springframework.http.HttpStatus;

public abstract class TransactionSimulationAbstractRuntimeException extends RuntimeException {

    public TransactionSimulationAbstractRuntimeException() {
        super();
    }

    public TransactionSimulationAbstractRuntimeException(String message) {
        super(message);
    }

    public TransactionSimulationAbstractRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract HttpStatus getStatus();
}