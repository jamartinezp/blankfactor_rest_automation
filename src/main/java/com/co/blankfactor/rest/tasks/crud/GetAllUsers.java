package com.co.blankfactor.rest.tasks.crud;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.co.blankfactor.rest.questions.ResponseToken.RECALL_TOKEN;

public class GetAllUsers implements Task {
    private static final String ENDPOINT = "/api/unknown";

    public static GetAllUsers inTheSystem() {
        return Tasks.instrumented(GetAllUsers.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(ENDPOINT)
                        .with(requestSpecification
                                -> requestSpecification
                                .contentType(ContentType.JSON)
                                .header("token", RECALL_TOKEN)));

    }
}
