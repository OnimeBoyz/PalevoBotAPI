package edu.onimeboyz.palevobotapi.controllers;

import edu.onimeboyz.palevobotapi.entities.User;
import edu.onimeboyz.palevobotapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{username}")
    public User getUserByName(@PathVariable(value = "username") String username) {
        return userRepository.findAll().stream()
                .filter(user -> user.getUsername().trim().equals(username.trim()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wrong username"));
    }

    @PutMapping("/{username}")
    public User updateNote(@PathVariable(value = "username") String username,
                              @Valid @RequestBody User userDetails) {

        User user = getUserByName(username);

        user.setUsername(userDetails.getUsername());
        user.setRating(userDetails.getRating());

        return userRepository.save(user);
    }


    @DeleteMapping("/username")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "username") String username) {

        User user = getUserByName(username);
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

}
