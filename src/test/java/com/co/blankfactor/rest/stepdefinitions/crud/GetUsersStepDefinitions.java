package com.co.blankfactor.rest.stepdefinitions.crud;

import com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException;
import com.co.blankfactor.rest.questions.ResponseCode;
import com.co.blankfactor.rest.tasks.crud.GetUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException.INCORRECT_RESPONSE_CODE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class GetUsersStepDefinitions {

    private EnvironmentVariables environmentVariables;

    @Given("^that (.*) want to get user's info with id (.*)$")
    public void thatBlankWantToKnowHowManyUsersAreInPage(String actorName, int id) {
        theActorCalled(actorName)
                .whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                .attemptsTo(
                        GetUser.withId(id)
                );
    }

    @Then("^he looks at the user information$")
    public void heLooksAtTheListOfUsers() {
        theActorInTheSpotlight()
                .should(seeThat(ResponseCode.was(), equalTo(200))
                        .orComplainWith(IncorrectResponseCodeException.class, INCORRECT_RESPONSE_CODE));

    }
}
