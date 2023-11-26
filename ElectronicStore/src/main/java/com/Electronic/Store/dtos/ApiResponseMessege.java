package com.Electronic.Store.dtos;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponseMessege {

    private String messege;
    private HttpStatus status;

    private boolean success;

}
