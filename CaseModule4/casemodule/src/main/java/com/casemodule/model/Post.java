package com.casemodule.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany
    private List<Image> imageList;
    @OneToMany
    private List<Video> videoList;
    private String content;
    @ManyToOne
    private Account account;
    private Date createAt;
    @OneToOne
    private Status privacy;
}
