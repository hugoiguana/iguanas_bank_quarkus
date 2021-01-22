package br.com.iguana.enums;

import br.com.iguana.exceptions.BusinessException;

public enum OperationDepositType {
    AGENCY(1, "Agency Bank"),
    ATM(2, "ATM"),
    MOBILE_DEVICES(3, "Mobile Devices"),
    INTERNET_BANKING(4, "Internet Banking");

    public static final String INVALID_CODE = "Invalid code to OperationMethod. Code = ";

    private Integer code;
    private String description;

    OperationDepositType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public static OperationDepositType toEnum(Integer cod) {
        for (OperationDepositType p : OperationDepositType.values()) {
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
