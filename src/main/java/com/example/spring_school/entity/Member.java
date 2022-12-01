package com.example.spring_school.entity;

import com.example.spring_school.dto.MemberDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //사용자 Id
    @Column(nullable = false)
    private String MemberId;

    //사용자 이름
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    //프로필 사진 경로
    private String image;

    //사용자 연혁
    private String career;

    //사용자 자기소개
    private String itd;

    //사용자 깃허브 링크
    private String link;

    public static Member createMember(MemberDto memberDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setMemberId(memberDto.getMemberId());
        String password = passwordEncoder.encode(memberDto.getPassword());
        member.setPassword(password);
        member.setImage(memberDto.getImage());
        member.setCareer(memberDto.getCareer());
        member.setItd(memberDto.getItd());
        member.setItd(memberDto.getItd());

        return member;
    }

}
