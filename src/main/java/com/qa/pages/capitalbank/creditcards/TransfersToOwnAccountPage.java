package com.qa.pages.capitalbank.creditcards;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.qa.engine.ProjectBase.logInfo;

public class TransfersToOwnAccountPage extends BasePage {
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Transfer to Own Account']//../following-sibling::android.widget.ImageView)[12]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[12]")
    protected WebElement selectOk;
    @AndroidFindBy(xpath = "//android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    protected WebElement description;

    @Override
    protected void waitForAppToLoad() {
    }

    public TransfersToOwnAccountPage setTransferAmount(String amount) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Transfer to Own Account']", 90);
        logInfo("Inputting the amount " + amount);
        char[] charArray = amount.toCharArray();
        if (getDriver() instanceof AndroidDriver) {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='Transfer to Own Account']//../following-sibling::" + parentAttribute2 + ")[11]"));
                else
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='Transfer to Own Account']//../following-sibling::" + parentAttribute2 + ")[" + c + "]"));
            }
        } else {
            for (char c : charArray) {
                if (c == '0')
                    getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[11]")).get(0).click();
                else if (c == '.')
                    getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[10]")).get(0).click();
                else
                    getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[" + c + "]")).get(0).click();
            }
        }
        return this;
    }

    public void selectOk() {
        if (getDriver() instanceof AndroidDriver)
            click(selectOk);
        else
            getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[12]")).get(0).click();
    }

    public void setDescription() {
        sendKeys(description, "Automation" + utils.getRandomString(4));
    }

    public String fetchPayToAccountBalance() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "='Pay to']/following-sibling::" + parentAttribute + "[@" + attribute + "='TOTAL ACCOUNT BALANCE']/following-sibling::" + parentAttribute + "[1]"), attribute);
    }
}
