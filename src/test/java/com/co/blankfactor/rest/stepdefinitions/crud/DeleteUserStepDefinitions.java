package com.co.blankfactor.rest.stepdefinitions.crud;

import com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException;
import com.co.blankfactor.rest.questions.ResponseCode;
import com.co.blankfactor.rest.tasks.crud.DeleteUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static com.co.blankfactor.rest.Hooks.THE_ACTOR_NAMED;
import static com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException.INCORRECT_RESPONSE_CODE;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class DeleteUserStepDefinitions {
    private EnvironmentVariables environmentVariables;

    @Given("^that an user wants to delete an user with id (.*)$")
    public void thatBlankWantToDeleteAnUserWithId( int id) {
        THE_ACTOR_NAMED.whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                .attemptsTo(DeleteUser.withId(id));
    }

    @Then("^he sees that the user was deleted$")
    public void heSeesThatTheUserWasDeleted() {
        THE_ACTOR_NAMED.should(seeThat(ResponseCode.was(), equalTo(204))
                        .orComplainWith(IncorrectResponseCodeException.class, INCORRECT_RESPONSE_CODE));
    }
}
