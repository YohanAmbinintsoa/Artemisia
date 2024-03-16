package itu.hiu.Artemisia.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/v1")
public class ArtController extends BaseController{
   
    @GetMapping("")
   public String getMethodName(@RequestParam String param) {
       return new String();
   }
   
}
