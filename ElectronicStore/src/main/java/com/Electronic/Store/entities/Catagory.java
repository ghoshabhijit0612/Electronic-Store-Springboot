package com.Electronic.Store.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Catagories")
public class Catagory {
    @Id
    @Column(name = "Catagory_id")
    private String catagoryId;
    @Column(name = "Title" , length = 50)
    private String title;
    @Column(name = "Description", length = 50)
    private String description;


}
