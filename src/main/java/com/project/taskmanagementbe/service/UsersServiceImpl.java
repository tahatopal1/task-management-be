package com.project.taskmanagementbe.service;

import com.project.taskmanagementbe.model.Task;
import com.project.taskmanagementbe.model.User;
import com.project.taskmanagementbe.repository.TaskRepository;
import com.project.taskmanagementbe.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    @Transactional
    public void addTaskToUser(String username, Task task) {
        usersRepository.findById(username).ifPresentOrElse(user -> {
            user.getTasks().add(task);
            task.setUser(user);
            usersRepository.save(user);
        }, () -> {
            try {
                throw new Exception("UserServiceError: ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
