package server;

import domain.Klant;
import domain.Product;
import domain.Winkel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("winkel")
public class TableServletwinkel {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getitems(){
        Klant online= Klant.getOnline();
        ArrayList<Product> products= online.getProducts();
        return javax.ws.rs.core.Response.ok(products).build();
    }
    @Path("{winkelid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getnames(@PathParam("winkelid") String id){
        ArrayList<Winkel> winkels=Winkel.getWinkels();
        ArrayList<String>names= new ArrayList<>();
        for (Winkel winkel:winkels) {
            names.add(winkel.getWinkelcode());

        }

        return Response.ok(names).build();
    }

}
