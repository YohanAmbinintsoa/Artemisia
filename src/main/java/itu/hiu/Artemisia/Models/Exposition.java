package itu.hiu.Artemisia.Models;

import java.sql.Date;

import itu.hiu.Artemisia.DAO.Column;
import itu.hiu.Artemisia.DAO.Generation;
import itu.hiu.Artemisia.DAO.Id;
import itu.hiu.Artemisia.DAO.Table;

@Table(name="exposition")
public class Exposition {
    @Id(name = "id_exposition",idtype = Generation.DEFAULT)
    Integer id;
    @Column(name = "titre")
    String titre;
    @Column(name = "theme")
    String theme;
    @Column(name = "datedebut")
    Date datedebut;
    @Column(name = "datefin")
    Date datefin;
    public Exposition() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public Date getDatedebut() {
        return datedebut;
    }
    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }
    public Date getDatefin() {
        return datefin;
    }
    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }
    
}
