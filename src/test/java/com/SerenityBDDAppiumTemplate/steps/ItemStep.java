package com.SerenityBDDAppiumTemplate.steps;

import com.SerenityBDDAppiumTemplate.pages.ItemPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ItemStep extends ScenarioSteps {

    ItemPage itemPage;

    @Step("clicar adicionar item ao carrinho button")
    public void clicarAdicionarItemAoCarrinhoButton(){
        itemPage.clicarAdicionarItemAoCarrinhoButton();
    }

    @Step("clicar classificacao item list")
    public void clicarClassificacaoItemList(String nota){
        itemPage.clicarClassificacaoItemList(nota);
    }

    @Step("retornar texto thank you for submitting your review label")
    public String retornarTextoThankYouForSubmittingYourReviewLabel(){
        return itemPage.retornarTextoThankYouForSubmittingYourReviewLabel();
    }

}
