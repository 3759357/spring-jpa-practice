package com.example.demo.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CartDTO {
	private Long cartId;
	private Integer amount;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private LocalDateTime deletedDate;
	private Long userId;
	private Long productId;

}
