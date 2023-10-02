package com.SerenityBDDAppiumTemplate.bases;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.By.xpath;

public class PageBase extends PageObject {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected long timeOutDefault;
    protected long implicitTimeOutDefault;
    protected JavascriptExecutor javascriptExecutor;

    public PageBase(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.timeOutDefault = getWaitForTimeout().toMillis();
        this.implicitTimeOutDefault = getImplicitWaitTimeout().toMillis();
        this.wait = new WebDriverWait(driver, Duration.ofMillis(timeOutDefault));
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }


    // Custom Actions
    public void waitUntilPageReady() {
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= this.timeOutDefault) {
            if (javascriptExecutor.executeScript("return document.readyState").toString().equals("complete")) {
                timeOut.stop();
                break;
            }
        }
    }

    //region Sincronização
    protected void waitLoadingScreen(WebElement element){
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();
        try
        {
            do
            {
                if (element.getAttribute("hidden") == "true")
                {
                    timeOut.stop();
                    return;
                }

            } while (timeOut.getTime() <= timeOutDefault);
        }
        catch (WebDriverException e)
        {

        }
    }

    //############################## Região Metodos WebElement ######################################

    public void waitForElement(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofMillis(timeOutDefault));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void aguardarCarregamento() {
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();
        try
        {
            do
            {
                WebElement element = driver.findElement(By.xpath("android.widget.ProgressBar"));
                if (Objects.equals(element.getAttribute("hidden"), "false"))
                {
                    timeOut.stop();
                    return;
                }

            } while (timeOut.getTime() <= timeOutDefault);
        }
        catch (WebDriverException e)
        {

        }
    }

    protected  boolean waitForTextPresentElement(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    protected void waitForElementToBeClickeable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementByTime(WebElement element, int time){
        WebDriverWait waitTime = new WebDriverWait(driver, ofSeconds(time));
        waitTime.until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(WebElement element){
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();
        while (timeOut.getTime() <= timeOutDefault)
        {
            //WebElement element = null;
            try
            {

                waitForElement(element);
                waitForElementToBeClickeable(element);
                element.click();
                timeOut.stop();
                return;
            }
            catch (StaleElementReferenceException e) {
                continue;
            }
            catch (WebDriverException e)
            {
                possibleWebDriverException = e;
                if (e.getMessage().contains("Other element would receive the click")) {
                    continue;
                }
                throw e;
            }
        }
        try {
            throw new Exception(possibleWebDriverException);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void click(By locator){
        waitForElement(locator).click();
    }

    protected void sendKeys(WebElement element, String text){
        waitForElement(element);
        element.sendKeys(text);

    }

    protected void sendKeys(By element, String text){
        waitForElement(element).sendKeys(text);

    }

    protected void sendKeysWithoutWaitVisible(WebElement element, String text){
        element.sendKeys(text);
    }

    protected void clear(WebElement element){
        waitForElement(element);
        element.clear();
    }

    protected void clearAndSendKeys(WebElement element, String text){
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
    }

    protected void clearAndSendKeysAlternative(WebElement element, String text){
        waitForElement(element);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);

    }

    protected String getText(WebElement element){
        waitForElement(element);
        return element.getText();
    }

    protected String getValue(WebElement element){
        waitForElement(element);
        return element.getAttribute("value");
    }

    protected boolean returnIfElementIsDisplayed(WebElement element){
        waitForElement(element);
        return element.isDisplayed();
    }

    protected boolean returnIfElementIsDisplayed(By element){
        return waitForElement(element).isDisplayed();
    }

    protected boolean returnIfElementIsEnabled(WebElement element){
        waitForElement(element);
        return element.isEnabled();
    }

    protected boolean returnIfElementIsSelected(WebElement element){
        waitForElement(element);
        return element.isSelected();
    }

    protected String[] returnTextListMobileElements(List<WebElement> elementList){
        int i = 0;
        String[] allText = new String[elementList.size()];

        for (WebElement element : elementList) {
            allText[i++] = element.getText();
        }
        return allText;
    }

    protected int returnCountMobileElements(List<WebElement> elementList){
        return elementList.size();
    }

    protected void clickFirstElementList(List<WebElement> listElement, String textNotContains){
        waitForElement(listElement.get(0));
        String textElement = "";

        for (WebElement element : listElement) {
            if(!element.getText().contains(textNotContains)){
                click(element);
                break;
            }
        }
    }

    protected void clickElementInList(List<WebElement> listElement, int position){
        waitForElement(listElement.get(position));
        click(listElement.get(position));
    }

    protected String clickRandomElementList(List<WebElement> listElement){
        String textElement = "";

        waitForElement(listElement.get(0));
        Random rand = new Random();
        int position = rand.nextInt(listElement.size());
        WebElement elementRandom = listElement.get(position);
        textElement = getText(elementRandom);
        click(elementRandom);

        return textElement;
    }

    protected String clickElementList(List<WebElement> listElement, String textElement){
        waitForElement(listElement.get(0));

        for (WebElement element : listElement) {
            if(element.getText().equals(textElement)){
                textElement = element.getText();
                click(element);
                break;
            }
        }
        return textElement;
    }

    protected String returnTextFirstElementList(List<WebElement> listElement, String textNotContains){
        waitForElement(listElement.get(0));
        String textElement = "";

        for (WebElement element : listElement) {
            if(!element.getText().contains(textNotContains)){
                textElement = element.getText();
                break;
            }
        }
        return textElement;
    }

    protected void scrollToText(String texto){
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+texto+"\"))"));
        element.isDisplayed();
    }

    //Android
    protected void scrollToContainsText(String text){
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\""+text+"\"))"));
        element.isDisplayed();
    }

    //Android
    protected void scrollToHorizontalContainsText(String text){
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView(new UiSelector().textContains(\""+text+"\"))"));
        element.isDisplayed();
    }

    protected void scrollToTextView(String text){
        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollIntoView(new UiSelector().className(\"android.view.View\"),\""+text+"\")"));
        element.isDisplayed();
    }

    protected void scrollToTextMatches(String element){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + element + "\").instance(0))"));
    }

    protected WebElement scrollToElementDescription(String toElementDescription) {
        return driver.findElement(AppiumBy.androidDataMatcher("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(" + toElementDescription + "));"));
    }

    protected void scrollForwardOneView(){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
    }

    protected void scrollSwipeForward(){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).flingForward()"));
    }

    protected void scrollBackwardOneView(){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
    }

    protected void scrollSwipeBackward(){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).flingBackward()"));
    }

    protected void scrollToEnd(){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
    }

    protected void scrollSwipeToEnd(){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"));
    }

    protected void scrollToBegin(){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(10)"));
    }

    protected void scrollSwipeToBegin(){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).flingToBeginning(10)"));
    }

    //end region List Mobile Elements Methods

    //region By Locator Methods
    //############################## Região By Locator Metodos ##########################################

    protected int returnCountMobileElements(By locator){
        waitForElement(locator);
        List<WebElement> mobileElementList = (List<WebElement>) driver.findElements(locator);
        return mobileElementList.size();
    }

    protected WebElement waitForElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected String[] returnTextListMobileElements(By locator){
        int i = 0;
        waitForElement(locator);
        List<WebElement> mobileElementList = (List<WebElement>) driver.findElements(locator);
        String[] allText = new String[mobileElementList.size()];

        for (WebElement element : mobileElementList) {
            allText[i++] = element.getText();
        }

        return allText;
    }

    protected String clickFirstElementList(By locator){
        waitForElement(locator);
        WebElement mobileElement = (WebElement) driver.findElements(locator).get(0);
        click(mobileElement);
        return mobileElement.getText();
    }

    protected String clickFirstElementList(By locator, String textNotContains){
        waitForElement(locator);
        String textElement = "";

        List<WebElement> mobileElementList = (List<WebElement>) driver.findElements(locator);
        for (WebElement element : mobileElementList) {
            if(!element.getText().contains(textNotContains)){
                textElement = element.getText();
                click(element);
                break;
            }
        }
        return textElement;
    }

    protected String getText(By locator){
        String text = waitForElement(locator).getText();
        return text;
    }

    protected WebElement webElementDispositivoFactory(String tipo){
        WebElement element = driver.findElement(xpath("//*[contains(@text,'"+tipo+"')]//self::android.widget.Button"));
        return element;
    }

    protected WebElement webElementDispositivoCadastradoFactory(){
        WebElement element = driver.findElement(xpath("//*[contains(@text,'"+
                Serenity.sessionVariableCalled("modelo")+" "+
                Serenity.sessionVariableCalled("sistemaOperacional")+
                "')]//self::android.widget.TextView"));
        return element;
    }

    protected WebElement webElementProjetosDisponiveisFactory(String projeto){
        WebElement element = driver.findElement(xpath("//android.view.View[@text='"+projeto+"']"));
        return element;
    }

    protected boolean returnIfElementExists(By element){
        boolean result = false;
        try
        {
            waitForElement(element);
            result = true;
        }
        catch (Exception e)
        {

        }
        return result;
    }

    protected void closeKeyBoardIOS(WebElement element){
        element.sendKeys("\n");
    }

    protected void sendKeysWorkAroundIOS(String texto){

        String base = "//XCUIElementTypeKey[@name='###']";
        By listButton = By.xpath("//XCUIElementTypeKey[@name]");
        ArrayList<Character> arrayList = new ArrayList<>();

        if (texto != null) {
            for (char c : texto.toCharArray()) {
                arrayList.add(c);
            }
        }

        for(Character element: arrayList){
            String novo = base.replace("###",element.toString().toLowerCase());
            if(element.equals(' ')){
                List<WebElement> keyList = driver.findElements(listButton);
                for(WebElement keybutton: keyList){
                    if(keybutton.getText().contains("sp")){
                        keybutton.click();
                    }
                }
            }else{
                driver.findElement(By.xpath(novo)).click();
            }

        }
    }

    public void sendKeysJScript(By element, String value){
        WebElement elemento = driver.findElement(element);
        javascriptExecutor.executeScript("arguments[0].value=arguments[1]", elemento, value);
    }

    public void scrollDownIOS(){
        javascriptExecutor.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));
    }

}
