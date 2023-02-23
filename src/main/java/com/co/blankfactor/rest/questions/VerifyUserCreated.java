package com.co.blankfactor.rest.questions;

import com.co.blankfactor.rest.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static com.co.blankfactor.rest.tasks.PostUser.SESSION_USER_VARIABLE;
import static com.co.blankfactor.rest.utils.JsonUtilities.convertJson;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class VerifyUserCreated implements Question<Boolean> {
    private Map convertedJson;
    private User userData;

    public static VerifyUserCreated ofTheResponse(){ return new VerifyUserCreated();}
    @Override
    public Boolean answeredBy(Actor actor) {
        convertedJson = convertJson(lastResponse().getBody().prettyPrint());
        userData = actor.recall(SESSION_USER_VARIABLE);
        return verifyUserData() && verifyInformationField();
    }

    private boolean verifyUserData(){
        return userData.getName().equals(convertedJson.get("name"))
                && userData.getJobTitle().equals(convertedJson.get("jobTitle"));
    }

    private boolean verifyInformationField(){
        return convertedJson.containsKey("createdAt")
                && StringUtils.isNumeric((CharSequence) convertedJson.get("id"));
    }
}
