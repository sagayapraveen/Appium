package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.qa.engine.ProjectBase.logInfo;

public class LetsSetYourPin extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Your card is ready!']/following-sibling::android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Your card is ready!']/following-sibling::XCUIElementTypeOther")
    protected WebElement successMessage;

    @Override
    protected void waitForAppToLoad() {
        utils.waitForElement(getDriver(), "Let’s set your 4-digit PIN", 90);
    }

    public LetsSetYourPin setYourPin(String pin) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'PIN')]", 60);
        tapOnPosition(210, 730);
        new Actions(getDriver()).sendKeys(pin).perform();
        logInfo("Pin '" + pin + "' has been inputted");
        return this;
    }

    public String getSuccessMessage() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Your card is ready!']", 60);
        return getTextWithAttribute(successMessage, attribute);
    }
}
