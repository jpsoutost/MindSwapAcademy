package academy.mindswap.controllers;

import academy.mindswap.models.User;
import academy.mindswap.services.UserServiceImpl;
import academy.mindswap.views.View;

import java.util.Optional;

public class LoginController extends AbstractController {

    public boolean doAuthentication(String username, String password) {
        Optional<User> authenticatedUser = service.getUsers().stream()
                .filter(user -> user.getUsername().equals(username))
                .filter(user -> user.getPassword().equals(password))
                .findFirst();

        authenticatedUser.ifPresent(user -> setAuthenticatedUserId(user.getId()));
        return authenticatedUser.isPresent();
    }
}
