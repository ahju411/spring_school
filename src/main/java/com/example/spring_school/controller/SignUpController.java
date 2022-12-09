package com.example.spring_school.controller;

import com.example.spring_school.dto.MemberDto;
import com.example.spring_school.entity.Member;
import com.example.spring_school.repository.MemberRepository;
import com.example.spring_school.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@RestController
public class SignUpController {

    private final PasswordEncoder passwordEncoder;
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @PostMapping(value = "/login")
    public String loginController(@Valid MemberDto memberDto, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "/";
        }

        try {
            Member member = Member.CreateMember(memberDto, passwordEncoder);

        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "redirect:/";
        }

        return "/";

    }

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/SignUp")
    public HashMap<String, String> getSignUp(@RequestParam Map<String, Object> getiden){
        System.out.println(getiden);
        System.out.println(getiden.get("id"));

        try {
            String id = (String) getiden.get("id");
            String pw = (String) getiden.get("password");
            String name = (String) getiden.get("name");

            MemberDto memberDto = new MemberDto();
            memberDto.setMemberId(id);
            memberDto.setPassword(pw);
            memberDto.setName(name);

            Member member = Member.CreateMember(memberDto, passwordEncoder);

            System.out.println(memberDto);

            memberService.saveMember(member);

        }catch (Exception e){
            e.printStackTrace();
        }

        HashMap<String,String> id = new HashMap<String,String>();
        id.put("test","test");
        return id;

    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/SignUp")
    public HashMap<String, String> PostSignUp(@RequestParam Map<String, Object> getiden){
        System.out.println(getiden);
        System.out.println(getiden.get("id"));

        try {
            String id = (String) getiden.get("id");
            String pw = (String) getiden.get("password");
            String name = (String) getiden.get("name");

            MemberDto memberDto = new MemberDto();
            memberDto.setMemberId(id);
            memberDto.setPassword(pw);
            memberDto.setName(name);


            Member member = Member.CreateMember(memberDto, passwordEncoder);

            System.out.println(memberDto);

            memberService.saveMember(member);

        }catch (Exception e){
            e.printStackTrace();
        }

        HashMap<String,String> id = new HashMap<String,String>();
        id.put("test","test");
        return id;
    }

}
