package com.example.cartServices.Services;

import com.example.cartServices.dtos.CartDto;
import com.example.cartServices.models.Cart;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartServices implements ServiceInterface{

    private final RestTemplate restTemplate = new RestTemplate();
    @Override
    public Cart getCartByID(Long id) {
        CartDto prod = restTemplate.getForObject("https://fakestoreapi.com/carts/" + id, CartDto.class);

        Cart cart_main = new Cart();

        cart_main.setId(prod.getId());
        cart_main.setUserId(prod.getUserId());
        cart_main.setDate(prod.getDate());
        cart_main.setProducts(prod.getProducts());

        return cart_main;
    }

    @Override
    public Cart[] getAllCarts(){
        ResponseEntity<Cart[]> response = restTemplate.getForEntity("https://fakestoreapi.com/carts", Cart[].class);
        Cart[] allProducts = response.getBody();
        return allProducts;
    }

    @Override
    public Cart[] getCartsInRange(long ids, long ide){
        ResponseEntity<Cart[]> response = restTemplate.getForEntity("https://fakestoreapi.com/carts", Cart[].class);
        Cart[] allProducts = response.getBody();
        if(ids>ide || ide> (allProducts != null ? allProducts.length : 0)) return null;
        Cart[] rangeProducts = new Cart[(int)ide-(int)ids+1];
        int j = 0;
        ids--;ide--;
        for(int i=(int)ids; i<=ide; i++){
            rangeProducts[j] = allProducts[i];
            j++;
        }
        return rangeProducts;
    }
    @Override
    public Cart[] getUserCart(long id){
        ResponseEntity<Cart[]> response = restTemplate.getForEntity("https://fakestoreapi.com/carts/user/"+id, Cart[].class);
        Cart[] userCarts = response.getBody();
        return userCarts;
    }

//    @Override
    public Cart addCart(Cart cart){
        CartDto newCart = new CartDto();
        newCart.setDate(cart.getDate());
        newCart.setId(cart.getId());
        newCart.setProducts(cart.getProducts());
        newCart.setUserId(cart.getUserId());

        restTemplate.postForObject(
                "https://fakestoreapi.com/carts/",
                newCart,
                CartDto.class
        );
        return cart;
    }
    public Cart updateCart(long id){

        Cart cart = getCartByID(id);
        CartDto newCart = new CartDto();

        newCart.setDate(cart.getDate());
        newCart.setId(cart.getId());
        newCart.setProducts(cart.getProducts());
        newCart.setUserId(cart.getUserId());

        restTemplate.put(
                "https://fakestoreapi.com/carts/"+id,newCart
        );
        return cart;
    }

    public Cart deleteCart(long id){
        Cart cartToBeDeleted = getCartByID(id);
        restTemplate.delete("https://fakestoreapi.com/carts/"+id);

        return cartToBeDeleted;
    }
}
