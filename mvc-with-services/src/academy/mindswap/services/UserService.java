package academy.mindswap.services;

import academy.mindswap.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUser(Integer id);

    List<User> getUsers();

    boolean editUsername(Integer id, String username);

    boolean editPassword(Integer id, String password);

    boolean editEmail(Integer id, String email);

    boolean deleteUser(Integer id);
}
