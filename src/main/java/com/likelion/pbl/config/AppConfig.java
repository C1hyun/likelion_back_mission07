package com.likelion.pbl.config;

import com.likelion.pbl.repository.MemoryMemberRepository;
import com.likelion.pbl.repository.MemberRepository;
import com.likelion.pbl.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 수동 주입 방식을 체험하려면 @Configuration 주석을 해제한다.
 */
// @Configuration
public class AppConfig {
    @Bean public MemberRepository memberRepository() { return new MemoryMemberRepository(); }
    @Bean public MemberService memberService()       { return new MemberService(memberRepository()); }
}
