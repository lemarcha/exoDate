package fr.formation.exodate.bll;

import fr.formation.exodate.bo.Personne;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PersonneServiceTests {

    @Autowired
    PersonneService service;

    @Test
    @Transactional
    void contextLoads() throws PersonneServiceException {
        LocalDate dateDeNaissance = LocalDate.of(1991, 1, 12);
        Personne personne = new Personne("Le Danvic", "Audrey", dateDeNaissance);
        service.addPersonne(personne);

        List<Personne> lst = service.getAllPersonnes();
        lst.forEach(System.out::println);

    }
}
