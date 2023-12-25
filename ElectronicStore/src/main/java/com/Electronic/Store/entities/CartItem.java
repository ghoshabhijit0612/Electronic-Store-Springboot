package com.Electronic.Store.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cart_items")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemId;

    private int quantity;

    private int totalPrice;

    @OneToOne
    private Product product;

    @ManyToOne
    private Cart cart;


}
