package academy.mindswap.controllers;

import java.util.List;
import java.util.stream.Collectors;

public class ListController extends AbstractController {

    @Override
    public void init() {
        view.setController(this);
        view.show();
        nextController.init();
    }

    public List<String> getUsersInfo() {
        return service.getUsers()
                .stream()
                .map(user -> user.getUsername() + " | " + user.getEmail())
                .collect(Collectors.toList());
    }
}
