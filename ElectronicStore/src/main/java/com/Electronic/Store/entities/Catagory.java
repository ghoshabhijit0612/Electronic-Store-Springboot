package com.Electronic.Store.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

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


    @OneToMany(mappedBy = "catagory",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonIgnoreProperties("catagory")
    private List<Product> products = new ArrayList<>();


}
