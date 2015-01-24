package com.alaska.controllers;

import com.alaska.daos.MySqlUserDao;
import com.alaska.daos.UserDao;
import com.alaska.models.User;
import com.alaska.utils.InvalidUserLoginException;
import com.alaska.utils.UserExistsException;

import java.util.ArrayList;

public class UserController{
    private UserDao dao;

    public UserController() {
        dao = new MySqlUserDao();
    }

    public User createUser(User user) throws UserExistsException{
        ArrayList<User> users = dao.readUsers();
		
		for (User u : users){
			if (user.getEmail().equals(u.getEmail())){
                throw new UserExistsException();
            }
		}
		
        dao.createUser(user);
        return user;
    }

    public String validateUser(User user) throws InvalidUserLoginException{
        User dbUser = dao.readUser(user);
        if(dbUser.getPassword().equals(user.getPassword())){
            String token = "valid";
            return token;
        }else{
            throw new  InvalidUserLoginException();
        }
    }
}
