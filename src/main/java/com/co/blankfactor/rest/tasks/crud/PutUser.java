package com.co.blankfactor.rest.tasks.crud;

import com.co.blankfactor.rest.models.User;
import com.co.blankfactor.rest.models.builders.UserBuilder;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.*;

public class PutUser implements Task {
    private static final String ENDPOINT = "/api/users/";
    public static final String SESSION_USER_VARIABLE = "SESSION USER VARIABLE";
    private int id;
    private User userData;

    public PutUser(int id, User userData) {
        this.id = id;
        this.userData = userData;
    }

    public static PutUser inTheSystem(int id, UserBuilder userBuilder) {
        return instrumented(PutUser.class, id, userBuilder.build());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(ENDPOINT + id)
                        .with(requestSpecification
                                -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userData))
        );
        actor.remember(SESSION_USER_VARIABLE, userData);
    }
}
