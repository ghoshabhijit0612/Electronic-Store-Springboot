package com.Electronic.Store.dtos;

import com.Electronic.Store.entities.Product;
import jakarta.persistence.OneToOne;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItemdtos {
    private int cartItemId;

    private int quantity;

    private int totalPrice;


    private Productdtos productdtos;
}
