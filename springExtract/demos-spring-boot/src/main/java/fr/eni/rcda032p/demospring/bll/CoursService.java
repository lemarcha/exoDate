package fr.eni.rcda032p.demospring.bll;
import java.util.List;

import fr.eni.rcda032p.demospring.bo.Cours;

public interface CoursService {
	List<Cours> getCours();

	Cours findById(long id);
}
