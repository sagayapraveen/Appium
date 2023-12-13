package com.qa.pages.capitalbank.dashBoard;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.time.Instant;

public class ManageCheques extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,\"Request\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name,\"Request\")]")
    protected WebElement requestMoney;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Cheque Book\")]/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Cheque Book\")]/following-sibling::XCUIElementTypeOther[1]")
    protected WebElement chequeBook;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Cheque Book\")]/android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Cheque Book\")]/following-sibling::XCUIElementTypeOther[2]")
    protected WebElement chequeLeaves;

    @Override
    protected void waitForAppToLoad() {
    }

    public void openManageCheques() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        waitForVisibility(requestMoney);
        Point point = requestMoney.getLocation();
        Instant timeout = Instant.now().plusSeconds(30);
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",\"Manage\")]";

        if (getDriver() instanceof AndroidDriver) {
            while (getDriver().findElements(By.xpath(xpath)).size() == 0) {
                scrollWithCoordinates("left", 0.40, point.x, point.y + 50);

                if (Instant.now().isAfter(timeout))
                    throw new TimeoutException("Manage cheque menu is not displaying after 30 seconds");
            }
        } else {
            scrollWithCoordinates("left", 0.60, point.x, point.y + 50);
            scrollWithCoordinates("left", 0.60, point.x, point.y + 50);
        }

        click(By.xpath(xpath), "Clicking the manage cheques menu");
    }

    public void selectChequeBook(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", \"Cheque Book\")]", 30);
        String xpath = "//*[@" + attribute + "='" + value + "']";
        click(chequeBook, "Clicking cheque book");
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Select Number of Cheque Books\"]", 30);
        click(By.xpath(xpath), "Clicking no of books " + value);
    }

    public void selectChequeLeaves(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        String xpath = "//*[contains(@" + attribute + ",'" + value + "')]";
        click(chequeLeaves, "Clicking cheque leaves");
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Select Cheque Book Leaves\"]", 30);
        click(By.xpath(xpath), "Clicking no of leaves " + value);
    }

    public void selectLanguage(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + value + "']"), "Clicking language " + value);
    }

    public String getConfirmationPageDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Confirm Request\"]", 30);
        return getAttribute(By.xpath("//*[contains(@" + attribute + ",'Number of')]"), attribute);
    }
}
