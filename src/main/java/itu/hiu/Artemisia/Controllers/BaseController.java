package itu.hiu.Artemisia.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;

import itu.hiu.Artemisia.DAO.DAO;
import itu.hiu.Artemisia.Security.MyContext;


@CrossOrigin(origins = "*",allowedHeaders = "*")
public class BaseController {
    // DAO requester=new DAO("YohanAmbinintsoa", "u4ixcVJHQOD3", "ep-shrill-voice-12867324.us-east-2.aws.neon.tech","final", "postgresql");
    DAO requester;
    
    public BaseController(){
        this.requester=MyContext.getRequester();
    }
}
