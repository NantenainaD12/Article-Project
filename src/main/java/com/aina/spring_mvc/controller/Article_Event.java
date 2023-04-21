package com.aina.spring_mvc.controller;

import aina.HibernateDao;
import com.aina.spring_mvc.model.Admin;
import com.aina.spring_mvc.model.Auther;
import com.aina.spring_mvc.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Article_Event {

    @Autowired
    HibernateDao dao;

    @GetMapping("/insert-article-event")
    public String redirect_insert (Model model){
        //System.out.println("Hello world" +model.getAttribute("data").getLogin());
        model.addAttribute("type", dao.findAll(Type.class));
        return "insert_arti_event";
    }
    @PostMapping("/save-article-event")
    public String createCommune(@ModelAttribute com.aina.spring_mvc.model.Article_Event art, Model model){
        art.setEtat(1);
        dao.create(art);
        model.addAttribute("data", dao.findAll(com.aina.spring_mvc.model.Article_Event.class));

        System.out.println("AONNNN");//
        return "redirect:/get_all_for_client/limite=0";
    }
    @GetMapping("/get_all_for_client")
    public String get_all_for_client (int limite,Model model){
        int size=3;
        int all_size=dao.findAll(com.aina.spring_mvc.model.Article_Event.class).size();
        int viruge=all_size%size;
        System.out.println("RESTE+ "+viruge+"off = "+size*limite);

        model.addAttribute("data", dao.paginate(com.aina.spring_mvc.model.Article_Event.class,limite*size,size));
        if (viruge==0){
            model.addAttribute("section",all_size/size);
        }else{
            model.addAttribute("section",(all_size/size)+1);
        }
        return "liste_client";
    }

    @GetMapping("/get_all_for_admin")
    public String get_all_for_admin (int limite,Model model){
        int size=2;
        int all_size=dao.findAll(com.aina.spring_mvc.model.Article_Event.class).size();
        int viruge=all_size%size;
        System.out.println("RESTE+ "+viruge+"off = "+size*limite);

        model.addAttribute("data", dao.paginate(com.aina.spring_mvc.model.Article_Event.class,limite*size,size));
        if (viruge==0){
            model.addAttribute("section",all_size/size);
        }else{
            model.addAttribute("section",(all_size/size)+1);
        }
        return "liste_admin";
    }
    @GetMapping("/search")
    public String search(String re, Model model){
        com.aina.spring_mvc.model.Article_Event art =new com.aina.spring_mvc.model.Article_Event();
        art.setTitre(re);
        art.setAbout(re);
        System.out.println("titre= "+art.getTitre()+" , "+art.getAbout()+" , "+art.getDate1());
        model.addAttribute("data", dao.findWhere(art));

        System.out.println("serachh");//
        return "valiny_search";
    }

    @PostMapping("/login")
    public String login(@RequestParam("login") String login,@RequestParam("mdp") String mdp ,Model model){
        System.out.println("titre= "+login+" , "+mdp);
        Admin ad=new Admin();
        ad.setLogin(login);ad.setMdp(mdp);
        List<Admin> u= dao.findWhere(ad);
        if (u.size()!=0){
            model.addAttribute("data",u);
            return "redirect:/get_all_for_admin?limite=0";
           // return "liste_admin";
        }
        else{
            return "redirect:/get_all_for_admin?limite=0";
        }

    }


    @PostMapping("/loginAuther")
    public String loginAuther(@RequestParam("login") String login,@RequestParam("mdp") String mdp ,Model model){
        System.out.println("titre= "+login+" , "+mdp);
        Auther ad=new Auther();
        ad.setLogin(login);ad.setMdp(mdp);
        List<Auther> u= dao.findWhere(ad);
        if (u.size()!=0){
            model.addAttribute("data",u);
            return "redirect:/insert-article-event";
            // return "Liste";
        }
        else{
            return "../index";
        }

    }

    @GetMapping("/update")
    public String update(String re, Model model){
        com.aina.spring_mvc.model.Article_Event art =dao.findById(com.aina.spring_mvc.model.Article_Event.class,new Integer(re));
        art.setEtat(2);
        dao.update(art);
        System.out.println("titre= "+art.getTitre()+" , "+art.getAbout()+" , "+art.getEtat());
        model.addAttribute("data", dao.findWhere(art));

        return "redirect:/get_all_for_admin?limite=0";
    }

}
