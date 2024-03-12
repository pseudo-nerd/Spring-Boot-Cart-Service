package com.example.cartServices.dtos;

import com.example.cartServices.models.Product;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CartDto {
    public Long id;
    public Long userId;
    public String date;
    public Product[] products;
}
