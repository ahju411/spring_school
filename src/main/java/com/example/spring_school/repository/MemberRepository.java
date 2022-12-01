package com.example.spring_school.repository;

import com.example.spring_school.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findById(String memberId);

}
