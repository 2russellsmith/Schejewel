package com.alaska.resources;

import com.alaska.controllers.UserController;
import com.alaska.models.User;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserResource {
    private UserController controller = new UserController();

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
		user = controller.createUser(user);
		if (user == null)
			return Response.status(304).entity("email address already in use").type("text/plain").build();
		return Response.ok().entity(user).build();
    }

    //Todo: Create endpoint /validate to validate users
}
