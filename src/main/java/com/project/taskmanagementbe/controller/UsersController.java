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

    @PostMapping("/users/{username}")
    public void addTaskToUser(@PathVariable String username, @RequestBody Task task){
        usersService.addTaskToUser(username, task);
    }

}
