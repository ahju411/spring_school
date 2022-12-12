package com.example.spring_school.entity;

import com.example.spring_school.config.LanguageProcess;
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
//    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false, unique = true)
    private String memberId;

    //사용자 이름
//    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
    private String password;

    //프로필 사진 경로\
    private String image;

    private String imageName;

    private String oriImageName;

    //사용자 연혁
    private String career;

    //사용자 자기소개
    private String comment;

    //사용자 깃허브 링크
    private String link;

    //사용자 사용 언어
    private String language;

    //사용자 수상 내역
    private String award;

    public static Member CreateMember(MemberDto memberDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setMemberId(memberDto.getMemberId());
        String password = passwordEncoder.encode(memberDto.getPassword());
        member.setPassword(password);
        member.setName(memberDto.getName());
        member.setImage(memberDto.getImage());
        member.setCareer(memberDto.getCareer());
        member.setComment(memberDto.getComment());
        member.setLink(memberDto.getLink());
        member.setAward(memberDto.getAward());

        return member;
    }


    public void updateMember(MemberDto memberDto, PasswordEncoder passwordEncoder){
        String password = passwordEncoder.encode(memberDto.getPassword());
        this.password = password;
        this.name = memberDto.getName();
        this.image = memberDto.getImage();
        this.career = memberDto.getCareer();
        this.comment = memberDto.getComment();
        this.link = memberDto.getLink();
        this.language = memberDto.getLanguage();
    }

}
