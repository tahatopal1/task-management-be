package com.project.taskmanagementbe.service;

import com.project.taskmanagementbe.model.Task;
import com.project.taskmanagementbe.repository.TaskRepository;
import com.project.taskmanagementbe.wsdto.TaskWsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService, Converter<Task, TaskWsDto> {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskWsDto> findAll() {
        return taskRepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    public TaskWsDto convert(Task task) {
        TaskWsDto taskWsDto = new TaskWsDto(task.getId(), task.getTitle());
        Optional.ofNullable(task.getUser()).map(user -> {
            user.setTasks(null);
            return user;
        }).ifPresent(taskWsDto::setUser);
        return taskWsDto;
    }
}
