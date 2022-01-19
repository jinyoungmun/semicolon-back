package com.webmister.semicolon.request;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
public class UserInfoRequest {

    private String userEmail;
    private String password;
    private String userNickName;
    private String userUniqueID;
    private String userProfileImageUrl;
    private String userDescription;

}
