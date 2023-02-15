package com.co.blankfactor.rest.exceptions;

public class IncorrectResponseCodeException extends AssertionError{
    public static final String INCORRECT_RESPONSE_CODE =
            "The expected response is incorrect";
    public IncorrectResponseCodeException(String message, Throwable e){
        super(message, e);
    }
}
