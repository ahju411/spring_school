package com.example.spring_school.repository;

import com.example.spring_school.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    //Member findById(String memberId);

//    List<Member> findByMemberId(String memberId);
    Optional<Member> findById(String id);

    List<Member> findByLanguageContaining(String language);
    List<Member> findByLanguage(String Language);

}
