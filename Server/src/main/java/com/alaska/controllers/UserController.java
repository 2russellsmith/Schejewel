package com.alaska.controllers;

import com.alaska.daos.MySqlUserDao;
import com.alaska.daos.UserDao;
import com.alaska.models.User;

import java.util.ArrayList;

public class UserController {
    private UserDao dao;

    public UserController() {
        dao = new MySqlUserDao();
    }

    public User createUser(User user) {
        ArrayList<User> users = dao.readUsers();
		
		for (User u : users){
			if (user.getEmail().equals(u.getEmail()))
				return null;
		}
		
        dao.createUser(user);
        return user;
    }

    public Boolean validateUser(User user){
        ArrayList<User> users = dao.readUsers();
        //Todo: Check if the user exists in this list and validate the users password.
        return false;
    }
}
