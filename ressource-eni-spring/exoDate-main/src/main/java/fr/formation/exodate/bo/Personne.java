package fr.formation.exodate.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personne {
    private Integer idPersonne;

    @NotBlank
    @Size(min = 2, max = 50, message = "Le nom doit avoir au moins 4 caractères")
    private String nom;

    @NotBlank
    @Size(min = 4, max = 50)
    private String prenom;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate ddn;

    public Personne(String nom, String prenom, LocalDate ddn) {
        this.nom = nom;
        this.prenom = prenom;
        this.ddn = ddn;
    }

//    public Integer daysToBirthday() {
//        Integer age = Period.between(ddn, LocalDate.now()).getYears();
//        LocalDate birthday = this.getDdn().plusYears(age);
//        return (int) ChronoUnit.DAYS.between(birthday, LocalDate.now());
//
//    }

    public Integer daysToBirthday() {
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = this.getDdn().withYear(today.getYear());

        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        return (int) ChronoUnit.DAYS.between(today, nextBirthday);
    }
}
