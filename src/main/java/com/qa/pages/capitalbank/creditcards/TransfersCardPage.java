package com.qa.pages.capitalbank.creditcards;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.qa.engine.ProjectBase.logInfo;

public class TransfersCardPage extends BasePage {
    @AndroidFindBy(accessibility = "Own Account")
    @iOSXCUITFindBy(accessibility = "Own Account")
    protected WebElement ownAccount;
    @AndroidFindBy(accessibility = "Next")
    @iOSXCUITFindBy(accessibility = "Next")
    protected WebElement next;
    @AndroidFindBy(accessibility = "Confirm")
    @iOSXCUITFindBy(accessibility = "Confirm")
    protected WebElement confirm;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Pay to')]//android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Pay\")]//following::XCUIElementTypeImage")
    protected WebElement payToAccount;

    @Override
    protected void waitForAppToLoad() {
    }

    public void clickOwnAccount() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Transfers']", 30);
        click(ownAccount, "Clicking Own account");
    }

    public void selectCurrentAccount() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Pay to')]", 30);

        String value = getAttribute(payToAccount, attribute);

        if (value.contains("CURRENT ACCOUNT"))
            click(payToAccount, "Clicking Pay to current account");
        else {
            logInfo("No current account found for this Customer");
            throw new RuntimeException();
        }
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

    public void clickNext() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Next']", 90);
        click(next, "Clicking next");
    }

    public String getConfirmPayFromDetails() {
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

        int size = getDriver().findElements(By.xpath("//" + parentAttribute + "[@" + attribute + "='Pay From']/following-sibling::" + parentAttribute)).size();

        StringBuilder payFromDetails = new StringBuilder();
        String temp = "";

        for (int i = 1; i <= size; i++) {
            temp = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "='Pay From']/following-sibling::" + parentAttribute + "[" + i + "]"))
                    .getAttribute(attribute);
            if (temp.equalsIgnoreCase("Pay to"))
                break;

            payFromDetails.append("\t").append(temp);
        }
        return payFromDetails.toString();
    }

    public String getConfirmPayToDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        int size = getDriver().findElements(By.xpath("//" + parentAttribute + "[@" + attribute + "='Pay to']/following-sibling::" + parentAttribute)).size();

        StringBuilder payToDetails = new StringBuilder();
        String temp = "";

        for (int i = 1; i <= size; i++) {
            temp = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "='Pay to']/following-sibling::" + parentAttribute + "[" + i + "]"))
                    .getAttribute(attribute);

            if (temp.equalsIgnoreCase("Disclaimers:"))
                break;

            payToDetails.append("\t").append(temp);
        }
        return payToDetails.toString();
    }

    public String fetchSuccessfulMessage(String context) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='" + context + "']", 90);

        int size = getDriver().findElements(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + context + "']/following-sibling::" + parentAttribute)).size();

        logInfo("Transaction is successful");

        StringBuilder successfulMessage = new StringBuilder();

        for (int i = 1; i <= size; i++) {
            successfulMessage.append("\t").append(getDriver().findElement(By.xpath("(//" + parentAttribute + "[@" + attribute + "='" + context + "']/following-sibling::" + parentAttribute + ")[" + i + "]"))
                    .getAttribute(attribute));
        }
        return successfulMessage.toString();
    }
}
