package com.webmister.semicolon.dto;

import com.webmister.semicolon.domain.UserInfo;
import lombok.Data;
import org.apache.catalina.User;

import java.sql.Timestamp;

@Data
public class EssentialUserInfo {

    String userEmail;
    String password;
    String userNickname;
    Timestamp userCreateTime;
    String userUniqueId;
    String userProfileImageUrl;
    String userOneLineIntroduction;

    public EssentialUserInfo(UserInfo userInfo) {
        this.userEmail = getUserEmail();
        this.password = getPassword();
        this.userNickname = getUserNickname();
        this.userCreateTime = getUserCreateTime();
        this.userUniqueId = getUserUniqueId();
        this.userProfileImageUrl = userProfileImageUrlNullCheck(userInfo);
        this.userOneLineIntroduction = userOneLineIntroductionNullCheck(userInfo);
    }

    public String userProfileImageUrlNullCheck(UserInfo userInfo) {
        if(userInfo.getUserProfileImageUrl() != null) {
            return userInfo.getUserProfileImageUrl();
        }
        return null;
    }

    public String userOneLineIntroductionNullCheck(UserInfo userInfo) {
        if(userInfo.getUserOneLineIntroduction() != null) {
            return userInfo.getUserOneLineIntroduction();
        }
        return null;
    }

}
