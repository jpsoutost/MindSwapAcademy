package academy.mindswap.services;

import academy.mindswap.models.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static int nextId;
    private List<User> users;

    public UserServiceImpl() {
        users = new LinkedList<>();
    }

    public void createUsers() {
        users.add(new User("crazycatlady_21", ++nextId, "cats_are_cool@gmail.com", "catsarelife"));
        users.add(new User("been_there_done_that", ++nextId, "johnnyc82@gmail.com", "password"));
        users.add(new User("smverissimo90", ++nextId, "smverissimo90@gmail.com", "1234"));
        users.add(new User("shaquille-oatmeal", ++nextId, "shaqthebest@gmail.com", "psswd"));
        users.add(new User("chicksbeforeducks", ++nextId, "camisanchez34@gmail.com", "quack"));
    }

    @Override
    public Optional<User> getUser(Integer id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public boolean editUsername(Integer id, String username) {
        Optional<User> userToEdit = getUser(id);

        if (userToEdit.isPresent()) {
            userToEdit.get().setUsername(username);
            return true;
        }

        return false;
    }

    @Override
    public boolean editPassword(Integer id, String password) {
        Optional<User> userToEdit = getUser(id);

        if (userToEdit.isPresent()) {
            userToEdit.get().setPassword(password);
            return true;
        }

        return false;
    }

    @Override
    public boolean editEmail(Integer id, String email) {
        Optional<User> userToEdit = getUser(id);

        if (userToEdit.isPresent()) {
            userToEdit.get().setEmail(email);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteUser(Integer id) {
        Optional<User> userToEdit = getUser(id);
        return userToEdit.map(user -> users.remove(user)).orElse(false);
    }
}
