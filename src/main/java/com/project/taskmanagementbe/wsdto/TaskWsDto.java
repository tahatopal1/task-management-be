package com.project.taskmanagementbe.wsdto;

import com.project.taskmanagementbe.model.User;

public class TaskWsDto {

    private int id;
    private String title;
    private String definition;
    private UserWsDto userWsDto;

    public TaskWsDto() { }

    public TaskWsDto(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public TaskWsDto(int id, String title, String definition) {
        this.id = id;
        this.title = title;
        this.definition = definition;
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

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public UserWsDto getUserWsDto() {
        return userWsDto;
    }

    public void setUserWsDto(UserWsDto userWsDto) {
        this.userWsDto = userWsDto;
    }
}
