package com.SerenityBDDAppiumTemplate.steps;

import com.SerenityBDDAppiumTemplate.pages.MenuPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MenuStep extends ScenarioSteps {

    MenuPage menuPage;

    @Step("clicar menu item log in button")
    public void clicarMenuItemLogInButton(){
        menuPage.clicarMenuItemLogInButton();
    }

    @Step("clicar menu item log out button")
    public void clicarMenuItemLogOutButton(){
        menuPage.clicarMenuItemLogOutButton();
    }

    @Step("clicar log out confirmar button")
    public void clicarLogOutConfirmarButton(){
        menuPage.clicarLogOutConfirmarButton();
    }

    @Step("retornar texto you are success fully logged out label")
    public String retornarTextoYouAreSuccessFullyLoggedOutLabel(){
        return menuPage.retornarTextoYouAreSuccessFullyLoggedOutLabel();
    }
}
