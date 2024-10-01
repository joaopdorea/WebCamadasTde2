package com.empresa.projetoapi.api;

import com.empresa.projetoapi.model.User;
import com.empresa.projetoapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService){

        this.userService = userService;

    }

    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable Integer id){

        Optional<User> user = userService.getUser(id);
        return (User)user.orElse(null);
    }

    @GetMapping("/users")
    public List<User> getUsers(){

        return userService.getUserList();
    }

    @PostMapping(value = "/user", consumes = {"application/xml", "application/json"})
    public ResponseEntity<String> createUser(@RequestBody User user){

            userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("ok");

    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){

        userService.removeUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("ok");

    }

    @PutMapping("/user")
    public ResponseEntity<String> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }






}
