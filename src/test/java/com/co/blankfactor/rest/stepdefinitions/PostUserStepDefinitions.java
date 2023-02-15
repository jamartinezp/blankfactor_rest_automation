package com.co.blankfactor.rest.stepdefinitions;

import com.co.blankfactor.rest.tasks.PostUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

public class PostUserStepDefinitions {
    private EnvironmentVariables environmentVariables;
    @Given("^hat (.*) want to create his user with his name and his job title, which is: (.*)$")
    public void thatBlankWantToCreateANewUserWithPostMethod(String actorName, String job) {
        OnStage.theActorCalled(actorName).whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                .attemptsTo(PostUser.inTheSystem());
    }

    @Then("^a new user was created$")
    public void aNewUserWasCreated() {

    }
}
