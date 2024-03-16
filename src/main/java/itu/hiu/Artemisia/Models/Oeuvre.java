package itu.hiu.Artemisia.Models;

import java.sql.Date;

import itu.hiu.Artemisia.DAO.Column;
import itu.hiu.Artemisia.DAO.Generation;
import itu.hiu.Artemisia.DAO.Id;
import itu.hiu.Artemisia.DAO.Table;

@Table(name = "Oeuvre")
public class Oeuvre {
    @Id(name = "id_oeuvre",idtype = Generation.DEFAULT)
    Integer id;
    @Column(name = "titre")
    String titre;
    @Column(name = "longueur")
    Float longueur;
    @Column(name = "largeur")
    Float largeur;
    @Column(name = "description")
    String description;
    @Column(name = "dateparution")
    Date dateparution;
    @Column(name = "artiste")
    Integer artiste;
    @Column(name = "expostion")
    Integer exposition;
    @Column(name = "image")
    String image;
    public Oeuvre() {
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
    public Float getLongueur() {
        return longueur;
    }
    public void setLongueur(Float longueur) {
        this.longueur = longueur;
    }
    public Float getLargeur() {
        return largeur;
    }
    public void setLargeur(Float largeur) {
        this.largeur = largeur;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDateparution() {
        return dateparution;
    }
    public void setDateparution(Date dateparution) {
        this.dateparution = dateparution;
    }
    public Integer getArtiste() {
        return artiste;
    }
    public void setArtiste(Integer artiste) {
        this.artiste = artiste;
    }
    public Integer getExposition() {
        return exposition;
    }
    public void setExposition(Integer exposition) {
        this.exposition = exposition;
    }

}
