package br.com.iguana.enums;

import br.com.iguana.exceptions.BusinessException;

public enum OperationStatus {
    OPEN(1, "Open"),
    DONE(2, "Done"),
    BLOCKED(3, "Blocked"),
    CANCELED(4, "Canceled");

    public static final String INVALID_CODE = "Invalid code to OperationStatus. Code = ";

    private Integer code;
    private String description;

    OperationStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static OperationStatus toEnum(Integer cod) {
        for (OperationStatus p : OperationStatus.values()) {
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
