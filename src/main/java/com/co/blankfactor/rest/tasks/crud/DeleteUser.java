package com.co.blankfactor.rest.tasks.crud;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteUser implements Task {
    private static final String ENDPOINT = "/api/users/{id}";
    private final int id;

    public DeleteUser(int id) {
        this.id = id;
    }

    public static DeleteUser withId(int id) {
        return Tasks.instrumented(DeleteUser.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(ENDPOINT)
                        .with(requestSpecification
                                -> requestSpecification
                                .pathParam("id", id)
                                .contentType(ContentType.JSON))
        );
    }
}
