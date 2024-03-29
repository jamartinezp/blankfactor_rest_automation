package com.co.blankfactor.rest.stepdefinitions.crud;

import com.co.blankfactor.rest.exceptions.IncorrectExpectedValuesException;
import com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException;
import com.co.blankfactor.rest.models.User;
import com.co.blankfactor.rest.questions.ResponseCode;
import com.co.blankfactor.rest.questions.VerifyUserCreated;
import com.co.blankfactor.rest.questions.VerifyUserUpdated;
import com.co.blankfactor.rest.tasks.crud.DeleteUser;
import com.co.blankfactor.rest.tasks.crud.GetUser;
import com.co.blankfactor.rest.tasks.crud.PostUser;
import com.co.blankfactor.rest.tasks.crud.PutUser;
import com.co.blankfactor.rest.utils.manager.FileReaderManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;

import static com.co.blankfactor.rest.Hooks.THE_ACTOR_NAMED;
import static com.co.blankfactor.rest.exceptions.IncorrectExpectedValuesException.INCORRECT_EXPECTED_VALUES;
import static com.co.blankfactor.rest.exceptions.IncorrectResponseCodeException.INCORRECT_RESPONSE_CODE;
import static com.co.blankfactor.rest.models.builders.UserBuilder.with;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CrudUserStepDefinition {
    private EnvironmentVariables environmentVariables;

    @Given("^that a user wants to delete an user with id (.*)$")
    public void thatBlankWantToDeleteAnUserWithId(int id) {
        THE_ACTOR_NAMED.whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                .attemptsTo(DeleteUser.withId(id));
    }

    @Given("^that a user wants to get user's info with id (.*)$")
    public void thatBlankWantToKnowHowManyUsersAreInPage(int id) {
        THE_ACTOR_NAMED.whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                .attemptsTo(
                        GetUser.withId(id)
                );
    }

    @Given("^that a user wants to create his user with (.*) and his job title, which is: (.*)$")
    public void thatBlankWantToCreateANewUserWithPostMethod(String name, String job) {
        THE_ACTOR_NAMED.whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                .attemptsTo(PostUser.inTheSystem(with().theName(name).andJobTitle(job)));
    }

    @Given("^that a user wants to update an user with id (.*), sending (.*) as new name and (.*) as new job$")
    public void thatBlankWantToUpdateAnUserWithIdSendingMorpheusAsNewNameAndZoneAsNewJob
            (int id, String newName, String newJob) {
        //User userName = FileReaderManager.getInstance().getJsonReader().getCustomerByName(newName);
        //User userJob = FileReaderManager.getInstance().getJsonReader().getUserJob(newJob);
        List<User> users = FileReaderManager.getInstance().getJsonReader().getCustomerData();
        for (User u : users) {
            THE_ACTOR_NAMED.whoCan(CallAnApi.at(environmentVariables.getProperty("api.rest.baseUrl")))
                    .attemptsTo(PutUser.inTheSystem(id, with().theName(u.getName()).andJobTitle(u.getJobTitle())));
        }
    }

    @Then("^he see that a new user was created$")
    public void aNewUserWasCreated() {
        THE_ACTOR_NAMED.should(seeThat(VerifyUserCreated.ofTheResponse())
                .orComplainWith(IncorrectExpectedValuesException.class, INCORRECT_EXPECTED_VALUES));
    }


    @Then("^he see that an user was updated$")
    public void heSeeThatAnUserWasUpdated() {
        THE_ACTOR_NAMED.should(seeThat(VerifyUserUpdated.ofTheResponse())
                .orComplainWith(IncorrectExpectedValuesException.class, INCORRECT_EXPECTED_VALUES));
    }

    @Then("^he sees that the response code was (.*)$")
    public void heSawTheResponseCodeWas(int responseCode) {
        THE_ACTOR_NAMED.should(seeThat(ResponseCode.was(), equalTo(responseCode))
                .orComplainWith(IncorrectResponseCodeException.class, INCORRECT_RESPONSE_CODE));
    }
}
