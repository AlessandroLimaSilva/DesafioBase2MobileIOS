package com.SerenityBDDAppiumTemplate.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.Serenity;

public class CucumberHooks {

    @Before
    public void beforeTest() {

    }

    @After
    public void afterTest()
    {
        Serenity.clearCurrentSession();
        Serenity.getWebdriverManager().resetDriver();
    }
}
