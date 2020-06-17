package server;


import domain.AssortimentProduct;
import domain.Klant;
import domain.Product;
import domain.Winkelwagen;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("winkelwagen")
public class TableServletWinkelWagen {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
public Response getitems(){
        JsonArrayBuilder arrayBuilder= Json.createArrayBuilder();
        Klant online= Klant.getOnline();
        Winkelwagen wagen=online.getWinkelwagen();
        for (int i = 0; i <10 ; i++) {
            JsonObjectBuilder objectBuilder=Json.createObjectBuilder();
            objectBuilder.add("omschrijving",Math.random());
            objectBuilder.add("categorie",Math.random());
            objectBuilder.add("land v herkomst",Math.random());
            objectBuilder.add("prijs",Math.random());
            arrayBuilder.add(objectBuilder);}

            /*
        }
        for (AssortimentProduct aproduct:wagen.getProducten()) {
            JsonObjectBuilder objectBuilder=Json.createObjectBuilder();
            Product product=aproduct.getProduct();
            objectBuilder.add("omschrijving",product.getOmschrijving());
            objectBuilder.add("categorie",product.getCategorie());
            objectBuilder.add("land v herkomst",product.getLandvherkomst());
            objectBuilder.add("prijs",aproduct. berekenprijs());
            arrayBuilder.add(objectBuilder);
        }

             */


        return javax.ws.rs.core.Response.ok(arrayBuilder).build();
    }
    @Path("{item}")
    @POST
    public Response additem(){
        return null;
    }
}
