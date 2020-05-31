package server;

import domain.Klant;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


//maakt een klant object aan
@Path("register")
public class AddKlant {
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(@FormParam("name")String naam,@FormParam("email")String email,@FormParam("password")String password){
        new Klant(naam,email,password);
        return Response.ok().build();
    }
}
