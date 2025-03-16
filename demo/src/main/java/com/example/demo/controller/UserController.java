package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// **Create (회원 가입)**
	@PostMapping("/create")
	public UserDTO createUser(@RequestBody UserDTO userDTO) {
		return userService.createUser(userDTO);
	}

	// **Read (모든 사용자 조회)**
	@GetMapping("/all")
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}

	// **Read (ID로 조회)**
	@GetMapping("/{userId}")
	public UserDTO getUserById(@PathVariable Long userId) {
		return userService.getUserById(userId);
	}

	// **Update (사용자 정보 수정)**
	@PutMapping("/update/{userId}")
	public UserDTO updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
		return userService.updateUser(userId, userDTO);
	}

	// **Delete (사용자 삭제)**
	@DeleteMapping("/delete/{userId}")
	public String deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return "User with ID " + userId + " deleted.";
	}
}
