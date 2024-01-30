package fr.eni.tp.filmotheque.tpfilmocorrection.bo;

import java.util.Objects;

public class Avis {

    private long id;

    private int note;

    private String commentaire;

    private Membre membre;

    public Avis() {
    }

    public Avis(int note, String commentaire) {
        this.note = note;
        this.commentaire = commentaire;
    }

    public Avis(long id, int note, String commentaire) {
        this.id = id;
        this.note = note;
        this.commentaire = commentaire;
    }

    public Avis(long id, int note, String commentaire, Membre membre) {
        this.id = id;
        this.note = note;
        this.commentaire = commentaire;
        this.membre = membre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Avis avis)) return false;
        return id == avis.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Avis{");
        sb.append("id=").append(id);
        sb.append(", note=").append(note);
        sb.append(", commentaire='").append(commentaire).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
