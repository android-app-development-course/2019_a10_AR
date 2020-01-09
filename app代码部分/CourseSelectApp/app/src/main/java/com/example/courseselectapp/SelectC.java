package com.example.courseselectapp;

import org.litepal.crud.LitePalSupport;

public class SelectC extends LitePalSupport {
    private int id;
    private int personId;
    private int courseId;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getPersonId() {
        return personId;
    }



}
