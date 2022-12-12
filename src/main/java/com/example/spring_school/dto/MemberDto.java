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

    private String imageName;

    private String oriImageName;

    private String career;

    private String comment;

    private String link;

    private String language;

    private String award;

    public static Member CreateMember(MemberDto memberDto, PasswordEncoder passwordEncoder){
        Member member = new Member();
        member.setMemberId(memberDto.MemberId);
        String password = passwordEncoder.encode(memberDto.getPassword());
        member.setPassword(password);
        member.setName(memberDto.getName());
        member.setImage(memberDto.getImage());
        member.setLink(memberDto.getLink());
        member.setCareer(memberDto.getCareer());
        member.setComment(memberDto.getComment());
        member.setLanguage(memberDto.getLanguage());
        member.setAward(memberDto.getAward());

        return member;
    }

}
