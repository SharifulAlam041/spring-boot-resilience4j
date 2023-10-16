package com.shoppingcart.orderservice.client;

import com.shoppingcart.orderservice.entity.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface ProductClient {

    @GetExchange("/product/get-product/{id}")
    @CircuitBreaker(name = "order-service")
    public Product getById(@PathVariable(value = "id") Long id);
}
