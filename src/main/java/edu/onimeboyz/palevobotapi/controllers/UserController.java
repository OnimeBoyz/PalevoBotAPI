package edu.onimeboyz.palevobotapi.controllers;

import edu.onimeboyz.palevobotapi.entities.User;
import edu.onimeboyz.palevobotapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Wrong id"));
    }

    @GetMapping("/users/{username}")
    public User getUserById(@PathVariable(value = "username") String username) {
        return userRepository.findAll().stream()
                .filter(user -> user.getUsername().trim().equals(username.trim()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wrong username"));
    }

    @PutMapping("/users/{id}")
    public User updateNote(@PathVariable(value = "id") Integer userId,
                              @Valid @RequestBody User userDetails) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Wrong id"));

        user.setUsername(userDetails.getUsername());
        user.setRating(userDetails.getRating());

        return userRepository.save(user);
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer userId) {
        System.out.println(userRepository.findAll().size());
        for (User user: userRepository.findAll()) {
            System.out.println(user.getId());
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Wrong id"));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

}
