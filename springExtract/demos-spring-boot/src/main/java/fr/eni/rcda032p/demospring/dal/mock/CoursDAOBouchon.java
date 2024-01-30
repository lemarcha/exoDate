package fr.eni.rcda032p.demospring.dal.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import fr.eni.rcda032p.demospring.bo.Cours;
import fr.eni.rcda032p.demospring.dal.CoursDAO;

@Repository
@Profile("dev")
public class CoursDAOBouchon implements CoursDAO {
	// Solution temporaire - gestion d'une liste de formateur locale
	private static List<Cours> lstCours;

	public CoursDAOBouchon() {
		lstCours = new ArrayList<Cours>();
		lstCours.add(new Cours(10, "Algorithmique", 5));
		lstCours.add(new Cours(20, "Initiation à la programmation", 5));
		lstCours.add(new Cours(30, "POO", 10));
		lstCours.add(new Cours(50, "SQL", 5));
		lstCours.add(new Cours(60, "PL-SQL", 5));
		lstCours.add(new Cours(130, "Web Client", 5));
		lstCours.add(new Cours(140, "Symfony", 10));
		lstCours.add(new Cours(220, "Frameworks Java EE", 10));
	}

	@Override
	public Cours read(long id) {
		return lstCours.stream().filter(item -> item.getId() == id).findAny().orElse(null);
	}

	@Override
	public List<Cours> findAll() {
		return lstCours;
	}

	@Override
	public List<Cours> findByFormateur(String emailFormateur) {
		return null;
	}

	@Override
	public void insertCoursFormateur(long idCours, String emailFormateur) {
		System.out.println("Formateur - " + emailFormateur + " dispense " + idCours);
	}
}
