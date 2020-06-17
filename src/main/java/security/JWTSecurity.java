package security;

import io.jsonwebtoken.JwtParser;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Security;

@Provider
@Priority(Priorities.AUTHENTICATION)

public class JWTSecurity implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        boolean isSecure=requestContext.getSecurityContext().isSecure();
        String scheme=requestContext.getUriInfo().getRequestUri().getScheme();
        //mySecurityContext msc=new mySecurityContext(null,scheme);
        String authHeader=requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if(authHeader!=null&&authHeader.startsWith("Bearer ")){
            String token=authHeader.substring("Bearer".length()).trim();


                // try {JwtParser parser=JwtParser(). }

        }


    }
}
