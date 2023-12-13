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
import org.openqa.selenium.interactions.Actions;

public class DebitCard extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Debit\") or contains(@content-desc,\"Credit\")]/android.widget.ImageView[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Debit\") or contains(@name,\"Credit\")]//following-sibling::XCUIElementTypeImage[3]")
    protected WebElement settingsIcon;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Freeze this card?\"]//following-sibling::android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Freeze this card?\"]//following-sibling::XCUIElementTypeImage")
    protected WebElement freezeDone;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Manage card limits\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Manage card limits\"]")
    protected WebElement manageCardLimit;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Unblock PIN?\"]//following-sibling::android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Unblock PIN?\"]//following-sibling::XCUIElementTypeImage")
    protected WebElement pinDone;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Report stolen or lost card\"]//following-sibling::android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Report stolen or lost card\"]//following-sibling::XCUIElementTypeImage")
    protected WebElement reportStolenDone;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Cancel\")]//following-sibling::android.view.View/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Cancel\")]//following-sibling::XCUIElementTypeOther/XCUIElementTypeImage")
    protected WebElement dropDownCancelCard;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Reason\")]/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Reason\")]/XCUIElementTypeImage")
    protected WebElement doneDropDown;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Cancel\")]//following-sibling::android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Cancel\")]//following-sibling::XCUIElementTypeOther[2]")
    protected WebElement cancelCardTerms;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Cancel\")]//following-sibling::android.widget.ImageView[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Cancel\")]//following-sibling::XCUIElementTypeImage[3]")
    protected WebElement cancelCardDone;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Report\")]//following-sibling::android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Report\")]//following-sibling::XCUIElementTypeImage")
    protected WebElement reportCardDone;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Flip\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Flip\")]")
    protected WebElement flip;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Add money\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Add money\"]")
    protected WebElement addMoney;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Request money\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Request money\"]")
    protected WebElement requestMoney;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Request physical card\"]//following-sibling::android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Request physical card\"]//following-sibling::XCUIElementTypeImage")
    protected WebElement requestPhysicalCard;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Request money\"]//ancestor::android.view.View/android.widget.ImageView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Request money\"]//ancestor::XCUIElementTypeOther/XCUIElementTypeImage[1]")
    protected WebElement backButton;

    @Override
    protected void waitForAppToLoad() {
    }

    public void swipeToDebitCard() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Total Balance\")]", 30);
        scroll("left", 0.75);
        scroll("left", 0.75);
    }

    public void settingsIcon() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Debit\") or contains(@" + attribute + ",\"Credit\")]", 30);
        click(settingsIcon, "Clicking settings icon");
    }

    public void freezeCard(String value) {
        By freezeToggle;
        if (getDriver() instanceof AndroidDriver)
            freezeToggle = By.xpath("//XCUIElementTypeImage[@name=\"Freeze this card\"]//XCUIElementTypeOther");
        else
            freezeToggle = By.xpath("//XCUIElementTypeImage[@name=\"Freeze this card\"]//following-sibling::XCUIElementTypeStaticText");

        if (value.equalsIgnoreCase("Enable")) {
            if (getAttribute(freezeToggle, "content-desc").equalsIgnoreCase("NO")) {
                click(freezeToggle, "Clicking freeze this card");
                click(freezeDone, "Clicking done button");
            }
        } else if (value.equalsIgnoreCase("Disable")) {
            if (getAttribute(freezeToggle, "content-desc").equalsIgnoreCase("YES"))
                click(freezeToggle, "Clicking unfreeze this card");
        }
    }

    public String cardValue() {
        String attribute = "";
        By freezeToggle;
        if (getDriver() instanceof AndroidDriver)
            freezeToggle = By.xpath("//XCUIElementTypeImage[@name=\"Freeze this card\"]//XCUIElementTypeOther");
        else
            freezeToggle = By.xpath("//XCUIElementTypeImage[@name=\"Freeze this card\"]//following-sibling::XCUIElementTypeStaticText");

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(freezeToggle);
        if (getAttribute(freezeToggle, attribute).equals("YES"))
            return "enabled";
        else
            return "disabled";
    }

    public void manageCardLimit() {
        click(manageCardLimit, "Clicking manage card limit");
    }

    public void editAmount(String value, String type, String card) {
        String attribute = "";
        String parentAttribute = "";
        String parentAttribute2 = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeStaticText";
            parentAttribute2 = "XCUIElementTypeTextField";
        }
        utils.waitForElement(getDriver(), By.xpath("//*[@" + attribute + "=\"Manage card limits\"])]"), 60);

        String textXpath = "";
        String toggleXpath = "";
        if (type.equalsIgnoreCase("Merchant Payments") && card.equalsIgnoreCase("Credit")) {
            textXpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + type + "')]//following-sibling::" + parentAttribute2 + "[2]";
            toggleXpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + type + "')]//following-sibling::" + parentAttribute + "[2]";
        } else {
            textXpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + type + "')]//following-sibling::" + parentAttribute2 + "[1]";
            toggleXpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + type + "')]//following-sibling::" + parentAttribute + "[1]";
        }

        By toggle = By.xpath(toggleXpath);
        By text = By.xpath(textXpath);

        if (getAttribute(toggle, attribute).equalsIgnoreCase("NO"))
            click(toggle, "Clicking" + type + "Toggle");

        if (!(value.equals(getAttribute(text, "text")))) {
            click(text);
            getDriver().findElement(text).clear();
            clickAndSendKeys(text, value, value + " is entered");
            Dimension point = getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"changes\")]")).getSize();
            tapOnPosition(point.width / 2, point.height - 75);
        }

    }

    public void amountExceedsLimit(String value, String type, String card) {
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
        utils.waitForElement(getDriver(), By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Manage card limits\"])]"), 60);
        String textXpath = "";
        String toggleXpath = "";
        if (type.equalsIgnoreCase("Merchant Payments") && card.equalsIgnoreCase("Credit")) {
            textXpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + type + "')]//following-sibling::" + parentAttribute2 + "[2]";
            toggleXpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + type + "')]//following-sibling::" + parentAttribute + "[2]";
        } else {
            textXpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + type + "')]//following-sibling::" + parentAttribute2 + "[1]";
            toggleXpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + type + "')]//following-sibling::" + parentAttribute + "[1]";
        }

        By toggle = By.xpath(toggleXpath);
        By text = By.xpath(textXpath);
        if (getAttribute(toggle, attribute).equalsIgnoreCase("NO"))
            click(toggle, "Clicking ATM Toggle");

        if (!(value.equals(getAttribute(text, "text")))) {
            click(text);
            getDriver().findElement(text).clear();
            clickAndSendKeys(text, value);
        }
    }

    public String getAmount(String type) {
        String attribute = "";
        String parentAttribute = "";
        String parentAttribute2 = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeStaticText";
            parentAttribute2 = "XCUIElementTypeTextField";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'" + type + "')]//following-sibling::" + parentAttribute2 + "[1]", 30);
        return getAttribute(By.xpath(
                "//" + parentAttribute + "[contains(@" + attribute + ",'" + type + "')]//following-sibling::" + parentAttribute2 + "[1]"), "text");
    }

    public String atmToggle(String type) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeStaticText";
        }
        utils.waitForElement(getDriver(), "//*[@" + attribute + "='" + type + "']", 30);
        return getAttribute(By.xpath(
                "//" + parentAttribute + "[@" + attribute + "='" + type + "']//following-sibling::" + parentAttribute + "[1]"), attribute);
    }

    public void debitMenu(String value) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.widget.ImageView";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeImage";
        }
        String xpath = "//" + parentAttribute + "[@" + attribute + "='" + value + "']";
        click(By.xpath(xpath), "Clicking manage card PIN");

        if (value.equalsIgnoreCase("Unblock card PIN"))
            click(pinDone, "Clicking done button in unblock PIN");

        if (value.equalsIgnoreCase("Report stolen or lost card"))
            click(reportStolenDone, "Clicking done button in Report stolen or lost card");

        if (value.equalsIgnoreCase("Replace damaged Card"))
            click(reportCardDone, "Clicking done button in report damaged card");

        if (value.equalsIgnoreCase("Request physical card"))
            click(requestPhysicalCard, "Clicking Request physical card");
    }

    public String managePinMessage(String value) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.widget.ImageView";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'" + value + "')]"), attribute);
    }

    public void yourCardPage() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Your\")]", 10);
        scroll("left", 0.5);
    }

    public DebitCard setPin(String value) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"4-digit PIN\")]", 10);

        Point point = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"DEBIT CARD\"]//ancestor::" + parentAttribute + "[1]/" + parentAttribute + "/" + parentAttribute + "//" + parentAttribute + "[2]//" + parentAttribute + "//" + parentAttribute)).getLocation();

        tapOnPosition(point.x + 100, point.y + 50);

        new Actions(getDriver()).sendKeys(value).perform();

        scroll("left", 0.50);

        return this;
    }

    public void confirmPin(String value) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Now\")]", 10);

        Point point = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"DEBIT CARD\"]//ancestor::" + parentAttribute + "[1]/" + parentAttribute + "/" + parentAttribute + "//" + parentAttribute + "[2]//" + parentAttribute + "//" + parentAttribute)).getLocation();

        tapOnPosition(point.x + 100, point.y + 50);

        new Actions(getDriver()).sendKeys(value).perform();

        scroll("left", 0.50);
    }

    public String reportCardMessage() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        String xpath = "//" + parentAttribute + "[@" + attribute + "=\"Your card is ready!\"]";

        utils.waitForElement(getDriver(), xpath, 30);

        return getAttribute(By.xpath(xpath), attribute);
    }

    public String debitCard() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"Debit Card\")]"), attribute);
    }

    public DebitCard selectReasonForCancel(String value) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }

        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + value + "')]";
        click(dropDownCancelCard, "Clicking drop down for cancel card");
        click(By.xpath(xpath), "Selecting " + value);
        click(doneDropDown, "Clicking done button in reasons page");
        return this;
    }

    public DebitCard cancelCardTerms() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Cancel\")]//following-sibling::" + parentAttribute + "[2]", 25);
        click(cancelCardTerms, "Clicking Terms");
        return this;
    }

    public void cancelCardDone() {
        click(cancelCardDone, "Clicking done button");
    }

    public void clickAction(String value) {
        if (value.contains("Flip"))
            click(flip, "Clicking flip link");
        else if (value.equalsIgnoreCase("Add money"))
            click(addMoney, "Clicking add money");
        else if (value.equalsIgnoreCase("Request money"))
            click(requestMoney, "Clicking request money");
    }

    public String accountDetails() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"LINKED ACCOUNT NUMBER\")]"), attribute);
    }

    public void backButton() {
        click(backButton, "Clicking back button");
    }

    public String requestMoney() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Request money\"]", 30);
        return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Request money\"]"), attribute);

    }

    public String addMoneyMessage(String value) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'" + value + "')]"),
                attribute).replaceAll("\n", " ");
    }
}