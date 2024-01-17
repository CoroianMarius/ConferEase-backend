package com.example.FirstTry.Controller;

import com.example.FirstTry.Entity.User;
import com.example.FirstTry.Repos.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "api/user/")
public class UserController {


    public final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @PostMapping
    public void registerNewUser(@RequestBody User user){
        userRepository.save(user);
    }

    //get the user by id
    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userRepository.findByEmail(email);

        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
