package com.co.blankfactor.rest.exceptions;

public class IncorrectResponseTokenException extends AssertionError {
    public static final String INCORRECT_RESPONSE_TOKEN =
            "THERE IS NOT A FIELD WITH NAME TOKEN";
    public static final String NOT_NULL_VALUE =
            "THERE IS NOT A VALUE";

    public IncorrectResponseTokenException(String message, Throwable e) {
        super(message, e);
    }
}
