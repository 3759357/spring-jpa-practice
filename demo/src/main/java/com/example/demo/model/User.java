package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "password")
	private String password;

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "user_address", nullable = false)
	private String userAddress;

	@Column(name = "user_card", nullable = false)
	private String userCard;

	@Column(name = "user_phone_number")
	private String userPhoneNumber;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Column(name = "modified_date", nullable = false)
	private LocalDateTime modifiedDate;

	@Column(name = "user_status", nullable = false)
	private String userStatus;
}

