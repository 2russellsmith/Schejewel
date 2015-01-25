package com.alaska.resources;

import com.alaska.controllers.UserController;
import com.alaska.models.User;
import com.alaska.utils.InvalidUserLoginException;
import com.alaska.utils.UserExistsException;

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
        try {
            return Response.ok().entity(controller.createUser(user)).build();
        } catch (UserExistsException e) {
            return Response.status(409).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/validate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response validateUser(User user){
        try {
            return Response.ok().entity(controller.validateUser(user)).build();
        } catch(InvalidUserLoginException e){
            return Response.status(401).entity(e.getMessage()).build();
        }
    }
}
