package server;


import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class WinkelRemoveProduct {
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    public Response deleteItem(){
        return null;
    }
}
