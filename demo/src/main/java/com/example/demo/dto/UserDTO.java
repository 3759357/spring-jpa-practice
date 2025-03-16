package com.example.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDTO {
	private Long userId;
	private String password;
	private String userName;
	private String userAddress;
	private String userCard;
	private String userPhoneNumber;

	private String userStatus;
}
