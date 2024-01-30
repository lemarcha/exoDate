package fr.eni.rcda032p.demospring.bll;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.rcda032p.demospring.bo.Cours;
import fr.eni.rcda032p.demospring.dal.CoursDAO;

@Service
public class CoursServiceImpl implements CoursService {
	private CoursDAO courseDAO;

	public CoursServiceImpl(CoursDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public List<Cours> getCours() {
		return courseDAO.findAll();
	}

	@Override
	public Cours findById(long id) {
		return courseDAO.read(id);
	}
}
