package com.example.spring_school.repository;

import com.example.spring_school.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {

    //Member findById(String memberId);

    List<Member> findByLanguage(String Language);

}
