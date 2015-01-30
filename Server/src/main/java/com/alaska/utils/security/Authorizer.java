package com.alaska.utils.security;

import com.alaska.models.User;

import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import java.security.Principal;

public class Authorizer implements SecurityContext {
    @Inject
    javax.inject.Provider<UriInfo> uriInfo;

    private User user;
    private Principal principal;

    public Authorizer(final User user) {
        this.user = user;
        this.principal = new UserPrincipal(user);
    }

    public Principal getUserPrincipal() {
        return this.principal;
    }

    public boolean isUserInRole(String role) {
        return (user.getRoles().contains(role));
    }

    public boolean isSecure() {
        return "https".equals(uriInfo.get().getRequestUri().getScheme());
    }

    public String getAuthenticationScheme() {
        return SecurityContext.BASIC_AUTH;
    }
}
