package com.webmister.semicolon.service;

import com.webmister.semicolon.domain.UserInfo;
import com.webmister.semicolon.repository.UserInfoRepository;
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
        List<UserInfo> aa = userInfoRepository.findAll();
        System.out.println(aa);
        return aa;
    }
}
