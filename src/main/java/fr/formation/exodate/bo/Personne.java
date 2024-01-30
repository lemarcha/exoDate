package fr.formation.exodate.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personne {
    private Integer idPersonne;

    @NotBlank
    @Size(min = 4, max = 50, message = "Le nom doit avoir au moins 4 caractères")
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
}
