package com.co.blankfactor.rest.stepdefinitions;

import com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException;
import com.co.blankfactor.rest.questions.ResponseCode;
import com.co.blankfactor.rest.tasks.DeleteUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException.INCORRECT_RESPONSE_CODE;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class DeleteUserStepDefinitions {
    private EnvironmentVariables environmentVariables;

    @Given("^that (.*) want to delete an user with id (.*)$")
    public void thatBlankWantToDeleteAnUserWithId(String actorName, int id) {
        theActorCalled(actorName)
                .whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                .attemptsTo(DeleteUser.withId(id));
    }

    @Then("^he sees that the user was deleted$")
    public void heSeesThatTheUserWasDeleted() {
        theActorInTheSpotlight()
                .should(seeThat(ResponseCode.was(), equalTo(204))
                        .orComplainWith(IncorrectResponseCodeException.class, INCORRECT_RESPONSE_CODE));
    }
}
