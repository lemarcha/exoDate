package fr.formation.exodate.ihm;

import fr.formation.exodate.bll.PersonneService;
import fr.formation.exodate.bll.PersonneServiceException;
import fr.formation.exodate.bo.Personne;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/personne")
public class PersonneController {
    @Autowired
    PersonneService service;

    @ModelAttribute("lstPersonnes")
    private List<Personne> getListPersonnes(){
        return service.getAllPersonnes();
    }

//    @ModelAttribute("lstAnniversairePersonnes")
//    private List<Personne> getListAnniversairePersonnes(){
//        return service.compareDatePersonne( Personne personne, LocalDate ddn);
//    }

    @GetMapping
    public String init(Personne personne) {
        return "personne";
    }

    @PostMapping
    public String valid(@Valid Personne personne, BindingResult errors, Model model) {
        if(errors.hasErrors()) {
            return "personne";
        }

        try {
            service.addPersonne(personne);
        } catch (PersonneServiceException e) {
            // TODO gérer l'exception
            e.printStackTrace();
        }
        return "redirect:/personne";
    }


}
