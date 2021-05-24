package com.demo.reactive.demo.adapter.repository;

import com.demo.reactive.demo.adapter.repository.mapper.EntityMapper;
import com.demo.reactive.demo.application.port.ProductRepository;
import com.demo.reactive.demo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductRepositoryJpa productRepositoryJpa;

    @Override
    public Flux<Product> getProducts(){
        return productRepositoryJpa.findAll().map(EntityMapper::entityToDto);
    }

    @Override
    public Mono<Product> getProduct(String id){
        return productRepositoryJpa.findById(id).map(EntityMapper::entityToDto);
    }

    @Override
    public Flux<Product> getProductInRange(double min, double max){
        return productRepositoryJpa.findByPriceBetween(Range.closed(min,max));
    }

    @Override
    public Mono<Product> saveProduct(Mono<Product> productDtoMono){
        return productDtoMono.map(EntityMapper::dtoToEntity)
                .flatMap(productRepositoryJpa::insert)
                .map(EntityMapper::entityToDto);
    }

    @Override
    public Mono<Product> updateProduct(Mono<Product> productDtoMono, String id){
        return productRepositoryJpa.findById(id)
                .flatMap(p->productDtoMono.map(EntityMapper::dtoToEntity)
                        .doOnNext(e->e.setId(id)))
                .flatMap(productRepositoryJpa::save)
                .map(EntityMapper::entityToDto);
    }

    @Override
    public Mono<Void> deleteProduct(String id){
        return productRepositoryJpa.deleteById(id);
    }

}
