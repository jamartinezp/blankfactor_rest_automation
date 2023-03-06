package com.co.blankfactor.rest.stepdefinitions.login;

import com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException;
import com.co.blankfactor.rest.exceptions.IncorrectResponseTokenException;
import com.co.blankfactor.rest.questions.ResponseCode;
import com.co.blankfactor.rest.questions.ResponseToken;
import com.co.blankfactor.rest.questions.VerifyFieldToken;
import com.co.blankfactor.rest.tasks.login.Login;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static com.co.blankfactor.rest.Hooks.THE_ACTOR_NAMED;
import static com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException.INCORRECT_RESPONSE_CODE;
import static com.co.blankfactor.rest.exceptions.IncorrectResponseTokenException.*;
import static com.co.blankfactor.rest.models.builders.UserBuilder.with;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class LoginStepDefinitions {
    private EnvironmentVariables environmentVariables;

    @Given("^that an user wants to login successfully with (.*) and (.*)$")
    public void thatBlankWantToLoginSuccessfullyWithHelloAnd(String email, String password) {
        THE_ACTOR_NAMED.whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                .attemptsTo(Login.inTheSystem(with().theEmail(email).andThePassword(password)));

    }

    @Then("^he logs in successfully$")
    public void heLoginSuccessfully() {
        THE_ACTOR_NAMED.should(seeThat(ResponseCode.was(), equalTo(200))
                        .orComplainWith(IncorrectResponseCodeException.class, INCORRECT_RESPONSE_CODE));

        THE_ACTOR_NAMED.should(seeThat(VerifyFieldToken.exists(), containsString("token"))
                        .orComplainWith(IncorrectResponseTokenException.class, INCORRECT_RESPONSE_TOKEN));

        THE_ACTOR_NAMED.should(seeThat(ResponseToken.wasSave(), notNullValue())
                        .orComplainWith(IncorrectResponseTokenException.class, NOT_NULL_VALUE));
    }
}
