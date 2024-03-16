package itu.hiu.Artemisia.Models;

import java.sql.Connection;
import java.util.Date;

import itu.hiu.Artemisia.DAO.Column;
import itu.hiu.Artemisia.DAO.DAO;
import itu.hiu.Artemisia.DAO.Generation;
import itu.hiu.Artemisia.DAO.Id;
import itu.hiu.Artemisia.DAO.Table;
import itu.hiu.Artemisia.Security.Role;

import java.sql.ResultSet;
import java.sql.Statement;

@Table(name = "artiste")
public class User {
    @Id(name = "id_artiste",idtype = Generation.DEFAULT)
    Integer id;
    @Column(name = "nom")
    String nom;
    @Column(name = "prenom")
    String prenom;
    @Column(name="date_naissance")
    Date dtn;
    @Column(name = "role")
    String role;
    @Column(name = "nom_artiste")
    String nomUser;
    @Column(name = "mdp")
    String mdp;
    @Column(name = "email")
    String email;
    @Column(name = "photo")
    String image;
    @Column(name = "description")
    String description;



    public static User login(String email,String password,DAO dao) throws Exception{
        User user=null;
        Connection con=dao.connect();
        Statement state=con.createStatement();
        ResultSet res=state.executeQuery("select * from artiste where email='"+email+"' and mdp='"+password+"'");
        if (res.next()) {
            user=new User();
            user.setNom(res.getString("nom"));
            user.setPrenom(res.getString("prenom"));
            user.setId(res.getInt("id_artiste"));
            user.setDtn(res.getDate("date_naissance"));
            user.setRole(res.getString("role"));
            user.setNomUser(res.getString("nom_artiste"));
            user.setEmail(res.getString("email"));
            user.setDescription(res.getString("description"));
            user.setImage(res.getString("photo"));
        }
        return user;
    }

    public User() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDtn() {
        return dtn;
    }

    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }

    public Role getRole() {
        if (this.role.equals("ADMIN")) {
            return Role.ADMIN;
        }
        return Role.USER;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
