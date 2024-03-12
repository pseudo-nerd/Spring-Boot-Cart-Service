package com.example.cartServices.Services;

import com.example.cartServices.models.Cart;

public interface ServiceInterface {
    Cart[] getAllCarts();

    Cart[] getCartsInRange(long ids, long ide);

    Cart getCartByID(Long id);
    Cart[] getUserCart(long id);
    Cart addCart(Cart cart);
    Cart updateCart(long id);
    Cart deleteCart(long id);
}
