package fr.eni.tp.filmotheque.tpfilmocorrection.bo;

import java.util.ArrayList;
import java.util.List;

public class Membre extends Personne{

    private String pseudo;

    private String motDePasse;

    private boolean admin = false;

    private String mail;

    private List<Avis> avis;

    public Membre() {
    }

    public Membre(String motDePasse, boolean admin) {
        this.motDePasse = motDePasse;
        this.admin = admin;
    }

    public Membre(String pseudo, String motDePasse, boolean admin) {
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.admin = admin;
    }

    public Membre(String nom, String prenom, String pseudo, String motDePasse, boolean admin, List<Avis> avis) {
        super(nom, prenom);
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.admin = admin;
        this.avis = new ArrayList<>();
    }

    public Membre(long id, String nom, String prenom, String mail, List<Avis> avis) {
        super(id, nom, prenom);
        this.mail = mail;
        this.avis = new ArrayList<>();
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Membre{");
        sb.append("pseudo='").append(pseudo).append('\'');
        sb.append(", admin=").append(admin);
        sb.append(", avis=").append(avis);
        sb.append('}');
        return sb.toString();
    }
}
