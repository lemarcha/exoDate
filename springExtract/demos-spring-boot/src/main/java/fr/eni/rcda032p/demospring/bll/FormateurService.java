package fr.eni.rcda032p.demospring.bll;

import java.util.List;

import fr.eni.rcda032p.demospring.bo.Formateur;

public interface FormateurService {
	void add(String nom, String prenom, String email);

	void add(Formateur formateur);

	List<Formateur> getFormateurs();
	
	Formateur findByEmail(String emailFormateur);
	
	void update(Formateur formateur);
	
	void updateCoursFormateur(String emailFormateur, long idCours);
}
