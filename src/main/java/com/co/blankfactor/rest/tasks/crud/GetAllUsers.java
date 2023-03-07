package com.co.blankfactor.rest.tasks.crud;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.co.blankfactor.rest.questions.ResponseToken.TOKEN;

public class GetAllUsers implements Task {
    private static final String ENDPOINT = "/api/unknown";
    private static String REMEMBERED_TOKEN;

    public static GetAllUsers inTheSystem() {
        return Tasks.instrumented(GetAllUsers.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        REMEMBERED_TOKEN = actor.recall(TOKEN);
        actor.attemptsTo(
                Get.resource(ENDPOINT)
                        .with(requestSpecification
                                -> requestSpecification
                                .contentType(ContentType.JSON)
                                .header("token", REMEMBERED_TOKEN)));

    }
}
