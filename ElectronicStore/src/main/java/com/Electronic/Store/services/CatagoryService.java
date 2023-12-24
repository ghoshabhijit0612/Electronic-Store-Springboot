package com.Electronic.Store.services;

import com.Electronic.Store.dtos.Catagorydtos;
import com.Electronic.Store.entities.Catagory;

import java.util.List;

public interface CatagoryService {

    //    create
    Catagorydtos createCatagory(Catagorydtos catagorydtos);

    //    update
    Catagorydtos updateCatagory(Catagorydtos catagorydtos,String id);

    //    delete
    void deletecatagory(String id);


    //getAll
    List<Catagorydtos> getAllCatagory();

    Catagory getCatagory(String id);



    // get single catagory



}
