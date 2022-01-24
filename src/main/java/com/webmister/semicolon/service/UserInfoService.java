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

   public String login(Login login) {
       userInfoRepository.findByUserEmailAndPassword(login.getUserEmail(), login.getPassword())
               .orElseThrow(RuntimeException::new);
       return "로그인에 성공하였습니다.";
   }

   public void updatePasswordService(String email, String password) {
        UserInfo userInfo = userInfoRepository.findByUserEmail(email)
                .orElseThrow(RuntimeException::new);
        userInfoRepository.save(userInfo.updatePassword(password));
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
