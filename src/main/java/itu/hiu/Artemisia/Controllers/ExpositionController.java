package itu.hiu.Artemisia.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import itu.hiu.Artemisia.DTO.ResponseData;
import itu.hiu.Artemisia.Models.Exposition;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("api/v1/Expositions")
public class ExpositionController extends BaseController{
    
    @GetMapping
    public ResponseData getAll() {
        ResponseData data=new ResponseData();
        try {
            data.addData(this.requester.select(null, new Exposition()));
        } catch (Exception e) {
            e.printStackTrace();
            data.setError(e.getMessage());
        }
        return data;
    }

    @GetMapping("{id}")
    public ResponseData getById(@PathVariable("id") Integer id) {
        ResponseData data=new ResponseData();
        try {
            Exposition exp=new Exposition();
            exp.setId(id);
            data.addData(this.requester.select(null, new Exception()));
        } catch (Exception e) {
            e.printStackTrace();
            data.setError(e.getMessage());
        }
        return data;
    }

    @PostMapping
    public ResponseData insert(HttpServletRequest req) {
        ResponseData data=new ResponseData();
        try {
            Exposition exp=new Exposition();
            exp.setTitre(req.getParameter("titre"));
            exp.setTheme(req.getParameter("theme"));
            exp.setDatedebut(Date.valueOf(req.getParameter("datedebut")));
            exp.setDatefin(Date.valueOf(req.getParameter("datefin")));
            data.addData(this.requester.insert(null, exp));
        } catch (Exception e) {
            e.printStackTrace();
            data.setError(e.getMessage());
        }
        return data;
    }
    
       
}
