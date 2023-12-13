package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class AddMoneyPage extends BasePage {
    @AndroidFindBy(accessibility = "Add money")
    @iOSXCUITFindBy(accessibility = "Add money")
    protected WebElement addMoney;
    @AndroidFindBy(accessibility = "Request money")
    @iOSXCUITFindBy(accessibility = "Request money")
    protected WebElement requestMoney;

    @Override
    protected void waitForAppToLoad() {
    }

    public AddMoneyPage clickAddMoney() {
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//android.view.View[@content-desc='Add money']", 90);
        else utils.waitForElement(getDriver(), "//XCUIElementTypeOther[@name='Add money']", 90);

        click(addMoney, "Clicking add money");
        return this;
    }

    public RequestMoneyPage clickRequestMoney() {
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//android.view.View[@content-desc='Request money']", 90);
        else utils.waitForElement(getDriver(), "//XCUIElementTypeOther[@name='Request money']", 90);

        click(requestMoney, "Clicking Request money");
        return new RequestMoneyPage();
    }
}
