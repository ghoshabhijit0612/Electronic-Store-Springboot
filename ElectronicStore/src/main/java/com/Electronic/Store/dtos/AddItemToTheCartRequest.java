package com.Electronic.Store.dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddItemToTheCartRequest {
    private String productdId;
    private int quantity;

}
