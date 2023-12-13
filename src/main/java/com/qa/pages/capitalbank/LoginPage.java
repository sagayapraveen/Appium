package com.qa.pages.capitalbank;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Username']/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Enter your username']")
    protected WebElement username;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Password']/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Password\"]")
    protected WebElement password;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"Password\"]")
    protected WebElement securePassword;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Login']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Login']")
    protected WebElement loginButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
    protected WebElement done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Next:\"]")
    protected WebElement next;

    public LoginPage() {
        waitForAppToLoad();
    }

    public LoginPage userName(String username) {
        if (getDriver() instanceof IOSDriver)
            tapOnPosition(this.username.getLocation().x, this.username.getLocation().y);
        clickAndSendKeys(this.username, username, "User name inputted as " + username);

        if (getDriver() instanceof IOSDriver)
        tapOnPosition(20, 100);

        return this;
    }

    public LoginPage password(String password) {
        if (getDriver() instanceof IOSDriver) {
            tapOnPosition(this.password.getLocation().x, this.password.getLocation().y);
            clickAndSendKeys(this.securePassword, password, "Entering password");
        } else
            clickAndSendKeys(this.password, password, "Entering password");

        if (getDriver() instanceof IOSDriver)
            done.click();
        return this;
    }

    public LoginPage login() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (getDriver() instanceof IOSDriver)
            tapOnPosition(loginButton.getLocation().x, loginButton.getLocation().y);
        else
            click(loginButton, "Clicking login button");
        return this;
    }

    @Override
    public void waitForAppToLoad() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Login']", 90);
    }
}
