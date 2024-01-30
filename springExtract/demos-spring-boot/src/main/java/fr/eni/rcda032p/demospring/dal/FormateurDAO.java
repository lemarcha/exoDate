package fr.eni.rcda032p.demospring.dal;

import java.util.List;

import fr.eni.rcda032p.demospring.bo.Formateur;

public interface FormateurDAO {
	void create(Formateur formateur);

	Formateur read(String emailFormateur);

	void update(Formateur formateur);

	List<Formateur> findAll();
}
