package com.example.courseselectapp;

import org.litepal.crud.LitePalSupport;

public class Person extends LitePalSupport {
    private int id;
    private String name;
    private String password;
    private String truename;
    private String age;
    private String school;
    private String faculty;
    private String classes;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name1){
        this.name = name1;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setSchool(String school1){
        this.school = school1;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getClasses() {
        return classes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getTruename() {
        return truename;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

}
