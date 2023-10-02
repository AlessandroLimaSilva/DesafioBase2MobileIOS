package com.SerenityBDDAppiumTemplate.pages;

import com.SerenityBDDAppiumTemplate.bases.PageBase;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends PageBase {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Full Name* input field']")
    protected WebElement fullNameInputField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Address Line 1* input field']")
    protected WebElement addressLineOneInputField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Address Line 2 input field']")
    protected WebElement addressLineTwoInputField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='City* input field']")
    protected WebElement cityInputField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='State/Region input field']")
    protected WebElement stateRegionInputField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Zip Code* input field']")
    protected WebElement zipCodeInputField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Country* input field']")
    protected WebElement countryInputField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='To Payment button']")
    protected WebElement toPaymentButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Full Name* input field']")
    protected WebElement cardFullNameInputField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Card Number* input field']")
    protected WebElement cardNumberInputField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Expiration Date* input field']")
    protected WebElement expirationDateInputField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Security Code* input field']")
    protected WebElement securityCodeInputField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='checkbox for My billing address is the same as my shipping address.']")
    protected WebElement myBillingAddressIsTheSameAsMyShippingAddressCheck;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Review Order button']")
    protected WebElement reviewOrderButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Place Order button']")
    protected WebElement placeOrderButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Checkout Complete']")
    protected WebElement checkoutCompleteLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeKey[@name='more']")
    protected WebElement numberKeyboardButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Please provide your full name.']")
    protected WebElement pleaseProvideYourFullnameLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Please provide your address.']")
    protected WebElement pleaseProvideYourAddressLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Please provide your city.']")
    protected WebElement pleaseProvideYourCityLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Please provide your zip code.']")
    protected WebElement pleaseProvideYourZipCodeLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Please provide your country.']")
    protected WebElement pleaseProvideYourCountryLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Value looks invalid.']")
    protected WebElement valueLooksInvalidLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Security Code*']")
    protected WebElement cardLabelWorkAround;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField[@name='Full Name* input field'])[2]")
    protected WebElement fullNameReviewOrder;


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void preencherFullNameInputField(String nome){
        fullNameInputField.click();
        fullNameInputField.sendKeys(nome);
        closeKeyBoardIOS(fullNameInputField);
    }

    public void preencherAddressLineOneInputField(String endereco){
        addressLineOneInputField.click();
        addressLineOneInputField.sendKeys(endereco);
        closeKeyBoardIOS(addressLineOneInputField);
    }

    public void preencherAddressLineTwoInputField(String endereco){
        addressLineTwoInputField.click();
        addressLineTwoInputField.sendKeys(endereco);
        closeKeyBoardIOS(addressLineTwoInputField);
    }

    public void preencherCityInputField(String cidade){
        cityInputField.click();
        cityInputField.sendKeys(cidade);
        closeKeyBoardIOS(cityInputField);
    }

    public void preencherStateRegionInputField(String estado){
        stateRegionInputField.click();
        stateRegionInputField.sendKeys(estado);
        closeKeyBoardIOS(stateRegionInputField);
    }

    public void preencherZipCodeInputField(String cep){
        zipCodeInputField.click();
        zipCodeInputField.sendKeys(cep);
        closeKeyBoardIOS(zipCodeInputField);
    }

    public void preencherCountryInputField(String pais){
        countryInputField.click();
        countryInputField.sendKeys(pais);
        closeKeyBoardIOS(countryInputField);
    }

    public void clicarToPaymentButton(){
        toPaymentButton.click();
    }

    public void preencherCardFullNameInputField(String nome){
        cardFullNameInputField.click();
        cardFullNameInputField.sendKeys(nome);
        closeKeyBoardIOS(cardFullNameInputField);
    }

    public void preencherCardNumberInputField(String numeroCartao){
        cardNumberInputField.click();
        sendKeysWorkAroundIOS(numeroCartao);
        closeKeyBoardIOS(cardNumberInputField);
    }

    public void preencherExpirationDateInputField(String dataVencimentoCartao){
        expirationDateInputField.click();
        numberKeyboardButton.click();
        sendKeysWorkAroundIOS(dataVencimentoCartao);
        closeKeyBoardIOS(expirationDateInputField);
    }

    public void preencherSecurityCodeInputField(String securityCode){
        securityCodeInputField.click();
        sendKeysWorkAroundIOS(securityCode);
        closeKeyBoardIOS(securityCodeInputField);
    }

    public void clicarMyBillingAddressIsTheSameAsMyShippingAddressCheck(){
        myBillingAddressIsTheSameAsMyShippingAddressCheck.click();
        scrollDownIOS();
    }

    public void clicarReviewOrderButton(){
        waitFor(reviewOrderButton);
        reviewOrderButton.click();
    }

    public void clicarPlaceOrderButton(){
        placeOrderButton.click();
    }

    public String retornaTextoCheckoutCompleteLabel(){
        return checkoutCompleteLabel.getText();
    }

    public String retornaTextoPleaseProvideYourFullnameLabel(){
        return pleaseProvideYourFullnameLabel.getText();
    }

    public String retornaTextoPleaseProvideYourAddressLabel(){
        return pleaseProvideYourAddressLabel.getText();
    }

    public String retornaTextoPleaseProvideYourCityLabel(){
        return pleaseProvideYourCityLabel.getText();
    }

    public String retornaTextoPleaseProvideYourZipCodeLabel(){
        return pleaseProvideYourZipCodeLabel.getText();
    }

    public String retornaTextoPleaseProvideYourCountryLabel(){
        return pleaseProvideYourCountryLabel.getText();
    }

    public String retornaTextoValueLooksInvalidLabel(){
        return valueLooksInvalidLabel.getText();
    }

    public void clicarCardLabelWorkAround(){
        cardLabelWorkAround.click();
    }

    public void preencherFullNameReviewOrder(String fullName){
        fullNameReviewOrder.sendKeys(fullName);
        closeKeyBoardIOS(fullNameReviewOrder);
    }

}
