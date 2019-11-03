package com.example.sqlite_15102019;

public class Book {
    private String title;
    private int id,idAuthor;

    public Book(String title, int id, int idAuthor) {
        this.title = title;
        this.id = id;
        this.idAuthor = idAuthor;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }
}
