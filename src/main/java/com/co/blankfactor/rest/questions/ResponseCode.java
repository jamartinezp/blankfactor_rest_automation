package com.co.blankfactor.rest.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ResponseCode implements Question {


    public static Question<Integer> was() {
        return new ResponseCode();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().statusCode();
    }
}
