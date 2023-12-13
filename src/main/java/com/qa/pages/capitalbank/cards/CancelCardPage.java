package com.qa.pages.capitalbank.cards;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.qa.engine.ProjectBase.logInfo;

public class CancelCardPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Cancel')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Cancel')]")
    protected WebElement clickCancelCard;

    @AndroidFindBy(accessibility = "Confirm")
    @iOSXCUITFindBy(accessibility = "Confirm")
    protected WebElement clickConfirmButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'cancel')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'cancel')]")
    protected WebElement fetchCancelMessage;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'successfully')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'successfully')]")
    protected WebElement fetchSuccessMessage;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'BALANCE')]//following-sibling::android.widget.ImageView[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'BALANCE')]//following-sibling::android.widget.ImageView[3]")
    protected WebElement clickForwardArrow;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Balance')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Balance')]")
    protected WebElement cardDetails;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'BALANCE')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'BALANCE')]")
    protected WebElement currentAccount;

    @Override
    public void waitForAppToLoad() {
    }

    public void clickOnCancelCardButton() {
        click(clickCancelCard, "Clicking on cancelCard");
    }

    public void clickOnForwardArrow() {
        click(clickForwardArrow, "click on forward arrow");
    }

    public void clickOnConfirmButton() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Confirm']", 60);
        click(clickConfirmButton, "Clicking on confirmButton");
    }

    public String clickCardToTransferBalance(String account) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }

        By type = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'" + account + "')]");
        scrollUntilElementPresent(type, "up", 0.30);

        String value = getAttribute(type, attribute);

        if (value.contains(account))
            click(type, "Clicking " + account + " card");
        else {
            logInfo("Account is not found for this Customer");
            throw new RuntimeException();
        }
        return value;
    }

    public String successfulMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'successfully')]", 60);
        return getTextWithAttribute(fetchSuccessMessage, attribute);
    }

    public CancelCardPage swipeToCancelCard() throws InterruptedException {
        logInfo("swiping to Cancel card  Card menu");
        Thread.sleep(500);
        scroll("up", 0.2);
        Thread.sleep(500);
        scroll("left", 0.6);
        return this;
    }

    public void clickOnSelectedCard() {
        click(currentAccount, "Clicking on card");
    }

    public String fetchCancelMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Confirm']", 60);
        return getTextWithAttribute(fetchCancelMessage, attribute);
    }

    public CancelCardPage selectCard(String number) throws InterruptedException {
        int count = 0;
        while (count < 5) {
            String cardValue = new CardPage().fetchDetails();
            if (cardValue.contains(number)) {
                new CancelCardPage().clickOnSelectedCard();
                break;
            } else {
                new CancelCardPage().clickOnForwardArrow();
            }
            count++;
        }
        return this;
    }

    public CancelCardPage clickOnCard(String cardName) throws InterruptedException {
        int count = 0;
        while (count < 5) {
            String cardValue = new CardPage().fetchVirtualCardDetails();
            logInfo("The card type is " + cardValue);
            if (cardValue.contains(cardName)) {
                new CancelCardPage().swipeToCancelCard();
                break;
            } else {
                new CancelCardPage().clickOnForwardArrow();
            }
            count++;
        }
        return this;
    }
}