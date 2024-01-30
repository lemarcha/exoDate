package fr.formation.exodate.dal;

import fr.formation.exodate.bo.Personne;

import java.time.LocalDate;
import java.util.List;

public interface PersonneDAO {
    public void ajouterPersonne(Personne personne);
    public List<Personne> getAll();
    public List<Personne> compareDate();

}
