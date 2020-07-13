package server;


import domain.Klant;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("budget")
public class BudgetServlet {
    @GET
    public Response getBudget(){
        Klant klant=Klant.getOnline();
        JsonObjectBuilder object= Json.createObjectBuilder();
        object.add("budget",klant.getBudget());
        return Response.ok(object).build();
    }
}
