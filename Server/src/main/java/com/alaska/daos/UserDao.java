package com.alaska.daos;

import com.alaska.models.User;
import com.alaska.utils.exceptions.UserNotFoundException;

import java.util.Set;

public interface UserDao {
    public User createUser(User user);
    public User readUser(String email) throws UserNotFoundException;
    public Set<String> readUserRoles(User user);
}
