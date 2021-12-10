package com.project.taskmanagementbe.repository;

import com.project.taskmanagementbe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, String> {

}
