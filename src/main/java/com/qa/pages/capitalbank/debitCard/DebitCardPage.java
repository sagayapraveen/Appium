package com.qa.pages.capitalbank.debitCard;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import static com.qa.engine.ProjectBase.logInfo;

public class DebitCardPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Spending')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Spending')]")
    protected WebElement manageSpendingLimits;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'ATM Withdrawal')]/android.widget.Switch[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Online Purchase')]/following-sibling::XCUIElementTypeSwitch[1]")
    protected WebElement atmToggle;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'ATM Withdrawal')]/android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'ATM Withdrawal')]/following-sibling::XCUIElementTypeTextField[1]")
    protected WebElement atmLimit;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Card Payments')]/android.widget.Switch[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Online Purchase')]/following-sibling::XCUIElementTypeSwitch[2]")
    protected WebElement cardPayToggle;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Card Payments')]/android.widget.EditText[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'ATM Withdrawal')]/following-sibling::XCUIElementTypeTextField[2]")
    protected WebElement cardPaymentLimit;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Online Purchase')]/android.widget.Switch[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Online Purchase')]/following-sibling::XCUIElementTypeSwitch[3]")
    protected WebElement onlinePaymentToggle;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Online Purchase')]/android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'ATM Withdrawal')]/following-sibling::XCUIElementTypeTextField[3]")
    protected WebElement onlinePaymentLimit;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Contactless Payment')]/android.widget.Switch[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Online Purchase')]/following-sibling::XCUIElementTypeSwitch[3]")
    protected WebElement contactLessToggle;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Contactless Payment')]/android.widget.EditText[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'ATM Withdrawal')]/following-sibling::XCUIElementTypeTextField[3]")
    protected WebElement contactLessLimit;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Manage Spending Limits\"]//..//..//../android.view.View[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'ATM Withdrawal')]/ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeOther[3]")
    protected WebElement saveButton;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'SUCCESS')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'SUCCESS')]")
    protected WebElement successMessage;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Entered value is greater than max limit for ATM Withdrawal')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Entered value is greater than max limit for ATM Withdrawal')]")
    protected WebElement atmError;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Entered value is greater than max limit for Card Payments')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Entered value is greater than max limit for Card Payments')]")
    protected WebElement cardError;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Entered value is greater than max limit for Online Purchase')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Entered value is greater than max limit for Online Purchase')]")
    protected WebElement onlinePurchaseError;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Entered value is greater than max limit for Contactless Payment')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Entered value is greater than max limit for Contactless Payment')]")
    protected WebElement contactLessError;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,  'Freeze')]/android.widget.Switch")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name,\"Manage\")]//following-sibling::XCUIElementTypeSwitch")
    protected WebElement freezeButton;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Card Details')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Card Details')]")
    protected WebElement statusOfCard;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Contactless Payment')]/android.widget.Switch[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Contactless Payment')]/XCUIElementTypeSwitch[1]")
    protected WebElement atmToggleOn;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Contactless Payment')]/android.widget.Switch[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Contactless Payment')]/XCUIElementTypeSwitch[2]")
    protected WebElement cardToggleOn;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Contactless Payment')]/android.widget.Switch[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Contactless Payment')]/XCUIElementTypeSwitch[3]")
    protected WebElement onLineToggleOn;

    @Override
    protected void waitForAppToLoad() {
    }

    public String getMenu() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Spending')]", 60);
        return getTextWithAttribute(manageSpendingLimits, attribute);
    }

    public String getCardStatus() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Spending')]", 60);
        return getTextWithAttribute(statusOfCard, attribute).replaceAll("\n", " ");
    }

    public void clickOnManageSpending(String text) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        waitForVisibility(manageSpendingLimits);
        click(getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + text + "')]")));
    }

    public void setATMWithdrawalLimit(String amount) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Manage Spending Limits\"]", 60);
        clear(atmLimit);
        clickAndSendKeys(atmLimit, amount, "Setting ATM Limit");

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public void setCardPayment(String amount) {
        clear(cardPaymentLimit);
        clickAndSendKeys(cardPaymentLimit, amount, "Setting Card Payment");

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public void setOnlinePurchase(String amount) {
        scroll("up", 0.80);
        clear(onlinePaymentLimit);
        clickAndSendKeys(onlinePaymentLimit, amount, "Setting Online Payment");

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public void setContactLessPayment(String amount) {
        scroll("up", 0.30);
        clear(contactLessLimit);
        String number = utils.getRandomNumber(2);
        clickAndSendKeys(contactLessLimit, amount + number, "Setting Contact less Payment");

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public void clickOnSave() {
        scroll("up", 0.30);
        waitForVisibility(saveButton);
        click(saveButton, "Clicking on save button");
    }

    public String getSuccessMessage() throws InterruptedException {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'SUCCESS')]", 60);
        Thread.sleep(1000);
        return getTextWithAttribute(successMessage, attribute);
    }

    public void clickToggleOnContactLess() {
        scroll("up", 0.5);
        waitForVisibility(contactLessToggle);
        click(contactLessToggle, "Clicking on Contactless Toggle");
    }

    public void clickToggleOnCard() {
        click(cardPayToggle, "Clicking on Card Payment Toggle");
    }

    public void clickToggleOnATMWithdrawal() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Manage Spending Limits\"]", 60);
        click(atmToggle, "Clicking on ATM Withdrawal Toggle");
    }

    public void clickToggleOnlinePurchase() {
        click(onlinePaymentToggle, "Clicking on Online Purchase Toggle");
    }

    public String getATMErrorMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Manage Spending Limits']", 60);
        return getTextWithAttribute(atmError, attribute).replaceAll("\n", " ");
    }

    public String getCardErrorMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        return getTextWithAttribute(cardError, attribute).replaceAll("\n", " ");
    }

    public String getOnlineErrorMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        return getTextWithAttribute(onlinePurchaseError, attribute).replaceAll("\n", " ");
    }

    public String getContactLessErrorMessage() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getTextWithAttribute(contactLessError, attribute).replaceAll("\n", " ");
    }

    public void clickFreezeButton() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            parentAttribute2 = "android.widget.Switch";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            parentAttribute2 = "XCUIElementTypeSwitch";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Spending')]", 60);
        Point point1 = getDriver().findElement(By.xpath("//" + parentAttribute2 + "[contains(@" + attribute + ", 'Freeze')]")).getLocation();
        tapOnPosition(point1.x + 497, point1.y + 50);
        logInfo("selecting activate card toggle");
    }

    public void clickOnFreeze() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Spending')]", 60);
        click(freezeButton, "Clicking On + freezeButton");
    }

    public void clickOnATMToggle() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Manage Spending Limits']", 60);
        click(atmToggleOn, "Clicking on Online Purchase Toggle");
    }

    public void clickOnToggleOnlinePurchase() {
        click(onLineToggleOn, "Clicking on Online Purchase Toggle");
    }

    public void clickOnCardToggle() {
        click(cardToggleOn, "Clicking on Online Purchase Toggle");
    }

    public void clickOnContactLessToggle() {
        scroll("up", 0.5);
        click(cardToggleOn, "Clicking on Online Purchase Toggle");
    }
}