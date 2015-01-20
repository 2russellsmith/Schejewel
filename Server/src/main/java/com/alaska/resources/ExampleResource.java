package com.alaska.resources;

import com.alaska.controllers.ExampleController;
import com.alaska.models.Message;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ExampleResource {
    private ExampleController controller = new ExampleController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage() {
        return controller.getMessage();
    }
}
