package com.aina.spring_mvc.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Article_Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    Integer id_type;
    @Column
    String titre;
    @Column
    String about;
    @Column
    String date1;
    @Column
    String date2;

    @Column
    String sary;
    @Column
    int etat;

    public Article_Event() {
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_type() {
        return id_type;
    }

    public void setId_type(Integer id_type) {
        this.id_type = id_type;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getSary() {
        return sary;
    }

    public void setSary(String sary) {
        this.sary = sary;
    }

    public Article_Event(Integer id, Integer id_type, String titre, String about, String date1, String date2, String sary, int etat) {
        this.id = id;
        this.id_type = id_type;
        this.titre = titre;
        this.about = about;
        this.date1 = date1;
        this.date2 = date2;
        this.sary = sary;
        this.etat = etat;
    }
}
