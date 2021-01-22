package br.com.iguana.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "tb_bank_operation")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "bo_id"))
        , @AttributeOverride(name = "creationDate", column = @Column(name = "bo_creation_date"))
        , @AttributeOverride(name = "alterationDate", column = @Column(name = "bo_alteration_date"))
})
public class BankOperation extends AbstractEntity {

    

}
