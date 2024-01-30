package fr.eni.tp.filmotheque.tpfilmocorrection.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Genre {

    private long id;

    private String titre;

    private List<Film> film;


    public Genre() {
    }

    public Genre(String titre, List<Film> film) {
        this.titre = titre;
        this.film = new ArrayList<>();
    }

    public Genre(long id, String titre, List<Film> film) {
        this.id = id;
        this.titre = titre;
        this.film = new ArrayList<>();
    }

    public Genre(long id, String titre) {
        this.id = id;
        this.titre = titre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Film> getFilm() {
        return film;
    }

    public void setFilm(List<Film> film) {
        this.film = film;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre genre)) return false;
        return id == genre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Genre{");
        sb.append("id=").append(id);
        sb.append(", titre='").append(titre).append('\'');
        sb.append(", film=").append(film);
        sb.append('}');
        return sb.toString();
    }

}
