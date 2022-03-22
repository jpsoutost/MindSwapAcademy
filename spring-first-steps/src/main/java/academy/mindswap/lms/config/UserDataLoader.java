package academy.mindswap.lms.config;

import academy.mindswap.lms.persistence.models.User;
import academy.mindswap.lms.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDataLoader {

    @Autowired
    private UserRepository userRepository;

    public void loadData() {
       // userRepository.deleteAll();
        for (int i = 1; i <= 10; i++) {
            User user = User.builder().id(i).name("user"+i).email("user" + i + "@email").password(i+"pass"+i).build();
            createIfNotFound(i, user);
        }
    }

    public void createIfNotFound(Integer id, User userToSave) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresentOrElse(
                u -> {
                    System.out.println("User already exists");
                },
                () -> {
                    System.out.println("User not found, creating...");

                    userRepository.save(userToSave);
                }
        );
    }

}
