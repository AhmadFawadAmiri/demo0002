package com.afa.demo0002.service;

import com.afa.demo0002.model.Users;
import com.afa.demo0002.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    public Users register(Users user){
        return repo.save(user);
    }

    public List<Users> getUsers(){
        return repo.findAll();
    }

    public String verify(Users user){
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if (authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());

        return "fail";

    }

}
