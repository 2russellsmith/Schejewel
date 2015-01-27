package com.alaska;

import com.alaska.filters.SecurityFilter;
import com.alaska.resources.AuthenticationResource;
import com.alaska.resources.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class Application extends ResourceConfig {

    public Application() {
        super(AuthenticationResource.class, UserResource.class);
        register(RolesAllowedDynamicFeature.class);
        register(SecurityFilter.class);
    }
}