package com.project.taskmanagementbe.controller;

import com.project.taskmanagementbe.model.Task;
import com.project.taskmanagementbe.model.User;
import com.project.taskmanagementbe.service.UsersService;
import com.project.taskmanagementbe.wsdto.UserWsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public List<UserWsDto> findAll(){
        return usersService.findAll();
    }

    @PostMapping("/users/{id}")
    public void addTaskToUser(@PathVariable Integer id, @RequestBody Task task){
        usersService.addTaskToUser(id, task);
    }

    @GetMapping("/users/{id}")
    public UserWsDto find(@PathVariable Integer id){
        return usersService.find(id);
    }

    @GetMapping("/users/username/{username}")
    public UserWsDto findByUsername(@PathVariable String username){
        return usersService.findByUsername(username);
    }

}
