package com.example.spring_school.service;

import com.example.spring_school.entity.Member;
import com.example.spring_school.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public void ValidateDuplicateMember(Member member){
        Optional<Member> findMember = memberRepository.findById(member.getId());
        if(findMember != null){
            throw new IllegalStateException("아이디가 이미 존재합니다.");
        }
    }

    //맴버 정보 수정
    @Transactional
    public Member getMemberById(String memberId) throws Exception{
        Member member = memberRepository.findByMemberId(memberId);

        return member;
    }

    public Member updateMember(Member member){


        return null;
    }

}
