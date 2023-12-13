package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.time.Instant;

import static com.qa.engine.ProjectBase.logInfo;

public class RequestMoneyPage extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Back to Payments']/android.view.View/android.view.View[2]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Back to Payments']/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    protected WebElement accountField;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Swipe down')]/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'Swipe down')]/XCUIElementTypeImage")
    protected WebElement select;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Edit']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Edit']")
    protected WebElement editButton;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Back to Payments')]/android.widget.ImageView[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Back to Payments')]/XCUIElementTypeImage[3]")
    protected WebElement editProceedPayment;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Edit Transaction Purpose')]/android.widget.ImageView[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'Edit Transaction Purpose')]/XCUIElementTypeImage[3]")
    protected WebElement doneEditPayment;

    @Override
    protected void waitForAppToLoad() {
    }

    public RequestMoneyPage sendAccountNo(String data) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        String accountXpath = "//" + parentAttribute + "[@" + attribute + "='Back to Payments']/" + parentAttribute + "/" + parentAttribute + "[2]";
        utils.waitForElement(getDriver(), accountXpath, 30);
        clickAndSendKeys(accountField, data, "Account number has been entered as " + data);
        new Actions(getDriver()).sendKeys(Keys.TAB)
                .perform();
        return this;
    }

    public RequestMoneyPage sendPurpose(String purpose) throws InterruptedException {
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
        String purposeXpath = "//" + parentAttribute + "[@" + attribute + "='Name']/following-sibling::" + parentAttribute2 + "[1]";
        String purposeDropDown = "//" + parentAttribute + "[@" + attribute + "='" + purpose + "']";
        utils.waitForElement(getDriver(), purposeXpath, 90);
        click(By.xpath(purposeXpath), "Purpose dropdown is clicked");
        click(By.xpath(purposeDropDown));
        click(select, "purpose got selected");
        return this;
    }

    public RequestMoneyPage sendPurposeDetails(String purposeDetails) {
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
        String purposeDetailXpath = "//" + parentAttribute + "[@" + attribute + "='Name']/following-sibling::" + parentAttribute2 + "[2]";
        String purposeDetailDropDown = "//" + parentAttribute + "[contains(@" + attribute + ",'" + purposeDetails + "')]";
        utils.waitForElement(getDriver(), purposeDetailXpath, 90);
        click(By.xpath(purposeDetailXpath), "Purpose dropdown is clicked");
        click(By.xpath(purposeDetailDropDown));
        click(select, "purpose got selected");
        return this;
    }

    public String accountName(String name) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        By xpath = By.xpath("//" + parentAttribute + "[@" + attribute + "='" + name + "']");
        return getAttribute(xpath, attribute);
    }

    public String statusMessage() {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Requested')]/" + parentAttribute2 + "[1]", 30);
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'Requested')]"), attribute);
    }

    public RequestMoneyPage editPurpose(String purpose) throws InterruptedException {
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
        String purposeXpath = "//" + parentAttribute + "[contains(@" + attribute + ",'Purpose')]/" + parentAttribute2 + "[1]";
        String purposeDropDown = "//" + parentAttribute + "[@" + attribute + "='" + purpose + "']";
        utils.waitForElement(getDriver(), purposeXpath, 90);
        click(By.xpath(purposeXpath), "Purpose dropdown is clicked");
        click(By.xpath(purposeDropDown));
        click(select, "purpose got selected");
        return this;
    }

    public RequestMoneyPage editPurposeDetails(String purposeDetails) {
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
        String purposeDetailXpath = "//" + parentAttribute + "[contains(@" + attribute + ",'Purpose')]/" + parentAttribute2 + "[2]";
        String purposeDetailDropDown = "//" + parentAttribute + "[contains(@" + attribute + ",'" + purposeDetails + "')]";
        utils.waitForElement(getDriver(), purposeDetailXpath, 90);
        click(By.xpath(purposeDetailXpath), "Purpose dropdown is clicked");
        click(By.xpath(purposeDetailDropDown));
        click(select, "purpose got selected");
        return this;
    }

    public RequestMoneyPage editButton() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Edit']", 30);
        click(editButton, "Selecting Edit button");
        return this;
    }

    public RequestMoneyPage enterMoney(String amount) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='1']", 30);
        char[] charArray = amount.toCharArray();
        for (char c : charArray) {
            click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + c + "']"));
        }

        logInfo("Entering the amount" + amount);
        return this;
    }

    public void editProceedPayment() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.widget.ImageView";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeImage";
        }
        utils.waitForElement(getDriver(), "//*[contains(@" + attribute + ", 'Back to Payments')]/" + parentAttribute + "[3]", 60);
        click(editProceedPayment, "Proceeding bill payment");
    }

    public void selectExistingRequestMoneyPayee(String name) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        String value = "//" + parentAttribute + "[contains(@" + attribute + ",'" + name + "')]";
        utils.waitForElement(getDriver(), value, 30);
        click(By.xpath(value), "Existing Payee has been selected as " + name);
    }

    public void doneEditPayment() {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Edit Transaction Purpose')]/" + parentAttribute2 + "[3]", 30);
        click(doneEditPayment, "Clicking done edit payment");
    }

    public String dashboard() throws InterruptedException {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        Instant timeout = Instant.now().plusSeconds(120);
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",\"Total Balance\")]";

        Dimension point = getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"Requested\")]")).getSize();

        logInfo(point.height + " height");
        logInfo(point.width + " width");

        int x = point.width / 2;
        int y = point.height;

        while (getDriver().findElements(By.xpath(xpath)).size() == 0) {
            tapOnPosition(x, y);

            Thread.sleep(1000);
            scroll("left", 0.5);

            y = y - 10;
            logInfo(y + " is height");

            if (getDriver().findElements(By.xpath(xpath)).size() == 1)
                break;

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException("App not loaded after waited for 120 seconds");
        }
        return getAttribute(By.xpath(xpath), "content-desc");
    }

    public String getAttributePurposeDetails() {
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
        String xpath = "//" + parentAttribute + "[@" + attribute + "='Name']/following-sibling::" + parentAttribute2 + "[2]";
        utils.waitForElement(getDriver(), xpath, 30);
        return getAttribute(By.xpath(xpath), "focused");
    }
}