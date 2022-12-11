package com.example.myspringproject.service;

import com.example.myspringproject.entity.User;
import com.example.myspringproject.repository.UserRepository;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAlluser() {
        return (List<User>) userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUser(int id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new Exception("Такой пользователь не найден");
        }
        return user.get();
    }

    public List<User> findByFirstName(String name) throws Exception {
        if (userRepository.findByFirstName(name).isEmpty()) {
            throw new Exception("Такое имя не найдено");
        }
        return userRepository.findByFirstName(name);
    }

    public List<User> findByLastName(String name) throws Exception {
        if (userRepository.findByLastName(name).isEmpty()) {
            throw new Exception("Такое имя не найдено");
        }
        return userRepository.findByLastName(name);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
