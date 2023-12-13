package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;

public class OutwardCliq extends BasePage {

    public OutwardCliq() {
        waitForAppToLoad();
    }

    @Override
    protected void waitForAppToLoad() {
    }

    public void sendRecipient(String value) {
        String attribute = "";
        String parentAttribute = "";
        String parentAttribute2 = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeTextField";
        }
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",'RECIPIENT NAME')]/" + parentAttribute2;
        utils.waitForElement(getDriver(), xpath, 45);
        clickAndSendKeys(By.xpath(xpath), value, "Recipient name has been entered as " + value);
    }

    public void sendRecipientAddress(String value) {
        String attribute = "";
        String parentAttribute = "";
        String parentAttribute2 = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeTextField";
        }
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",'RECIPIENT ADDRESS')]//" + parentAttribute2;
        utils.waitForElement(getDriver(), xpath, 45);
        clickAndSendKeys(By.xpath(xpath), value, "Recipient Address has been entered as " + value);
    }

    public void sendIBANNo(String value) throws InterruptedException {
        String attribute = "";
        String parentAttribute = "";
        String parentAttribute2 = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeTextField";
        }
        String page = "//android.view.View[@content-desc='Back to Payments']";
        utils.waitForElement(getDriver(), page, 60);

        Point point = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Back to Payments\"]/" + parentAttribute + "/" + parentAttribute + "[2]/" + parentAttribute2)).getLocation();
        tapOnPosition(point.x + 50, point.y);
        new Actions(getDriver())
                .sendKeys(value)
                .sendKeys(Keys.TAB)
                .perform();

    }

    public void sendBeneficiaryNo(String value) {
        String attribute = "";
        String parentAttribute = "";
        String parentAttribute2 = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeTextField";
        }
        String page = "//" + parentAttribute + "[@" + attribute + "='Back to Payments']";
        utils.waitForElement(getDriver(), page, 60);
        String xpath;
        if (getDriver() instanceof AndroidDriver)
            xpath = "//\" + parentAttribute + \"[@\" + attribute + \"=\\\"Back to Payments\\\"]/\" + parentAttribute + \"/\" + parentAttribute + \"[2]/\" + parentAttribute2";
        else
            xpath = "//XCUIElementTypeImage[contains(@name,\"ACCOUNT NO.\")]//following-sibling::XCUIElementTypeTextField";

        Point point = getDriver().findElement(By.xpath(xpath)).getLocation();
        tapOnPosition(point.x + 50, point.y);
        new Actions(getDriver())
                .sendKeys(value)
                .sendKeys(Keys.TAB)
                .perform();

        if (getDriver() instanceof IOSDriver)
            click(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]"));
    }

    public void nickName(String name) {
        String attribute = "";
        String parentAttribute = "";
        String parentAttribute2 = "";
        String parentAttribute3 = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
            parentAttribute3 = "android.widget.ScrollView";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeTextField";
            parentAttribute3 = "XCUIElementTypeScrollView";
        }
        String xpath;
        if (getDriver() instanceof AndroidDriver)
            xpath = "//" + parentAttribute + "[@" + attribute + "='Back to Payments']/" + parentAttribute3 + "/" + parentAttribute2;
        else
            xpath = "//XCUIElementTypeTextField[@name=\"Add nickname\"]";

        utils.waitForElement(getDriver(), xpath, 30);
        clickAndSendKeys(By.xpath(xpath), name, "Nickname is entered as " + name);
        scroll("left", 0.50);
    }

    public boolean enterString() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        int size = getDriver().findElements(By.xpath("//" + parentAttribute + "[@" + attribute + "='a']")).size();

        return size == 0;
    }
}
