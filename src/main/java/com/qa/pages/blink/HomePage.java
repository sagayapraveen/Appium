package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.qa.engine.ProjectBase.logInfo;

public class HomePage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Total Balance')]/android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Total Balance\")]//following-sibling::XCUIElementTypeImage[2]")
    protected WebElement homeMenu;

    @AndroidFindBy(accessibility = "Bills & Payments")
    @iOSXCUITFindBy(accessibility = "Bills & Payments")
    protected WebElement billPayments;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Bills & Payments']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='Bills & Payments']")
    protected WebElement billPayment;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Manage') and contains(@content-desc,'CliQ ID')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name,'CliQ ID')]")
    protected WebElement manageCliQ;

    @Override
    protected void waitForAppToLoad() {
    }

    public HomePage clickHomeMenu() {
        String attribute = "";
        String parentAttribute = "";
        String parentAttribute2 = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ImageView";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeImage";
        }
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Total Balance')]/" + parentAttribute2 + "[2]", 60);
        else
            utils.waitForElement(getDriver(), "//XCUIElementTypeOther[contains(@name,\"Total Balance\")]//following-sibling::XCUIElementTypeImage[2]", 60);
        click(homeMenu, "Clicking the home menu");
        return this;
    }

    public void clickBillPayments() {
        click(billPayment, "Clicking the Bill Payments");
    }

    public void clickManageCliQ() {
        waitForVisibility(billPayments);

        Point point = billPayments.getLocation();
        scrollWithCoordinates("left", 0.35, point.x + 10, point.y + 10);
        scrollWithCoordinates("left", 0.35, point.x + 10, point.y + 10);
        scrollWithCoordinates("left", 0.35, point.x + 10, point.y + 10);


        waitForVisibility(manageCliQ);
        click(manageCliQ, "Clicking the Manage CliQ");
    }

    public void requestNewDebitCard() throws InterruptedException {
        Thread.sleep(1000);
        logInfo("Navigated to Request debitCard screen");
        new Actions(getDriver()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        logInfo("Clicking Request new DebitCard");
    }
}
