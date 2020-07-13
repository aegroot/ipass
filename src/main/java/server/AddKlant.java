package server;

import database.OracleBaseDao;
import domain.Klant;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.SQLException;


//maakt een klant object aan
@Path("/register")
public class AddKlant extends OracleBaseDao {

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(@FormParam("name")String naam,@FormParam("email")String email,@FormParam("password")String password){
        try {
            new Klant(naam,email,password);
            //Connection conn=getConnection();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Response.ok().build();
    }
}
