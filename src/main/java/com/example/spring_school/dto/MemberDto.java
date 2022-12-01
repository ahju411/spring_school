package com.example.spring_school.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@Getter
@Setter
@ToString
public class MemberDto {

    private String MemberId;

    private String name;

    private String password;

    private String image;

    private String career;

    private String itd;

    private String link;

}
