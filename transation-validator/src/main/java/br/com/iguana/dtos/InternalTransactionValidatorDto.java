package br.com.iguana.dtos;

import br.com.iguana.entities.InternalTransactionValidator;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InternalTransactionValidatorDto {

    @JsonbProperty("operation_id")
    private Long operationId;

    @JsonbProperty("is_valid")
    private Boolean isValid;

    @JsonbProperty("key")
    private String key;


    public static List<InternalTransactionValidatorDto> build(List<InternalTransactionValidator> transactionValidators) {
        if (Objects.isNull(transactionValidators)) {
            return List.of();
        }
        return transactionValidators.stream().map(b -> new InternalTransactionValidatorDto().build(b))
                .collect(Collectors.toList());
    }

    public static InternalTransactionValidatorDto build(InternalTransactionValidator transactionValidator) {
        InternalTransactionValidatorDto dto = new InternalTransactionValidatorDto();
        dto.setOperationId(transactionValidator.operationId);
        dto.setKey(transactionValidator.key);
        dto.setValid(transactionValidator.isValid);
        return dto;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
