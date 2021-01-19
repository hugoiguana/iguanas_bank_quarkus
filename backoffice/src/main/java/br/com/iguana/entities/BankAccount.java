package br.com.iguana.entities;

import br.com.iguana.enums.Gender;
import br.com.iguana.enums.Profile;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_bank_account")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "us_id"))
        , @AttributeOverride(name = "creationDate", column = @Column(name = "us_dth_creation_date"))
        , @AttributeOverride(name = "alterationDate", column = @Column(name = "us_dth_alteration_date"))
})
public class BanckAccount extends AbstractEntity {

    @NotNull
    @Size(min = 3)
    @Schema(required = true)
    @Column(name = "us_str_name", nullable = false)
    public String name;

    @NotNull
    @Schema(required = true)
    @Column(name = "us_dr_birthday_date", nullable = false)
    public LocalDate birthdayDate;

    @NotNull
    @Schema(required = true)
    @Column(name = "us_tp_gender", nullable = false)
    public Integer gender;

    @NotNull
    @Email
    @Schema(required = true)
    @Column(name = "us_str_email", nullable = false, unique = true)
    public String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_profile", joinColumns = @JoinColumn(name = "us_id"))
    @Column(name = "pro_name")
    public Set<Integer> profiles = new HashSet<>();

    @PrePersist
    public void prePersist() {
        if (Objects.isNull(profiles) || profiles.isEmpty()) {
            profiles = Set.of(Profile.CUSTOMER.getCode());
        }
    }



    public static List<BanckAccount> findByGender(Gender gender) {
        return find("gender", gender.getCode()).list();
    }

    public static List<BanckAccount> findByGender1(Gender gender) {
        return find("SELECT u FROM UserSystem u WHERE u.gender = ?1", gender.getCode()).list();
    }

    public static List<BanckAccount> findByGender2(Gender gender) {
        return find("gender = ?1", gender.getCode()).list();
    }

    public static List<BanckAccount> findByGenderOrderByNameAsc(Gender gender) {
        return find("gender = ?1 ORDER BY name ASC", gender.getCode()).list();
    }

    public static List<BanckAccount> findContainName(String name) {
        return find("upper(name) like ?1", "%" + name.toUpperCase() + "%").list();
    }

    public void load(BanckAccount bmNew) {
        this.name = bmNew.name;
        this.birthdayDate = bmNew.birthdayDate;
        this.gender = bmNew.gender;
    }

    @Override
    public String toString() {
        return "UserSystem{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", alterationDate=" + alterationDate +
                ", name='" + name + '\'' +
                ", birthdayDate=" + birthdayDate +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }
}
