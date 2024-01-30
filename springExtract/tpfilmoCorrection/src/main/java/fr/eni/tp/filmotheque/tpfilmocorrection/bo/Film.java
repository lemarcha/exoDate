package fr.eni.tp.filmotheque.tpfilmocorrection.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film {

    private long id;

    private String titre;

    private int annee;

    private int duree;

    private String synopsis;

    private List<Avis> avis;


    private Genre genre;

    private List<Participant> acteurs;

    private Participant realisateur;


    {
        avis = new ArrayList<>();
        acteurs = new ArrayList<>();
    }

    public Film() {
    }

    public Film(List<Participant> acteurs, Participant realisateur) {
        this.acteurs = acteurs;
        this.realisateur = realisateur;
    }

    public Film(String titre, int annee, int duree, String synopsis) {
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
    }

    public Film(long id, String titre, int annee, int duree, String synopsis) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
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

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<Avis> getAvis() {
        return avis;
    }

    public void setAvis(List<Avis> avis) {
        this.avis = avis;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Participant> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Participant> acteurs) {
        this.acteurs = acteurs;
    }

    public Participant getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Participant realisateur) {
        this.realisateur = realisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film film)) return false;
        return id == film.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Film{");
        sb.append("id=").append(id);
        sb.append(", titre='").append(titre).append('\'');
        sb.append(", annee=").append(annee);
        sb.append(", duree=").append(duree);
        sb.append(", synopsis='").append(synopsis).append('\'');
        sb.append(", avis=").append(avis);
        sb.append(", genre=").append(genre);
        sb.append(", acteurs=").append(acteurs);
        sb.append(", realisateur=").append(realisateur);
        sb.append('}');
        return sb.toString();
    }
}
