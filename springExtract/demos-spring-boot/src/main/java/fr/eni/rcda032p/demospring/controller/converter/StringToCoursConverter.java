package fr.eni.rcda032p.demospring.controller.converter;

import fr.eni.rcda032p.demospring.bll.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import fr.eni.rcda032p.demospring.bo.Cours;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StringToCoursConverter implements Converter<String, Cours> {

    private final CoursService coursService;

    @Autowired
    public StringToCoursConverter(CoursService coursService) {
        System.out.println("StringToCoursConverter - Constructeur");
        this.coursService = coursService;
    }

    @Override
    public Cours convert(String idCours) {
        System.out.printf("Conversion : %s%n", idCours);
        return coursService.findById(Long.parseLong(idCours));
    }
}
