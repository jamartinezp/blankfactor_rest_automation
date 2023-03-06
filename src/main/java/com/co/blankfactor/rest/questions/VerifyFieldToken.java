package com.co.blankfactor.rest.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

import static com.co.blankfactor.rest.utils.JsonUtilities.convertJson;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class ResponseToken implements Question<Boolean> {
    private Map convertedJson;
    public static final String TOKEN = "TOKEN";
    public static  String RECALL_TOKEN = "";

    public static ResponseToken exists() {
        return new ResponseToken();
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        convertedJson = convertJson(lastResponse().getBody().prettyPrint());
        return convertedJson.containsKey("tken");
    }
}
