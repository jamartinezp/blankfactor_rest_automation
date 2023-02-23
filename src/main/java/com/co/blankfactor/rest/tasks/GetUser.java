package com.co.blankfactor.rest.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.*;

public class GetUser implements Task {
    private static final String ENDPOINT = "/api/users/{id}";
    private int id;

    public GetUser(int id) {
        this.id = id;
    }

    public static GetUser withId(int page) {
        return instrumented(GetUser.class, page);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(ENDPOINT)
                        .with(requestSpecification ->
                                requestSpecification
                                        .pathParam("id", id)
                                        .contentType(ContentType.JSON))
        );
    }
}
