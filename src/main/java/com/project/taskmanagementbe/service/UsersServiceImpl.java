package com.project.taskmanagementbe.service;

import com.project.taskmanagementbe.model.User;
import com.project.taskmanagementbe.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }
}
