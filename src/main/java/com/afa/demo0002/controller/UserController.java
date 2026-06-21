package com.afa.demo0002.controller;

import com.afa.demo0002.model.Users;
import com.afa.demo0002.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("/register")
    public Users user(@RequestBody Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return service.register(user);
    }

    @GetMapping("users")
    public List<Users> getUsers(){
        return service.getUsers();
    }



}
