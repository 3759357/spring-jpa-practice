package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_info")
@Getter
@Setter
@ToString
public class PurchaseInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "purchase_date")
	private LocalDateTime purchaseDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "purchase_status", nullable = false)
	private PurchaseStatus purchaseStatus;

	@Column(name = "card")
	private String card;

	@Column(name = "history")
	private String history;

	@Column(name = "price")
	private Integer price;

	@Column(name = "is_direct")
	private Boolean isDirect;

	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;

	public enum PurchaseStatus {
		PurchaseConfirmation, Return, Delivery
	}
}
