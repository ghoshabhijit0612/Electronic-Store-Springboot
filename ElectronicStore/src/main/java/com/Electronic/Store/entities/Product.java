package com.Electronic.Store.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "catagory_id")
    @JsonIgnoreProperties("product")
    private Catagory catagory;

}
