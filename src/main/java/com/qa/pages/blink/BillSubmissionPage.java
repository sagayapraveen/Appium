package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class BillSubmissionPage extends BasePage {
    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Ref No.')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@content-desc, 'Ref No.')]")
    protected WebElement referenceMessage;

    public BillSubmissionPage() {
        waitForAppToLoad();
    }

    @Override
    protected void waitForAppToLoad() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//*[contains(@" + attribute + ", 'Ref No.')]", 90);
    }

    public String getReferenceMessage() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//*[contains(@" + attribute + ", 'Ref No.')]", 30);
        return getTextWithAttribute(referenceMessage, "content-desc");
    }
}