package com.Electronic.Store.services;

import com.Electronic.Store.dtos.AddItemToTheCartRequest;
import com.Electronic.Store.dtos.Cartdtos;

public interface CartService {

    //add cartitems in the cart to a userId.
    Cartdtos addItemIntoCart(String userId, AddItemToTheCartRequest addItemToTheCartRequest);
    //remove items from the cart
    void removeItemFromCart(String userId, int cartItemId);
    void clearAllItemFromCart(String userId);
}
