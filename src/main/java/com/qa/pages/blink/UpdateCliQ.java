package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UpdateCliQ extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='ALIAS￼']/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='ALIAS']/following-sibling::XCUIElementTypeTextField")
    protected WebElement aliasName;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='ALIAS￼']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Back to Manage CliQ\"]/preceding::XCUIElementTypeOther[1]")
    protected WebElement agreeChanges;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Suspend CliQ ID']/following-sibling::android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"suspend your CliQ ID?\")]//following-sibling::XCUIElementTypeImage")
    protected WebElement okSuspend;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Reactivate CliQ ID']/following-sibling::android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Swipe down to cancel\"]/preceding::XCUIElementTypeOther[1]")
    protected WebElement acceptActivate;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Reactivate CliQ ID']/following-sibling::android.widget.ImageView[last()]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Swipe down to cancel\"]/preceding::XCUIElementTypeImage[1]")
    protected WebElement okReactivate;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Confirm Delete?']/following-sibling::android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Swipe down to cancel\"]/preceding::XCUIElementTypeImage[1]")
    protected WebElement confirmDelete;

    @Override
    protected void waitForAppToLoad() {
    }

    public UpdateCliQ setAliasName(String name) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'EDIT CLIQ ID')]", 50);
        click(aliasName);
        aliasName.clear();
        clickAndSendKeys(aliasName, name, "Alias name has set to " + name);

        if (getDriver() instanceof IOSDriver)
            click(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]"));
        return this;
    }

    public void agreeChanges() {
        click(agreeChanges, "Click agree changes");
    }

    public void okSuspend() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeStaticText";
        }
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Suspend CliQ ID']/following-sibling::" + parentAttribute + "[1]", 50);
        else
            utils.waitForElement(getDriver(), "//XCUIElementTypeStaticText[contains(@name,\"suspend your CliQ ID?\")]//following-sibling::XCUIElementTypeImage", 50);
        click(okSuspend, "Confirming the suspend");
    }

    public UpdateCliQ acceptActivateCliQ() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeStaticText";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Reactivate CliQ ID']", 50);
        click(acceptActivate, "Clicking accept activate");
        return this;
    }

    public void okReactivate() {
        click(okReactivate, "Clicking Ok Reactivate");
    }

    public void confirmDelete() {
        waitForVisibility(confirmDelete);
        click(confirmDelete, "Clicking confirm delete");
    }
}
