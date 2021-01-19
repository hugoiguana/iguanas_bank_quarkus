package br.com.iguana.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractEntity extends PanacheEntityBase {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public LocalDateTime creationDate;

    @Column(nullable = false)
    public LocalDateTime alterationDate;

    @PrePersist
    public void prePersist() {
        creationDate = LocalDateTime.now();
        alterationDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        alterationDate = LocalDateTime.now();
    }
}
