package com.co.blankfactor.rest.stepdefinitions.crud;

import com.co.blankfactor.rest.exceptions.IncorrectExpectedValuesException;
import com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException;
import com.co.blankfactor.rest.questions.ResponseCode;
import com.co.blankfactor.rest.questions.VerifyUserCreated;
import com.co.blankfactor.rest.tasks.crud.PostUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static com.co.blankfactor.rest.Hooks.THE_ACTOR_NAMED;
import static com.co.blankfactor.rest.exceptions.IncorrectExpectedValuesException.INCORRECT_EXPECTED_VALUES;
import static com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException.INCORRECT_RESPONSE_CODE;
import static com.co.blankfactor.rest.models.builders.UserBuilder.with;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;

public class PostUserStepDefinitions {
    private EnvironmentVariables environmentVariables;

    @Given("^that an user wants to create his user with (.*) and his job title, which is: (.*)$")
    public void thatBlankWantToCreateANewUserWithPostMethod(String name, String job) {
        THE_ACTOR_NAMED.whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                .attemptsTo(PostUser.inTheSystem(with().theName(name).andJobTitle(job)));
    }

    @Then("^he see that a new user was created$")
    public void aNewUserWasCreated() {
        THE_ACTOR_NAMED.should(seeThat(ResponseCode.was(), equalTo(201))
                        .orComplainWith(IncorrectResponseCodeException.class, INCORRECT_RESPONSE_CODE));

        THE_ACTOR_NAMED.should(seeThat(VerifyUserCreated.ofTheResponse())
                        .orComplainWith(IncorrectExpectedValuesException.class, INCORRECT_EXPECTED_VALUES));
    }
}
