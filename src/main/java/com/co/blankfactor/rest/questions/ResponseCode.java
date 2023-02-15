package com.co.blankfactor.rest.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ResponseCode implements Question<Boolean> {
    private int statusCode;

    public ResponseCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public static ResponseCode Api(int statusCode) {
        return new ResponseCode(statusCode);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return lastResponse().statusCode() == statusCode;
    }
}
