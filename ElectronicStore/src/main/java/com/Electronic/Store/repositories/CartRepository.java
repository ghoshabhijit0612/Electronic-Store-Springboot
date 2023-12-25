package com.Electronic.Store.repositories;

import com.Electronic.Store.entities.Cart;
import com.Electronic.Store.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,String> {
    Cart findByUser(User user);
}
