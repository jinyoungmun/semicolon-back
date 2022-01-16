package com.webmister.semicolon.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String userEmail;

    @Column
    String password;

    @OneToMany(mappedBy = "userInfo")
    List<Report> reportList;

}
