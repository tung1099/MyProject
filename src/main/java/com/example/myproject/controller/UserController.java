package com.example.myproject.controller;

import com.example.myproject.entity.User;
import com.example.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<User> findAll(){
        return userService.findAll();
    }
    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.create(user);
    }
}
