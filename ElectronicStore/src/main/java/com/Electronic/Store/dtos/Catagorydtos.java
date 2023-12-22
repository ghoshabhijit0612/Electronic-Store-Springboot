package com.Electronic.Store.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Catagorydtos {
    @NotBlank
    private String catagoryId;
    @Size(min = 3,max = 15)
    @NotBlank(message = "title required")
    private String title;
    @Size(min=10, max=30)
    private String description;
}
