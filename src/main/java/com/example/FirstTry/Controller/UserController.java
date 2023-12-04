package com.example.FirstTry.Controller;

import com.example.FirstTry.Entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "api/user")
public class UserController {
    @GetMapping
    public User getUser(){
        return new User();
    }
}