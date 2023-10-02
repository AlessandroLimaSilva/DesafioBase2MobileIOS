package com.SerenityBDDAppiumTemplate.steps;

import com.SerenityBDDAppiumTemplate.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginStep extends ScenarioSteps {

    LoginPage loginPage;

    @Step("preencher username input field")
    public void preencherUsernameInputField(String nome){
        loginPage.preencherUsernameInputField(nome);
    }

    @Step("preencher password input field")
    public void preencherPasswordInputField(String password){
        loginPage.preencherPasswordInputField(password);
    }

    @Step("clicar login button")
    public void clicarLoginButton(){
        loginPage.clicarLoginButton();
    }

    @Step("retorna texto provided credential do not match any user in this service label")
    public String retornaTextoProvidedCredentialsDoNotMatchAnyUserInThisServiceLabel(){
        return loginPage.retornaTextoProvidedCredentialsDoNotMatchAnyUserInThisServiceLabel();
    }

    @Step("retorna texto username is required label")
    public String retornaTextoUsernameIsRequiredLabel(){
        return loginPage.retornaTextoUsernameIsRequiredLabel();
    }

    @Step("retorna texto password is required label")
    public String retornaTextoPasswordIsRequiredLabel(){
        return loginPage.retornaTextoPasswordIsRequiredLabel();
    }

    @Step("retorna texto sorry this user has been locked out label")
    public String retornaTextoSorryThisUserHasBeenLockedOutLabel(){
        return loginPage.retornaTextoSorryThisUserHasBeenLockedOutLabel();
    }

    @Step("clicar preencher usuario bloquedo automaticamente button")
    public void clicarPreencherUsuarioBloqueadoAutomaticamenteButton(){
        loginPage.clicarPreencherUsuarioBloqueadoAutomaticamenteButton();
    }

    @Step("clicar preencher usuario cadastrado automaticamente button")
    public void clicarPreencherUsuarioCadastradoAutomaticamenteButton(){
        loginPage.clicarPreencherUsuarioCadastradoAutomaticamenteButton();
    }

}
