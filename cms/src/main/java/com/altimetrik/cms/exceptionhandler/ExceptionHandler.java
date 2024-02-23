package com.altimetrik.cms.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handleNoSuchElementException(Exception ex){
        ApiError api = new ApiError(new Date(),"Id is not found !!!", "check your customer id !! Enter valid id");
        ResponseEntity<?> err = new ResponseEntity<>(api, HttpStatus.NOT_FOUND);
   return err;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(CustomerIdNotFound.class)

public ResponseEntity<?> handleCustomerIdNotFoundException(Exception ex){
        ApiError api = new ApiError(new Date(),ex.getMessage(), "check your customer id !! Enter valid id");
        ResponseEntity<?> err = new ResponseEntity<>(api, HttpStatus.NOT_FOUND);
        return err;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(Exception ex, BindingResult br){
       List<FieldError> list =  br.getFieldErrors();
       StringBuilder sb = new StringBuilder();
        for (FieldError fe: list) {
            sb.append(fe.getField()+" "+fe.getDefaultMessage()+" , ");
        }
        ApiError api = new ApiError(new Date(),sb.toString(),"Check Your Json Data");
        ResponseEntity<?> e = new ResponseEntity<>(api, HttpStatus.BAD_REQUEST);
        return e;
    }
}