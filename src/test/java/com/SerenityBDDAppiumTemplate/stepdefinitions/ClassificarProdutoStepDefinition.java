package com.SerenityBDDAppiumTemplate.stepdefinitions;

import com.SerenityBDDAppiumTemplate.steps.ItemStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class ClassificarProdutoStepDefinition {

    @Steps
    ItemStep itemStep;

    @When("^o usuario seleciona uma (.*)$")
    public void oUsuarioSelecionaUma(String nota){
        itemStep.clicarClassificacaoItemList(nota);
    }

    @Then("o produto é classificado com sucesso")
    public void oProdutoEClassificadoComSucesso(){
        Assert.assertTrue(itemStep.retornarTextoThankYouForSubmittingYourReviewLabel().contains("Thank you for submitting your review!"));
    }
}
