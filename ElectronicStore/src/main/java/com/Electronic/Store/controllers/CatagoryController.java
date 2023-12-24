package com.Electronic.Store.controllers;


import com.Electronic.Store.dtos.Catagorydtos;
import com.Electronic.Store.dtos.Productdtos;
import com.Electronic.Store.entities.Catagory;
import com.Electronic.Store.services.CatagoryService;
import com.Electronic.Store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catagories")
public class CatagoryController {

    @Autowired
    CatagoryService catagoryService;
    @Autowired
    ProductService productService;
    @PostMapping
    public ResponseEntity<Catagorydtos> createCatagory(@RequestBody  Catagorydtos catagorydtos){
        Catagorydtos catagorydtos1 = catagoryService.createCatagory(catagorydtos);
        return new ResponseEntity<>(catagorydtos1, HttpStatus.CREATED);

    }
    @PutMapping("/{CatagoryId}")
    public ResponseEntity<Catagorydtos> updateCatagory(@PathVariable("CatagoryId") String id, @RequestBody Catagorydtos catagorydtos){
        Catagorydtos catagorydtos1 = catagoryService.updateCatagory(catagorydtos,id);
        return new ResponseEntity<>(catagorydtos1,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCatagory(@PathVariable("id") String id){
        catagoryService.deletecatagory(id);
        return new ResponseEntity<>("Delete Sucessfully",HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Catagorydtos>> getAllCatagory(){
        List<Catagorydtos> list = catagoryService.getAllCatagory();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    //create product with catagory
    @PostMapping("/{catagoryId}/product")
    public ResponseEntity<Productdtos> createProductWithCategory(@PathVariable("catagoryId") String catagoryId,@RequestBody Productdtos productdtos){

        Productdtos productWithCatagory = productService.createProductWithCatagory(productdtos, catagoryId);
        return new ResponseEntity<>(productWithCatagory,HttpStatus.OK);


    }


    @PutMapping("/{catagoryId}/product/{productId}")
    public ResponseEntity<Productdtos> updateCatagoryWithProductId(@PathVariable("catagoryId") String catagoryId,
                                                                   @PathVariable("productId") String productId){
        Productdtos productdtos = productService.updateProductCatagory(catagoryId, productId);
        return new ResponseEntity<>(productdtos,HttpStatus.OK);

    }

}
