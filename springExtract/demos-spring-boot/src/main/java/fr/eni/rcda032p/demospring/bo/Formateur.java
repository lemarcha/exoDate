package fr.eni.rcda032p.demospring.bo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class Formateur {
	@NotBlank
	@Size(min = 4, max = 50, message = "Le nom doit avoir au moins 4 caractères")
	private String nom;
	@NotBlank
	@Size(min = 4, max = 50)
	private String prenom;
	@NotBlank
	@Email
	@Pattern(regexp = "^[\\w\\-\\.\\_]+@campus-eni\\.fr$")
	private String email;

	private List<Cours> listeCours;

	{
		listeCours = new ArrayList<>();
	}

	public Formateur() {
	}

	public Formateur(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Cours> getListeCours() {
		return listeCours;
	}

	public void setListeCours(List<Cours> listeCours) {
		this.listeCours = listeCours;
	}

	@Override
	public String toString() {
		return "Formateur [nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}

}
