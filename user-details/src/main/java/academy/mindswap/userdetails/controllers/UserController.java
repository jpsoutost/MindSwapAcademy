package academy.mindswap.userdetails.controllers;

import academy.mindswap.userdetails.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String sayWelcome() {
        return userService.sayWelcome();
    }

    @GetMapping("/users")
    public List<String> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable Integer id) {
        return  userService.getUserById(id);
    }

}
