package fr.eni.rcda032p.demospring.dal;

import java.util.List;

import fr.eni.rcda032p.demospring.bo.Cours;

public interface CoursDAO {

	Cours read(long id);

	List<Cours> findAll();

	List<Cours> findByFormateur(String emailFormateur);

	void insertCoursFormateur(long idCours, String emailFormateur);
}
