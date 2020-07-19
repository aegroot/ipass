package server;

import domain.AssortimentProduct;
import domain.Klant;
import domain.Product;
import domain.Winkelwagen;

import javax.annotation.Priority;
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
        //voor testen
        JsonArrayBuilder arrayBuilder= Json.createArrayBuilder();
        for (int i = 0; i <10 ; i++) {
            JsonObjectBuilder objectBuilder=Json.createObjectBuilder();
            objectBuilder.add("omschrijving","o");
            objectBuilder.add("categorie","c");
            objectBuilder.add("landvherkomst","l");
            objectBuilder.add("prijs","p");
            objectBuilder.add("id","id");
            arrayBuilder.add(objectBuilder);}
            /*

        for (AssortimentProduct aproduct:online.getWinkelwagen().getProducten()) {
            JsonObjectBuilder objectBuilder=Json.createObjectBuilder();
            Product product=aproduct.getProduct();
            objectBuilder.add("omschrijving",product.getOmschrijving());
            objectBuilder.add("categorie",product.getCategorie());
            objectBuilder.add("land v herkomst",product.getLandvherkomst());
            objectBuilder.add("prijs",aproduct. berekenprijs());
              objectBuilder.add("id",aproduct.getId);
            arrayBuilder.add(objectBuilder);
        }

             */
        return javax.ws.rs.core.Response.ok(arrayBuilder.build()).build();

    }
    @Path("{id}")
    @DELETE
    public Response deleteItem(@PathParam("id")int id){
        Klant klant=Klant.getOnline();
        Winkelwagen winkelwagen=klant.getWinkelwagen();
        winkelwagen.remproduct(winkelwagen.getByid(id));
        return null;
    }



    @Path("{id}")
    @PUT
    public Response additem(@PathParam("id")int id){
        Klant klant=Klant.getOnline();
        Winkelwagen winkelwagen=klant.getWinkelwagen();
        boolean bool=winkelwagen.addproduct(winkelwagen.getByid(id));
        if (bool=true){
            return Response.ok().build();

        }
            else{
                return Response.status(304).build();

        }

    }
}
