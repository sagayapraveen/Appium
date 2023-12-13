package com.qa.pages.capitalbank;

import com.qa.pages.BasePage;
import com.qa.pages.blink.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class OtpPinSetUpPage extends BasePage {
    @AndroidFindBy(accessibility = "Next")
    @iOSXCUITFindBy(accessibility = "Next")
    protected WebElement next;

    @Override
    protected void waitForAppToLoad() {
    }

    public OtpPinSetUpPage next() throws InterruptedException {
        if (getDriver() instanceof IOSDriver)
            tapOnPosition(next.getLocation().x, next.getLocation().y);
        else
            click(next);
        return this;
    }

    public OtpPinSetUpPage createAppPin() throws InterruptedException {
        Thread.sleep(2000);
        if (getDriver() instanceof AndroidDriver)
            new Actions(getDriver()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                    .sendKeys("111111")
                    .perform();
        else {
            tapOnPosition(50, 390);
            new Actions(getDriver())
                    .sendKeys("111111")
                    .perform();
        }
        return this;
    }

    public OtpPinSetUpPage verifyMobile(String otp) throws InterruptedException {
        Thread.sleep(2000);
        if (getDriver() instanceof AndroidDriver)
            new Actions(getDriver()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                    .sendKeys(otp)
                    .perform();
        else {
            tapOnPosition(50, 390);
            new Actions(getDriver())
                    .sendKeys(otp)
                    .perform();
        }
        return this;
    }

    public OtpPinSetUpPage verifyMobileOTP(String otp) {
        if (getDriver() instanceof IOSDriver)
            new HomePage().tapOnPosition(48, 423);

        new Actions(getDriver()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(otp)
                .perform();
        return this;
    }
}