package com.project.taskmanagementbe.service;

import com.project.taskmanagementbe.model.Role;
import com.project.taskmanagementbe.model.Task;
import com.project.taskmanagementbe.model.User;
import com.project.taskmanagementbe.repository.TaskRepository;
import com.project.taskmanagementbe.repository.UsersRepository;
import com.project.taskmanagementbe.wsdto.RoleWsDto;
import com.project.taskmanagementbe.wsdto.TaskWsDto;
import com.project.taskmanagementbe.wsdto.UserWsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public void addTaskToUser(Integer id, Task task) {
        usersRepository.findById(id).ifPresentOrElse(user -> {
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
    public UserWsDto find(Integer id) {
        return usersRepository.findById(id)
                .map(this::convert)
                .orElseGet(UserWsDto::new);
    }

    @Override
    public UserWsDto findByUsername(String username) {
        return Optional.ofNullable(usersRepository.findByUsername(username))
                            .map(this::convert)
                            .orElseGet(UserWsDto::new);
    }

    @Override
    public UserWsDto convert(User user) {
        UserWsDto userWsDto = new UserWsDto(user.getUsername(), user.getPassword());
        userWsDto.setTaskWsDtos(user.getTasks().stream().map(task -> {
            TaskWsDto taskWsDto = new TaskWsDto();
            taskWsDto.setUserWsDto(null);
            taskWsDto.setTitle(task.getTitle());
            taskWsDto.setId(task.getId());
            return taskWsDto;
        }).collect(Collectors.toList()));
        userWsDto.setRoleWsDtos(user.getRoles().stream()
                                .map(role -> new RoleWsDto(role.getName()))
                                .collect(Collectors.toList()));
        return userWsDto;
    }
}
