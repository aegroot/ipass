package server;


import domain.Klant;
import domain.Winkel;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.JsonString;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("auth")
public class AuthServlet {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticate(@FormParam("username") String uN, @FormParam("password") String pass) {
        boolean winkelb = Winkel.validate(uN, pass);
        boolean klantb = Klant.validate(uN, pass);
        JsonObjectBuilder objectBuilder= Json.createObjectBuilder();

        if (winkelb) {
            Winkel.setWinkelonline(Winkel.getbyaccount(uN, pass));
            objectBuilder.add("naam","winkel");
            return Response.ok(objectBuilder).build();
        }
        if (klantb) {
            Klant.setOnline(Klant.getbyaccount(uN, pass));
            objectBuilder.add("naam","klant");
            return Response.ok(objectBuilder).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();


    }
}
