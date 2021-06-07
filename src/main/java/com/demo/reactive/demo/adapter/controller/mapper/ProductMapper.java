package com.demo.reactive.demo.adapter.controller.mapper;

import com.demo.reactive.demo.adapter.controller.model.ProductRequest;
import com.demo.reactive.demo.domain.Product;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProductMapper {

    public static Product requestToDomain(ProductRequest productRequest){
        return Product.builder()
                .id(productRequest.getId())
                .qty(productRequest.getQty())
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .build();
    }
}
