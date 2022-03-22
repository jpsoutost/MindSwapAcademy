package academy.mindswap.userdetails.services;

import academy.mindswap.userdetails.persistence.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private List<User> list;

    public UserService() {
        this.list = new ArrayList<>();
        addClients();
    }

    private void addClients(){
        this.list.add(new User(1, "João", "j@g.c"));
        this.list.add(new User(2, "Maria", "m@g.c"));
        this.list.add(new User(3, "Diogo", "d@g.c"));
        this.list.add(new User(4, "Luís", "l@g.c"));
        this.list.add(new User(5, "António", "a@g.c"));
        this.list.add(new User(6, "Tiago", "t@g.c"));
        this.list.add(new User(7, "Ricardo", "r@g.c"));
    }

    public String sayWelcome() {
        return "WELCOME!";
    }

    public List<String> getUsers() {
        return this.list.stream().map(user -> user.getName()).collect(Collectors.toList());
    }

    public String getUserById(@PathVariable Integer id) {
        Optional<User> opt = this.list.stream().filter(user -> user.getID() == id).findFirst();

        return opt.isPresent()? opt.get().toString() : "USER NOT FOUND";
    }
}
