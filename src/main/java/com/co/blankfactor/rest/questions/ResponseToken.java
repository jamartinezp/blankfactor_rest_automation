package com.co.blankfactor.rest.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

import static com.co.blankfactor.rest.utils.JsonUtilities.convertJson;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ResponseToken implements Question<String> {
    public static final String TOKEN = "TOKEN";

    public static ResponseToken wasSave() {
        return new ResponseToken();
    }

    @Override
    public String answeredBy(Actor actor) {
        Map<?,?> convertedJson = convertJson(lastResponse().getBody().prettyPrint());
        actor.remember(TOKEN, convertedJson.get("token"));
        return convertedJson.get("token").toString();
    }
}
