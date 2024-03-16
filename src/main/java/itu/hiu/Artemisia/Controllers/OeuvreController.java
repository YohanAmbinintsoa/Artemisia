package itu.hiu.Artemisia.Controllers;

import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import itu.hiu.Artemisia.DTO.ResponseData;
import itu.hiu.Artemisia.Models.Oeuvre;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/v1/Oeuvres")
public class OeuvreController extends BaseController{
    @GetMapping
    public ResponseData getAll() {
        ResponseData data = new ResponseData();
        try {
            data.addData(this.requester.select(null, new Oeuvre()));
        } catch (Exception e) {
            e.printStackTrace();
            data.setError(e.getMessage());
        }
        return data;
    }

    @GetMapping("{id}")
    public ResponseData getById(@PathVariable("id") Integer id) {
        ResponseData data = new ResponseData();
        try {
            Oeuvre oeuvre = new Oeuvre();
            oeuvre.setId(id);
            data.addData(this.requester.select(null, oeuvre));
        } catch (Exception e) {
            e.printStackTrace();
            data.setError(e.getMessage());
        }
        return data;
    }

    @PostMapping
    public ResponseData insert(HttpServletRequest req) {
        ResponseData data = new ResponseData();
        try {
            Oeuvre oeuvre=new Oeuvre();
            oeuvre.setArtiste(Integer.parseInt(req.getParameter("artiste")));
            oeuvre.setDateparution(Date.valueOf(req.getParameter("dateparution")));
            oeuvre.setTitre(req.getParameter("titre"));
            oeuvre.setExposition(Integer.parseInt(req.getParameter("exposition")));
            oeuvre.setDescription(req.getParameter("description"));
            oeuvre.setLongueur(Float.parseFloat(req.getParameter("longueur")));
            oeuvre.setLargeur(Float.parseFloat(req.getParameter("largeur")));
            data.addData(this.requester.insert(null, oeuvre));
        } catch (Exception e) {
            e.printStackTrace();
            data.setError(e.getMessage());
        }
        return data;
    }
    
}
