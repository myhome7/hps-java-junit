package com.coffeemachine;

import com.saucelabs.saucerest.SauceREST;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Actionwords {

    private RemoteWebDriver driver;
    private String platform = System.getProperty("platform", "OS X 10.11");
    private String browser = System.getProperty("browser", "chrome");
    private String browserVersion = System.getProperty("browserVersion", "71");
    private String testName = "Hiptest Test";
    private static final String sauceUser = System.getenv("SAUCE_USERNAME");
    private static final String sauceKey = System.getenv("SAUCE_ACCESS_KEY");
    private SauceREST sauceClient;



    public void iStartTheCoffeeMachineUsingLanguageLang(String lang) {
        // TODO: Implement action: String.format("Start the coffee machine using language %s", lang)
        // throw new UnsupportedOperationException();
    }

    public void iShutdownTheCoffeeMachine() {
        // TODO: Implement action: "Shutdown coffee machine"
        // throw new UnsupportedOperationException();
    }

    public void messageMessageShouldBeDisplayed(String message) {
        // TODO: Implement result: String.format("Displayed message is \"%s\"", message)
        // throw new UnsupportedOperationException();
    }

    public void coffeeShouldBeServed() {
        // TODO: Implement result: "Coffee is served :)"
        // throw new UnsupportedOperationException();
    }

    public void coffeeShouldNotBeServed() {
        // TODO: Implement result: "No coffee is served :("
        // throw new UnsupportedOperationException();
    }

    public void iTakeACoffee() {
        // TODO: Implement action: "Take a coffee"
        // throw new UnsupportedOperationException();
    }

    public void iEmptyTheCoffeeGrounds() {
        // TODO: Implement action: "Empty coffee grounds"
        // throw new UnsupportedOperationException();
    }

    public void iFillTheBeansTank() {
        // TODO: Implement action: "Fill beans"
        // throw new UnsupportedOperationException();
    }

    public void iFillTheWaterTank() {
        // TODO: Implement action: "Fill water tank"
        // throw new UnsupportedOperationException();
    }

    public void iTakeCoffeeNumberCoffees(int coffeeNumber) {

    }

    public void theCoffeeMachineIsStarted() {
        iStartTheCoffeeMachineUsingLanguageLang("en");
    }

    public void iHandleEverythingExceptTheWaterTank() {
        iHandleCoffeeGrounds();
        iHandleBeans();
    }

    public void iHandleWaterTank() {

    }

    public void iHandleBeans() {

    }

    public void iHandleCoffeeGrounds() {

    }

    public void iHandleEverythingExceptTheBeans() {
        iHandleWaterTank();
        iHandleCoffeeGrounds();
    }

    public void iHandleEverythingExceptTheGrounds() {
        iHandleWaterTank();
        iHandleBeans();
    }

    public void displayedMessageIs(String freeText) {
        messageMessageShouldBeDisplayed(freeText);
    }

    public void iSwitchToSettingsMode() {

    }

    public void settingsShouldBe(String datatable) {

    }

    public void iLookInStrawContainer() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("version", browserVersion);
        capabilities.setCapability("platform", platform);
        capabilities.setCapability("name", testName);

        String sauceUrl = String.format("http://%s:%s@ondemand.saucelabs.com:80/wd/hub",
                sauceUser, sauceKey);

        try {
            driver = new RemoteWebDriver(new URL(sauceUrl), capabilities);
        } catch(MalformedURLException e) {
            System.out.println("ERROR: " + e);
        }

        driver.setFileDetector(new LocalFileDetector());

        // String sessionId = (driver).getSessionId().toString();
        sauceClient = new SauceREST(sauceUser, sauceKey);

        driver.get("https://dev.conversations.dealerinspire.com/login");
        WebElement webElement = driver.findElement(By.cssSelector("input[name=username]"));
        webElement.sendKeys("TestUser");
        Assert.assertTrue("did not find button", driver.findElement(By.cssSelector("button")).isDisplayed());
        driver.quit();
    }

    public void iFindStrawNumberStraws(String strawNumber) {
        System.out.println("I found " + strawNumber + "straws");
    }

    public void iShouldSeeStrawErrorMessage() {
        System.out.println("I'm looking for an error message");
    }
}