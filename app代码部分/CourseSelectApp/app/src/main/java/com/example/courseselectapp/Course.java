package com.example.courseselectapp;

import org.litepal.crud.LitePalSupport;


public class Course extends LitePalSupport {
    private int id;
    private String coursename;
    private String teacher;
    private String time;
    private String book;
    private String introduction;
    private int imageId;

    public void setBook(String book) {
        this.book = book;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public int getId() {
        return id;
    }

    public int getImageId() {
        return imageId;
    }

    public String getBook() {
        return book;
    }

    public String getCoursename() {
        return coursename;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getTeacher() {
        return teacher;
    }



}
