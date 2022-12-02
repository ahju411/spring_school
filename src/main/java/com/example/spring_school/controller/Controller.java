package com.example.spring_school.controller;

import com.example.spring_school.dto.MemberDto;
import com.example.spring_school.entity.Member;
import com.example.spring_school.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {

    @Autowired
    MemberRepository memberRepository;

//    @GetMapping(value = "/123")
//    public List<Member> ControllerTest(@RequestBody Map<String, String>language){
//
//        List<Member> member = memberRepository.findByLanguage(language.get("language"));
//
//        return member;
//    }

    @GetMapping(value = "/123")
    public List<Member> ControllerTest(){

        List<Member> member = memberRepository.findAll();
//        List<Member> member = memberRepository.findByLanguage("java");

        return member;
    }

}
