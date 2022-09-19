package com.example.UserDataAPI.Filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Component
public class JwtUtil implements Serializable {
      @Value("${jwt.secret}")
      private String secret;
      private static final long JWT_VALID_PERIOD_IN_SEC=7*24*60*60;

      public String getUsernameFromToken(String token){
          return getClaimFromToken(token, Claims::getSubject);
      }
    public Date getIssueDateFromToken(String token){
        return getClaimFromToken(token, Claims::getIssuedAt);
    }
    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }
    public <T> T getClaimFromToken(String token, Function<Claims,T> claimsResolver){
          final Claims claims=getAllClaimsFromToken(token);
          return claimsResolver.apply(claims);
    }
    private Claims getAllClaimsFromToken(String token){
          return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
    private Boolean ignoreTokenExpiration(String token){
          return false;
    }
    private Boolean isTokenExpired(String token){
          final Date expiration=getExpirationDateFromToken(token);
          return expiration.before(new Date());
    }
    public String generateToken(UserDetails userDetails){
          Map<String,Object> claims = new HashMap<>();
          return doGenerateToken(claims,userDetails.getUsername());
    }
    public String doGenerateToken(Map<String,Object> claims,String subject){
          return Jwts.builder().setClaims(claims).setSubject(subject)
                  .setIssuedAt(new Date(System.currentTimeMillis()+JWT_VALID_PERIOD_IN_SEC*1000))
                  .signWith(SignatureAlgorithm.HS512,secret).compact();
    }
    public Boolean canTokenBeRefreshed(String token){
          return (!isTokenExpired(token)||ignoreTokenExpiration(token));
    }
    public Boolean validateToken(String token,UserDetails userDetails){
          final String username=getUsernameFromToken(token);
          return(username.equals(userDetails.getUsername())&&!isTokenExpired(token));
    }
}
