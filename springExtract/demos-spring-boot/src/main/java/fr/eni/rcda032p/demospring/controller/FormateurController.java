package fr.eni.rcda032p.demospring.controller;

import fr.eni.rcda032p.demospring.bll.CoursService;
import fr.eni.rcda032p.demospring.bll.FormateurService;
import fr.eni.rcda032p.demospring.bo.Cours;
import fr.eni.rcda032p.demospring.bo.Formateur;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;


@Controller
@RequestMapping("/formateurs")
@SessionAttributes({"coursSession"})
public class FormateurController {
	private FormateurService formateurService;
	private CoursService coursService;

	@Autowired
	public FormateurController(FormateurService formateurService, CoursService coursService) {
		this.formateurService = formateurService;
		this.coursService = coursService;
	}

	@ModelAttribute("coursSession")
	public List<Cours> chargerCours() {
		System.out.println("Chargement des cours en session...");
		return coursService.getCours();
	}

	@GetMapping
	public String afficherFormateurs(Model model) {

		List<Formateur> formateurs = formateurService.getFormateurs();
		model.addAttribute("listeFormateurs", formateurs);
		return "view-formateurs";
	}

	//Création d'un formateur
	@GetMapping("/creer")//Création et affichage du formulaire
	public String creerFormateur(Model model) {
		model.addAttribute("formateur", new Formateur());
		return "view-formateur-creer";
	}
	//Récupération de l'objet formateur du formulaire
	//Sauvegarde de ce dernier
	@PostMapping("/creer")
	public String creerFormateur(@Valid @ModelAttribute("formateur") Formateur formateur, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "view-formateur-creer";
		} else {
			System.out.println(formateur.getListeCours());
			formateurService.add(formateur);
			return "redirect:/formateurs";
		}
	}

	@GetMapping("/detail")
	public String detailFormateurParParametre(@RequestParam(name = "email", defaultValue = "coach@campus-eni.fr", required = false) String emailFormateur, Model model) {
		System.out.printf("Le paramètre reçu est : %s%n", emailFormateur);

		Formateur formateur = formateurService.findByEmail(emailFormateur);

		model.addAttribute("formateur", formateur);

		return "view-formateur-detail";
	}

	@PostMapping("/detail")
	public String sauvegarderFormateur(@ModelAttribute("formateur") Formateur formateur) {
		System.out.println("Les paramètres reçus sont :");
		System.out.printf("Prénom : %s%n", formateur.getPrenom());
		System.out.printf("Nom : %s%n", formateur.getNom());
		System.out.printf("Email : %s%n", formateur.getEmail());
		Formateur formateurAcharger = formateurService.findByEmail(formateur.getEmail());
		if (null != formateurAcharger) {
			formateurAcharger.setNom(formateur.getNom());
			formateurAcharger.setPrenom(formateur.getPrenom());
			formateurService.update(formateurAcharger);
		}
		return "redirect:/formateurs";
	}
	@GetMapping({"/detail/variable/","/detail/variable/{email}"})
	public String detailFormateurParVariable(@PathVariable(name = "email", required = false) String emailFormateur) {
		if (null == emailFormateur) {
			emailFormateur = "coach@campus-eni.fr";
		}
		System.out.printf("La variable reçue est : %s%n", emailFormateur);
		return "redirect:/formateurs";
	}

	//Gestion des cours
	@PostMapping("/cours")
	public String ajouterCours(@RequestParam String email, @RequestParam(name = "idCours") String id) {

		formateurService.updateCoursFormateur(email, Long.parseLong(id));
		return "redirect:/formateurs/detail?email="+email;
	}
}
