package com.project.taskmanagementbe.controller;

import com.project.taskmanagementbe.model.User;
import com.project.taskmanagementbe.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public List<User> findAll(){
        return usersService.findAll();
    }

}
