package br.com.iguana.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_transaction_validator")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "tv_id"))
        , @AttributeOverride(name = "creationDate", column = @Column(name = "tv_creation_date", nullable = false))
        , @AttributeOverride(name = "alterationDate", column = @Column(name = "tv_alteration_date", nullable = false))
})
public class InternalTransactionValidator extends AbstractEntity {

    @Column(name = "tv_operation_id", nullable = false)
    public Long operationId;

    @Column(name = "tv_is_valid", nullable = false)
    public Boolean isValid;

    @Column(name = "tv_key", nullable = false)
    public String key;

}
