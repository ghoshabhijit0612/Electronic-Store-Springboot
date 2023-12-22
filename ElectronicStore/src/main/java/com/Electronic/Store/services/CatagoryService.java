package com.Electronic.Store.services;

import com.Electronic.Store.dtos.Catagorydtos;

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



    // get single catagory



}
