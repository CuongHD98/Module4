package com.example.case1.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String avatar;
    private String  aboutMe;
    private Date birthday;
    @Column(unique = true)
    private String phone;
    private String gender;
    private String country;


}
