package com.alaska.filters;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Request;
import javax.ws.rs.ext.Provider;

import com.alaska.controllers.UserController;
import com.alaska.models.User;
import com.alaska.utils.exceptions.AuthenticationException;
import com.alaska.utils.security.Authorizer;
import com.alaska.utils.exceptions.UserNotFoundException;
import org.glassfish.jersey.internal.util.Base64;
import org.glassfish.jersey.server.ContainerRequest;

@Provider
@PreMatching
public class SecurityFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext filterContext) throws IOException {
        filterContext.setSecurityContext(new Authorizer(authenticate(filterContext.getRequest())));
    }

    private User authenticate(Request request) {
        String[] values = extractAuthenticationCredentials((ContainerRequest) request);

        String email = values[0];
        String password = values[1];

        try{
            //Try to find the user in the database
            UserController controller = new UserController();

            User user = controller.findUser(email);

            //Todo: This will have to change to being salted and hashed and compared
            //Validate the user
            if (!user.getPassword().equals(password)) {
                throw new AuthenticationException("Invalid username or password\r\n");
            }
            return user;
        }catch(UserNotFoundException e){
            throw new AuthenticationException("Invalid username or password\r\n");
        }
    }

    private String[] extractAuthenticationCredentials(ContainerRequest request){
        String authentication = (request).getHeaderString(HttpHeaders.AUTHORIZATION);

        if (authentication == null) {
            throw new AuthenticationException("Authentication credentials are required");
        }

        if (!authentication.startsWith("Basic ")) {
            throw new AuthenticationException("Only Basic HTTP authorization is supported");
        }

        authentication = authentication.substring("Basic ".length());

        String[] values = Base64.decodeAsString(authentication).split(":");

        //Check the syntax of the authorization header
        if (values.length != 2) {
            throw new WebApplicationException(400);
        }

        //Check to make sure there are values for the email and password
        if (values[0].isEmpty() || values[1].isEmpty()) {
            throw new WebApplicationException(400);
        }

        return values;
    }
}
