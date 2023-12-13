package com.qa.pages.capitalbank.billpay;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import static com.qa.engine.ProjectBase.logInfo;

public class PayBillSuccessfulPage extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Biller Name']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"success\")]")
    protected WebElement billerName;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Total Amount']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Success\")]")
    protected WebElement totalAmount;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Ref No']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Success\")]")
    protected WebElement refNumber;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Date']/following-sibling::android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Success\")]")
    protected WebElement billerDate;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='You have successfully paid your bill!']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='You have successfully paid your bill!']")
    protected WebElement successfulMessage;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Biller Name')][1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'Biller Name')][1]")
    protected WebElement postPaidBillSuccessful1;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Biller Name')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'Biller Name')][2]")
    protected WebElement postPaidBillSuccessful2;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Save Biller']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Save Biller']")
    protected WebElement saveBiller;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Add as Save Biller']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Add as Save Biller']")
    protected WebElement addAsSaveBiller;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Biller Name')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Biller Name')]")
    protected WebElement prepaidSuccess;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Biller Name')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Biller Name')]")
    protected WebElement postpaidSuccess;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Total Amount\"]/following-sibling::android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total Amount\"]//following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement compareAmount;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Biller Saved!']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Biller Saved!']")
    protected WebElement billerSaved;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@text, 'Amount should')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name, 'Amount should')]")
    protected WebElement postpaidInsufficientError;

    public PayBillSuccessfulPage() {
        waitForAppToLoad();
    }

    @Override
    public void waitForAppToLoad() {
    }

    public StringBuilder getSuccessfulMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='You have successfully paid your bill!']", 90);

        StringBuilder message = new StringBuilder();
        if (getDriver() instanceof AndroidDriver) {
            message.append(billerName.getAttribute(attribute)).append("\n ")
                    .append(totalAmount.getAttribute(attribute)).append(" \n ")
                    .append(refNumber.getAttribute(attribute)).append("\n")
                    .append(billerDate.getAttribute(attribute)).append(" - ")
                    .append(successfulMessage.getAttribute(attribute)).append(" - ");
        } else {
            message.append(billerName.getAttribute("name").replaceAll("\n", " "));
        }
        logInfo("successfully message " + message);
        return message;
    }

    public StringBuilder getPostpaidSuccessful() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Biller Name')]", 40);
        StringBuilder message = new StringBuilder();

        message.append(postPaidBillSuccessful1.getAttribute(attribute)).append("\n ")
                .append(postPaidBillSuccessful2.getAttribute(attribute)).append("\n ")
                .append(successfulMessage.getAttribute(attribute)).append(" - ");

        return message;
    }

    public void clickOnSaveBiller(String page) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//*[contains(@" + attribute + ", '" + page + "')]", 90);
        click(saveBiller, "Clicking Save biller " + page);
    }

    public String addAsSaveBiller() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Add as Save Biller']", 90);
        return getTextWithAttribute(addAsSaveBiller, attribute);
    }

    public String getPrePaidAndPostpaidSuccessMessage(String paymentMode, String text) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", '" + text + "')]", 90);

        if (paymentMode.equals("prepaid")) {
            return getTextWithAttribute(prepaidSuccess, attribute);
        } else {
            return getTextWithAttribute(postpaidSuccess, attribute);
        }
    }

    public String getAmountForConfirmation() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Total Amount']/following-sibling::" + parentAttribute, 90);
        return getTextWithAttribute(compareAmount, attribute);
    }

    public String getPostpaidBillerSavedSuccessMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeTextField";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Biller Saved!']", 90);
        return getTextWithAttribute(billerSaved, attribute);
    }

    public String getPostpaidInsufficientError() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Pay to']", 90);
        if (getDriver() instanceof AndroidDriver)
            return getTextWithAttribute(postpaidInsufficientError, "text");
        else
            return getTextWithAttribute(postpaidInsufficientError, "name");

    }
}