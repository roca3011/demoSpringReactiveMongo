package com.demo.reactive.demo.adapter.controller.mapper;

import com.demo.reactive.demo.adapter.controller.model.ProductRequest;
import com.demo.reactive.demo.domain.Product;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

@UtilityClass
public class ProductMapper {

    public static Product requestToDomain(ProductRequest productRequest){
        Product product = Product.builder().build();
        BeanUtils.copyProperties(productRequest, product);
        return product;
    }
}
