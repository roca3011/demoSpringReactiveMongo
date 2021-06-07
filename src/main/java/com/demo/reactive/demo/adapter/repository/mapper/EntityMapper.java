package com.demo.reactive.demo.adapter.repository.mapper;

import com.demo.reactive.demo.adapter.repository.model.ProductEntity;
import com.demo.reactive.demo.domain.Product;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

@UtilityClass
public class EntityMapper {

    public static Product entityToDto(ProductEntity productEntity){
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .qty(productEntity.getQty())
                .price(productEntity.getPrice())
                .build();
    }

    public static ProductEntity dtoToEntity(Product product){
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);
        return productEntity;
    }
}
