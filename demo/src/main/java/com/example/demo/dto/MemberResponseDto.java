package com.example.demo.dto;


import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseDto {
	private Long memberId;
	private String memberName;
	@Min(10)
	private Integer memberAge;
	private String memberJob;
	private String memberEmail;

}
