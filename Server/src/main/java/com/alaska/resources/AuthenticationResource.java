package com.alaska.resources;

import com.alaska.controllers.UserController;
import com.alaska.models.LoginResponse;
import com.alaska.utils.exceptions.UserNotFoundException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.UUID;

@Path("/")
public class AuthenticationResource {
    private UserController controller = new UserController();

    @GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response validateUser(@Context SecurityContext sc, String email){
        try {
            //Todo: Tokens are currently not used we are just passing this back to mock tokens.
            return Response.ok().entity(new LoginResponse(controller.findUser(sc.getUserPrincipal().getName()),UUID.randomUUID().toString())).build();
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
