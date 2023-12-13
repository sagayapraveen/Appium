package com.qa.pages.capitalbank.notification;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InboxPage extends BasePage {
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Inbox\"]//ancestor::android.view.View[6]//android.widget.ScrollView//following-sibling::android.widget.ImageView[last()])[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Message Centre\"]//ancestor::XCUIElementTypeOther[1]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther//XCUIElementTypeOther[2]/following-sibling::XCUIElementTypeButton")
    protected WebElement addButton;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Inbox\"]//ancestor::android.view.View[6]//android.widget.ScrollView//following-sibling::android.widget.ImageView[last()])[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name,\"message\")]//following-sibling::XCUIElementTypeButton")
    protected WebElement addButtonNoMessage;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'About')][1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'About')][1]")
    protected WebElement conversationDetails;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Start Chat']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Start Chat']")
    protected WebElement startChatButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Message Details\"]//../following-sibling::android.view.View/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Enter Your Message\"]")
    protected WebElement messageTextField;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Message Details\"]//../following-sibling::android.view.View/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Enter Your Message\"]//following-sibling::XCUIElementTypeImage")
    protected WebElement sendButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Message Details\"]//../following-sibling::android.widget.ScrollView//android.widget.ImageView[last()]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Details\")]//ancestor::XCUIElementTypeOther[1]//following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeImage[1]")
    protected WebElement message;

    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc, 'Message Details')]//..//../android.widget.ImageView)[last()]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Message Details\"]//preceding::XCUIElementTypeButton")
    protected WebElement backButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Message Centre']//../following-sibling::android.view.View//android.widget.ImageView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name,\"About\") or contains(@name,\"message\")]")
    protected WebElement inboxMessage;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc= 'View Conversation']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name= 'View Conversation']")
    protected WebElement viewConversation;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Message Details\"]//ancestor::android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Details\") or contains(@name,\"Card\")]")
    protected WebElement messageDetails;

    @Override
    protected void waitForAppToLoad() {
    }

    public void clickAddButton() {
        if (new InboxPage().fetchInboxMessage().contains("message")) {
            waitForVisibility(addButtonNoMessage);
            click(addButtonNoMessage, "Clicking on add button");
        } else {
            waitForVisibility(addButton);
            click(addButton, "Clicking on add Button");
        }
    }

    public InboxPage selectNeed(String need) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        String INeedToXpath = "//*[contains(@" + attribute + ", 'need')]/following-sibling::" + parentAttribute + "[1]";
        String selectFromDropDown = "//*[@" + attribute + "='" + need + "']";
        utils.waitForElement(getDriver(), INeedToXpath, 90);
        click(By.xpath(INeedToXpath), "I Need to dropdown is clicked");
        utils.waitForElement(getDriver(), selectFromDropDown, 30);
        click(By.xpath(selectFromDropDown), "option got selected from dropdown");
        return this;
    }

    public void selectAbout(String about) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        String aboutXpath = "//*[contains(@" + attribute + ", 'About')]/following-sibling::" + parentAttribute + "[1]";
        String selectFromDropDown = "//*[@" + attribute + "='" + about + "']";
        utils.waitForElement(getDriver(), aboutXpath, 90);
        click(By.xpath(aboutXpath), "About dropdown is clicked");
        utils.waitForElement(getDriver(), selectFromDropDown, 30);
        click(By.xpath(selectFromDropDown), "option got selected from dropdown");
    }

    public void clickStartChatButton() {
        waitForVisibility(startChatButton);
        click(startChatButton, "Clicking on start chat Button");
    }

    public InboxPage enterMessage(String message) {
        clickAndSendKeys(messageTextField, message, "Entering the message as" + message);
        return this;
    }

    public void clickSendButton() {
        click(sendButton, "Clicking on send Button");
    }

    public String fetchMessage() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }

        waitForVisibility(messageDetails);
        return getTextWithAttribute(message, attribute);
    }

    public void clickBackButton() {
        click(backButton, "Clicking on back Button");
    }

    public String fetchConversationDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getTextWithAttribute(conversationDetails, attribute).toUpperCase();
    }

    public String fetchInboxMessage() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getTextWithAttribute(inboxMessage, attribute);
    }

    public void clickViewConversation() {
        click(viewConversation, "Clicking on view Conversation");
    }

    public String fetchMessageDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(messageDetails);
        return getTextWithAttribute(messageDetails, attribute).toUpperCase();
    }
}
