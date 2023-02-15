package com.co.blankfactor.rest.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.*;

public class GetUser implements Task {
    private static final String ENDPOINT = "/api/users/";
    private int page;

    public GetUser(int page) {
        this.page = page;
    }

    public static GetUser byId(int page) {
        return instrumented(GetUser.class, page);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(ENDPOINT + page)
                        .with(requestSpecification ->
                                requestSpecification
                                        .contentType(ContentType.JSON)));
    }
}
