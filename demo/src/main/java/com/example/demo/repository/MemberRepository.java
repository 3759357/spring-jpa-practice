package com.example.demo.repository;

import com.example.demo.model.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	List<Member> findByMemberId(Long memberId);
	void deleteAllByMemberId(Long memberId);
}
