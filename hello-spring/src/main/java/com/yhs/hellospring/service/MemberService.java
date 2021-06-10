package com.yhs.hellospring.service;

import com.yhs.hellospring.domain.Member;
import com.yhs.hellospring.repository.MemberRepository;
import com.yhs.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*회원가입*/
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원은x
        /*Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });*/

        memberRepository.findByName(member.getName())
            .ifPresent(m->{
                throw new IllegalStateException("이미 존재하는 회원입니다");
            });

        memberRepository.save(member);
        return member.getId();

    }

    /*전체 회원 가져오기*/
    public List<Member> findMemberAll(){
        return memberRepository.findAll();
    }

    /*특정 회원 가져오기*/
    public Optional<Member> findOne(Long memberId){

        return memberRepository.findById(memberId);

    }

}
