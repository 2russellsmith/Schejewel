package com.alaska.daos;

import com.alaska.models.User;

import java.util.ArrayList;

public interface UserDao {
    public User createUser(User user);
    public ArrayList<User> readUsers();
}
