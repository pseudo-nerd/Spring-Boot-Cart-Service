package com.example.cartServices;

import com.example.cartServices.Services.CartServices;
import com.example.cartServices.models.Cart;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductServicesApplicationTests {

    CartServices cs = new CartServices();
    Cart[] carts = cs.getAllCarts();
    @Test
    void contextLoads() throws Exception {
        assertThat(carts).isNotNull();
    }
}
