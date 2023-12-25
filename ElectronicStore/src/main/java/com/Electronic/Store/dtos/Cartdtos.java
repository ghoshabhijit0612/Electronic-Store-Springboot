package com.Electronic.Store.dtos;

import com.Electronic.Store.entities.Cart;
import com.Electronic.Store.entities.CartItem;
import com.Electronic.Store.entities.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cartdtos {
    private String cartId;
    private Date createDate;

    private Userdtos userdtos;

    private List<CartItem> cartItems = new ArrayList<>();


}
