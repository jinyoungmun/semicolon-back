package com.webmister.semicolon.controller;

import com.webmister.semicolon.domain.UserInfo;
import com.webmister.semicolon.request.FindUserOnlyOneResponse;
import com.webmister.semicolon.response.FindUserOnlyOneRequest;
import com.webmister.semicolon.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/")
    public ResponseEntity<List<UserInfo>> aaaaa(){
        List<UserInfo> userInfoList;

        userInfoList = userInfoService.findAll();

        System.out.println(userInfoList);

        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("Content-Type", "application/json;charset=UTF-8");

        return new ResponseEntity<>(userInfoList ,resHeaders,  HttpStatus.OK);
    }

    @PostMapping("/get")
    public ResponseEntity<FindUserOnlyOneResponse> createUser(@RequestBody FindUserOnlyOneRequest findUserOnlyOneRequest){
        UserInfo userInfo = userInfoService.findUserInfoById(findUserOnlyOneRequest.getId());

        FindUserOnlyOneResponse findUserOnlyOneResponse = new FindUserOnlyOneResponse(userInfo);

        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("Content-Type", "application/json;charset=UTF-8");

        return new ResponseEntity<>( findUserOnlyOneResponse,resHeaders,  HttpStatus.OK);
    }

}
