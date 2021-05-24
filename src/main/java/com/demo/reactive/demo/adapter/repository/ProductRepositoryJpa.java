package com.demo.reactive.demo.adapter.repository;

import com.demo.reactive.demo.adapter.repository.model.ProductEntity;
import com.demo.reactive.demo.domain.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepositoryJpa extends ReactiveMongoRepository<ProductEntity,String> {
    Flux<Product> findByPriceBetween(Range<Double> priceRange);
}
