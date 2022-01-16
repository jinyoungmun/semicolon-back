package com.webmister.semicolon.request;

import com.webmister.semicolon.DTO.Rptlrmf;
import com.webmister.semicolon.domain.Report;
import com.webmister.semicolon.domain.UserInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FindUserOnlyOneResponse {
    String email;
    String password;
    List<Rptlrmf> rptlrmfList;

    public FindUserOnlyOneResponse(UserInfo userInfo){
        this.rptlrmfList = new ArrayList<>();
        this.setEmail(userInfo.getUserEmail());
        this.setPassword(userInfo.getPassword());
        this.modifyReportTorptlrmf(userInfo.getReportList());
    }

    private void modifyReportTorptlrmf(List<Report> reportList){
        for(Report report: reportList){
            this.getRptlrmfList().add(new Rptlrmf(report));
        }
    }

}
