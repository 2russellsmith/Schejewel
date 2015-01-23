package com.alaska.resources;

import com.alaska.controllers.UserController;
import com.alaska.models.User;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserResource {
    private UserController controller = new UserController();

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        return Response.ok().entity(controller.createUser(user)).build();
    }

    //Todo: Create endpoint /validate to validate users
}
