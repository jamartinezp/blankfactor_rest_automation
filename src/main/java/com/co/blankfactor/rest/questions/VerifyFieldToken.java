package com.co.blankfactor.rest.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

import static com.co.blankfactor.rest.utils.JsonUtilities.convertJson;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerifyFieldToken implements Question<String> {

    public static VerifyFieldToken exists() {
        return new VerifyFieldToken();
    }

    @Override
    public String answeredBy(Actor actor) {
        return lastResponse().getBody().prettyPrint();
    }
}
