package com.example.lifetech.model;

public class MyModel {
    private String course,teacher,time,description;

    public MyModel() {

    }

    public MyModel(String course, String teacher, String time,String description) {
        this.course = course;
        this.teacher = teacher;
        this.time = time;
        this.description = description;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourse() {
        return course;
    }

    public String getTeacher() {
        return teacher;
    }
    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }
}
