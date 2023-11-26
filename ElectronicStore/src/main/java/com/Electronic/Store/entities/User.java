package com.Electronic.Store.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @Column(name = "User_id")
    private String id;

    @Column(name = "User_name")
    private String name;

    @Column(name = "User_email",unique = true)
    private String email;

    @Column(name = "User_password",length = 10)
    private String password;
    @Column(name = "User_gender")
    private String gender;

    @Column(name="image_name")
    private String imageName;



}
