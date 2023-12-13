package com.qa.pages.capitalbank.billpay;

import com.qa.pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class PayPrepaidNewBillPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Pay']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Pay']")
    protected WebElement payButton;

    public PayPrepaidNewBillPage() {
        waitForAppToLoad();
    }

    @Override
    protected void waitForAppToLoad() {
    }

    public void clickPayButton() {
        waitForVisibility(payButton);
        click(payButton, "Click on PayButton");
        new PrepaidBillConfirmPage();
    }
}