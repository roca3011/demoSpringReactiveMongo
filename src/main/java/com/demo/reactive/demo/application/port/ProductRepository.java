package com.demo.reactive.demo.application.port;

import com.demo.reactive.demo.domain.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {

    Flux<Product> getProducts();

    Mono<Product> getProduct(String id);

    public Flux<Product> getProductInRange(double min, double max);

    public Mono<Product> saveProduct(Mono<Product> productDtoMono);

    public Mono<Product> updateProduct(Mono<Product> productDtoMono, String id);

    public Mono<Void> deleteProduct(String id);
}
