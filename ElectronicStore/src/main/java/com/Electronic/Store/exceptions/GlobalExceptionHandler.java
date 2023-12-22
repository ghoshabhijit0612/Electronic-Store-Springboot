package com.Electronic.Store.exceptions;

import com.Electronic.Store.dtos.ApiResponseMessege;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponseMessege> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        ApiResponseMessege resourceNotFound = ApiResponseMessege.builder().messege(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(resourceNotFound,HttpStatus.NOT_FOUND);


    }

    //MethodArgumentNotFoundException

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> MethodArgumentNotFoundExceptionHandler(MethodArgumentNotValidException ex){

        Map<String,Object> mp = new HashMap<>();
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        allErrors.stream().forEach(errors->{
                String messege =errors.getDefaultMessage();
                String feild= ((FieldError) errors).getField();
                mp.put(messege,feild);

        });


    return new ResponseEntity<>(mp,HttpStatus.BAD_REQUEST);
    }

}
