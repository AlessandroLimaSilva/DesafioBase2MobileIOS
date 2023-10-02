package com.SerenityBDDAppiumTemplate.pages;

import com.SerenityBDDAppiumTemplate.bases.PageBase;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Username input field']")
    protected WebElement usernameInputField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name='Password input field']")
    protected WebElement passwordInputField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Login button']")
    protected WebElement loginButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Provided credentials do not match any user in this service.']")
    protected WebElement providedCredentialsDoNotMatchAnyUserInThisServiceLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Username is required']")
    protected WebElement usernameIsRequiredLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Password is required']")
    protected WebElement passwordIsRequiredLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sorry, this user has been locked out.']")
    protected WebElement sorryThisUserHasBeenLockedOutLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='alice@example.com (locked out)-autofill']")
    protected WebElement preencherUsuarioBloqueadoAutomaticamenteButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='bob@example.com-autofill']")
    protected WebElement preencherUsuarioCadastradoAutomaticamenteButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void preencherUsernameInputField(String nome){
        usernameInputField.sendKeys(nome);
    }

    public void preencherPasswordInputField(String password){
        passwordInputField.sendKeys(password);
    }

    public void clicarLoginButton(){
        loginButton.click();
    }

    public String retornaTextoProvidedCredentialsDoNotMatchAnyUserInThisServiceLabel(){
        return providedCredentialsDoNotMatchAnyUserInThisServiceLabel.getText();
    }

    public String retornaTextoUsernameIsRequiredLabel(){
        return usernameIsRequiredLabel.getText();
    }

    public String retornaTextoPasswordIsRequiredLabel(){
        return passwordIsRequiredLabel.getText();
    }

    public String retornaTextoSorryThisUserHasBeenLockedOutLabel(){
        return sorryThisUserHasBeenLockedOutLabel.getText();
    }

    public void clicarPreencherUsuarioBloqueadoAutomaticamenteButton(){
        preencherUsuarioBloqueadoAutomaticamenteButton.click();
    }

    public void clicarPreencherUsuarioCadastradoAutomaticamenteButton(){
        preencherUsuarioCadastradoAutomaticamenteButton.click();
    }
}
