package com.demo.reactive.demo.application.service;

import com.demo.reactive.demo.application.port.ProductRepository;
import com.demo.reactive.demo.application.port.ProductService;
import com.demo.reactive.demo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Flux<Product> getProducts(){
        return productRepository.getProducts();
    }

    @Override
    public Mono<Product> getProduct(String id){
        return productRepository.getProduct(id);
    }

    @Override
    public Flux<Product> getProductInRange(double min, double max){
        return productRepository.getProductInRange(min,max);
    }

    @Override
    public Mono<Product> saveProduct(Mono<Product> productDtoMono){
        return productRepository.saveProduct(productDtoMono);
    }

    @Override
    public Mono<Product> updateProduct(Mono<Product> productDtoMono, String id){
        return productRepository.updateProduct(productDtoMono, id);
    }

    @Override
    public Mono<Void> deleteProduct(String id){
        return productRepository.deleteProduct(id);
    }

}
