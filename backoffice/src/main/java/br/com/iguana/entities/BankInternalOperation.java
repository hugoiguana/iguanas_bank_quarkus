package br.com.iguana.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "tb_bank_internal_oper")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "bio_id"))
        , @AttributeOverride(name = "creationDate", column = @Column(name = "bio_creation_date"))
        , @AttributeOverride(name = "alterationDate", column = @Column(name = "bio_alteration_date"))
})
public class BankInternalOperation extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "us_id_owner", referencedColumnName = "us_id", nullable = false)
    public UserSystem owner;

    @ManyToOne
    @JoinColumn(name = "us_id_beneficiary", referencedColumnName = "us_id", nullable = false)
    public UserSystem beneficiary;

    @Column(name = "bio_operation_method", nullable = false)
    public Integer operationMethod;

    @Column(name = "bio_operation_value", nullable = false)
    public BigDecimal operationValue;

    @Column(name = "bio_operation_type", nullable = false)
    public Integer operationType;

}
