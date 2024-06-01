package ssa.com.br.transaction_simulation.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply = true)
public class TypeTransactionEnumConvert implements AttributeConverter<TypeTransaction, String> {

    @Override
    public String convertToDatabaseColumn(TypeTransaction typeTransaction) {
        return Optional.ofNullable(typeTransaction)
                .map(TypeTransaction::getDescription)
                .orElse(null);
    }

    @Override
    public TypeTransaction convertToEntityAttribute(String description) {
        return Optional.ofNullable(description)
                .map(TypeTransaction::fromDescription)
                .orElse(null);
    }
}