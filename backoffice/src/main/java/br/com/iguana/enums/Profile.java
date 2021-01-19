package br.com.iguana.enums;

import br.com.iguana.exceptions.BusinessException;

public enum Profile {
    ADMIN(1, "ROLE_ADMIN"),
    MANAGER(2, "ROLE_MANAGER"),
    CUSTOMER(3, "ROLE_CUSTOMER");

    public static final String INVALID_CODE = "Invalid code to Profile. Code = ";

    private int code;
    private String role;

    Profile(Integer code, String role) {
        this.code = code;
        this.role = role;
    }

    public static Profile toEnum(Integer cod) {
        for (Profile p : Profile.values()) {
            if (cod.equals(p.getCode())) {
                return p;
            }
        }
        throw new BusinessException(INVALID_CODE + cod);
    }

    public int getCode() {
        return code;
    }

    public String getRole() {
        return role;
    }

}
