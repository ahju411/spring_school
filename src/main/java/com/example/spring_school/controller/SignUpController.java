package com.example.spring_school.controller;

import com.example.spring_school.dto.MemberDto;
import com.example.spring_school.entity.Member;
import com.example.spring_school.repository.MemberRepository;
import com.example.spring_school.service.FileService;
import com.example.spring_school.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@RestController
public class SignUpController {

    private final PasswordEncoder passwordEncoder;
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final FileService fileService;

    @Value("${uploadProfile}")
    private String uploadPath;

    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/login")
    public String loginController(@RequestParam Map<String, Object> get){
        String memberId = (String) get.get("memberId");
        String password = (String) get.get("password");
        System.out.println("여기작동");
        String encodePassoword = passwordEncoder.encode(password);

        Member member = memberRepository.findByMemberId(memberId);

        if(member.getMemberId().isEmpty()){
            return "fail";
        }else {
            if (password.equals(member.getPassword())){
                return "success";
            }else {
                return "fail";
            }
        }

    }

/*    @CrossOrigin
    @ResponseBody
    @GetMapping(value = "/SignUp")
    public HashMap<String, String> getSignUp(@RequestParam Map<String, Object> getiden, MultipartHttpServletRequest request){
        System.out.println(getiden);

        try {
            String id = (String) getiden.get("id");
            String pw = (String) getiden.get("password");
            String name = (String) getiden.get("name");
            String career = (String) getiden.get("career");
            String itd = (String) getiden.get("itd");
            String link = (String) getiden.get("link");


            MemberDto memberDto = new MemberDto();
            memberDto.setMemberId(id);
            memberDto.setPassword(pw);
            memberDto.setName(name);
            memberDto.setCareer(career);
            memberDto.setComment(itd);
            memberDto.setLink(link);

            Member member = Member.CreateMember(memberDto, passwordEncoder);



        }catch (Exception e){
            e.printStackTrace();
        }

        HashMap<String,String> id = new HashMap<String,String>();
        id.put("test","test");
        return id;

    }*/

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/SignUp")
    public HashMap<String, String> PostSignUp(@RequestParam Map<String, Object> getiden){
        System.out.println(getiden);

        try {
//            String id = String.valueOf("id");
            String id = (String) getiden.get("id");
            String pw = (String) getiden.get("password");
            String name = (String) getiden.get("name");
            String career = (String) getiden.get("career");
            String comment = (String) getiden.get("comment");
            String link = (String) getiden.get("link");
            String language = (String) getiden.get("language");
            byte[] image = String.valueOf("image").getBytes();
            String imagestring = (String) getiden.get("image");
            String award = (String) getiden.get("award");

            System.out.println("가져왔니 이미지스트링?"+imagestring);

//            byte[] image = (byte[]) getiden.get("image");
            String imageName = (String) getiden.get("imageName");

            String uploadUrl = "";

//            if (image != null){
//                uploadUrl = fileService.uploadFile(uploadPath, imageName, image);
//            }

            MemberDto memberDto = new MemberDto();
            memberDto.setMemberId(id);
            memberDto.setPassword(pw);
            memberDto.setName(name);
            memberDto.setCareer(career);
            memberDto.setComment(comment);
            memberDto.setLink(link);
            memberDto.setImage(uploadUrl);
            memberDto.setOriImageName(imageName);
            memberDto.setLanguage(language);
            memberDto.setAward(award);
//            imageName.substring()
//            memberDto.setImageName();

            System.out.println("member.link__________________________>" + memberDto.getLink());

                Member member = Member.CreateMember(memberDto, passwordEncoder);

                memberService.saveMember(member);


        }catch (Exception e){
            e.printStackTrace();
        }

        HashMap<String,String> id = new HashMap<String,String>();
        id.put("test","test");
        return id;
    }

}
