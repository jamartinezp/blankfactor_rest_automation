package com.co.blankfactor.rest.stepdefinitions;

import com.co.blankfactor.rest.tasks.PostUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static com.co.blankfactor.rest.models.builders.UserBuilder.with;

public class PostUserStepDefinitions {
    private EnvironmentVariables environmentVariables;
    @Given("^that (.*) want to create his user with his name and his job title, which is: (.*)$")
    public void thatBlankWantToCreateANewUserWithPostMethod(String actorName, String job) {
        OnStage.theActorCalled(actorName).whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                .attemptsTo(PostUser.inTheSystem(with().theName(actorName).andJobTitle(job)));
    }

    @Then("^he see that a new user was created$")
    public void aNewUserWasCreated() {

    }
}
