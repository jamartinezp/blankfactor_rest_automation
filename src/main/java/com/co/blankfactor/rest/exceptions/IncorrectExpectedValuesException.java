package com.co.blankfactor.rest.exceptions;

public class IncorrectExpectedValuesException extends AssertionError {
    public static final String INCORRECT_EXPECTED_VALUES =
            "VALUES EXPECTED ARE INCORRECT";

    public IncorrectExpectedValuesException(String message, Throwable e) {
        super(message, e);
    }
}
