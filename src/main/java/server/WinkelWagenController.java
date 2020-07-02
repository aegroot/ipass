package server;

import domain.AssortimentProduct;
import domain.Klant;
import domain.Product;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/winkelwagen")
public class WinkelWagenController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
public Response getShoppingcartByCustomer(){

       // Klant online=Klant.getOnline();
        //assert online != null;
        JsonArrayBuilder arrayBuilder= Json.createArrayBuilder();
        for (int i = 0; i <10 ; i++) {
            JsonObjectBuilder objectBuilder=Json.createObjectBuilder();
            objectBuilder.add("omschrijving","o");
            objectBuilder.add("categorie","c");
            objectBuilder.add("landvherkomst","l");
            objectBuilder.add("prijs","p");
            arrayBuilder.add(objectBuilder);}
            /*

        for (AssortimentProduct aproduct:online.getWinkelwagen().getProducten()) {
            JsonObjectBuilder objectBuilder=Json.createObjectBuilder();
            Product product=aproduct.getProduct();
            objectBuilder.add("omschrijving",product.getOmschrijving());
            objectBuilder.add("categorie",product.getCategorie());
            objectBuilder.add("land v herkomst",product.getLandvherkomst());
            objectBuilder.add("prijs",aproduct. berekenprijs());
            arrayBuilder.add(objectBuilder);
        }

             */
        return javax.ws.rs.core.Response.ok(arrayBuilder.build()).build();

    }
    @Path("{item}")
    @POST
    public Response additem(){

        return null;
    }
}
