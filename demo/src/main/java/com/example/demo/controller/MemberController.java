package com.example.demo.controller;


import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberservice;

	@GetMapping
	public ResponseEntity<List<MemberDTO>> getAllMember(HttpServletRequest request) {
		List<MemberDTO> members = memberservice.getAllMembers();
		return ResponseEntity.ok(members);
	}
	@PostMapping
	public ResponseEntity<MemberDTO> createMember(@RequestBody MemberDTO memberDTO, HttpServletRequest request){

		MemberDTO memberDto = memberservice.createMember(memberDTO);
		return ResponseEntity.ok(memberDTO);
	}

}
