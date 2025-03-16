package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	@Transactional
	public UserDTO createUser(UserDTO userDTO) {
		logger.info("DTO Content: {}", userDTO);
		User user = User.builder()
			.password(userDTO.getPassword())
			.userName(userDTO.getUserName())
			.userAddress(userDTO.getUserAddress())
			.userCard(userDTO.getUserCard())
			.userPhoneNumber(userDTO.getUserPhoneNumber())
			.userStatus(userDTO.getUserStatus())
			.build();

		user = userRepository.save(user);
		return convertToDTO(user);
	}

	private UserDTO convertToDTO(User user) {
		return UserDTO.builder()
			.userId(user.getUserId())
			.password(user.getPassword())
			.userName(user.getUserName())
			.userAddress(user.getUserAddress())
			.userCard(user.getUserCard())
			.userPhoneNumber(user.getUserPhoneNumber())
			.userStatus(user.getUserStatus())
			.build();
	}

	// **Read (모든 사용자 조회)**
	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	// **Read (ID로 특정 사용자 조회)**
	public UserDTO getUserById(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		return user.map(this::convertToDTO).orElse(null);
	}

	// **Update (사용자 정보 수정)**
	public UserDTO updateUser(Long userId, UserDTO userDTO) {
		Optional<User> existingUser = userRepository.findById(userId);

		if (existingUser.isPresent()) {
			User user = existingUser.get();
			user.setPassword(userDTO.getPassword());
			user.setUserName(userDTO.getUserName());
			user.setUserAddress(userDTO.getUserAddress());
			user.setUserCard(userDTO.getUserCard());
			user.setUserPhoneNumber(userDTO.getUserPhoneNumber());
			user.setUserStatus(userDTO.getUserStatus());

			return convertToDTO(userRepository.save(user));
		}
		return null;
	}

	// **Delete (사용자 삭제)**
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}
}
