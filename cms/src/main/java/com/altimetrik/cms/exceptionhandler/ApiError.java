package com.altimetrik.cms.exceptionhandler;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
public class ApiError {
    private Date date;
    private String message;
    private String cause;

}
