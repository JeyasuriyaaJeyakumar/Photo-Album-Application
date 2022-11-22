package com.example.assignment6.service;


import com.example.assignment6.model.User;
import com.example.assignment6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    public void  deleteUser(String id) {
         userRepository.deleteById(id);
    }

    public User getUserById(String id) {
        return  userRepository.findById(id).get();
    }

    public List<User> getByName(String name) {
        return userRepository.findAllByName(name);
    }



}
