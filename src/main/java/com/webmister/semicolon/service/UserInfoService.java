package com.webmister.semicolon.service;

import com.webmister.semicolon.domain.UserInfo;
import com.webmister.semicolon.repository.UserInfoRepository;
import com.webmister.semicolon.request.Login;
import com.webmister.semicolon.request.UserInfoRequest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

   public String login(Login login) {
        UserInfo user = userInfoRepository.findByUserEmailAndPassword(login.getUserEmail(), login.getPassword());

        if(login.getUserEmail().equals(user.getUserEmail()) && login.getPassword().equals(user.getPassword())) {
            return "로그인에 성공하였습니다.";
        } else {
            return "로그인에 실패하였습니다.";
        }
   }


    public void signUp(UserInfoRequest userInfoRequest) {
            userInfoRepository.save(UserInfo.builder()
                    .password(userInfoRequest.getPassword())
                    .userEmail(userInfoRequest.getUserEmail())
                    .userNickName(userInfoRequest.getUserNickName())
                    .userUniqueID(userInfoRequest.getUserUniqueID())
                    .userProfileImageUrl(userInfoRequest.getUserProfileImageUrl())
                    .userDescription(userInfoRequest.getUserDescription())
                    .build());
    }







}
