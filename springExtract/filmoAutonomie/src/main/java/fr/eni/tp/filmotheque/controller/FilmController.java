package fr.eni.tp.filmotheque.controller;

import java.util.List;

import fr.eni.tp.filmotheque.bo.Genre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Film;

@Controller
@RequestMapping("/films")
@SessionAttributes({"genresSession"})
public class FilmController {

	// Dépendance
	private FilmService filmService;

	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}

	/**
	 * La méthode réagit à l'url /films et la méthode Get du protocole HTTP
	 * 
	 * @param model -- pour injecter des données à la vue
	 * @return l'alias de la page à afficher
	 */

	@ModelAttribute("genresSession")
	public List<Genre> chargerGenres() {
		System.out.println("Chargement des cours en session...");
		return filmService.consulterGenres();
	}

//	@GetMapping
//	public String afficherGenresFilms(Model model){
//		List<Genre> genres = filmService.consulterGenres();
//		model.addAttribute("listeGenres", genres);
//		return "view-films";
//	}

	@GetMapping
	public String afficherFilms(Model model) {
		System.out.println("\nTous les films : ");
		List<Film> films = filmService.consulterFilms();
		// Ajout des films dans le modèle
		model.addAttribute("films", films);
		return "view-films";
	}

	@GetMapping("/detail")
	public String afficherUnFilm(@RequestParam(name = "id", required = true) long id, Model model) {
		if (id > 0) {// L'identifiant en base commencera en 1
			Film film = filmService.consulterFilmParId(id);
			if (film != null) {
				// Ajout de l'instance dans le modèle
				model.addAttribute("film", film);
				return "view-film-detail";
			} else
				System.out.println("Film inconnu!!");
		} else {
			System.out.println("Identifiant inconnu");
		}
		// Par défaut redirection vers l'url pour afficher les films
		return "redirect:/films";
	}

	@GetMapping("/creer")
	public String ajouterFilms() {
		return "view-film-creer";
	}

}
