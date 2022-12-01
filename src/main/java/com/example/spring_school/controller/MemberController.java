package com.example.spring_school.controller;

import com.example.spring_school.dto.MemberDto;
import com.example.spring_school.entity.Member;
import com.example.spring_school.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class MemberController {

    private final PasswordEncoder passwordEncoder;
    private final MemberService memberService;

    @GetMapping(value = "")
    public String con(Model model){
        return "";
    }

 /*   @PostMapping(value = "")
    public String loginController(@Valid MemberDto memberDto, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "redirect:/";
        }

        try {
            Member member = Member.createMember(memberDto, passwordEncoder);
            memberService.saveMember(member);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "redirect:/";
        }

        return "redirect:/";

    }
*/
}
