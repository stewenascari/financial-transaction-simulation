package ssa.com.br.transaction_simulation.enums;

import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Arrays;

@Getter
public enum TypeTransaction {

    DEB("debito"),
    CRED("credito");

    private final String description;

    TypeTransaction(String description) {
        this.description = description;
    }

    public static TypeTransaction fromDescription(@NotNull String description) {
        return Arrays.stream(TypeTransaction.values())
                .filter(p -> p.getDescription().equals(description))
                .findFirst()
                .orElse(null);
    }
}