package com.SerenityBDDAppiumTemplate.steps;

import com.SerenityBDDAppiumTemplate.pages.CheckoutPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CheckoutStep extends ScenarioSteps {

    CheckoutPage checkoutPage;

    @Step("preencher full name input field")
    public void preencherFullNameInputField(String nome){
        checkoutPage.preencherFullNameInputField(nome);
    }

    @Step("preencher address line one input field")
    public void preencherAddressLineOneInputField(String endereco){
        checkoutPage.preencherAddressLineOneInputField(endereco);
    }

    @Step("preencher address line two input field")
    public void preencherAddressLineTwoInputField(String endereco){
        checkoutPage.preencherAddressLineTwoInputField(endereco);
    }

    @Step("preencher city input field")
    public void preencherCityInputField(String cidade){
        checkoutPage.preencherCityInputField(cidade);
    }

    @Step("preencher state region input field")
    public void preencherStateRegionInputField(String estado){
        checkoutPage.preencherStateRegionInputField(estado);
    }

    @Step("preencher zip code input field")
    public void preencherZipCodeInputField(String cep){
        checkoutPage.preencherZipCodeInputField(cep);
    }

    @Step("preencher country input field")
    public void preencherCountryInputField(String pais){
        checkoutPage.preencherCountryInputField(pais);
    }

    @Step("clicar to payment button")
    public void clicarToPaymentButton(){
        checkoutPage.clicarToPaymentButton();
    }

    @Step("preencher card full name input field")
    public void preencherCardFullNameInputField(String nome){
        checkoutPage.preencherCardFullNameInputField(nome);
    }

    @Step("preencher card number input field")
    public void preencherCardNumberInputField(String numeroCartao){
        checkoutPage.preencherCardNumberInputField(numeroCartao);
    }

    @Step("preencher expiration date input field")
    public void preencherExpirationDateInputField(String dataVencimentoCartao){
        checkoutPage.preencherExpirationDateInputField(dataVencimentoCartao);
    }

    @Step("preencher security code input field")
    public void preencherSecurityCodeInputField(String securityCode){
        checkoutPage.preencherSecurityCodeInputField(securityCode);
    }

    @Step("clicar my billing address is the same as my shipping address check")
    public void clicarMyBillingAddressIsTheSameAsMyShippingAddressCheck(){
        checkoutPage.clicarMyBillingAddressIsTheSameAsMyShippingAddressCheck();
    }

    @Step("clicar review order button")
    public void clicarReviewOrderButton(){
        checkoutPage.clicarReviewOrderButton();
    }

    @Step("clicar place order button")
    public void clicarPlaceOrderButton(){
        checkoutPage.clicarPlaceOrderButton();
    }

    @Step("retorna texto checkout complete label")
    public String retornaTextoCheckoutCompleteLabel(){
        return checkoutPage.retornaTextoCheckoutCompleteLabel();
    }

    @Step("retorna texto please provide your fullname label")
    public String retornaTextoPleaseProvideYourFullnameLabel(){
        return checkoutPage.retornaTextoPleaseProvideYourFullnameLabel();
    }

    @Step("retorna texto please provide your address label")
    public String retornaTextoPleaseProvideYourAddressLabel(){
        return checkoutPage.retornaTextoPleaseProvideYourAddressLabel();
    }

    @Step("retorna texto please provide your city label")
    public String retornaTextoPleaseProvideYourCityLabel(){
        return checkoutPage.retornaTextoPleaseProvideYourCityLabel();
    }

    @Step("retorna texto please provide your zip code label")
    public String retornaTextoPleaseProvideYourZipCodeLabel(){
        return checkoutPage.retornaTextoPleaseProvideYourZipCodeLabel();
    }

    @Step("retorna texto please provide your country label")
    public String retornaTextoPleaseProvideYourCountryLabel(){
        return checkoutPage.retornaTextoPleaseProvideYourCountryLabel();
    }

    @Step("retorna texto value looks invalid label")
    public String retornaTextoValueLooksInvalidLabel(){
        return checkoutPage.retornaTextoValueLooksInvalidLabel();
    }

    @Step("clicar card label work around")
    public void clicarCardLabelWorkAround(){
        checkoutPage.clicarCardLabelWorkAround();
    }

    @Step("preencher full name review order")
    public void preencherFullNameReviewOrder(String fullName){
        checkoutPage.preencherFullNameReviewOrder(fullName);
    }
}
