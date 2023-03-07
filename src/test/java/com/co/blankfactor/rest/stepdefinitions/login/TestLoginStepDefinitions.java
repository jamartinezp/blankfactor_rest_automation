package com.co.blankfactor.rest.stepdefinitions.login;

import com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException;
import com.co.blankfactor.rest.questions.ResponseCode;
import com.co.blankfactor.rest.tasks.crud.GetAllUsers;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static com.co.blankfactor.rest.Hooks.THE_ACTOR_NAMED;
import static com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException.INCORRECT_RESPONSE_CODE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class TestLoginStepDefinitions {
    private EnvironmentVariables environmentVariables;

    @Given("^that an user wants to see all users in the system$")
    public void thatAnUserWantsToSeeAllUsersInTheSystem() {
        THE_ACTOR_NAMED.whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                .attemptsTo(GetAllUsers.inTheSystem());
    }

    @Then("^he can see all users$")
    public void heCanSeeAllUsers() {
        THE_ACTOR_NAMED.should(seeThat(ResponseCode.was(), equalTo(200))
                .orComplainWith(IncorrectResponseCodeException.class, INCORRECT_RESPONSE_CODE));
    }
}
