package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class CreateYourProfilePage extends BasePage {
    @AndroidFindBy(accessibility = "Register via Email")
    @iOSXCUITFindBy(accessibility = "Register via Email")
    protected WebElement registerViaEmail;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='EMAIL ADDRESS￼']/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name-desc='EMAIL ADDRESS￼']/XCUIElementTypeTextField")
    protected WebElement emailAddress;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='MOBILE NUMBER￼']/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='MOBILE NUMBER￼']/XCUIElementTypeTextField")
    protected WebElement mobileNumber;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='CREATE PASSWORD￼']/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='CREATE PASSWORD￼']/XCUIElementTypeTextField")
    protected WebElement createPassword;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='CONFIRM PASSWORD￼']/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='CONFIRM PASSWORD￼']/XCUIElementTypeTextField")
    protected WebElement confirmPassword;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Open an Account\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Open an Account\"]")
    protected WebElement openAnAccount;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Open Your Account Now\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Open Your Account Now\"]")
    protected WebElement openYourAccountNow;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Maybe later\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Maybe later\"]")
    protected WebElement mayBeLater;


    @Override
    protected void waitForAppToLoad() {
    }

    public void registerViaEmail() {
        waitForVisibility(registerViaEmail);
        click(registerViaEmail, "Clicking Register via email");
    }

    public CreateYourProfilePage setEmailAddress(String emailAddress) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Enter your email')]", 90);
        clickAndSendKeys(this.emailAddress, emailAddress, "Email address is set to " + emailAddress);
        return this;
    }

    public void setMobileNumber(String mobileNumber) throws InterruptedException {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Enter your email')]", 60);
        Thread.sleep(1000);
        clickAndSendKeys(this.mobileNumber, mobileNumber, "Mobile Number is set to " + mobileNumber);
    }

    public CreateYourProfilePage setPassword(String password) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'your password')]", 30);
        clickAndSendKeys(createPassword, password, "Password set to " + password);
        return this;
    }

    public void setConfirmPassword(String password) {
        clickAndSendKeys(confirmPassword, password, "Confirm Password set to " + password);
    }

    public void openAnAccount() {
        click(openAnAccount, "Clicking open an account button");
    }

    public void openYourAccountNow() {
        click(openYourAccountNow, "Clicking open your account now button");
    }

    public void mayBeLater() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Maybe later\"]", 30);
        click(mayBeLater, "Clicking may be later button");
    }
}
