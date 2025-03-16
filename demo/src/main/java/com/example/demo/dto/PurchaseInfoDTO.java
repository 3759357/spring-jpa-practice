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
public class PurchaseInfoDTO {
	private Long id;
	private LocalDateTime purchaseDate;
	private String purchaseStatus;
	private String card;
	private String history;
	private Integer price;
	private Boolean isDirect;
	private Long cartId;
}
