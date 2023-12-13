package com.qa.pages.capitalbank.dashBoard;

import com.qa.pages.BasePage;
import com.qa.pages.capitalbank.ProfilePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import static com.qa.engine.ProjectBase.logInfo;

public class HomePage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Next']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next']")
    protected WebElement takeTourNext;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Transfers']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='Transfers']")
    protected WebElement transfers;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Request') and contains(@content-desc,'Money')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Request') and contains(@name,'Money')]")
    protected WebElement requestMoney;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Done']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
    protected WebElement takeTourDone;

    @Override
    protected void waitForAppToLoad() {
    }

    public void proceedTakeTour() throws InterruptedException {
        if (getDriver() instanceof AndroidDriver) {
            String parentAttribute = "";
            String attribute = "";

            if (getDriver() instanceof AndroidDriver) {
                parentAttribute = "android.widget.Button";
                attribute = "content-desc";
            } else if (getDriver() instanceof IOSDriver) {
                parentAttribute = "XCUIElementTypeButton";
                attribute = "name";
            }
            click(takeTourNext);
            Thread.sleep(1000);
            click(takeTourNext);
            Thread.sleep(1000);
            click(takeTourNext);
            Thread.sleep(1500);
            if (getDriver().findElements(By.xpath("//" + parentAttribute + "[@" + attribute + "='Done']")).size() > 0)
                click(takeTourDone);
        } else if (getDriver() instanceof IOSDriver) {
            Point point = takeTourNext.getLocation();
            tapOnPosition(point.x + 10, point.y + 10);
            Thread.sleep(1000);
            tapOnPosition(point.x + 10, point.y + 10);
            Thread.sleep(1000);
            tapOnPosition(point.x + 10, point.y + 10);
            Thread.sleep(1500);
            Point point1 = takeTourDone.getLocation();
            tapOnPosition(point1.x + 10, point1.y + 10);
        }
    }

    public void clickTransfers() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//*[contains(@" + attribute + ", 'TOTAL ACCOUNT BALANCE')]", 60);

        try {
            waitForVisibility(transfers);
        } catch (StaleElementReferenceException ignored) {
            // ignored the exception
        }

        click(transfers, "Clicking the transfers");
    }

    public void clickRequestMoney() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Request') and contains(@" + attribute + ",'Money')]", 90);
        click(requestMoney, "Clicking the Request money menu");
    }

    public ProfilePage clickProfileIcon() {

        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Good')]", 90);
        getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Good')]")).click();

        logInfo("Clicking Profile icon");
        return new ProfilePage();
    }
}