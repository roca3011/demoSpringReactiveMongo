package com.demo.reactive.demo.adapter.controller;


import com.demo.reactive.demo.application.service.ProductServiceImpl;
import com.demo.reactive.demo.domain.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import  static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(ProductController.class)
class SpringReactiveMongoCrudApplicationTests {

    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private ProductServiceImpl service;

    @Test
    void addProductTest(){
        Mono<Product> productDtoMono= Mono.just(Product.builder().id("102").name("mobile").qty(1).price(10000).build());
        when(service.saveProduct(productDtoMono)).thenReturn(productDtoMono);

        webTestClient.post().uri("/products")
                .body(Mono.just(productDtoMono), Product.class)
                .exchange()
                .expectStatus().isOk();//200

    }


    @Test
    void getProductsTest(){
        Flux<Product> productDtoFlux = Flux.just(Product.builder().id("102").name("mobile").qty(1).price(10000).build(),
                Product.builder().id("103").name("TV").qty(1).price(50000).build());
        when(service.getProducts()).thenReturn(productDtoFlux);

        Flux<Product> responseBody = webTestClient.get().uri("/products")
                .exchange()
                .expectStatus().isOk()
                .returnResult(Product.class)
                .getResponseBody();

        StepVerifier.create(responseBody)
                .expectSubscription()
                .expectNext(Product.builder().id("102").name("mobile").qty(1).price(10000).build())
                .expectNext(Product.builder().id("103").name("TV").qty(1).price(50000).build())
                .verifyComplete();

    }


    @Test
    void getProductTest(){
        Mono<Product> productDtoMono=Mono.just(Product.builder().id("102").name("mobile").qty(1).price(10000).build());

        when(service.getProduct(any())).thenReturn(productDtoMono);

        Flux<Product> responseBody = webTestClient.get().uri("/products/102")
                .exchange()
                .expectStatus().isOk()
                .returnResult(Product.class)
                .getResponseBody();

        StepVerifier.create(responseBody)
                .expectSubscription()
                .expectNextMatches(p->p.getName().equals("mobile"))
                .verifyComplete();
    }


    @Test
    void updateProductTest(){
        Mono<Product> productDtoMono= Mono.just(Product.builder().id("102").name("mobile").qty(1).price(10000).build());
        when(service.updateProduct(productDtoMono,"102")).thenReturn(productDtoMono);

        webTestClient.put().uri("/products/update/102")
                .body(Mono.just(productDtoMono), Product.class)
                .exchange()
                .expectStatus().isOk();//200
    }

    @Test
    void deleteProductTest(){
        given(service.deleteProduct(any())).willReturn(Mono.empty());
        webTestClient.delete().uri("/products/delete/102")
                .exchange()
                .expectStatus().isOk();//200
    }

}
