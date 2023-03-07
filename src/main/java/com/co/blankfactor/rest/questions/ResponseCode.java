package com.co.blankfactor.rest.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ResponseCode implements Question<Integer> {


    public static ResponseCode was() {
        return new ResponseCode();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().statusCode();
    }
}
