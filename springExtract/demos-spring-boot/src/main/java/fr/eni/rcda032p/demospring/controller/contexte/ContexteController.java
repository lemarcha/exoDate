package fr.eni.rcda032p.demospring.controller.contexte;

import fr.eni.rcda032p.demospring.bo.contexte.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/contexte/SessionRequest")
@SessionAttributes({"utilisateurSession"})
public class ContexteController {


    @ModelAttribute("utilisateurSession")
    public Utilisateur chargerUtilisateurSession() {
        System.out.println("Création de l'utilisateur en session");
        return new Utilisateur();
    }
    @GetMapping
    public String addAttributeRequest(@ModelAttribute(name = "utilisateurSession") Utilisateur utilisateur, @RequestParam(required = false) String pseudo, Model model) {
        System.out.println("Ajout d'un utilisateur dans la requête");
        model.addAttribute("utilisateurRequest", new Utilisateur("Séga"));

        System.out.printf("Utilisateur en session est : %s%n", utilisateur.getPseudo());

        System.out.printf("Paramètre session reçu : %s%n", pseudo);

        utilisateur.setPseudo(pseudo);

        return "contexte/view-contexte";
    }

    @GetMapping("/recuperer")
    public String recuperAttributs(@ModelAttribute("utilisateurSession") Utilisateur utilisateurSession, Utilisateur utilisateurRequest) {

        System.out.printf("Utilisateur en session est : %s%n", utilisateurSession.getPseudo());
        System.out.printf("Utilisateur en request est : %s%n", utilisateurRequest);

        return "contexte/view-contexte";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        System.out.println("Déconnexion");
        sessionStatus.setComplete();
        return "redirect:/contexte/SessionRequest";
    }
}
