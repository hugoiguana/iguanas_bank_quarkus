package br.com.iguana.dtos;

import br.com.iguana.entities.BankAccount;
import br.com.iguana.entities.UserSystem;
import br.com.iguana.entities.BankAccountType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;

public class BankAccountCreateDto {

    @Schema(required = true)
    @NotNull
    @JsonbProperty("id_customer")
    private Long idCustomer;

    @Schema(required = true)
    @NotNull
    @JsonbProperty("id_manager")
    private Long idManager;

    @Schema(required = true)
    @NotNull
    @JsonbProperty("id_account_type")
    private Long idAccountType;


    public static BankAccount buildToInsert(BankAccountCreateDto dto) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.customer = new UserSystem(dto.getIdCustomer());
        bankAccount.manager = new UserSystem(dto.getIdManager());
        bankAccount.type = new BankAccountType(dto.getIdAccountType());
        return bankAccount;
    }

    public static BankAccount buildToUpdate(BankAccountCreateDto dto) {
        return buildToInsert(dto);
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
