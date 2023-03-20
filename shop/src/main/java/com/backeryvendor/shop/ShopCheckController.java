package com.backeryvendor.shop;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("api/v1/shop")
public class ShopCheckController {

    private final ShopCheckService shopCheckService;

    @GetMapping(path= "{customerId}")
    public ShopCheckResponse isShopperino(@PathVariable("customerId") Integer customerId){
        boolean isCustomerShopperino = shopCheckService.isCustomerShopperino(customerId);
        log.info("shop check for customer {}", customerId);
        return new ShopCheckResponse(isCustomerShopperino);
    }
}
