package fr.eni.tp.filmotheque.tpfilmocorrection.controller;

import fr.eni.tp.filmotheque.tpfilmocorrection.bll.FilmService;
import fr.eni.tp.filmotheque.tpfilmocorrection.bo.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmController {
    private FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    public void afficherFilms() {
        System.out.println("\nTous les films : ");
        List<Film> films = filmService.consulterFilms();
        films.forEach(System.out::println);
    }

    public void afficherUnFilm(long id) {
        if (id <= 0) {
            System.out.println("Id incorrect");
        } else {
            Film film = filmService.consulterFilmParId(id);
            if (null == film) {
                System.out.println("Film inconu / non trouvé");
            } else {
                System.out.println(film);
            }
        }


    }
}
