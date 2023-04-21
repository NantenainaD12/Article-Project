package com.aina.spring_mvc;

import com.aina.spring_mvc.model.Article_Event;
import com.aina.spring_mvc.model.Commune;
import aina.HibernateDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        HibernateDao dao = context.getBean(HibernateDao.class);
        System.out.println(dao);

              //  CREATE
//        String date_string = "26-01-2023";
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//        Date date = formatter.parse(date_string);
//
//        Article_Event commune = new Article_Event();
//        commune.setId_type(1);
//        commune.setTitre("test article");
//        commune.setAbout("hihihi");
//        commune.setDate1(date);
////        commune.setNom("Jejo");
////        commune.setIdDistrict(2);
//        commune = dao.create(commune);
//        System.out.println("kkkk"+commune.getId());

       // Find All
        Article_Event art=new Article_Event();
        art.setAbout("milay");
        art.setTitre("u");
        List<Article_Event> communes = dao.paginateWhere(art,1,5);
       // List<Article_Event> communes = dao.findAll(Article_Event.class);
        for (Article_Event commune : communes
             ) {
            System.out.println(commune.getTitre());

        }




//        Commune commune = new Commune();
//        commune.setId(1);
//        commune.setNom("vatosola");
//        commune.setIdDistrict(1);
//        dao.update(commune);
//        List<Commune> communes = dao.paginate(Commune.class, 0, 5, "id", true);
//        for (Commune tmp : communes
//        ) {
//            System.out.println(tmp.getId());
//
//        }
    }
}
