package br.com.iguana.dtos;

import br.com.iguana.entities.BankAccountType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BankAccountTypeDto {

    @JsonbProperty("id")
    private Long id;

    @JsonbProperty("creation_date")
    private LocalDateTime creationDate;

    @JsonbProperty("alteration_date")
    private LocalDateTime alterationDate;

    @Schema(required = true)
    @NotNull
    @JsonbProperty("code")
    public Integer code;

    @Schema(required = true)
    @NotNull
    @JsonbProperty("name")
    private String name;

    @Schema(required = true)
    @NotNull
    @JsonbProperty("description")
    private String description;

    public static List<BankAccountTypeDto> build(List<BankAccountType> bankAccountsType) {
        if (Objects.isNull(bankAccountsType)) {
            return List.of();
        }
        return bankAccountsType.stream().map(b -> new BankAccountTypeDto().build(b))
                .collect(Collectors.toList());
    }

    public static BankAccountTypeDto build(BankAccountType bankAccountType) {
        BankAccountTypeDto dto = new BankAccountTypeDto();
        dto.setId(bankAccountType.id);
        dto.setCreationDate(bankAccountType.creationDate);
        dto.setAlterationDate(bankAccountType.alterationDate);
        dto.setCode(bankAccountType.code);
        dto.setName(bankAccountType.name);
        dto.setDescription(bankAccountType.description);
        return dto;
    }

    public BankAccountType buildEntity() {
        BankAccountType bankAccountType = new BankAccountType();
        bankAccountType.id = this.id;
        bankAccountType.code = this.code;
        bankAccountType.name = this.name;
        bankAccountType.description = this.description;
        return bankAccountType;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
