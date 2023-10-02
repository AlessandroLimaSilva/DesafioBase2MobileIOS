package com.SerenityBDDAppiumTemplate.steps;

import com.SerenityBDDAppiumTemplate.pages.MyCartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MyCartStep extends ScenarioSteps {

    MyCartPage myCartPage;

    @Step("clicar excluir item")
    public void clicarExcluirItem(){
        myCartPage.excluirItemButton();
    }

    @Step("retorna se carrinho vazio e visivel")
    public boolean retornaSeCarrinhoVazioEVisivel(){
        return myCartPage.retornaSeCarrinhoVazioLabelEVisivel();
    }

    @Step("excluir todos os itens do carrinho")
    public void excluirTodosOsItensDoCarrinho(){
        myCartPage.excluirTodosOsItensDoCarrinho();
    }

    @Step("clicar proceed to checkout button")
    public void clicarProceedToCheckoutButton(){
        myCartPage.clicarProceedToCheckoutButton();
    }
}
