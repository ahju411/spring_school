package com.example.spring_school.dto;

import com.example.spring_school.entity.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    public static Member CreateMember(MemberDto memberDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setMemberId(memberDto.MemberId);
        String password = passwordEncoder.encode(memberDto.getPassword());
        member.setPassword(password);
        member.setImage(memberDto.getImage());
        member.setCareer(memberDto.getCareer());
        member.setItd(memberDto.getItd());
        member.setItd(memberDto.getItd());

        return member;
    }

}
