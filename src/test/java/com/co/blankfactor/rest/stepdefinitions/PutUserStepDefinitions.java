package com.co.blankfactor.rest.stepdefinitions;

import com.co.blankfactor.rest.exceptions.IncorrectExpectedValuesException;
import com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException;
import com.co.blankfactor.rest.questions.ResponseCode;
import com.co.blankfactor.rest.questions.VerifyUserUpdated;
import com.co.blankfactor.rest.tasks.PutUser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static com.co.blankfactor.rest.exceptions.IncorrectExpectedValuesException.INCORRECT_EXPECTED_VALUES;
import static com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException.INCORRECT_RESPONSE_CODE;
import static com.co.blankfactor.rest.models.builders.UserBuilder.with;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;

public class PutUserStepDefinitions {
    private EnvironmentVariables environmentVariables;
    @Given("^that (.*) want to update an user with id (.*), sending (.*) as new name and (.*) as new job$")
    public void thatBlankWantToUpdateAnUserWithIdSendingMorpheusAsNewNameAndZoneAsNewJob
            (String actorName, int id, String newName, String newJob) {
        theActorCalled(actorName).whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                .attemptsTo(PutUser.inTheSystem(id,with().theName(newName).andJobTitle(newJob)));
    }

    @Then("^he see that an user was updated$")
    public void heSeeThatAnUserWasUpdated() {
        theActorInTheSpotlight()
                .should(seeThat(ResponseCode.was(), equalTo(200))
                        .orComplainWith(IncorrectResponseCodeException.class, INCORRECT_RESPONSE_CODE ));

        theActorInTheSpotlight()
                .should(seeThat(VerifyUserUpdated.ofTheResponse())
                        .orComplainWith(IncorrectExpectedValuesException.class, INCORRECT_EXPECTED_VALUES ));
    }
}
