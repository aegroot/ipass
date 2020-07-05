package security;

import org.apache.catalina.User;
import org.glassfish.jersey.server.SubjectSecurityContext;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Principal;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {


    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        boolean isSecure =requestContext.getSecurityContext().isSecure();
        String scheme=requestContext.getUriInfo().getRequestUri().getScheme();
        String authheader=requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);



    }
}

