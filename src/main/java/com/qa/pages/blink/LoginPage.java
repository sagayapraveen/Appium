package com.qa.pages.blink;

import com.google.common.collect.ImmutableMap;
import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='EMAIL ADDRESS￼']/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@nam='EMAIL ADDRESS￼']/XCUIElementTypeTextField")
    protected WebElement username;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='PASSWORD￼']/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='PASSWORD￼']/XCUIElementTypeTextField")
    protected WebElement password;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Login\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Login\"]")
    protected WebElement login;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Forgot password?\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Forgot password?\"]")
    protected WebElement forgotPassword;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"PASSWORD￼\"]/android.widget.EditText/android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"PASSWORD￼\"]/XCUIElementTypeTextField/XCUIElementTypeOther")
    protected WebElement eyeIcon;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Open an Account\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Open an Account\"]")
    protected WebElement openAnAccount;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"EMAIL ADDRESS￼\"]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"EMAIL ADDRESS￼\"]/XCUIElementTypeTextField")
    protected WebElement emailAddress;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"NATIONAL ID NUMBER￼\"]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NATIONAL ID NUMBER￼\"]/XCUIElementTypeTextField")
    protected WebElement nationalId;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"SELECT DATE\")]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"SELECT DATE\")]/XCUIElementTypeTextField")
    protected WebElement date;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"OK\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    protected WebElement dateDone;
    By loginWithEmail = By.xpath("//XCUIElementTypeButton[@name=\"Login with Email\" or contains(@name,\"الإلكتروني\")]");

    public LoginPage() {

    }

    public LoginPage loginPage() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.widget.Button";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeButton";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Login\")]", 30);

        click(loginWithEmail, "Clicking Login with Email button");
        return this;
    }

    public void loginClick() {
        click(login, "Clicking login button");
    }

    public LoginPage userName(String username) {
        clickAndSendKeys(this.username, username, "Username " + username + " has been inputted.");
        return this;
    }

    public LoginPage password(String password) {
        clickAndSendKeys(this.password, password);
        return this;
    }

    public LoginPage login() {
        getDriver().executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
        return this;
    }

    @Override
    public void waitForAppToLoad() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.widget.Button";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeButton";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Login\")]", 30);
    }

    public void forgotPassword() {
        click(forgotPassword, "Clicking forgot password");
    }

    public void backToLogin() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Enter below details to reset your password\"]", 30);
        Dimension point = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Back to Login\"]")).getSize();
        tapOnPosition(point.width - 400, point.height + 430);
    }

    public String getLoginPageAttribute() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Enter your login details\"]"), attribute);
    }

    public void eyeIcon() {
        click(eyeIcon, "Clicking eye icon");
    }

    public String eyeValue() {
        String attribute = "";
        String parentAttribute = "";
        String parentAttribute2 = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeTextField";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"PASSWORD￼\"]/" + parentAttribute2), "text");
    }

    public void languageClick(String value) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"ENG\")]", 30);
        Point point = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"ENG\" or @content-desc=\"عربي\"]//" + parentAttribute)).getLocation();
        if (value.equalsIgnoreCase("ENG"))
            tapOnPosition(point.x + 10, point.y + 50);
        else
            tapOnPosition(point.x + 150, point.y + 50);
    }

    public String getLoginButtonAttribute() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }

        return getAttribute(loginWithEmail, attribute).replace("\n", " ");
    }

    public void openAnAccountButton() {
        click(openAnAccount, "Clicking open an account button");
    }

    public String getOpenAnAccountButtonAttribute() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Open Your Account Now\"]"), "displayed");
    }

    public LoginPage forgotPasswordEmail(String value) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"FORGOT PASSWORD?\"]", 30);
        clickAndSendKeys(emailAddress, value);
        return this;
    }

    public LoginPage forgotPasswordNationalId(String value) {
        clickAndSendKeys(nationalId, value);
        return this;
    }

    public void forgotPasswordDate(String value) {
        String attribute = "";
        String parentAttribute = "";
        String parentAttribute2 = "";
        String parentAttribute3 = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ImageView";
            parentAttribute3 = "android.widget.Button";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeImage    ";
            parentAttribute3 = "XCUIElementTypeButton";
        }
        Point point = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"ID EXPIRY DATE￼\"]/" + parentAttribute2)).getLocation();
        tapOnPosition(point.x + 600, point.y + 10);

        click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"SELECT DATE\")]/" + parentAttribute3 + "[1]"));
        date.clear();
        clickAndSendKeys(date, value);
        click(dateDone);
    }

    public String getAttributeNewPasswordPage() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Next\")]", 30);
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"Next\")]"), attribute).replace("\n", " ");
    }
}


