package com.project.taskmanagementbe.service;

import com.project.taskmanagementbe.model.Task;
import com.project.taskmanagementbe.wsdto.TaskWsDto;

import java.util.List;

public interface TaskService {

    List<TaskWsDto> findAll();

}
