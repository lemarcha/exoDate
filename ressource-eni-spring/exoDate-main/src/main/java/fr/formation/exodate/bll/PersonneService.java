package fr.formation.exodate.bll;

import fr.formation.exodate.bo.Personne;

import java.time.LocalDate;
import java.util.List;

public interface PersonneService {
    public void addPersonne(Personne personne) throws PersonneServiceException;

    public List<Personne> getAllPersonnes();

    public List<Personne> compareDatePersonne();
}
