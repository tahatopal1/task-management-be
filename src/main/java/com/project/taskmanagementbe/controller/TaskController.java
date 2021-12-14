package com.project.taskmanagementbe.controller;

import com.project.taskmanagementbe.service.TaskService;
import com.project.taskmanagementbe.wsdto.TaskWsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public TaskWsDto createTask(@RequestBody TaskWsDto taskWsDto,@RequestParam Integer id){
        taskService.createTask(taskWsDto, id);
        return taskWsDto;
    }

    @PutMapping("/task")
    public TaskWsDto updateTask(@RequestBody TaskWsDto taskWsDto){
        taskService.updateTask(taskWsDto);
        return taskWsDto;
    }

}
