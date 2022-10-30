package com.project.controller;

import com.project.model.User;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public ResponseEntity<List<User>> home() {
        List<User> users = service.loadUsers();
        return new ResponseEntity<>( users, HttpStatus.OK );
    }
}
