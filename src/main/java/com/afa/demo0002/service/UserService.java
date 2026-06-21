package com.afa.demo0002.service;

import com.afa.demo0002.model.Users;
import com.afa.demo0002.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public Users register(Users user){
        return repo.save(user);
    }

    public List<Users> getUsers(){
        return repo.findAll();
    }


}
