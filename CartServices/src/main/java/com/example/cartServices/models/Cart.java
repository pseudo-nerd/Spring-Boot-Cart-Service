package com.example.cartServices.models;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Cart {
        public Long id;
        public Long userId;
        public String date;
        public Product[] products;

}
