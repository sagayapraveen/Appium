package com.qa.pages.capitalbank.overdraft;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class OverdraftConfirmPage extends BasePage {

    @Override
    protected void waitForAppToLoad() {
    }

    public String getAmount() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Amount in')]/following-sibling::" + parentAttribute + "[1]"), attribute);
    }

    public String getDescription() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Description\"]/following-sibling::" + parentAttribute + "[1]"), attribute);
    }

    public String getPayFromAccount() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Pay From\"]", 60);

        if (getDriver() instanceof AndroidDriver)
            return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Pay From\"]/following-sibling::" + parentAttribute + "[3]"), attribute);
        else
            return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Pay From\"]/following-sibling::" + parentAttribute + "[3]"), attribute);
    }

    public float getConversionRate() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        String value = getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Exchange Rate\"]/following-sibling::" + parentAttribute + "[1]"), attribute);
        return Float.parseFloat(value.split(" ")[3]);
    }

    public String getCurrency() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute2 = "android.widget.ScrollView";
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeScrollView";
            attribute = "name";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'Confirm')]//ancestor::" + parentAttribute + "//following-sibling::" + parentAttribute2 + "//" + parentAttribute + "[15]"), attribute);
    }
}