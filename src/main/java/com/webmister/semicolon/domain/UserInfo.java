package com.webmister.semicolon.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userNickName;


    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp userCreateTime;

    @Column(nullable = false)
    private String userUniqueID;

    @Column
    private String userProfileImageUrl;

    @Column
    private String userDescription;

    @OneToMany(mappedBy = "userInfo")
    private List<Report> reportList;

}
