package com.Electronic.Store.controllers;

import com.Electronic.Store.dtos.AddItemToTheCartRequest;
import com.Electronic.Store.dtos.Cartdtos;
import com.Electronic.Store.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;


    @PostMapping("/{user_id}")
    public ResponseEntity<Cartdtos> addToCart(@PathVariable("user_id") String user_id,@RequestBody AddItemToTheCartRequest addItemToTheCartRequest){
        Cartdtos cartdtos = cartService.addItemIntoCart(user_id, addItemToTheCartRequest);
        return new ResponseEntity<>(cartdtos, HttpStatus.CREATED);
    }

}
