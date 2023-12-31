package com.Electronic.Store.services;

import com.Electronic.Store.dtos.Productdtos;
import com.Electronic.Store.entities.Product;
import jakarta.annotation.PostConstruct;

import java.util.List;

public interface ProductService {
    //create

    Productdtos createProduct(Productdtos productdtos);

    //update
    Productdtos updateProduct(Productdtos productdtos,String id);

    //delelete
    String deleteProduct(String id);


    //search by id
    Productdtos searchProduct(String id);


    //get



    //get All
    List<Productdtos> getAllProduct();

    //get all : live
    List<Productdtos> getAllProductLive();

    List<Productdtos> findByTitle(String title);


//    create product with catagoty
    Productdtos createProductWithCatagory(Productdtos productdtos,String catagoryId);

    //update catagory of product
    Productdtos updateProductCatagory(String catagoryId,String productId);

}
