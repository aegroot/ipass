package server;


import domain.Klant;
import domain.Product;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("winkelwagen")
public class TableServletWinkelWagen {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
public Response getitems(){
       Klant online= Klant.getOnline();
       ArrayList<Product>products= new ArrayList<>();

        return javax.ws.rs.core.Response.ok(online).build();
    }
}
