package br.com.iguana.dtos;

import br.com.iguana.entities.BankInternalOperation;
import br.com.iguana.entities.UserSystem;
import br.com.iguana.enums.OperationMethod;
import br.com.iguana.enums.OperationType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Schema(description = "All Bank Internal Operations.")
public class BankInternalOperationDto {

    @JsonbProperty("id")
    private Long id;

    @JsonbProperty("creation_date")
    private LocalDateTime creationDate;

    @JsonbProperty("alteration_date")
    private LocalDateTime alterationDate;

    @Schema(required = true)
    @JsonbProperty("id_owner")
    private Long idOwner;

    @Schema(required = true)
    @JsonbProperty("id_beneficiary")
    private Long idBeneficiary;

    @Schema(required = true, example = "AGENCY=1,ATM=2,MOBILE_DEVICES=3,INTERNET_BANKING=4")
    @JsonbProperty("operation_method")
    private Integer operationMethod;

    @Schema(required = true)
    @JsonbProperty("operation_value")
    private BigDecimal operationValue;

    @Schema(required = true, example = "DEPOSITY=1,TRANSFER=2,PAYMENT=3")
    @JsonbProperty("operation_type")
    private Integer operationType;

    public static List<BankInternalOperationDto> build(List<BankInternalOperation> operations) {
        if (Objects.isNull(operations)) {
            return List.of();
        }
        return operations.stream().map(u -> new BankInternalOperationDto().build(u))
                .collect(Collectors.toList());
    }

    public static BankInternalOperationDto build(BankInternalOperation operation) {
        BankInternalOperationDto dto = new BankInternalOperationDto();
        dto.setId(operation.id);
        dto.setCreationDate(operation.creationDate);
        dto.setAlterationDate(operation.alterationDate);
        if (!Objects.isNull(operation.owner)) {
            dto.setIdOwner(operation.owner.id);
        }
        if (!Objects.isNull(operation.beneficiary)) {
            dto.setIdBeneficiary(operation.beneficiary.id);
        }
        dto.setOperationMethod(operation.operationMethod);
        dto.setOperationValue(operation.operationValue);
        dto.setOperationType(operation.operationType);
        return dto;
    }

    public BankInternalOperation buildEntity() {
        BankInternalOperation operation = new BankInternalOperation();
        operation.id = this.id;
        operation.owner = new UserSystem(this.idOwner);
        operation.beneficiary = new UserSystem(this.idBeneficiary);
        operation.operationMethod = OperationMethod.toEnum(this.operationMethod).getCode();
        operation.operationValue = this.operationValue;
        operation.operationType = OperationType.toEnum(this.operationType).getCode();
        return operation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getAlterationDate() {
        return alterationDate;
    }

    public void setAlterationDate(LocalDateTime alterationDate) {
        this.alterationDate = alterationDate;
    }

    public Long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Long idOwner) {
        this.idOwner = idOwner;
    }

    public Long getIdBeneficiary() {
        return idBeneficiary;
    }

    public void setIdBeneficiary(Long idBeneficiary) {
        this.idBeneficiary = idBeneficiary;
    }

    public Integer getOperationMethod() {
        return operationMethod;
    }

    public void setOperationMethod(Integer operationMethod) {
        this.operationMethod = operationMethod;
    }

    public BigDecimal getOperationValue() {
        return operationValue;
    }

    public void setOperationValue(BigDecimal operationValue) {
        this.operationValue = operationValue;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }
}
