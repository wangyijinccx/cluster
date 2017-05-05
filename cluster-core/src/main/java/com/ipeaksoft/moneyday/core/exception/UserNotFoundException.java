package com.ipeaksoft.moneyday.core.exception;

public class UserNotFoundException extends Exception {
    
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String msg) throws Exception {
        throw new Exception(msg);
    }
}
