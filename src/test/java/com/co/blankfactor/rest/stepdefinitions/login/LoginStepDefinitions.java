package com.co.blankfactor.rest.stepdefinitions.login;

import com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException;
import com.co.blankfactor.rest.questions.ResponseCode;
import com.co.blankfactor.rest.tasks.login.Login;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException.INCORRECT_RESPONSE_CODE;
import static com.co.blankfactor.rest.models.builders.UserBuilder.with;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinitions {
    private EnvironmentVariables environmentVariables;

    @Given("^that (.*) want to login successfully with (.*) and (.*)$")
    public void thatBlankWantToLoginSuccessfullyWithHelloAnd(String actorName, String email, String password) {
        OnStage.theActorCalled(actorName).whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                .attemptsTo(Login.inTheSystem(with().theEmail(email).andThePassword(password)));

    }

    @Then("^he login successfully$")
    public void heLoginSuccessfully() {
        theActorInTheSpotlight()
                .should(seeThat(ResponseCode.was(), equalTo(200))
                        .orComplainWith(IncorrectResponseCodeException.class, INCORRECT_RESPONSE_CODE));
    }
}
