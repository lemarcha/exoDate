package fr.eni.rcda032p.demospring.bo.contexte;

import java.io.Serializable;
import java.util.Objects;

public class Utilisateur implements Serializable {

    private String pseudo;

    public Utilisateur() {
    }

    public Utilisateur(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Utilisateur that = (Utilisateur) object;
        return Objects.equals(pseudo, that.pseudo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pseudo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Utilisateur{");
        sb.append("pseudo='").append(pseudo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
