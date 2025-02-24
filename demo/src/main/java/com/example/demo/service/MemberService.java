package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	@Autowired
	private MemberRepository memberRepository;


	@Transactional
	public List<MemberDTO> getAllMembers() {
		List<Member> members = memberRepository.findAll();

		return members.stream()
			.map(member -> MemberDTO.builder()
				.memberId(member.getMemberId())
				.memberName(member.getMemberName())
				.memberAge(member.getMemberAge())
				.memberEmail(member.getMemberEmail())
				.memberJob(member.getMemberJob())
				.build())
			.collect(Collectors.toList());
	}

	@Transactional
	public MemberDTO createMember(MemberDTO memberDTO) {
		logger.info("DTO Content: {}", memberDTO);

		Member member = Member.builder()
			.memberId(memberDTO.getMemberId())
			.memberAge(memberDTO.getMemberAge())
			.memberName(memberDTO.getMemberName())
			.memberEmail(memberDTO.getMemberEmail())
			.memberJob(memberDTO.getMemberJob())
			.build();

		Member savedMember = memberRepository.save(member);

		MemberDTO savedMemberDTO = MemberDTO.builder()
			.memberId(savedMember.getMemberId())
			.memberName(savedMember.getMemberName())
			.memberAge(savedMember.getMemberAge())
			.memberEmail(savedMember.getMemberEmail())
			.memberJob(savedMember.getMemberJob())
			.build();

		return savedMemberDTO;
	}

	@Transactional
	public MemberDTO getByIDMember(MemberDTO memberDTO){

		return null;
	}

	@Transactional
	public MemberDTO updateMember(MemberDTO memberDTO){

		return null;
	}
}
