package com.example.demo.controller;

import com.example.demo.dto.CartDTO;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	// **Create (장바구니 추가)**
	@PostMapping("/add")
	public CartDTO addCartItem(@RequestParam Long userId, @RequestParam Long productId, @RequestParam Integer amount) {
		return cartService.addCartItem(userId, productId, amount);
	}

	// **Read (전체 장바구니 조회)**
	@GetMapping("/all")
	public List<CartDTO> getAllCartItems() {
		return cartService.getAllCartItems();
	}

	// **Read (ID로 조회)**
	@GetMapping("/{cartId}")
	public CartDTO getCartById(@PathVariable Long cartId) {
		return cartService.getCartById(cartId);
	}

	// **Update (수량 변경)**
	@PutMapping("/update/{cartId}")
	public CartDTO updateCart(@PathVariable Long cartId, @RequestParam Integer amount) {
		return cartService.updateCart(cartId, amount);
	}

	// **Delete (장바구니 삭제)**
	@DeleteMapping("/delete/{cartId}")
	public String deleteCart(@PathVariable Long cartId) {
		cartService.deleteCart(cartId);
		return "Cart item with ID " + cartId + " deleted.";
	}
}
