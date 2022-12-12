package com.example.spring_school.controller;

import com.example.spring_school.dto.MemberDto;
import com.example.spring_school.entity.Member;
import com.example.spring_school.repository.MemberRepository;
import com.example.spring_school.service.FileService;
import com.example.spring_school.service.MemberService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@org.springframework.stereotype.Controller

//@RequestMapping
//@RequiredArgsConstructor
@RestController
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final MemberService memberService;

    @Autowired
    FileService fileService;

    @PostMapping(value = "/memberListByLanguage")
    public String getMemberDataTest(@RequestParam Map<String, Object> getiden){
        String language = (String) getiden.get("language");
        List<Member> member = memberRepository.findByLanguage(language);

        String json = new Gson().toJson(member);
        return json;
    }

    @CrossOrigin
    @PostMapping(value = "/memberList")
    public List<Member> getMember(){
        List<Member> member = memberRepository.findAll();

        return member;
    }

    @CrossOrigin
    @PostMapping(value = "/getMymember")
    public Member getMyMember(@RequestParam Map<String, Object> get){

        String memberId = (String) get.get("memberId");

        Member member = memberRepository.findByMemberId(memberId);

        return member;
    }

    @CrossOrigin
    @Transactional
    @PostMapping(value = "/memberUpdate")
    public Member memberUpdate(@RequestParam Map<String, Object> getiden){

        String id = (String) getiden.get("id");
        Long longId = Long.parseLong(id);

        Optional<Member> memberOptiaonl = memberRepository.findById(longId);

        if (memberOptiaonl.isEmpty()){
            return null;
        }

        String memberId = (String) getiden.get("memberId");
//        String pw = (String) getiden.get("password");
        String name = (String) getiden.get("name");
        String career = (String) getiden.get("career");
        String comment = (String) getiden.get("comment");
        String link = (String) getiden.get("link");
        String language = (String) getiden.get("language");

        MemberDto memberDto = new MemberDto();
        memberDto.setMemberId(memberId);
//        memberDto.setPassword(pw);
        memberDto.setName(name);
        memberDto.setCareer(career);
        memberDto.setComment(comment);
        memberDto.setLink(link);
        memberDto.setLanguage(language);

        Member member = memberOptiaonl.get();

        memberRepository.save(member);

        return null;
    }

/*    @CrossOrigin
    @PostMapping(value = "deleteMember")
    public String deleteMember(@RequestParam Map<String, Object> getiden){
        String id = (String) getiden.get("id");

        memberRepository.deleteById(Long.valueOf(id));

        return "삭제가 완료되었습니다.";
    }*/

    @CrossOrigin
    @PostMapping(value = "getImage")
    public byte[] getImage(@RequestParam Map<String, Object> getiden) throws IOException {
        String path = (String) getiden.get("path");
        System.out.println("getPath--------------------------------->" + path);

        byte[] image = fileService.getFile(path);

        return image;
    }


}
