package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {
	@NotNull(message = "필수 입력 값입니다.")
	private Long memberId;
	@NotNull(message = "필수 입력 값입니다.")
	private String memberName;
	@Min(10)
	private Integer memberAge;
	@NotNull(message = "필수 입력 값입니다.")
	private String memberJob;
	@NotNull(message = "필수 입력 값입니다.")
	private String memberEmail;

}
