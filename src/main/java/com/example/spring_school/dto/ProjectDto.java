package com.example.spring_school.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ProjectDto {

    private String id;

    private String pjName;

    private String pjShortInfo;

    private String pjLongInfo;

    private String pjLink;

    private String language;

    private String image;

    private String imageName;

    private String oriImageName;

    private LocalDateTime regDate;

}
