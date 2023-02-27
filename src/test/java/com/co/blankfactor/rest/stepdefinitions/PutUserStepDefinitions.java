package com.co.blankfactor.rest.stepdefinitions;

import com.co.blankfactor.rest.exceptions.IncorrectExpectedValuesException;
import com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException;
import com.co.blankfactor.rest.models.User;
import com.co.blankfactor.rest.questions.ResponseCode;
import com.co.blankfactor.rest.questions.VerifyUserUpdated;
import com.co.blankfactor.rest.tasks.PutUser;
import com.co.blankfactor.rest.utils.manager.FileReaderManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;

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
        //User userName = FileReaderManager.getInstance().getJsonReader().getCustomerByName(newName);
        //User userJob = FileReaderManager.getInstance().getJsonReader().getUserJob(newJob);
        List<User> users = FileReaderManager.getInstance().getJsonReader().getCustomerData();
        for (User u:users) {
            theActorCalled(actorName).whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                    .attemptsTo(PutUser.inTheSystem(id, with().theName(u.getName()).andJobTitle(u.getJobTitle())));
        }
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
