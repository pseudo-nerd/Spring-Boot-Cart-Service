package com.example.cartServices.Controller;

import com.example.cartServices.Services.CartServices;
import com.example.cartServices.models.Cart;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import java.sql.SQLOutput;

@RestController
public class CartController {
    public CartServices cartService;
    public CartController(CartServices cartService){
        this.cartService = cartService;
    }
    //1 Get All Carts Controller
    @GetMapping("/carts")
    public Cart[] getAllCarts(){
        return cartService.getAllCarts();
    }

    //2 Get Single Cart By Id Controller
    @GetMapping("/carts/{id}")
    public Cart getCartByID(@PathVariable("id")Long id){
        return cartService.getCartByID(id);
    }

    //3 Get Data in Range Controller
    @GetMapping("/carts/{idS}/{idE}")
    public Cart[] getCartsInRange(@PathVariable("idS")Long idS, @PathVariable("idE")Long idE){
        return cartService.getCartsInRange(idS, idE);
    }

    //4 Show for error (additional functionality)
    @GetMapping("/carts/user")
    public static String error(){
        return ("Error! ID must be provided after (.....user/{id})");
    }

    //5 Get User Cart
    @GetMapping("/carts/user/{id}")
    public Cart[] getUserCart(@PathVariable("id")long id){
        return cartService.getUserCart(id);
    }

    //6 Post request for adding a cart
    @PostMapping("/carts")
    public Cart addCart(@RequestBody Cart cart){
        return cartService.addCart(cart);
    }

    //7 Patch request for updating in cart
    @PatchMapping("/carts/{id}")
    public Cart updateCart(@PathVariable("id")long id){
        return cartService.updateCart(id);
    }

    //8 Delete request to delete a cart
    @DeleteMapping("/carts/{id}")
    public Cart deleteCart(@PathVariable("id")long id){
        return cartService.deleteCart(id);
    }
}
