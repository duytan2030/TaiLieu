package com.example.sqlite_15102019;

public class Author {
    private int idAuthor;
    private  String name, mail, address;

    public Author(int idAuthor, String name, String mail, String address) {
        this.idAuthor = idAuthor;
        this.name = name;
        this.mail = mail;
        this.address = address;
    }

    public Author() {
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
