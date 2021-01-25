package br.com.iguana.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_bank_account")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ba_id"))
        , @AttributeOverride(name = "creationDate", column = @Column(name = "ba_creation_date", nullable = false))
        , @AttributeOverride(name = "alterationDate", column = @Column(name = "ba_alteration_date", nullable = false))
})
public class BankAccount extends AbstractEntity {

    @Column(name = "ba_active", nullable = false)
    public Boolean active;

    @Column(name = "ba_agency_code", nullable = false)
    public String agencyCode;

    @Column(name = "ba_agency_code_vd", nullable = false)
    public String agencyCodeDv;

    @Column(name = "ba_account_code", nullable = false)
    public String accountCode;

    @Column(name = "ba_account_code_vd", nullable = false)
    public String accountCodeDv;

    @OneToOne
    @JoinColumn(name = "us_id_customer", nullable = false, referencedColumnName = "us_id")
    public UserSystem customer;

    @ManyToOne
    @JoinColumn(name = "us_id_manager", nullable = false, referencedColumnName = "us_id")
    public UserSystem manager;

    @ManyToOne
    @JoinColumn(name = "bat_id", nullable = false)
    public BankAccountType type;

    public void loadToUpdate(BankAccount bmNew) {
        this.customer = bmNew.customer;
        this.manager = bmNew.manager;
        this.type = bmNew.type;
    }

}
