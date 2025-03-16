package com.example.demo.service;

import com.example.demo.dto.CartDTO;
import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;

	// **DTO 변환 메서드**
	private CartDTO convertToDTO(Cart cart) {
		return CartDTO.builder()
			.cartId(cart.getCartId())
			.amount(cart.getAmount())
			.createdDate(cart.getCreatedDate())
			.modifiedDate(cart.getModifiedDate())
			.deletedDate(cart.getDeletedDate())
			.userId(cart.getUser().getUserId())
			.productId(cart.getProduct().getProductId())
			.build();
	}

	// **Create (장바구니 추가)**
	public CartDTO addCartItem(Long userId, Long productId, Integer amount) {
		Optional<User> user = userRepository.findById(userId);
		Optional<Product> product = productRepository.findById(productId);

		if (user.isPresent() && product.isPresent()) {
			Cart cart = Cart.builder()
				.amount(amount)
				.user(user.get())
				.product(product.get())
				.build();

			return convertToDTO(cartRepository.save(cart));
		}
		return null;
	}

	// **Read (장바구니 전체 조회)**
	public List<CartDTO> getAllCartItems() {
		List<Cart> cartList = cartRepository.findAll();
		return cartList.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	// **Read (ID로 장바구니 조회)**
	public CartDTO getCartById(Long cartId) {
		Optional<Cart> cart = cartRepository.findById(cartId);
		return cart.map(this::convertToDTO).orElse(null);
	}

	// **Update (장바구니 수정)**
	public CartDTO updateCart(Long cartId, Integer amount) {
		Optional<Cart> existingCart = cartRepository.findById(cartId);

		if (existingCart.isPresent()) {
			Cart cart = existingCart.get();
			cart.setAmount(amount);
			return convertToDTO(cartRepository.save(cart));
		}
		return null;
	}

	// **Delete (장바구니 삭제)**
	public void deleteCart(Long cartId) {
		cartRepository.deleteById(cartId);
	}
}

