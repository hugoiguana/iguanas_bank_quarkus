package br.com.iguana.enums;

public enum Gender {

    MALE(1, "Male"),
    FEMALE(2, "Female");

    private int code;
    private String name;

    Gender(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Gender toEnum(Integer cod) {
        for (Gender p : Gender.values()) {
            if (cod.equals(p.getCode())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid code Gender enum: " + cod);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
