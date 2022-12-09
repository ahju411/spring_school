package com.example.spring_school.controller;

import com.example.spring_school.entity.Member;
import com.example.spring_school.repository.MemberRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller

//@RequestMapping
//@RequiredArgsConstructor
@RestController
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

//    @GetMapping(value = "/123")
//    public List<Member> ControllerTest(@RequestBody Map<String, String>language){
//
//        List<Member> member = memberRepository.findByLanguage(language.get("language"));
//
//        return member;
//    }

    @GetMapping(value = "/list1")
    public String getMemberDataTest(Model model){
//        List<Member> member = memberRepository.findAll();
        List<Member> member = memberRepository.findByLanguage("java");

        String json = new Gson().toJson(member);
        model.addAttribute("data", json);

        return json;
    }

    @CrossOrigin
    @GetMapping(value = "/list")
    public List<Member> getMember(){
        List<Member> member = memberRepository.findAll();
        return member;
    }

    @GetMapping(value = "/list2")
    public String saveMember(Model model){

        Member member = new Member();

        memberRepository.save(member);

        return "/";
    }



}
