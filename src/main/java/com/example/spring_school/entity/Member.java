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

    //사용자 연혁
    private String career;

    //사용자 자기소개
    private String itd;

    //사용자 깃허브 링크
    private String link;

    //사용자 사용 언어
    private String language;

    public static Member CreateMember(MemberDto memberDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setMemberId(memberDto.getMemberId());
        String password = passwordEncoder.encode(memberDto.getPassword());
        member.setPassword(password);
        member.setName(memberDto.getName());
        member.setImage(memberDto.getImage());
        member.setCareer(memberDto.getCareer());
        member.setItd(memberDto.getItd());
        member.setItd(memberDto.getItd());

        return member;
    }


    public void updateMember(MemberDto memberDto){
        this.name = memberDto.getName();
        this.image = memberDto.getImage();
        this.career = memberDto.getCareer();
        this.itd = memberDto.getItd();
        this.link = memberDto.getLink();
//        this.language = memberDto.getl
    }

}
