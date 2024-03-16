package itu.hiu.Artemisia.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import itu.hiu.Artemisia.DTO.JwtResponse;
import itu.hiu.Artemisia.DTO.ResponseData;
import itu.hiu.Artemisia.Models.User;
import itu.hiu.Artemisia.Security.JwtUtils;
import itu.hiu.Artemisia.Security.MyContext;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.Connection;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("api/v1/auth")
public class LoginController extends BaseController{
    @Autowired
    JwtUtils utils;
    @PostMapping("/login")
    public ResponseData loginUser(HttpServletRequest req) {
        ResponseData data=new ResponseData();
        Connection con=null;
        try {
            con=MyContext.getRequester().connect();
            User user=User.login(req.getParameter("email"), req.getParameter("mdp"), this.requester);
            if (user==null) {
                data.setError("Verifier vos identifiants!");
                return data;
            }
            String token=utils.generateJwtToken(user);
            user.setMdp(null);
            data.addData(user);
            data.addData(new JwtResponse(token));
        } catch (Exception e) {
            e.printStackTrace();
            data.setError(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return data;
    }

    @PostMapping("/register")
    public ResponseData register(HttpServletRequest req) {
        ResponseData data=new ResponseData();
        Connection con=null;
        try {
            con=MyContext.getRequester().connect();
            User user=new User();
            user.setNom(req.getParameter("nom"));
            user.setPrenom(req.getParameter("prenom"));
            if (req.getParameter("dtn")!=null&&!req.getParameter("dtn").equals("")) {
                user.setDtn(Date.valueOf(req.getParameter("dtn")));
            }
            user.setNomUser(req.getParameter("email"));
            user.setMdp(req.getParameter("mdp"));
            user.setNomUser(req.getParameter("nomartiste"));
            user.setRole("USER");
            System.out.println(user.getRole());
            user.setDescription(req.getParameter("description"));
            user.setImage("");
            user=this.requester.insert(null, user);
            String token=utils.generateJwtToken(user);
            user.setMdp(null);
            data.addData(user);
            data.addData(new JwtResponse(token));
        } catch (Exception e) {
            e.printStackTrace();
            data.setError(e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return data;
    }
    
}
