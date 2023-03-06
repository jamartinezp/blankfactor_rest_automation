package com.co.blankfactor.rest.runners.login;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/login/",
        glue = {"com.co.blankfactor.rest"},
        snippets = SnippetType.CAMELCASE
)
public class LoginRunner {
}
