package com.alaska.controllers;

import com.alaska.daos.MySqlUserDao;
import com.alaska.daos.UserDao;
import com.alaska.models.User;
import com.alaska.utils.exceptions.UserNotFoundException;
import com.alaska.utils.security.Authenticator;

public class UserController{
    private UserDao dao;

    public UserController() {
        dao = new MySqlUserDao();
    }

    public User createUser(User user) {
        Authenticator authenticate = new Authenticator();
        user.setPassword(authenticate.createHash(user.getPassword()));
        dao.createUser(user);
        return user;
    }

    public User findUser(String email) throws UserNotFoundException{
        User user = dao.readUser(email);
        user.setRoles(dao.readUserRoles(user));
        return user;
    }
}
