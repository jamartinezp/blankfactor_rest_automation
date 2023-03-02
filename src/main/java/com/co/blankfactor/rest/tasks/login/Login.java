package com.co.blankfactor.rest.tasks.login;

import com.co.blankfactor.rest.models.User;
import com.co.blankfactor.rest.models.builders.UserBuilder;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.*;

public class Login implements Task {
    private static final String ENDPOINT = "/api/login";
    public static final String SESSION_USER_VARIABLE = "SESSION USER VARIABLE";
    private User userData;

    public Login(User userData) {
        this.userData = userData;
    }

    public static Login inTheSystem(UserBuilder userBuilder){
        return instrumented(Login.class, userBuilder.build());
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
        actor.remember(SESSION_USER_VARIABLE, userData);
    }
}
