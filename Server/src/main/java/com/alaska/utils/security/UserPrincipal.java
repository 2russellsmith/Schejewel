package com.alaska.utils.security;

import com.alaska.models.User;

import javax.security.auth.Subject;
import java.security.Principal;

public class UserPrincipal implements Principal {
    private User user;

    public UserPrincipal(User user){
        this.user = user;
    }

    @Override
    public String getName() {
        return user.getEmail();
    }

    @Override
    public boolean implies(Subject subject) {
        //Todo: What should go in this method?
        return false;
    }
}
