package com.yhs.hellospring.repository;

import com.yhs.hellospring.domain.Member;
import jdk.nashorn.internal.runtime.options.Option;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //테스트 순서는 보장이 안되기떄문에 클리어 작업이 필요하다.why? 공용 저장소이기 때문이다.
    //callback 함수라고 보면 된다.
    @AfterEach
    public void clearStore(){
        repository.clearStore();
    }


    @Test
    public void save(){

        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        //확인
        Assertions.assertEquals(member, member);
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(member);

    }

    @Test
    public void findByname(){
        Member member1 = new Member();
        member1.setName("spring1");

        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        org.assertj.core.api.Assertions.assertThat(member1).isEqualTo(result);

    }

    @Test
    public void findAll(){

        Member member1 = new Member();
        member1.setName("spring1");

        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2);

    }


}
