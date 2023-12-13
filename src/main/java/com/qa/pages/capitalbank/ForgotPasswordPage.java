package com.qa.pages.capitalbank;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ForgotPasswordPage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Forget Username/Password']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Please enter 16 digit debit card number\"]")
    protected WebElement debitCardField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Forget Username/Password']/following-sibling::android.widget.EditText[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Please enter the same 4 digit PIN you've used for atm.\"]")
    protected WebElement cardPIN;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Verify Mobile']/following-sibling::android.view.View[4]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Verify Mobile']/following-sibling::android.view.View[4]")
    protected WebElement codeField;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'Resend Code')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Resend Code')]")
    protected WebElement resendCodeText;
    @AndroidFindBy(xpath = "//android.view.View[@text='2221222, Enter your username']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='2221222, Enter your username']")
    protected WebElement usernameText;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='You’re all set,ready to go!']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='You’re all set,ready to go!']")
    protected WebElement successMessage;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Username']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Username']")
    protected WebElement usernameField;

    @Override
    protected void waitForAppToLoad() {

    }

    public void enterDebitCardNumber(String DebitCard) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }

        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Forget Username/Password']/following-sibling::android.widget.EditText[1]", 90);
        else
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Forget Username/Password']", 90);
        click(debitCardField);
        clickAndSendKeys(debitCardField, DebitCard, "Debit card Number is entered as " + DebitCard);
    }

    public void enterPin(String PIN) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            parentAttribute2 = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Forget Username/Password']/following-sibling::" + parentAttribute2 + "[2]", 90);
        else
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Forget Username/Password']", 90);
        clickAndSendKeys(cardPIN, PIN, " entering PIN as " + PIN);
    }

    public void enterCode(String code) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Verify Mobile']/following-sibling::" + parentAttribute + "[4]", 90);
        click(codeField);
        clickAndSendKeys(codeField, code, "Linked MobileNumber entered as " + code);
    }

    public void enteringCode(String code) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'verification code')]", 10);
        Point point = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "='Verify Mobile']/following-sibling::" + parentAttribute + "[4]")).getLocation();
        tapOnPosition(point.x, point.y);
        new Actions(getDriver())
                .sendKeys(code)
                .perform();
    }

    public String fetchPageContains(String message) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", '" + message + "')]", 60);
        return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "= '" + message + "']"), attribute);
    }

    public boolean isResendCodeDisplayed() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Resend Code')]", 90);
        return resendCodeText.isDisplayed();
    }

    public String fetchSuccessMessage(String message) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='" + message + "']", 90);
        return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "= '" + message + "']"), attribute);
    }

    public boolean fetchUsername(String username) {
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@text, '" + username + "')]", 90);
        return usernameText.isDisplayed();
    }

    public void enterPassword(String value) {
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.EditText";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeTextField";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@text, 'Enter new password')]", 90);
        clickAndSendKeys(By.xpath("//" + parentAttribute + "[contains(@text, 'Enter new password')]"), value, "password has set to " + value);
        new Actions(getDriver()).sendKeys(Keys.ENTER).perform();
    }

    public void reenterPassword(String value) {
        if (getDriver() instanceof AndroidDriver)
            clickAndSendKeys(By.xpath("(//android.widget.EditText[@text='Re-Enter your password'])"),
                    value, "Re-Enter password has set to " + value);
        else
            clickAndSendKeys(By.xpath("(//XCUIElementTypeTextField[@name='Re-Enter your password'])"),
                    value, "Re-Enter password has set to " + value);
    }

    public String passwordHintMessage(String message) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='" + message + "']", 60);
        return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "= '" + message + "']"), attribute);
    }

    public boolean successMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='You’re all set,ready to go!']", 90);
        return successMessage.isDisplayed();
    }

    public void backToLoginButton() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Back to Login']", 60);
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='Back to Login']"), "Clicking on Back to Login button");
    }

    public boolean loginPage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Username']", 90);
        return usernameField.isDisplayed();
    }

    public void clickOnEnter() {
        new Actions(getDriver()).sendKeys(Keys.ENTER).perform();
    }
}