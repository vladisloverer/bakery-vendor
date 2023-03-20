package com.bakeryvendor.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //todo: check if email valid
        //todo: check if email not token
        customerRepo.saveAndFlush(customer);

        //todo: check if shopper
        ShopCheckResponse shopCheckResponse = restTemplate.getForObject(
                "http://SHOP/api/v1/shop/{customerId}",
                ShopCheckResponse.class,
                customer.getId()
        );

        if(shopCheckResponse.isShopperino()){
            throw new IllegalStateException("shopperino");
        }
        //todo: store customer in db
        //todo: send notification
    }
}
