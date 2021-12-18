package com.project.taskmanagementbe.service;

import com.project.taskmanagementbe.wsdto.TaskWsDto;

import java.util.List;

public interface TaskService {

    List<TaskWsDto> findAll();

    void createTask(TaskWsDto taskWsDto, Integer id);

    TaskWsDto find(Integer id);

    void updateTask(TaskWsDto taskWsDto);

    void remove(Integer id);

}
