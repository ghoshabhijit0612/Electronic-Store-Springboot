package com.Electronic.Store.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Productdtos {
    @NotBlank
    private String productId;
    @NotBlank
    private String title;

    private String description;
    private int price;
    private int quantity;
    private int disCountedPrice;
    private Date addedDate;
    private boolean live;
    private boolean stock;
}
