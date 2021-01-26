package br.com.iguana.services.external.Dtos;

import javax.json.bind.annotation.JsonbProperty;

public class InternalTransactionValidatorCreateDto {

    @JsonbProperty("operation_id")
    private Long operationId;

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }
}
