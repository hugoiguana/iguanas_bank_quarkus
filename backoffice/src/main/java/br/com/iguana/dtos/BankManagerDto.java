package br.com.iguana.dtos;

import br.com.iguana.entities.BankManager;
import br.com.iguana.enums.Gender;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

@Schema(description = "All managers.")
public class BankManagerDto {

    @Schema(required = true)
    @JsonbProperty("id")
    private Long id;

    @Schema(required = true)
    @NotNull
    @JsonbProperty("name")
    private String name;

    @Schema(required = true)
    @NotNull
    @JsonbProperty("birthday_date")
    private LocalDate birthdayDate;

    @Schema(required = true)
    @NotNull
    @JsonbProperty("gender")
    private Integer gender;

    @Email
    @NotNull
    @Schema(required = true)
    @JsonbProperty("email")
    private String email;

    @JsonbTransient
    private String willNotShowInResponseJson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWillNotShowInResponseJson() {
        return willNotShowInResponseJson;
    }

    public void setWillNotShowInResponseJson(String willNotShowInResponseJson) {
        this.willNotShowInResponseJson = willNotShowInResponseJson;
    }

    public static BankManagerDto build(BankManager bankManager) {
        BankManagerDto dto = new BankManagerDto();
        dto.id = bankManager.id;
        dto.name = bankManager.name;
        dto.birthdayDate = bankManager.birthdayDate;
        dto.gender = bankManager.gender;
        dto.email = bankManager.email;
        return dto;
    }

    public BankManager buildEntity() {
        BankManager bankManager = new BankManager();
        bankManager.id = this.id;
        bankManager.name = this.name;
        bankManager.birthdayDate = this.birthdayDate;
        bankManager.gender = Gender.toEnum(this.gender).getCode();
        bankManager.email = this.email;
        return bankManager;
    }
}
