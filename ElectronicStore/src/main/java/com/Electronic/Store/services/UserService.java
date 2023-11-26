package com.Electronic.Store.services;

import com.Electronic.Store.dtos.Userdtos;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    //create
    Userdtos CreateUser(Userdtos userdtos);


    //update
    Userdtos updateUser(Userdtos userdtos,String id );


    //get by id
    Userdtos getUserById(String id);

    //getByEmail
    Userdtos getUserByEmail(String email);


    //getAll
    List<Userdtos> getAllUser();


    //delete
    void deleteUser(String id);


    //search user
    List<Userdtos> searchUser(String keyword);

}
