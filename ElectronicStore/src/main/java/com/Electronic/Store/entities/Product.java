package com.Electronic.Store.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    private String productId;

    private String title;
    @Column(length = 1000)
    private String description;
    private int price;
    private int quantity;
    private int disCountedPrice;
    private Date addedDate;
    private boolean live;
    private boolean stock;

}
