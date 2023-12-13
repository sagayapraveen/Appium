package com.qa.pages.capitalbank;

import com.qa.pages.BasePage;
import com.qa.pages.capitalbank.transfers.TransferPayeePage;
import com.qa.pages.capitalbank.transfers.TransfersPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Instant;

import static com.qa.engine.ProjectBase.logInfo;

public class OwnTransfersPage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'BALANCE')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'BALANCE')]")
    protected WebElement payFromAccount;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Pay to']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Pay to']")
    protected WebElement payTo;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Amount']/following-sibling::android.view.View[4]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Amount\"]//following-sibling::XCUIElementTypeOther[2]")
    protected WebElement currency;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Amount']/following-sibling::android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Amount']/following-sibling::XCUIElementTypeOther[2]")
    protected WebElement currencyFlag;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Transfers']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='Transfers']")
    protected WebElement transfersImage;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Recipient Name']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Recipient Name']/following-sibling::android.widget.EditText[1]")
    protected WebElement recipientName;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Amount']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Amount']/following-sibling::XCUIElementTypeOther[1]")
    protected WebElement amountField;

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
        return getAttribute(payFromAccount, attribute);
    }


    public void selectPayFromAccount(String accountNumber) throws InterruptedException {
        Instant timeout = Instant.now().plusSeconds(90);

        String cardValue = new OwnTransfersPage().fetchDetails();

        while (!cardValue.contains(accountNumber)) {
            new TransferPayeePage().clickOnForwardArrow();
            Thread.sleep(1500);
            cardValue = new OwnTransfersPage().fetchDetails();

            if (cardValue.contains(accountNumber))
                break;
            if (Instant.now().isAfter(timeout)) {
                break;
            }
        }
    }

    public String selectPayToCard(String account) {
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
        else
            throw new RuntimeException("Account is not found for this Customer");

        return value;
    }

    public void clickOnPayToType(String type) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + type + "']"), "Clicking on " + type);
    }

    public String fetchPayToAccountBalance() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "='Pay to']/following-sibling::" + parentAttribute + "[@" + attribute + "='TOTAL ACCOUNT BALANCE']/following-sibling::" + parentAttribute + "[1]"), attribute);
    }

    public void selectFlagCurrency() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        By xpath = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'Conversion Rate :')]");

        if (getDriver().findElements(xpath).size() > 0)
            click(currency);
        else
            click(currencyFlag);

    }

    public void clickTransfersImage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Transfers']", 90);
        waitForVisibility(transfersImage);
        click(transfersImage, "Clicking the transfers");

    }

    public String fetchAlertMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        waitForVisibility(recipientName);
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'Please enter at least 3 names')]"), attribute);
    }

    public String fetchAlertMessageRecipientAddress() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        waitForVisibility(recipientName);
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'Recipient address cannot be empty')]"), attribute);

    }

    public void enterTransferAmount(String amount, String page) {
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

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='" + page + "']", 90);

        click(amountField);

        logInfo("Inputting the amount " + amount);

        char[] charArray = amount.toCharArray();

        if (getDriver() instanceof AndroidDriver) {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='" + page + "']//../following-sibling::" + parentAttribute2 + ")[11]"));
                else
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='" + page + "']//../following-sibling::" + parentAttribute2 + ")[" + c + "]"));
            }
            click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='" + page + "']//../following-sibling::" + parentAttribute2 + ")[12]"));
        } else {
            for (char c : charArray) {
                if (c == 0)
                    click(getDriver().findElements(By.xpath("//XCUIElementTypeOther[contains(@name,\"Transfer\")]//ancestor::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton")).get(11));
                else if (c == '.')
                    click(getDriver().findElements(By.xpath("//XCUIElementTypeOther[contains(@name,\"Transfer\")]//ancestor::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton")).get(10));
                else
                    click(getDriver().findElements(By.xpath("//XCUIElementTypeOther[contains(@name,\"Transfer\")]//ancestor::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton")).get(c));
            }
            click(getDriver().findElements(By.xpath("//XCUIElementTypeOther[contains(@name,\"Transfer\")]//ancestor::XCUIElementTypeOther//following-sibling::XCUIElementTypeButton")).get(12));
        }
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

        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='New Beneficiary']"));
        return new TransfersPage();
    }
}