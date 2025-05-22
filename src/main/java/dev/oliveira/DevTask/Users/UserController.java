package dev.oliveira.DevTask.Users;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // CREATE
    @PostMapping()
    public UserModel createUser(@RequestBody UserModel user) {
        return userRepository.save(user);
    }


    // READ ALL
    @GetMapping()
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

}
