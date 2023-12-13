package com.qa.pages.capitalbank.cards;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.time.Instant;

import static com.qa.engine.ProjectBase.logInfo;

public class CardLimitPage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Purchase')]//following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"E-commerce\")]//following-sibling::XCUIElementTypeTextField")
    protected WebElement enterAmount;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Save']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Save']")
    protected WebElement saveButton;

    @Override
    public void waitForAppToLoad() {
    }

    public void clickAddAmount(String amount) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Card Limits']", 90);
        clear(enterAmount);
        clickAndSendKeys(enterAmount, amount, "Amount entered as " + amount);
    }

    public void clickOnSaveButton() {
        click(saveButton, "Clicking on save button");
    }

    public String getMessage(String message) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + message + "')]"), attribute);
    }

    public String enterNewCardLimit() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Card Limits']", 90);
        clear(enterAmount);
        String amount = utils.getRandomNumber(3);
        clickAndSendKeys(enterAmount, amount, "Amount entered as " + amount);

        if (getDriver() instanceof IOSDriver)
            click(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]"));
        return amount;
    }

    public String getCardLimit() {
        String data = "";
        if (getDriver() instanceof AndroidDriver)
            data = "text";
        else
            data = "value";
        return getAttribute(enterAmount, data);
    }

    public void clickOnEnableButton() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.Switch";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeSwitch";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "= 'Card Limits']", 90);
        Instant timeout = Instant.now().plusSeconds(120);

        int x = 830;
        int y = 300;
        while (getDriver().findElements(By.xpath("//" + parentAttribute2 + "[@" + attribute + "=\"E-commerce Purchase\"]")).size() > 0) {
            tapOnPosition(x, y);
            y = y + 20;
            logInfo(y);

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException("App not loaded after waited for 120 seconds");
        }
    }
}
