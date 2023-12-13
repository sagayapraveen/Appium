package com.qa.pages.capitalbank.billpay;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class PayBillDetailsPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Pay']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Pay']")
    protected WebElement payButton;

    public PayBillDetailsPage() {
        waitForAppToLoad();
    }

    @Override
    protected void waitForAppToLoad() {
    }

    public void clickPayButton() {
        if (getDriver() instanceof AndroidDriver) {
            utils.waitForElement(getDriver(), "//android.widget.Button[@content-desc='Pay']", 90);
        } else if (getDriver() instanceof IOSDriver) {
            utils.waitForElement(getDriver(), "//XCUIElementTypeButton[@name='Pay']", 90);
        }
        click(payButton, "Click on pay button");
    }
}
