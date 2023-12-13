package com.qa.pages.capitalbank.overdraft;

import com.qa.pages.BasePage;
import com.qa.pages.capitalbank.transfers.TransferPayeePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Instant;


public class OverdraftTransferPage extends BasePage {
    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'BALANCE')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'BALANCE')]")
    protected WebElement account;

    @AndroidFindBy(accessibility = "Own Account")
    @iOSXCUITFindBy(accessibility = "Own Account")
    protected WebElement ownAccount;

    @AndroidFindBy(accessibility = "TRANSACTIONS")
    @iOSXCUITFindBy(accessibility = "TRANSACTIONS")
    protected WebElement transactions;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'BALANCE')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'BALANCE')]")
    protected WebElement overDraftAccount;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Description')]/following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Description')]/following-sibling::XCUIElementTypeTextField")
    protected WebElement description;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Transfer successful!\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"successful!\")]")
    protected WebElement successMessage;

    @AndroidFindBy(accessibility = "Confirm")
    @iOSXCUITFindBy(accessibility = "Confirm")
    protected WebElement confirm;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Pay to\"]/following-sibling::android.widget.ImageView[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Search\"]")
    protected WebElement searchButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Recipient Name\"]/following-sibling::android.widget.EditText/android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Enter recipient name\"]/following-sibling::XCUIElementTypeOther")
    protected WebElement alertMessage;

    @Override
    protected void waitForAppToLoad() {
    }

    public String fetchDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        if (getDriver() instanceof AndroidDriver)
            waitForVisibility(overDraftAccount);
        else
            utils.waitForElement(getDriver(), "//*[contains(@name, 'BALANCE')]", 30);
        return getAttribute(overDraftAccount, attribute);
    }

    public String fetchCardDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(overDraftAccount);
        return getAttribute(account, attribute);
    }

    public void clickOwnAccount() {
        click(ownAccount, "Clicking on Own Account");
    }

    public void descriptionName(String name) {
        clickAndSendKeys(description, name, "Description entered as " + name);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[contains(@name,\"D\")]")).click();
    }

    public void selectPayToAccount(String currency, String account) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        String type = "//" + parentAttribute + "[contains(@" + attribute + ",'"
                + account.toUpperCase() + "') and contains(@" + attribute + ",'" + currency + "')]";

        scrollUntilElementPresent(By.xpath(type), "up", 0.50);

        click(By.xpath(type), "Clicking " + account + " card");
    }

    public void selectCard(String countryName) {
        Instant timeout = Instant.now().plusSeconds(45);
        String cardValue = new OverdraftTransferPage().fetchDetails();

        while (!cardValue.contains(countryName)) {
            new TransferPayeePage().clickOnForwardArrow();

            cardValue = new OverdraftTransferPage().fetchDetails();
            if (cardValue.contains(countryName))
                break;

            if (Instant.now().isAfter(timeout)) {
                break;
            }
        }
    }

    public String fetchSuccessMessage() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getTextWithAttribute(successMessage, attribute);
    }

    public void confirmTransfer() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Confirm Transfer']", 90);
        click(confirm, "Clicking confirm");
    }

    public void clickNewBeneficiary() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='New Beneficiary']"), "Clicking New beneficiary");
    }

    public void clickAndEnterBeneficiary(String Name) {
        waitForVisibility(searchButton);
        clickAndSendKeys(searchButton, Name, "Beneficiary selected as as " + Name);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[contains(@name,\"S\") or contains(@name,\"Search\")]")).click();
    }

    public OverdraftTransferPage selectBeneficiary(String name) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
            scrollUntilElementPresent(By.xpath("//" + parentAttribute + "[@" + attribute + "='Pay to']/following-sibling::" + parentAttribute), "down", 0.5);
            click(By.xpath("//" + parentAttribute + "[@" + attribute + "='Pay to']/following-sibling::" + parentAttribute), "Clicking on the beneficiary from the list");
        } else if (getDriver() instanceof IOSDriver) {
            scrollUntilElementPresent(By.xpath("//XCUIElementTypeStaticText[contains(@name,\"AUTOMATION\") or contains(@name,'" + name.substring(4) + "') or contains(@name,'" + name + "')]"), "down", 0.5);
            click(By.xpath("//XCUIElementTypeStaticText[contains(@name,\"AUTOMATION\") or contains(@name,'" + name.substring(4) + "') or contains(@name,'" + name + "')]"), "Clicking on the beneficiary from the list");
        }
        return this;
    }

    public void clickOnAmountTextField() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        By xpath = By.xpath("//*[@" + attribute + "=\"Amount\"]/following-sibling::" + parentAttribute);
        utils.waitForElement(getDriver(), xpath, 30);
        tapOnPosition(getDriver().findElement(xpath).getLocation().x + 100, getDriver().findElement(xpath).getLocation().y + 10);
    }

    public String fetchAlertMessage() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(alertMessage);
        return getAttribute(alertMessage, attribute);
    }

    public void clickOnChargeOptions(String option) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + option + "']"), "Clicking charge options as " + option);
    }
}