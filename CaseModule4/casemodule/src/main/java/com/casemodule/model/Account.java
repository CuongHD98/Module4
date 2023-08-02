package com.casemodule.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String avatar;
    private String coverPhoto;
    private String  aboutMe;
    private Date birthday;
    @Column(unique = true)
    private String phone;
    private String gender;
    private String country;
    @Column(unique = true)
    private String email;
    @ManyToOne
    private Role role;
    private Date createdAt;
    @OneToOne
    private Status statusChat;
    @OneToOne
    private Status statusProfile;
    @OneToOne
    private Status statusAccount;
}