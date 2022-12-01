package com.example.spring_school.service;

import com.example.spring_school.entity.Member;
import com.example.spring_school.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public void ValidateDuplicateMember(Member member){
        Member findMember = memberRepository.findById(member.getMemberId());
        if(findMember != null){
            throw new IllegalStateException("아이디가 이미 존재합니다.");
        }
    }

}
