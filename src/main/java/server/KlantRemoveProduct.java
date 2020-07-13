package server;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

public class KlantRemoveProduct {
    @Path("/id}")
    @DELETE
    public Response deleteItem(){
        return null;
    }
}
