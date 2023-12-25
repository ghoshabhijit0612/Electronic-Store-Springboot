package com.Electronic.Store.services.imple;

import com.Electronic.Store.dtos.AddItemToTheCartRequest;
import com.Electronic.Store.dtos.Cartdtos;
import com.Electronic.Store.entities.Cart;
import com.Electronic.Store.entities.CartItem;
import com.Electronic.Store.entities.Product;
import com.Electronic.Store.entities.User;
import com.Electronic.Store.exceptions.ResourceNotFoundException;
import com.Electronic.Store.repositories.CartRepository;
import com.Electronic.Store.repositories.ProductRepository;
import com.Electronic.Store.repositories.UserRepository;
import com.Electronic.Store.services.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
@Service
public class CartImple implements CartService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    @Override
    public Cartdtos addItemIntoCart(String userId, AddItemToTheCartRequest addItemToTheCartRequest) {
        String productId = addItemToTheCartRequest.getProductdId();
        int quantity = addItemToTheCartRequest.getQuantity();

        // Fetch the user
        User foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Cart cart = cartRepository.findByUser(foundUser);

        if (cart == null) {
            cart = new Cart();
            String id = UUID.randomUUID().toString();
            cart.setCartId(id);

            cart.setCreateDate(new Date(System.currentTimeMillis()));
            cart.setUser(foundUser);
        }

        boolean updatedItem = false;

        for (CartItem item : cart.getCartItems()) {
            if (item.getProduct().getProductId().equals(productId)) {
                item.setQuantity(quantity);
                item.setTotalPrice(quantity * product.getPrice());
                updatedItem = true;
                break;
            }
        }

        if (!updatedItem) {
            CartItem cartItem = CartItem.builder()
                    .quantity(quantity)
                    .totalPrice(quantity * product.getPrice())
                    .product(product)
                    .cart(cart)
                    .build();
            cart.getCartItems().add(cartItem);
        }

        Cart updatedCart = cartRepository.save(cart);
        return modelMapper.map(updatedCart, Cartdtos.class);


    }

    @Override
    public void removeItemFromCart(String userId, int cartItemId) {

    }

    @Override
    public void clearAllItemFromCart(String userId) {

    }
}
