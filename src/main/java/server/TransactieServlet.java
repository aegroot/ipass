package server;

import domain.Klant;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

public class TransactieServlet {
    @Path("/rekenaf")
    public Response rekenAf(){
        Klant klant=Klant.getOnline();
        klant.rekenAf();
        return null;
    }
}
