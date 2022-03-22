package academy.mindswap.lms.controllers;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String sayHello() {
        return "Hi from UserController";
    }

    @GetMapping("/users")
    public User getUser() {
        return User.builder()
                .email("j@g.c")
                .name("John")
                .build();
        //return new User("John", "Doe");
    }

    @GetMapping("/users/{id}")
    public User geUserById(@PathVariable Integer id){
        return User.builder()
                .email("j@g.c")
                .name("John")
                .id(id)
                .build();
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class User{
        private Integer id;
        private String name;
        private String email;
    }

}
