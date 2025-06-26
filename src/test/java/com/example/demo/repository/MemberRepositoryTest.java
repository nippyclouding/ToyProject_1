package com.example.demo.repository;

import com.example.demo.domain.Member;
import com.example.demo.domain.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;


    @Test
    void testJpa() {
        Member member = new Member("lsw6449", "6449", 27, "Lee");
        //memberRepository.save(member);
        //memberRepository.delete(member);
    }


}