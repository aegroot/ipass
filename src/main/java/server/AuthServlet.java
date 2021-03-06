package server;


import domain.Klant;
import domain.Winkel;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.JsonString;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.AbstractMap;
import java.util.Calendar;


public class AuthServlet {


    public String createToken(String username,String role){
        final Key key= MacProvider.generateKey();
        Calendar expiration=Calendar.getInstance();
        expiration.add(Calendar.MINUTE,30);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiration.getTime())
                .claim("role",role)
                .signWith(SignatureAlgorithm.HS512,key)
                .compact();
    }

    @Path("auth")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticate(@FormParam("username") String uN,
                                 @FormParam("password") String pass) {

       
        try{
        JsonObjectBuilder objectBuilder= Json.createObjectBuilder();
        String rol = "";
        boolean winkelb = Winkel.validate(uN, pass);
        boolean klantb = Klant.validate(uN, pass);

        if (winkelb) {
            Winkel.setWinkelonline(Winkel.getbyaccount(uN, pass));
            objectBuilder.add("naam","winkel");
            rol="winkel";
            String token=createToken(uN,rol);
            return Response.ok(objectBuilder).build();
        }
        if (klantb) {
            rol="klant";
            Klant.setOnline(Klant.getbyaccount(uN, pass));
            objectBuilder.add("naam","klant");
            String token=createToken(uN,rol);
            return Response.ok(objectBuilder).build();
        }

        if (rol==""){throw new IllegalArgumentException("no user found");}
        String token=createToken(uN, rol);
        AbstractMap.SimpleEntry<String,String> JWT=new AbstractMap.SimpleEntry<>("JWT",token);
        return Response.ok(JWT).build();}
        catch (JwtException |IllegalArgumentException e)
        {return Response.status(Response.Status.UNAUTHORIZED).build();}


    }
    
}