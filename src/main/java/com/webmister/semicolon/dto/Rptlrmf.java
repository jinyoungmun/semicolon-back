package com.webmister.semicolon.dto;

import com.webmister.semicolon.domain.Report;
import lombok.Data;

@Data
public class Rptlrmf {
    String title;
    String contents;
    String description;

    public Rptlrmf(Report report){
        this.title = report.getTitle();
        this.contents = report.getContents();
        this.description ="임시";
    }
}
