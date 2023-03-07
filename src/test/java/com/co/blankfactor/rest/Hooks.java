package com.co.blankfactor.rest;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class Hooks {
    public static Actor THE_ACTOR_NAMED = Actor.named("Blank");

    public void prepareStage() {
        setTheStage(new OnlineCast());
    }
}
