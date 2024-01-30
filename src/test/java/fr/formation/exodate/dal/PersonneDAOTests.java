package fr.formation.exodate.dal;

import fr.formation.exodate.bo.Personne;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class PersonneDAOTests {

    @Autowired
    PersonneDAO dao;

    @Test
    @Transactional
    void contextLoads() {

        LocalDate dateDeNaissance = LocalDate.of(1989, 9, 9);

        Personne personne = new Personne( "Lemarchand","Antoine",  dateDeNaissance);
        dao.ajouterPersonne(personne);

        List<Personne> lst = dao.getAll();
        lst.forEach(System.out::println);
    }

}
