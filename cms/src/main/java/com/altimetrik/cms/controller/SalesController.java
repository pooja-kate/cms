package com.altimetrik.cms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales-api")
public class SalesController {

    @GetMapping("/sales")
    public String getSales(){
        return "Sales is called..";
    }
}
