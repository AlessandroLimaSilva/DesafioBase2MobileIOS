package com.SerenityBDDAppiumTemplate.test;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/revisarPedido.feature",
        glue = {"com.SerenityBDDAppiumTemplate.stepdefinitions"},
        tags = "@automatizado")


public class RevisarPedidoTest {
}
