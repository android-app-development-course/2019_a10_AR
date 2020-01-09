package com.example.courseselectapp;

public class selectedCourse {
    private int id;
    private String userid;
    private int bookid;

    public selectedCourse(int id,String userid,int bookid){
        this.id = id;
        this.userid = userid;
        this.bookid = bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookid() {
        return bookid;
    }

    public int getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }
}
