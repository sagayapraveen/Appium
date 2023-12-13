package com.qa.pages.capitalbank.notification;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class MessageCentrePage extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Message Centre\"]/following-sibling::android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Centre\")]/following-sibling::XCUIElementTypeImage")
    protected WebElement menuButton;
    @AndroidFindBy(accessibility = "Select All")
    @iOSXCUITFindBy(accessibility = "Select All")
    protected WebElement selectAllButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Actions...\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Actions...\"]")
    protected WebElement actionButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Notifications\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"cations\")]")
    protected WebElement notificationTab;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Inbox\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Inbox\"]")
    protected WebElement inboxTab;
    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc, 'Notifications')]//..//../android.widget.ImageView)[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Notifications')]//preceding::XCUIElementTypeButton[1]")
    protected WebElement backButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Notifications\"]//../following-sibling::android.view.View/android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"cations\")]//ancestor::XCUIElementTypeOther[1]//following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeStaticText[1]")
    protected WebElement notificationDate;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Notifications\"]//../following-sibling::android.view.View/android.view.View[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Notifications\"]//ancestor::XCUIElementTypeOther[1]//following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeStaticText[3]")
    protected WebElement notificationDetails;

    @Override
    protected void waitForAppToLoad() {
    }

    public void clickOnNotificationMenu() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"cations\")]", 60);
        click(notificationTab, "Clicking on notification menu");
    }

    public void clickInboxMenu() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Inbox\"]", 60);
        click(inboxTab, "Clicking on inbox menu");
    }

    public void clickMenuIcon() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Centre\")]", 60);
       if(getDriver() instanceof AndroidDriver)
        click(menuButton, "Clicking on menuIcon");
        else
            tapOnPosition(menuButton.getLocation().x + 25, menuButton.getLocation().y + 10);
    }

    public void clickSelectAllLink() {
        click(selectAllButton, "Clicking on selectAllButton");
    }

    public MessageCentrePage clickActionsLink() {
        click(actionButton, "Clicking on actionButton");
        return this;
    }

    public void selectAction(String action) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        click(By.xpath("//" + parentAttribute + "[@" + attribute + " ='" + action + "']"));
    }

    public String fetchAction(String name) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", '" + name.substring(5) + "') or contains(@" + attribute + ", '" + name + "')]", 30);
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + name.substring(5) + "') or contains(@" + attribute + ", '" + name + "')]"), attribute);
    }

    public void clickNotification(String name) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + name.substring(5) + "') or contains(@" + attribute + ", '" + name + "')]"), "Selecting notification");
    }

    public void clickBackButton() {
        click(backButton, "clicking on back button");
    }

    public void scrollInNotification(String name) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//*[contains(@name,\"cations\") or contains(@name,\"Notifications\")]", 60);
        Point point = getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + " ,'" + name.substring(5) + "') or contains(@" + attribute + " ,'" + name + "')]")).getLocation();
        scrollWithCoordinates("right", 0.40, point.x + 200, point.y + 10);
    }

    public void clickOnActionSymbol(String name) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + " ,'" + name.substring(5) + "') or contains(@" + attribute + " ,'" + name + "')]", 60);
        Point point = getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + " ,'" + name.substring(5) + "') or contains(@" + attribute + " ,'" + name + "')]")).getLocation();
        tapOnPosition(point.x + 10, point.y);
    }

    public String fetchNotificationDate() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getTextWithAttribute(notificationDate, attribute);
    }

    public String fetchNotificationDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getTextWithAttribute(notificationDetails, attribute);
    }

    public void scrollToDelete(String name) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Notifications\"]", 60);
        Point point = getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + " ,'" + name.substring(5) + "') or contains(@" + attribute + " ,'" + name + "')]")).getLocation();
        scrollWithCoordinates("left", 0.35, point.x, point.y);
    }

    public MessageCentrePage swipeBackFromDelete() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            parentAttribute2 = "XCUIElementTypeImage";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"cations\") or contains(@" + attribute + ",\"Notifications\")]", 60);
        Point point = getDriver().findElement(By.xpath("//" + parentAttribute2 + "[contains(@" + attribute + ", 'Delete')]")).getLocation();
        scrollWithCoordinates("right", 0.35, point.x + 100, point.y);
        return this;
    }
}
