package com.qa.pages.capitalbank.cards;


import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import static com.qa.engine.ProjectBase.logInfo;

public class AddNewCard extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Add')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Add')]")
    protected WebElement clickAddNewCard;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Cardholder Name']/following-sibling::android.widget.EditText[@text='Please Enter'])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cardholder Name\"]//following-sibling::XCUIElementTypeTextField")
    protected WebElement cardHolderName;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Linked Mobile Number']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Linked Mobile Number\"]//following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField")
    protected WebElement mobileNumber;

    @AndroidFindBy(accessibility = "Next")
    @iOSXCUITFindBy(accessibility = "Next")
    protected WebElement clickNextButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'New')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'New')]")
    protected WebElement confirmationMessage;

    @AndroidFindBy(accessibility = "Confirm")
    @iOSXCUITFindBy(accessibility = "Confirm")
    protected WebElement clickConfirmButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Top up Card']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Top up Card']")
    protected WebElement clickOnTopUPCardButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Cardholder Name']//..//android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cardholder Name\"]")
    protected WebElement cardHolder;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Cardholder Name']//..//android.view.View[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cardholder Name\"]//following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement cardHolderValue;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Cardholder Name']//..//android.view.View[4]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Card Number\"]")
    protected WebElement cardNumber;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Cardholder Name']//..//android.view.View[5]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Card Number\"]//following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement cardNumberValue;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Cardholder Name']//..//android.view.View[6]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Issuance Date\"]")
    protected WebElement IssuanceDate;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Cardholder Name']//..//android.view.View[7]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Issuance Date\"]//following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement IssuanceDateValue;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Cardholder Name']//..//android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Your New Card is ready!\"]")
    protected WebElement successMessage;

    @AndroidFindBy(accessibility = "Withdraw")
    @iOSXCUITFindBy(accessibility = "Withdraw")
    protected WebElement withdrawButton;

    @Override
    public void waitForAppToLoad() {
    }

    public AddNewCard clickOnAddNewCard() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Add')]", 60);
        click(clickAddNewCard, "Clicking on Add New Card button");
        return this;
    }

    public AddNewCard enterCardHolderName(String name) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            parentAttribute2 = "XCUIElementTypeTextField";
            attribute = "name";
        }
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "(//" + parentAttribute + "[@" + attribute + "='Cardholder Name']/following-sibling::" + parentAttribute2 + "[@text='Please Enter'])[1]", 90);
        else
            utils.waitForElement(getDriver(), "//XCUIElementTypeStaticText[@name=\"Cardholder Name\"]//following-sibling::XCUIElementTypeTextField", 90);
        clickAndSendKeys(cardHolderName, name, "CardHolder name entered as " + name);
        return this;
    }

    public AddNewCard enterMobileNumber(String number) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            parentAttribute2 = "XCUIElementTypeTextField";
            attribute = "name";
        }
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Linked Mobile Number']/following-sibling::" + parentAttribute2 + "[1]", 90);
        else {
            utils.waitForElement(getDriver(), "//XCUIElementTypeStaticText[@name=\"Linked Mobile Number\"]//following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField", 90);
            click(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]"));
        }

        clickAndSendKeys(mobileNumber, number, "Linked MobileNumber entered as " + number);
        return this;
    }

    public AddNewCard clickOnNextButton() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Next']", 60);
        click(clickNextButton, "Clicking on next Button");
        return this;
    }

    public void clickTopUpCard() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Top up Card']", 60);
        click(clickOnTopUPCardButton, "Clicking on Top up card");
    }

    public AddNewCard swipeToAddToCard() throws InterruptedException {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Cards\"]", 60);
        logInfo("Swiping to Add New Card menu");
        Thread.sleep(500);
        scroll("up", 0.2);
        waitForVisibility(withdrawButton);
        Point point = withdrawButton.getLocation();
        scrollWithCoordinates("left", 0.70, point.x, point.y + 100);
        waitForVisibility(clickAddNewCard);
        return this;
    }

    public String fetchConfirmationDetails() {
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
        return getTextWithAttribute(confirmationMessage, attribute);
    }

    public boolean isAmountClickable() {
        return Boolean.parseBoolean(getTextWithAttribute(clickAddNewCard, "checkable"));
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
        click(clickConfirmButton, "Clicking on confirm Button");
    }

    public StringBuilder fetchSuccessMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Your New Card is ready!']", 90);
        StringBuilder message = new StringBuilder();
        message.append(cardHolder.getAttribute(attribute))
                .append("-").append(cardHolderValue.getAttribute(attribute)).append("\n")
                .append(cardNumber.getAttribute(attribute)).append("-")
                .append(cardNumberValue.getAttribute(attribute)).append("\n")
                .append(IssuanceDate.getAttribute(attribute)).append("-").
                append(IssuanceDateValue.getAttribute(attribute)).append("\n").
                append(successMessage.getAttribute(attribute)).append("\n");
        logInfo(message.toString());
        return message;
    }

    public int countOfCard() {
        String cardName = new CardPage().fetchVirtualCardDetails();
        String newCardName = "";
        int count = 0;
        while (!(newCardName.equals(cardName))) {
            newCardName = cardName;
            new CardPage().clickOnCardForwardArrow();
            cardName = new CardPage().fetchVirtualCardDetails();
            count++;
        }
        return count;
    }

    public boolean isButtonEnabled() {
        return Boolean.parseBoolean(getTextWithAttribute(clickNextButton, "enabled"));
    }

}
