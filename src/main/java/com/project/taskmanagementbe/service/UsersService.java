package com.project.taskmanagementbe.service;

import com.project.taskmanagementbe.model.Task;
import com.project.taskmanagementbe.model.User;
import com.project.taskmanagementbe.wsdto.UserWsDto;

import java.util.List;

public interface UsersService {

    List<UserWsDto> findAll();

    void addTaskToUser(String username, Task task);

}
