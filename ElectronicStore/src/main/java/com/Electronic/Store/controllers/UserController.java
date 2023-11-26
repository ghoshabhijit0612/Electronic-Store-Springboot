package com.Electronic.Store.controllers;


import com.Electronic.Store.dtos.ApiResponseMessege;
import com.Electronic.Store.dtos.Userdtos;
import com.Electronic.Store.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.OutputKeys;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    //create
    public ResponseEntity<Userdtos> createUser(@Valid @RequestBody Userdtos userdtos){

       Userdtos userdtos1 = userService.CreateUser(userdtos);
       return  new ResponseEntity<>(userdtos1, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    //update
    public ResponseEntity<Userdtos> updateUser(
            @PathVariable String id,
            @Valid @RequestBody Userdtos userdtos
    ){
        Userdtos userdtos1 = userService.updateUser(userdtos,id);
        return new ResponseEntity<>(userdtos1,HttpStatus.OK);


    }


    @GetMapping("/{id}")
    //getbyid
    public ResponseEntity<Userdtos> getById(@PathVariable String id){
        Userdtos userdtos1 = userService.getUserById(id);
        return new ResponseEntity<>(userdtos1,HttpStatus.OK);


    }


    //getbyemail
    @GetMapping("/email/{email}")
    public ResponseEntity<Userdtos> getByEmail(@PathVariable String email){
        Userdtos userByEmail = userService.getUserByEmail(email);
        return new ResponseEntity<>(userByEmail,HttpStatus.OK);
    }


    //getAll
    @GetMapping
    public ResponseEntity<List<Userdtos>> getAllUser(){
        List<Userdtos> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser,HttpStatus.OK);
    }

    //deleteById

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponseMessege> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        ApiResponseMessege deleted = ApiResponseMessege.builder().messege("Delete").status(HttpStatus.OK).success(true).build();
        return new ResponseEntity<>(deleted, HttpStatus.OK);

    }

    //search user by keyword

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Userdtos>> getUserBySearch(@PathVariable String keyword){
        return new ResponseEntity<>(userService.searchUser(keyword),HttpStatus.OK);
    }



}
