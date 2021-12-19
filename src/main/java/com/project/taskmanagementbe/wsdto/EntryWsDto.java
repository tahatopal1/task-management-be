package com.project.taskmanagementbe.wsdto;

public class EntryWsDto {

    private int id;
    private String comment;

    public EntryWsDto() { }

    public EntryWsDto(String comment) {
        this.comment = comment;
    }

    public EntryWsDto(int id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
