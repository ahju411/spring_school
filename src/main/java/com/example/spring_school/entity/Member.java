package com.example.spring_school.entity;

import com.example.spring_school.dto.MemberDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Member {

    //사용자 Id
    @Id
    @Column(nullable = false, name = "id")
    private String id;

    //사용자 이름
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    //프로필 사진 경로\
    private String image;

    //사용자 연혁
    private String career;

    //사용자 자기소개
    private String itd;

    //사용자 깃허브 링크
    private String link;

    //사용자 사용 언어
    private String language;


}
