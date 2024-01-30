package fr.eni.rcda032p.demospring.bo;

import java.io.Serializable;
import java.util.Objects;

public class Cours implements Serializable {

    private long id;
    private String titre;
    private int duree;

    public Cours() {
    }

    public Cours(long id, String titre, int duree) {
        this.id = id;
        this.titre = titre;
        this.duree = duree;
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

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Cours cours = (Cours) object;
        return id == cours.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cours{");
        sb.append("id=").append(id);
        sb.append(", titre='").append(titre).append('\'');
        sb.append(", duree=").append(duree);
        sb.append('}');
        return sb.toString();
    }
}
