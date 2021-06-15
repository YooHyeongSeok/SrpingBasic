package com.yhs.hellospring;

import com.yhs.hellospring.repository.JdbcTemplateMemberRepository;
import com.yhs.hellospring.repository.MemberRepository;
import com.yhs.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
    // return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }

}