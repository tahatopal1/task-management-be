package com.project.taskmanagementbe.repository;

import com.project.taskmanagementbe.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
