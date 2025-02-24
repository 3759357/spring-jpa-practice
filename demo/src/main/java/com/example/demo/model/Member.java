package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long memberId;

	@NotNull()
	@Column(name="member_name")
	private String memberName;

	@Column(name="member_age")
	private Integer memberAge;

	@Column(name="member_job")
	private String memberJob;

	@Column(name="member_email")
	private String memberEmail;



	@Override
	public String toString(){
		return "Member{" +
			"MemberId=" + memberId +
			", MemberName=" + memberName +
			", MemberAge=" + memberAge +
			", MemberJob=" + memberJob +
			", MemberEmail=" + memberEmail +
			'}';
	}
}
