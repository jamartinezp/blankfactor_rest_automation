package com.co.blankfactor.rest.tasks;

import com.co.blankfactor.rest.models.User;
import com.co.blankfactor.rest.models.builders.UserBuilder;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.*;

public class PostUser implements Task {
    private static final String ENDPOINT = "/api/users";
    private User userData;

    public PostUser(User userData) {
        this.userData = userData;
    }

    public static PostUser inTheSystem(UserBuilder userBuilder) {
        return instrumented(PostUser.class, userBuilder.build());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(ENDPOINT)
                        .with(requestSpecification
                                -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userData))
        );
    }
}
