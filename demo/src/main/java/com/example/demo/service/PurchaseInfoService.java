package com.example.demo.service;


import com.example.demo.dto.PurchaseInfoDTO;
import com.example.demo.model.PurchaseInfo;
import com.example.demo.repository.PurchaseInfoRepository;
import jakarta.transaction.Transactional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseInfoService {

	@Autowired
	private PurchaseInfoRepository purchaseInfoRepository;

	@Transactional
	public List<PurchaseInfoDTO> getAllPurchaseInfo(){
		List<PurchaseInfo> purchaseInfos = purchaseInfoRepository.findAll();
		return purchaseInfos.stream()
			.map(purchaseInfo->PurchaseInfoDTO.builder()
				.id(purchaseInfo.getId())
				.purchaseDate(purchaseInfo.getPurchaseDate())
				.purchaseStatus(String.valueOf(purchaseInfo.getPurchaseStatus()))
				.card(purchaseInfo.getCard())
				.history(purchaseInfo.getHistory())
				.price(purchaseInfo.getPrice())
				.isDirect(purchaseInfo.getIsDirect())
				.cartId(purchaseInfo.getCart().getCartId())
				.build())
			.toList();
	}

}
