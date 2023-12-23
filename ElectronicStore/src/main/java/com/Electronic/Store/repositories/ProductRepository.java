package com.Electronic.Store.repositories;

import com.Electronic.Store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    List<Product> findByTitleContaining(String title);
    List<Product> findByLiveTrue();

}
