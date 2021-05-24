package com.demo.reactive.demo.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Product {

    String id;
    String name;
    int qty;
    double price;
}
