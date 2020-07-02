package server;

import domain.Klant;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;


//maakt een klant object aan
@Path("/register")
public class AddKlant {
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(@FormParam("name")String naam,@FormParam("email")String email,@FormParam("password")String password){
        try {
            new Klant(naam,email,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Response.ok().build();
    }
}
