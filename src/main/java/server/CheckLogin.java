package server;

import domain.Klant;
import domain.Winkel;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("checklogin")
public class CheckLogin {

    @POST
    public Response checklogin(){
        Klant k= Klant.getOnline();
        Winkel w= Winkel.getWinkelonline();
        if((w == null )&&(k == null)){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
       return Response.ok().build();

    }
}
