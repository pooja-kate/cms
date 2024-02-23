package com.altimetrik.cms.exceptionhandler;

public class CustomerIdNotFound extends Exception{
    String msg;
    public CustomerIdNotFound(String message) {
        super(message);
        this.msg = message;
    }

}
