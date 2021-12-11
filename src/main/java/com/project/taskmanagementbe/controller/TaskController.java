package com.project.taskmanagementbe.controller;

import com.project.taskmanagementbe.model.Task;
import com.project.taskmanagementbe.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public List<Task> getTasks(){
        return taskService.findAll();
    }


}
