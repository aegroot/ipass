package server;


import domain.Klant;
import domain.Winkel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("auth{name}{password}")
public class AuthServlet {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticate(@FormParam("username") String uN, @FormParam("password") String pass) {
        boolean winkelb = Winkel.validate(uN, pass);
        boolean klantb = Klant.validate(uN, pass);

        if (winkelb) {
        }
        if (klantb) {
        }
        return null;


    }
}
