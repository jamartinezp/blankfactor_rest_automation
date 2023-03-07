package com.co.blankfactor.rest.exceptions;

public class IncorrectResponseCodeException extends AssertionError {
    public static final String INCORRECT_RESPONSE_CODE =
            "THE EXPECTED RESPONSE CODE IS INCORRECT";

    public IncorrectResponseCodeException(String message, Throwable e) {
        super(message, e);
    }
}
