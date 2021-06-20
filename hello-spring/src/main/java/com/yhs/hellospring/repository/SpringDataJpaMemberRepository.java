package com.yhs.hellospring.repository;

import com.yhs.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findById(Long aLong);

    Optional<Member> findByName(String name);

}
