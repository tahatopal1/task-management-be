package com.project.taskmanagementbe.wsdto;

import com.project.taskmanagementbe.model.Role;
import com.project.taskmanagementbe.model.Task;

import java.util.List;

public class UserWsDto {

    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private List<TaskWsDto> taskWsDtos;
    private List<RoleWsDto> roleWsDtos;

    public UserWsDto() { }

    public UserWsDto(Integer id, String username, String password, String firstName, String lastName, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserWsDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TaskWsDto> getTaskWsDtos() {
        return taskWsDtos;
    }

    public void setTaskWsDtos(List<TaskWsDto> taskWsDtos) {
        this.taskWsDtos = taskWsDtos;
    }

    public List<RoleWsDto> getRoleWsDtos() {
        return roleWsDtos;
    }

    public void setRoleWsDtos(List<RoleWsDto> roleWsDtos) {
        this.roleWsDtos = roleWsDtos;
    }
}
