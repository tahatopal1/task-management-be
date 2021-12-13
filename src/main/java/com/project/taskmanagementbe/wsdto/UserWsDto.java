package com.project.taskmanagementbe.wsdto;

import com.project.taskmanagementbe.model.Task;

import java.util.List;

public class UserWsDto {

    private String username;
    private String password;
    private Integer enabled;
    private List<TaskWsDto> taskWsDtos;

    public UserWsDto() { }

    public UserWsDto(String username, String password, Integer enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
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

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<TaskWsDto> getTaskWsDtos() {
        return taskWsDtos;
    }

    public void setTaskWsDtos(List<TaskWsDto> taskWsDtos) {
        this.taskWsDtos = taskWsDtos;
    }
}
