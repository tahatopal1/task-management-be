package com.project.taskmanagementbe.service;

import com.project.taskmanagementbe.model.Task;
import com.project.taskmanagementbe.model.User;

import java.util.List;

public interface UsersService {

    List<User> findAll();

    void addTaskToUser(String username, Task task);

}
