package com.qa.pages.capitalbank.billpay;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class PrepaidBillConfirmPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Confirm']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Confirm']")
    protected WebElement confirmButton;

    public PrepaidBillConfirmPage() {
        waitForAppToLoad();
    }

    @Override
    protected void waitForAppToLoad() {
    }

    public void clickConfirmButton() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Confirm']", 90);
        click(confirmButton, "Click on confirm Button");
    }
}
