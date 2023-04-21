package com.aina.spring_mvc.controller;

import aina.HibernateDao;
import com.aina.spring_mvc.model.Commune;
import com.aina.spring_mvc.model.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommuneController {

    @Autowired
    HibernateDao dao;

    @GetMapping("/form-commune")
    public String formulaireCommune(Model model){
        model.addAttribute("districts", dao.findAll(District.class) );
        return "commune";
    }

    @PostMapping("/commune")
    public String createCommune(@ModelAttribute Commune commune, Model model){
        dao.create(commune);
        model.addAttribute("communes", dao.findAll(Commune.class));
        return "liste-commune";
    }

    public HibernateDao getDao() {
        return dao;
    }

    public void setDao(HibernateDao dao) {
        this.dao = dao;
    }
}
