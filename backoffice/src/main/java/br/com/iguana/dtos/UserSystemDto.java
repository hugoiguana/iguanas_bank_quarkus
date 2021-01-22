package br.com.iguana.dtos;

import br.com.iguana.entities.UserSystem;
import br.com.iguana.enums.Gender;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Schema(description = "All Users.")
public class UserSystemDto {

    @Schema(required = true)
    @JsonbProperty("id")
    private Long id;

    @JsonbProperty("creation_date")
    private LocalDateTime creationDate;

    @JsonbProperty("alteration_date")
    private LocalDateTime alterationDate;

    @Schema(required = true)
    @NotNull
    @JsonbProperty("name")
    private String name;

    @Schema(required = true)
    @NotNull
    @JsonbProperty("birthday_date")
    @JsonbDateFormat("dd/MM/yyyy")
    private LocalDate birthdayDate;

    @Schema(required = true)
    @NotNull
    @JsonbProperty("gender")
    private Integer gender;

    @Email
    @NotNull
    @Schema(required = true)
    @JsonbProperty("email")
    private String email;

    @NotNull
    @Schema(required = true)
    @JsonbProperty("profiles")
    public Set<Integer> profiles = new HashSet<>();

    @JsonbTransient
    private String willNotShowInResponseJson;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWillNotShowInResponseJson() {
        return willNotShowInResponseJson;
    }

    public Set<Integer> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<Integer> profiles) {
        this.profiles = profiles;
    }

    public void setWillNotShowInResponseJson(String willNotShowInResponseJson) {
        this.willNotShowInResponseJson = willNotShowInResponseJson;
    }

    public static List<UserSystemDto> build(List<UserSystem> usersSystem) {
        if (Objects.isNull(usersSystem)) {
            return List.of();
        }
        return usersSystem.stream().map(u -> new UserSystemDto().build(u))
                .collect(Collectors.toList());
    }

    public static UserSystemDto build(UserSystem userSystem) {
        UserSystemDto dto = new UserSystemDto();
        dto.id = userSystem.id;
        dto.creationDate = userSystem.creationDate;
        dto.alterationDate = userSystem.alterationDate;
        dto.name = userSystem.name;
        dto.birthdayDate = userSystem.birthdayDate;
        dto.gender = userSystem.gender;
        dto.email = userSystem.email;
        dto.profiles = userSystem.profiles;
        return dto;
    }

    public UserSystem buildEntity() {
        UserSystem userSystem = new UserSystem();
        userSystem.id = this.id;
        userSystem.name = this.name;
        userSystem.birthdayDate = this.birthdayDate;
        userSystem.gender = Gender.toEnum(this.gender).getCode();
        userSystem.email = this.email;
        userSystem.profiles = this.profiles;
        return userSystem;
    }
}
