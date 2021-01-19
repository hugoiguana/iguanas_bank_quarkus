package br.com.iguana.entities;

import br.com.iguana.enums.Gender;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Schema(description = "BankManager representation")
@Entity
@Table(name = "tb_bank_manager")
public class BankManager extends PanacheEntityBase {

    @Column(name = "bm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Long id;

    @NotNull
    @Size(min = 3)
    @Schema(required = true)
    @Column(name = "bm_name", nullable = false)
    public String name;

    @NotNull
    @Schema(required = true)
    @Column(name = "bm_birthday_date", nullable = false)
    public LocalDate birthdayDate;

    @NotNull
    @Schema(required = true)
    @Column(name = "bm_gender", nullable = false)
    public Integer gender;

    @NotNull
    @Email
    @Schema(required = true)
    @Column(name = "bm_email", nullable = false)
    public String email;

    public static List<BankManager> findByGender(Gender gender) {
        return find("gender", gender.getCode()).list();
    }

    public static List<BankManager> findByGender1(Gender gender) {
        return find("SELECT m FROM BankManager m WHERE m.gender = ?1", gender.getCode()).list();
    }

    public static List<BankManager> findByGender2(Gender gender) {
        return find("gender = ?1", gender.getCode()).list();
    }

    public static List<BankManager> findByGenderOrderByNameAsc(Gender gender) {
        return find("gender = ?1 ORDER BY name ASC", gender.getCode()).list();
    }

    public static List<BankManager> findContainName(String name) {
        return find("upper(name) like ?1", "%" + name.toUpperCase() + "%").list();
    }


    @Override
    public String toString() {
        return "BankManager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdayDate=" + birthdayDate +
                ", gender=" + gender +
                '}';
    }
}
