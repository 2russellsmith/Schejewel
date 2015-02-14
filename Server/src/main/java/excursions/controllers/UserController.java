package excursions.controllers;

import excursions.daos.interfaces.UserDao;
import excursions.daos.JdbcUserDao;
import excursions.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao = new JdbcUserDao();

    public User createUser(User user){
        return userDao.createUser(user);
    }
}
