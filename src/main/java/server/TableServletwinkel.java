package server;

import domain.AssortimentProduct;
import domain.Product;
import domain.Winkel;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/winkel")
public class TableServletwinkel {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getitems(){

        Winkel winkel=Winkel.getWinkelonline();
        JsonArrayBuilder builder= Json.createArrayBuilder();
        ArrayList<AssortimentProduct> products= winkel.getProducten();
        for (AssortimentProduct aproduct:products) {
            JsonObjectBuilder object=Json.createObjectBuilder();
            Product product=aproduct.getProduct();
            object.add("omschrijving",product.getOmschrijving());
            object.add("categorie",product.getCategorie());
            object.add("land v herkomst",product.getLandvherkomst());
            object.add("prijs",aproduct.berekenprijs());
            builder.add(object);
        }
        return javax.ws.rs.core.Response.ok(builder).build();

    }
    @Path("{winkelid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getnames(@PathParam("winkelid") String id){
        ArrayList<Winkel> winkels=Winkel.getWinkels();
        JsonArrayBuilder builder= Json.createArrayBuilder();
        for (Winkel winkel:winkels) {
            JsonObjectBuilder object=Json.createObjectBuilder();
            object.add("naam",winkel.getWinkelcode());
            builder.add(object);
        }
        return Response.ok(builder).build();
    }
}
