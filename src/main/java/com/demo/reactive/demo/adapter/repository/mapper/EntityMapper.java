package com.demo.reactive.demo.adapter.repository.mapper;

import com.demo.reactive.demo.adapter.repository.model.ProductEntity;
import com.demo.reactive.demo.domain.Product;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

@UtilityClass
public class EntityMapper {

    public static Product entityToDto(ProductEntity productEntity){
        Product product = Product.builder().build();
        BeanUtils.copyProperties(productEntity, product);
        return product;
    }

    public static ProductEntity dtoToEntity(Product product){
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);
        return productEntity;
    }
}
