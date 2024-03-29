package itu.hiu.Artemisia.Security;

import java.security.Key;
import java.util.Date;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import itu.hiu.Artemisia.Models.User;

@Component
public class JwtUtils {
  
  private String jwtSecret="======================Yohan=Spring===========================";

  private int jwtExpirationMs=86400000;

  public static String getToken(HttpServletRequest request){
    String token="";
    if (request.getHeader("authorization")!=null&&request.getHeader("authorization")!=""&&request.getHeader("authorization").startsWith("Bearer ")) {
        token=request.getHeader("authorization").substring(7);
    } 
    return token;
  }

  public String generateJwtToken(User user) {
    System.out.println(user.getRole());
    System.out.println("CLASS="+user.getRole().getClass());
    return Jwts.builder()
        .setSubject(String.valueOf(user.getId()))
        .claim("role", user.getRole())
        .setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
        .signWith(key(), SignatureAlgorithm.HS256)
        .compact();
  }
  
  private Key key() {
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
  }

  public Integer getUserIdFromToken(String token) {
    return  Integer.parseInt(Jwts.parserBuilder().setSigningKey(key()).build()
    .parseClaimsJws(token).getBody().getSubject());
          
  }

  public String getRoleFromToken(String token){
      return Jwts.parserBuilder().setSigningKey(key()).build()
      .parseClaimsJws(token).getBody().get("role").toString();
  }

  public boolean validateJwtToken(String authToken) throws Exception{
    try {
      Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
      return true;
    } catch (Exception e){
      throw e;
    }
  }
}
