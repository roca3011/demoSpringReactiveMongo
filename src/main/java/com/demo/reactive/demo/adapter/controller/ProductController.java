package com.demo.reactive.demo.adapter.controller;

import com.demo.reactive.demo.adapter.controller.mapper.ProductMapper;
import com.demo.reactive.demo.adapter.controller.model.ProductRequest;
import com.demo.reactive.demo.application.port.ProductService;
import com.demo.reactive.demo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Flux<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProduct(@PathVariable String id){
        return productService.getProduct(id);
    }

    @GetMapping("/product-range")
    public Flux<Product> getProductBetween(@RequestParam("min") double min, @RequestParam("max") double max){
        return productService.getProductInRange(min, max);
    }

    @PostMapping
    public Mono<Product> saveProduct(@RequestBody ProductRequest productRequest){
        Product product = ProductMapper.requestToDomain(productRequest);
        return productService.saveProduct(Mono.just(product));
    }

    @PutMapping("/update/{id}")
    public Mono<Product> saveProduct(@RequestBody Product productDto, @PathVariable String id){
        return productService.updateProduct(Mono.just(productDto), id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return productService.deleteProduct(id);
    }
}
