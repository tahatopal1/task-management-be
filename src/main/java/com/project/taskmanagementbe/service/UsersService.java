package com.project.taskmanagementbe.service;

import com.project.taskmanagementbe.model.Task;
import com.project.taskmanagementbe.model.User;
import com.project.taskmanagementbe.wsdto.UserWsDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsersService extends UserDetailsService {

    List<UserWsDto> findAll();

    void addTaskToUser(Integer id, Task task);

    UserWsDto find(Integer id);

    UserWsDto findByUsername(String username);

}
