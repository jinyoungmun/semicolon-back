package com.webmister.semicolon.service;

import com.webmister.semicolon.domain.UserInfo;
import com.webmister.semicolon.repository.UserInfoRepository;
import com.webmister.semicolon.request.Login;
import com.webmister.semicolon.request.UserInfoRequest;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    public UserInfo findUserInfoById(Long id){
      return userInfoRepository.findById(id).orElse(new UserInfo());
    }

    public List<UserInfo> findAll(){
        List<UserInfo> AllUser = userInfoRepository.findAll();
        System.out.println(AllUser);
        return AllUser;
    }

    public  boolean checkDupicateEmail(String userEmail) {
        return userInfoRepository.existsByUserEmail(userEmail);
    }

    public boolean checkDupicateUserNickname(String userNickname) {
        return userInfoRepository.existsByUserNickName(userNickname);
    }

   public UserInfo login(Login login) {
        return userInfoRepository.findByUserEmailAndPassword(login.getUserEmail(), login.getPassword())
                .orElse(new UserInfo());
   }

   public UserInfo updatePasswordService(String email, String password) {
        UserInfo userInfo = userInfoRepository.findByUserEmail(email)
                .orElse(new UserInfo());
        userInfoRepository.save(userInfo.setPassword(password));
        return userInfo;
   }

    public Boolean signUp(UserInfoRequest userInfoRequest) {

        try {
            userInfoRepository.save(UserInfo.builder()
                    .password(userInfoRequest.getPassword())
                    .userEmail(userInfoRequest.getUserEmail())
                    .userNickName(userInfoRequest.getUserNickName())
                    .userUniqueID(userInfoRequest.getUserUniqueID())
                    .userProfileImageUrl(userInfoRequest.getUserProfileImageUrl())
                    .userDescription(userInfoRequest.getUserDescription())
                    .build());
            return Boolean.TRUE;

        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }







}
