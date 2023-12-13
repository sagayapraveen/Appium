package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.qa.engine.ProjectBase.logInfo;

public class ManageCliQPage extends BasePage {

    @AndroidFindBy(accessibility = "Edit ID")
    @iOSXCUITFindBy(accessibility = "Edit ID")
    protected WebElement editId;
    @AndroidFindBy(accessibility = "Suspend ID")
    @iOSXCUITFindBy(accessibility = "Suspend ID")
    protected WebElement suspendId;
    @AndroidFindBy(accessibility = "Delete CliQ ID")
    @iOSXCUITFindBy(accessibility = "Delete CliQ ID")
    protected WebElement deleteId;
    @AndroidFindBy(accessibility = "Activate ID")
    @iOSXCUITFindBy(accessibility = "Activate ID")
    protected WebElement activateId;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Manage CliQ ID']/following-sibling::android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Manage CliQ ID\"]//following-sibling::XCUIElementTypeOther[1]")
    protected WebElement addCliQId;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Change\")]//following-sibling::android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Change\")]//following-sibling::XCUIElementTypeOther[1]")
    protected WebElement terms;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Change\")]//following-sibling::android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Change\")]//following-sibling::XCUIElementTypeImage[2]")
    protected WebElement swipeDownButton;

    @Override
    protected void waitForAppToLoad() {
    }

    public void createCliQ() {
        waitForVisibility(addCliQId);
        click(addCliQId, "Click create new CliQ");
    }

    public boolean isAliasPresent(String alias) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//*[contains(@" + attribute + ", 'Manage') and contains(@" + attribute + ",'CliQ ID')]", 50);

        int size = getDriver().findElements(By.xpath(
                "//" + parentAttribute + "[contains(@" + attribute + ", 'Alias') and contains(@" + attribute + ",'Active')" +
                        " and contains(@" + attribute + ",'" + alias + "')]")).size();
        return size > 0;
    }

    public void selectActiveAlias(String alias) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }

        utils.waitForElement(getDriver(), "//*[contains(@" + attribute + ", 'Manage') and contains(@" + attribute + ",'CliQ ID')]", 50);

        int size = getDriver().findElements(By.xpath(
                "//" + parentAttribute + "[contains(@" + attribute + ", 'Alias') " +
                        "and contains(@" + attribute + ",'Active') " +
                        "and contains(@" + attribute + ",'" + alias + "')]")).size();

        Assert.assertTrue(size > 0, "Assertion on alias found in the app");

        logInfo(alias + " is in Active status.");

        logInfo("Active alias '" + alias + "' is available in the app.");
        Dimension point = getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Active') and contains(@" + attribute + ",'" + alias + "')]")).getSize();
        tapOnPosition(point.width - 200, point.height);
    }

    public void selectSuspendedAlias(String alias) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Manage') and contains(@" + attribute + ",'CliQ ID')]", 50);

        int size = getDriver().findElements(By.xpath(
                "//" + parentAttribute + "[contains(@" + attribute + ", 'Alias') " +
                        "and contains(@" + attribute + ",'Suspended') " +
                        "and contains(@" + attribute + ",'" + alias + "')]")).size();

        Assert.assertTrue(size > 0, "Assertion on alias found in the app");

        logInfo(alias + " is in suspended status.");

        Dimension point = getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Suspended')] and contains(@" + attribute + ",'" + alias + "')]")).getSize();

        tapOnPosition(point.width - 200, point.height);
    }

    public UpdateCliQ editAlias() {
        click(editId, "Clicking Edit CliQ ID");
        return new UpdateCliQ();
    }

    public UpdateCliQ suspendAlias() {
        click(suspendId, "Clicking Suspend CliQ ID");
        return new UpdateCliQ();
    }

    public UpdateCliQ deleteAlias() {
        click(deleteId, "Clicking Delete CliQ ID");
        return new UpdateCliQ();
    }

    public UpdateCliQ activateAlias() {
        click(activateId, "Clicking Activate CliQ ID");
        return new UpdateCliQ();
    }

    public String fetchActiveAlias(String aliasName) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Manage') and contains(@" + attribute + ",'CliQ ID')]", 50);
        String value = getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Alias') and contains(@" + attribute + ",'Active') and contains(@" + attribute + ",'" + aliasName + "')]"),
                attribute).split("\n")[0];

        logInfo(value + " is in active status");
        return value;
    }

    public String fetchSuspendedAlias(String aliasName) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Manage') and contains(@c" + attribute + ",'CliQ ID')]", 50);

        String value = getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Alias')" +
                        " and contains(@" + attribute + ",'Suspended') and contains(@\"+attribute+\",'" + aliasName + "')]"),
                attribute).split("\n")[0];

        logInfo(value + " is in suspended status");

        return value;
    }

    public void clickLinkButton(String value) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        Point point;
        Point points;
        if (getDriver() instanceof AndroidDriver) {
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'" + value + "')]//" + parentAttribute + "contains(@" + attribute + ",\"Savings\")]", 30);
            point = getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'" + value + "')]//" + parentAttribute + "[contains(@" + attribute + ",\"Savings\")]")).getLocation();
            points = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Set as Default\"]")).getLocation();

        } else {
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@name,'" + value + "')]", 30);
            point = getDriver().findElement(By.xpath("//XCUIElementTypeOther[contains(@name,'" + value + "')]/following::XCUIElementTypeStaticText[1]")).getLocation();
            points = getDriver().findElement(By.xpath("//XCUIElementTypeButton[@" + attribute + "=\"Set as Default\"]")).getLocation();
        }
        tapOnPosition(point.x + 100, point.y + 50);

        tapOnPosition(points.x + 50, points.y);

        click(terms, "Clicking terms");
        click(swipeDownButton);
    }

    public String defaultVerification(String value) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }

        String xpath = "";
        if (getDriver() instanceof AndroidDriver)
            xpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + value + "')]//" + parentAttribute + "[contains(@" + attribute + ",\"Savings\")]";
        else
            xpath = "//" + parentAttribute + "[contains(@name,'\" + value + \"')]//following::XCUIElementTypeStaticText[1]";
        utils.waitForElement(getDriver(), xpath, 30);
        return getAttribute(By.xpath(xpath), attribute);
    }
}