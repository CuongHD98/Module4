package com.example.account.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Account {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private int id;
    private String username;
    private String password;
    private String img;
    private LocalDate birthday;

    public Account() {
    }

    public Account(int id, String username, String password, String img, String birthday) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.img = img;
        this.birthday = LocalDate.parse(birthday,dateTimeFormatter);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = LocalDate.parse(birthday,dateTimeFormatter);
    }
}
