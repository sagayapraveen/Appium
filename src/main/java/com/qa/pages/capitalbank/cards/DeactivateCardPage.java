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

public class DeactivateCardPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Limits')]/following-sibling::android.widget.Switch")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Limits')]/following-sibling::XCUIElementTypeSwitch")
    protected WebElement clickDeactivateCard;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Confirm']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Confirm']")
    protected WebElement confirmButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Details')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Details')]")
    protected WebElement cardDetails;

    @Override
    public void waitForAppToLoad() {
    }

    public void swipeToDeactivateCard() throws InterruptedException {
        waitForVisibility(cardDetails);
        logInfo("swiping to deactivate card menu");
        Thread.sleep(500);
        scroll("up", 0.2);
        Thread.sleep(500);
        scroll("left", 0.6);

    }

    public DeactivateCardPage clickOnDeactivateCardToggle() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='CARD DETAILS']", 60);
        click(clickDeactivateCard, "Clicking on deactivate card toggle");
        return this;
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
        click(confirmButton, "Clicking on confirm button ");
    }

    public void clickOnActivateToggle() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='CARD DETAILS']", 60);
        logInfo("selecting activate card toggle");

        Point point1 = getDriver().findElement(By.xpath("//" + parentAttribute2 + "[contains(@" + attribute + ", 'Card')" +
                " and contains(@content-desc,'Limits')]")).getLocation();

        tapOnPosition(point1.x + 300, point1.y + 70);
    }

    public boolean isDeactivateToggleClickable() {
        return Boolean.parseBoolean(getAttribute(clickDeactivateCard, "clickable"));
    }

    public void selectCard(String cardName) {
        int count = 0;
        while (count < 5) {
            String cardValue = new CardPage().fetchDetails();
            logInfo("The card type is " + cardValue);
            if (cardValue.contains(cardName)) {
                new CardPage().clickOnCard();
                break;
            } else {
                new CardPage().clickOnCardForward();
            }
            count++;
        }
    }
}

