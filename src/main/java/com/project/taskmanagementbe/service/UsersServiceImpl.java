package com.project.taskmanagementbe.service;

import com.project.taskmanagementbe.model.Task;
import com.project.taskmanagementbe.model.User;
import com.project.taskmanagementbe.repository.TaskRepository;
import com.project.taskmanagementbe.repository.UsersRepository;
import com.project.taskmanagementbe.wsdto.TaskWsDto;
import com.project.taskmanagementbe.wsdto.UserWsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService, Converter<User, UserWsDto> {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<UserWsDto> findAll() {
        return usersRepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
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
                throw new Exception("UserServiceError:  ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public UserWsDto convert(User user) {
        UserWsDto userWsDto = new UserWsDto(user.getUsername(), user.getPassword(), user.getEnabled());
        userWsDto.setTaskWsDtos(user.getTasks().stream().map(task -> {
            TaskWsDto taskWsDto = new TaskWsDto();
            taskWsDto.setUserWsDto(null);
            taskWsDto.setTitle(task.getTitle());
            taskWsDto.setId(task.getId());
            return taskWsDto;
        }).collect(Collectors.toList()));
        return userWsDto;
    }
}
