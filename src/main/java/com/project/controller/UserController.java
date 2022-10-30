package com.project.controller;

import com.project.model.User;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  // [since Spring 4, @RestController = @Controller + @ResponseBody. Postman -> to test REST methods]
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/saveUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        service.saveUser( user );
        var userResponseEntity = new ResponseEntity<User>( HttpStatus.CREATED );
        return userResponseEntity;
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") int userId, @RequestBody User getUser) {
        User user = service.getUserById( userId );

        user.setFirstName( getUser.getFirstName() );
        user.setLastName( getUser.getLastName() );
        user.setEmail( getUser.getEmail() );
        user.setUsername( getUser.getUsername() );
        user.setPassword( getUser.getPassword() );

        service.updateUser( user );
        return new ResponseEntity<>( HttpStatus.OK );
    }

    // delete user
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable("userId") int userId, @ModelAttribute User user) {
        service.deleteUser( userId );
//        return "redirect:/";
        return new ResponseEntity<>( user, HttpStatus.NO_CONTENT );
    }

}
