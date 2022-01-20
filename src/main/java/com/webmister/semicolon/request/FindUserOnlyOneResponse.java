package com.webmister.semicolon.request;

import com.webmister.semicolon.dto.Post;
import com.webmister.semicolon.domain.Report;
import com.webmister.semicolon.domain.UserInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FindUserOnlyOneResponse {
    String email;
    String password;
    List<Post> postList;

    public FindUserOnlyOneResponse(UserInfo userInfo){
        this.postList = new ArrayList<>();
        this.setEmail(userInfo.getUserEmail());
        this.setPassword(userInfo.getPassword());
        this.modifyReportTopost(userInfo.getReportList());
    }

    private void modifyReportTopost(List<Report> reportList){
        for(Report report: reportList){
            this.getPostList().add(new Post(report));
        }
    }

}
