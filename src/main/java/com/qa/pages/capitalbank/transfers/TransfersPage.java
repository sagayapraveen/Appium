package com.qa.pages.capitalbank.transfers;

import com.qa.pages.BasePage;
import com.qa.pages.capitalbank.dashBoard.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.qa.engine.ProjectBase.logInfo;

public class TransfersPage extends BasePage {
    @AndroidFindBy(accessibility = "New Beneficiary")
    @iOSXCUITFindBy(accessibility = "New Beneficiary")
    protected WebElement newBeneficiary;

    @AndroidFindBy(accessibility = "Confirm")
    @iOSXCUITFindBy(accessibility = "Confirm")
    protected WebElement confirm;

    @AndroidFindBy(accessibility = "Cards")
    @iOSXCUITFindBy(accessibility = "Cards")
    protected WebElement cards;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[last()]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[last()]")
    protected WebElement existingBeneficiary;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Select Bank Country']/android.widget.ImageView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Select Bank Country\"]//following-sibling::XCUIElementTypeTextField")
    protected WebElement searchButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Select Bank Country']/android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Select Bank Country\"]//following-sibling::XCUIElementTypeImage")
    protected WebElement clickCountry;

    @Override
    protected void waitForAppToLoad() {
    }

    public TransfersPage clickNewBeneficiary() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='New Beneficiary']", 90);
        click(newBeneficiary, "Clicking New beneficiary");
        return this;
    }

    public TransfersPage setIban(String ibanNumber) {
        logInfo("Setting the IBAN number as " + ibanNumber);
        if (getDriver() instanceof IOSDriver) {
            new HomePage().tapOnPosition(65, 456);

            new Actions(getDriver())
                    .sendKeys(ibanNumber)
                    .perform();
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
        } else {
            new Actions(getDriver()).sendKeys(Keys.TAB)
                    .sendKeys(ibanNumber)
                    .sendKeys(Keys.ENTER)
                    .perform();
        }
        return this;
    }

    public TransfersPage searchForCountry(String name) {
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
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Select Bank Country']/" + parentAttribute2 + "[1]", 90);
        else
            utils.waitForElement(getDriver(), "//XCUIElementTypeOther[@name=\"Select Bank Country\"]//following-sibling::XCUIElementTypeImage[1]", 90);
        clickAndSendKeys(searchButton, name, "Country name entered as " + name);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Search\"]")).click();
        return this;
    }

    public void clickConfirm() {
        click(confirm, "Confirming the IBAN entered");
    }

    public void clickCards() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Pay From']", 30);
        click(cards, "Clicking Cards tab");
    }

    public void clickCountry() {
        click(clickCountry, "Select the country selected");
    }

    public void existingBeneficiary() {
        click(existingBeneficiary, "Selecting the existing beneficiary for transfer");
    }
}

