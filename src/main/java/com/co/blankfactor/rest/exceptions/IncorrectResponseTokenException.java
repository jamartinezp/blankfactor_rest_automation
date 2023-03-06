package com.co.blankfactor.rest.exceptions;

public class IncorrectResponseTokenException extends AssertionError{
    public static final String INCORRECT_RESPONSE_TOKEN =
            "There is not a field with name token";
    public static final String NOT_NULL_VALUE =
            "There is not a value";
    public IncorrectResponseTokenException(String message, Throwable e){ super(message, e);}
}
