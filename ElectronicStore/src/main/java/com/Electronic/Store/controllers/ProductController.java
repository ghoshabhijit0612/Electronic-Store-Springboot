package com.Electronic.Store.controllers;

import com.Electronic.Store.dtos.Productdtos;
import com.Electronic.Store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    //create

    @PostMapping
    public ResponseEntity<Productdtos> create(@RequestBody Productdtos productdtos){
        Productdtos product = productService.createProduct(productdtos);
        return new ResponseEntity<>(product, HttpStatus.CREATED);

    }


    @PutMapping("/{id}")
    //update
    public ResponseEntity<Productdtos> update(@PathVariable("id") String id,@RequestBody Productdtos productdtos){
        Productdtos productdtos1 = productService.updateProduct(productdtos, id);
        return new ResponseEntity<>(productdtos1,HttpStatus.OK);
    }




    @DeleteMapping("/{id}")
    //delete product
    public ResponseEntity<String> delete(@PathVariable String id){
        String deleteResponse = productService.deleteProduct(id);
        return new ResponseEntity<>(deleteResponse,HttpStatus.OK);
    }




    @GetMapping("/get-all-product")
    //get-all product
    public ResponseEntity<List<Productdtos>> getAll(){
        List<Productdtos> allProduct = productService.getAllProduct();
        return new ResponseEntity<>(allProduct,HttpStatus.OK);
    }




    @GetMapping("/get-all-live-product")
    //search product
    public ResponseEntity<List<Productdtos>> getAllLive(){
        List<Productdtos> allProductLive = productService.getAllProductLive();
        return new ResponseEntity<>(allProductLive,HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<Productdtos>> findByTitle(@PathVariable String title){
        List<Productdtos> byTitle = productService.findByTitle(title);
        return new ResponseEntity<>(byTitle,HttpStatus.OK);


    }



    //get-all-live product which is in the stock

}
