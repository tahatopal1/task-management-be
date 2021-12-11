package com.project.taskmanagementbe.wsdto;

import com.project.taskmanagementbe.model.User;

public class TaskWsDto {

    private int id;
    private String title;
    private User user;

    public TaskWsDto() { }

    public TaskWsDto(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
