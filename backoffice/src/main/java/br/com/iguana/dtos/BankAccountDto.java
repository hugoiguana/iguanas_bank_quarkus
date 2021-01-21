package br.com.iguana.dtos;

import br.com.iguana.entities.BankAccount;
import br.com.iguana.entities.UserSystem;
import br.com.iguana.entities.BankAccountType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BankAccountDto {

    @JsonbProperty("id")
    private Long id;

    @JsonbProperty("creation_date")
    private LocalDateTime creationDate;

    @JsonbProperty("alteration_date")
    private LocalDateTime alterationDate;

    @JsonbProperty("active")
    private Boolean active;

    @JsonbProperty("agency_code")
    private String agencyCode;

    @JsonbProperty("agency_code_vd")
    private String agencyCodeDv;

    @JsonbProperty("account_code")
    private String accountCode;

    @JsonbProperty("account_code_vd")
    private String accountCodeDv;

    @Schema(required = true)
    @NotNull
    @JsonbProperty("id_customer")
    private Long idCustomer;

    @Schema(required = true)
    @NotNull
    @JsonbProperty("us_id_manager")
    private Long idManager;

    @Schema(required = true)
    @NotNull
    @JsonbProperty("id_account_type")
    private Long idAccountType;

    public static List<BankAccountDto> build(List<BankAccount> bankAccounts) {
        if (Objects.isNull(bankAccounts)) {
            return List.of();
        }
        return bankAccounts.stream().map(b -> new BankAccountDto().build(b))
                .collect(Collectors.toList());
    }

    public static BankAccountDto build(BankAccount bankAccount) {
        BankAccountDto dto = new BankAccountDto();
        dto.setId(bankAccount.id);
        dto.setCreationDate(bankAccount.creationDate);
        dto.setAlterationDate(bankAccount.alterationDate);
        dto.setActive(bankAccount.active);
        dto.setAgencyCode(bankAccount.agencyCode);
        dto.setAgencyCodeDv(bankAccount.agencyCodeDv);
        dto.setAccountCode(bankAccount.accountCode);
        dto.setAccountCodeDv(bankAccount.accountCodeDv);
        dto.setIdCustomer(bankAccount.customer.id);
        dto.setIdManager(bankAccount.manager.id);
        dto.setIdAccountType(bankAccount.type.id);
        return dto;
    }

    public BankAccount buildEntity() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.id = this.id;
        bankAccount.customer = new UserSystem(this.idCustomer);
        bankAccount.manager = new UserSystem(this.idManager);
        bankAccount.type = new BankAccountType(this.idAccountType);;
        return bankAccount;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public String getAgencyCodeDv() {
        return agencyCodeDv;
    }

    public void setAgencyCodeDv(String agencyCodeDv) {
        this.agencyCodeDv = agencyCodeDv;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountCodeDv() {
        return accountCodeDv;
    }

    public void setAccountCodeDv(String accountCodeDv) {
        this.accountCodeDv = accountCodeDv;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Long getIdManager() {
        return idManager;
    }

    public void setIdManager(Long idManager) {
        this.idManager = idManager;
    }

    public Long getIdAccountType() {
        return idAccountType;
    }

    public void setIdAccountType(Long idAccountType) {
        this.idAccountType = idAccountType;
    }
}
