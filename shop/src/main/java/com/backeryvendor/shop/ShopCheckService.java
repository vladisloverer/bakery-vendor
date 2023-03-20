package com.backeryvendor.shop;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ShopCheckService {

    private final ShopCheckHistoryRepo shopCheckHistoryRepo;

    public boolean isCustomerShopperino(Integer customerId){
        shopCheckHistoryRepo.save(
                ShopCheckHistory.builder()
                        .isShopper(false)
                        .customerId(customerId)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
