package dev.oliveira.DevTask.Users;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // CREATE
    @PostMapping()
    public UserModel createUser(@RequestBody UserModel user) {
        log.info("POST /users - Body: {}", user);

        user.setStatus(Boolean.FALSE);

        return userRepository.save(user);
    }


    // READ ALL
    @GetMapping()
    public List<UserModel> getAll() {
        log.info("GET /users");

        return userRepository.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public UserModel getById(@PathVariable Long id) {
        log.info("GET /users/{}", id);

        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel userDetails) {
        log.info("PUT /users/{} - Body: {}", id, userDetails);

        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        user.setNome(userDetails.getNome());
        user.setEmail(userDetails.getEmail());
        user.setIdade(userDetails.getIdade());

        return userRepository.save(user);
    }

    // DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        log.info("DELETE /users/{}", id);

        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        userRepository.deleteById(id);
    }

}
