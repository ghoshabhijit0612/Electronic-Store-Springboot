package com.Electronic.Store.controllers;


import com.Electronic.Store.dtos.Catagorydtos;
import com.Electronic.Store.entities.Catagory;
import com.Electronic.Store.services.CatagoryService;
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
}
