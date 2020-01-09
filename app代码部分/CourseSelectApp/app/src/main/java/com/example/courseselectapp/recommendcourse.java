package com.example.courseselectapp;

public class recommendcourse {
    private int id;
    private int bookid;
    public recommendcourse(int id,int bookid){
        this.id  = id;
        this.bookid = bookid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getId() {
        return id;
    }

    public int getBookid() {
        return bookid;
    }
}
