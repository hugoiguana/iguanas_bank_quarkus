package br.com.iguana.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_bank_account_type")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "bat_id"))
        , @AttributeOverride(name = "creationDate", column = @Column(name = "bat_creation_date", nullable = false))
        , @AttributeOverride(name = "alterationDate", column = @Column(name = "bat_alteration_date", nullable = false))
})
public class BankAccountType extends AbstractEntity {

    @Column(name = "bat_code", nullable = false)
    public Integer code;

    @Column(name = "bat_name", nullable = false)
    public String name;

    @Column(name = "bat_description")
    public String description;

    public BankAccountType() {
    }

    public BankAccountType(Long id) {
        this.id = id;
    }

    public void loadToUpdate(BankAccountType batNew) {
        this.code = batNew.code;
        this.name = batNew.name;
        this.description = batNew.description;
    }
}
