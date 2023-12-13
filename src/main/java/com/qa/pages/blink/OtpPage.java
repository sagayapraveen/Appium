package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;

import static com.qa.engine.ProjectBase.logInfo;

public class OtpPage extends BasePage {
    @Override
    protected void waitForAppToLoad() {
    }

    public void enterOtp(String otp) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//*[contains(@" + attribute + ",'Enter the 6-digit code sent to')]", 60);

        Point point = getDriver().findElement(By.xpath("//*[contains(@" + attribute + ",'Resend')]")).getLocation();
        tapOnPosition(point.x + 150, point.y + 150);
        new Actions(getDriver()).sendKeys(otp).perform();
        scroll("left", 0.5);
    }

    public void enterOtpUpdateCliq(String otp) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Enter the 6-digit code sent to')]", 60);

        Point point = getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"Resend\")]")).getLocation();
        tapOnPosition(point.x + 100, point.y + 100);
        new Actions(getDriver()).sendKeys(otp).perform();
        scroll("left", 0.5);
    }

    public void clearAndEnterOtp(String otp) throws InterruptedException {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Enter the 6-digit code sent to')]", 60);

        tapOnPosition(200, 750);

        new Actions(getDriver()).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .perform();

        logInfo("Clearing and Entering the otp");

        new Actions(getDriver())
                .sendKeys(otp)
                .perform();

        Thread.sleep(2500);

        scroll("Left");
    }
}
