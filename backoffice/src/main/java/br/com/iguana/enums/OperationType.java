package br.com.iguana.enums;

import br.com.iguana.exceptions.BusinessException;

public enum OperationType {
    DEPOSITY(1, "Deposity"),
    TRANSFER(2, "Transfer"),
    PAYMENT(3, "Payment");

    public static final String INVALID_CODE = "Invalid code to OperationType. Code = ";

    private Integer code;
    private String description;

    OperationType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static OperationType toEnum(Integer cod) {
        for (OperationType p : OperationType.values()) {
            if (cod.equals(p.getCode())) {
                return p;
            }
        }
        throw new BusinessException(INVALID_CODE + cod);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
