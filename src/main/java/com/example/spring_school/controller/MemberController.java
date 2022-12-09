package com.example.spring_school.controller;

import com.example.spring_school.entity.Member;
import com.example.spring_school.repository.MemberRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller

//@RequestMapping
//@RequiredArgsConstructor
@RestController
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping(value = "/memberListByLanguage")
    public String getMemberDataTest(@RequestParam Map<String, Object> getiden){
        String language = (String) getiden.get("language");
        List<Member> member = memberRepository.findByLanguage(language);

        String json = new Gson().toJson(member);
        return json;
    }

    @CrossOrigin
    @GetMapping(value = "/memberList")
    public List<Member> getMember(){
        List<Member> member = memberRepository.findAll();
        return member;
    }



}
