package fr.formation.exodate.bll;

import fr.formation.exodate.bo.Personne;
import fr.formation.exodate.dal.PersonneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonneServiceImpl implements PersonneService{

    @Autowired
    PersonneDAO dao;
    @Override
    public void addPersonne(Personne personne) throws PersonneServiceException {
        dao.ajouterPersonne(personne);
    }

    @Override
    public List<Personne> getAllPersonnes() {
        return dao.getAll();
    }

//    @Override
//    public List<Personne> compareDatePersonne(Personne personne, LocalDate ddn) {
//        return dao.compareDate();
//    }
}
