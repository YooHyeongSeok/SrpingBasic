package com.yhs.hellospring.service;

import com.yhs.hellospring.domain.Member;
import com.yhs.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    /*MemoryMemberRepository repository = new MemoryMemberRepository();*/
    MemoryMemberRepository repository;
    //다른 repository 인스턴스 사용이 아닌 동일한 인스턴스 사용을 위해 아래와 같이 작업
    @BeforeEach
    public void beforeEach(){
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }

    @AfterEach
    public void clearStore(){
        repository.clearStore();
    }

    @Test
    void 회원가입() {
        //givne
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member result = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(result.getName());

    }

    @Test
    public void 중복회원예외(){

        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

        /*try {
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        }*/

        //then

    }



    @Test
    void 모든회원가져오기() {
    }

    @Test
    void 특정회원가져오기() {
    }
}