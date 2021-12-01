package com.sergioarboleda.app.controller;

import com.sergioarboleda.app.model.User;
import com.sergioarboleda.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")

public class UserController {
    
    @Autowired
    private UserService service;

    
    @GetMapping("/all")
    public List<User> getAll() {
        return service.getAll();
    }

    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user){
        return service.create(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return service.update(user);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }

    
    @GetMapping("/emailexist/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return service.emailExists(email);
    }

    
    @GetMapping("/{email}/{password}")
    public User authUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return service.authenticateUser(email, password);
    }
}
