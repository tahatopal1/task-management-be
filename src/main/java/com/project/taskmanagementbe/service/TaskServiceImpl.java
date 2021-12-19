package com.project.taskmanagementbe.service;

import com.project.taskmanagementbe.model.Task;
import com.project.taskmanagementbe.repository.TaskRepository;
import com.project.taskmanagementbe.repository.UsersRepository;
import com.project.taskmanagementbe.wsdto.TaskWsDto;
import com.project.taskmanagementbe.wsdto.UserWsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService, Converter<Task, TaskWsDto> {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<TaskWsDto> findAll() {
        return taskRepository.findAll().stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void createTask(TaskWsDto taskWsDto, Integer id) {
        taskRepository.save(Optional.ofNullable(taskWsDto).map(wsDto -> convertReverse(taskWsDto, id)).get());
    }

    @Override
    public TaskWsDto find(Integer id) {
        return taskRepository.findById(id)
                .map(this::convert)
                .orElse(new TaskWsDto());
    }

    @Override
    public void updateTask(TaskWsDto taskWsDto) {
        taskRepository.save(this.convertReverse(taskWsDto, taskWsDto.getUserWsDto().getId()));
    }

    @Override
    public TaskWsDto convert(Task task) {
        TaskWsDto taskWsDto = new TaskWsDto(task.getId(), task.getTitle(), task.getDefinition());
        Optional.ofNullable(task.getUser()).map(user -> {
            UserWsDto userWsDto = new UserWsDto();
            userWsDto.setTaskWsDtos(null);
            userWsDto.setUsername(user.getUsername());
            userWsDto.setPassword(user.getPassword());
            return userWsDto;
        }).ifPresent(taskWsDto::setUserWsDto);
        return taskWsDto;
    }

    public Task convertReverse(TaskWsDto taskWsDto, Integer id){
        Task task = new Task(taskWsDto.getId(), taskWsDto.getTitle());
        if (!ObjectUtils.isEmpty(id))
            usersRepository.findById(id).ifPresent(task::setUser);
        else if (!StringUtils.isEmpty(taskWsDto.getUserWsDto().getUsername()))
            Optional.ofNullable(usersRepository.findByUsername(taskWsDto.getUserWsDto().getUsername())).ifPresent(task::setUser);
        return task;
    }

}
