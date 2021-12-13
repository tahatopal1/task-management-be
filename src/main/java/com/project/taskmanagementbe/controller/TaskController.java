package com.project.taskmanagementbe.controller;

import com.project.taskmanagementbe.model.Task;
import com.project.taskmanagementbe.service.TaskService;
import com.project.taskmanagementbe.wsdto.TaskWsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public List<TaskWsDto> getTasks(){
        return taskService.findAll();
    }

    @GetMapping("/task/{id}")
    public TaskWsDto getTask(@PathVariable Integer id){
        return taskService.find(id);
    }

    @PostMapping("/task")
    public TaskWsDto createTask(@RequestBody TaskWsDto taskWsDto,@RequestParam String username){
        taskService.createTask(taskWsDto, username);
        return taskWsDto;
    }

}
