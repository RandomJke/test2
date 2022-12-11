package com.example.myspringproject.controller;

import com.example.myspringproject.entity.User;
import com.example.myspringproject.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("")
    public List<User> list() {
        return userService.listAlluser();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable int id) throws Exception {
        return userService.getUser(id);
    }

    @GetMapping("/userByFirstName/{name}")
    public List<User> getUserByFirstName(@PathVariable String name) throws Exception {
        return userService.findByFirstName(name);
    }

    @GetMapping("/userByLastName/{name}")
    public List<User> getUserByLastName(@PathVariable String name) throws Exception {
        return userService.findByLastName(name);
    }

    @PostMapping("/")
    public void add(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody User user, @PathVariable int id) {
        user.setId(id);
        userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.deleteUser(id);
    }

}
