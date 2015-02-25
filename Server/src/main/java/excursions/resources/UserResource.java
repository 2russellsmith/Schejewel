package excursions.resources;

import excursions.controllers.UserController;
import excursions.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserResource {
    @Autowired
    private UserController userController = new UserController();

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public @ResponseBody User createUser(@RequestBody User user){
        return userController.createUser(user);
    }
}