package com.SerenityBDDAppiumTemplate.steps;

import com.SerenityBDDAppiumTemplate.pages.PaginalnicialPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class PaginaInicialStep extends ScenarioSteps {

    PaginalnicialPage paginalnicialPage;

    @Step("clicar em menu button")
    public void clicarEmMenuButton(){
        paginalnicialPage.clicarMenuButton();
    }

    @Step("clicar catalog button")
    public void clicarCatalogButton(){
        paginalnicialPage.clicarCatalogButton();
    }

    @Step("clicar cart button")
    public void clicarCartButton(){
        paginalnicialPage.clicarCartButton();
    }

    @Step("clicar sauce labs back pack card")
    public void clicarSauceLabsBackPackCard(){
        paginalnicialPage.clicarSauceLabsBackPackCard();
    }

    @Step("clicar sauce labs bike light card")
    public void clicarSauceLabsBikeLightCard(){
        paginalnicialPage.clicarSauceLabsBikeLightCard();
    }

    @Step("clicar sauce labs bolt t shirt card")
    public void clicarSauceLabsBoltTShirtCard(){
        paginalnicialPage.clicarSauceLabsBoltTShirtCard();
    }

    @Step("clicar sauce labs fleece jacket card")
    public void clicarSauceLabsFleeceJacketCard(){
        paginalnicialPage.clicarSauceLabsFleeceJacketCard();
    }

    @Step("clicar sauce labs onesie card")
    public void clicarSauceLabsOnesieCard(){
        paginalnicialPage.clicarSauceLabsOnesieCard();
    }

    @Step("clicar test all the things t shirt card")
    public void clicarTestAllTheThingsTShirtCard(){
        paginalnicialPage.clicarTestAllTheThingsTShirtCard();
    }

}
