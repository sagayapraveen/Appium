package com.qa.pages.capitalbank;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.qa.engine.ProjectBase.logInfo;

public class LauncherPage extends BasePage {

    @AndroidFindBy(accessibility = "Login")
    @iOSXCUITFindBy(accessibility = "Login")
    protected WebElement loginButton;
    @AndroidFindBy(accessibility = "Register")
    @iOSXCUITFindBy(accessibility = "Register")
    protected WebElement register;
    @AndroidFindBy(accessibility = "Verify Your Card")
    @iOSXCUITFindBy(accessibility = "Verify Your Card")
    protected WebElement verifyYourCard;
    @AndroidFindBy(accessibility = "Forget Username/Password")
    @iOSXCUITFindBy(accessibility = "Forget Username/Password")
    protected WebElement forgetUsernamePassword;

    public LauncherPage() {
        waitForAppToLoad();
    }

    public LauncherPage clickLogin() {
        waitForVisibility(loginButton, 60, "Error while launching the app");
        click(loginButton, "Clicking Login button");
        return this;
    }

    public void waitForAppToLoad() {
    }

    public void register() {
        click(register, "Clicking register");
    }

    public void waitForVerifyCard() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";


        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            parentAttribute2 = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            parentAttribute2 = "XCUIElementTypeOther";
            attribute = "name";
        }

        waitForVisibility(verifyYourCard);
        logInfo("Verify your card page is displayed");
        if (getDriver() instanceof AndroidDriver)
            click(By.xpath("//" + parentAttribute2 + "[@" + attribute + "=\"Verify Your Card\"]/ancestor::" + parentAttribute2 + "[1]/" + parentAttribute));
        else
            click(By.xpath("//XCUIElementTypeStaticText[@name=\"Verify Your Card\"]/preceding::XCUIElementTypeButton[1]"));
    }

    public void forgotLogin() {
        click(forgetUsernamePassword, "Clicking forgot username password");
    }

    public void waitForForgotLoginPage() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            parentAttribute2 = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            parentAttribute2 = "XCUIElementTypeStaticText";
            attribute = "name";
        }

        waitForVisibility(By.xpath("//" + parentAttribute2 + "[@" + attribute + "='Please complete the following details to reset your password']"));
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='Close']"));

        logInfo("Forget Username password page is displayed");
    }

    public LauncherPage clickCloseButton() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            parentAttribute2 = "XCUIElementTypeButton";
            attribute = "name";
        }
        if (getDriver().findElements(By.xpath("//" + parentAttribute + "[@" + attribute + "='Please enter a 6-digit PIN for the app.']"))
                .size() > 0) {
            getDriver().findElement(By.xpath("//" + parentAttribute2 + "[@" + attribute + "='Close']")).click();
        }
        waitForVisibility(loginButton, 60, "Error while launching the app");
        click(loginButton, "Clicking Login button");
        return this;
    }
}