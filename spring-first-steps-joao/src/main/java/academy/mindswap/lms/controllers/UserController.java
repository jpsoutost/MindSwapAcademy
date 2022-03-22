package academy.mindswap.lms.controllers;

import academy.mindswap.lms.commands.UserDto;
import academy.mindswap.lms.persistence.models.User;
import academy.mindswap.lms.services.GitHubLookupService;
import academy.mindswap.lms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GitHubLookupService gitHubLookupService;

  /*  public UserController(UserService userService) {
        this.userService = userService;
    }*/


    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto>  getUserById(@PathVariable Integer id) {
        Optional<UserDto> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            System.out.println(("Error: " + bindingResult.getAllErrors()));
            return ResponseEntity.badRequest().body(null);
        }
        UserDto  createdUserDto = userService.save(userDto);
        if (createdUserDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }
    @GetMapping("/search")
    public List<UserDto> getUserByName(@RequestParam(value = "name", defaultValue = "World") String name) {
        return  userService.getUserByName(name);
    }

    @GetMapping("/find")
    public List<UserDto> getUserByNameIWant(@RequestParam(value = "name", defaultValue = "World") String name) {
        return  userService.getUserByOther(name);
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return  userService.getAllUsers();
    }

    @GetMapping("/user/github/{githubId}")
    public User getUserGitHubUser(@PathVariable String githubId) throws ExecutionException, InterruptedException {
        CompletableFuture<User> user = gitHubLookupService.findUsr(githubId);
        User userGit = user.get();
        return userGit;
    }

/*
    @GetMapping("/user")
    public User  getUser() {
     return   User.builder()
                .email("j@jsd.com")
                .name("j")
                .build();

     //   return new User("John", "Doe");
    }
    @GetMapping("/search")
    public User getUserByName(@RequestParam(value = "name", defaultValue = "World") String name,
                              @RequestParam(value = "lastname", defaultValue = "World") String lastname,
                              @RequestParam(value = "email", defaultValue = "d@d.com") String email,
                              @RequestParam(value = "name", defaultValue = "1") String id
                              ) {
        return  User.builder()
                .id(1)
                .email(email)
                .name(name + " " + lastname + " " + id)
                .build();
        //   return new User("John", "Doe");
    }


    @PostMapping("/users")
    public  List<User> newUsers( @RequestBody List<User> users) {
       // user.setName(user.getName() + " Resposta" );

        //Create a new users list

        return users;
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        // delete user
    }


    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        user.setName(user.getName() + " Resposta" + id);
        return user;
    }

*/
}
