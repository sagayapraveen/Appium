package com.qa.pages.capitalbank.cards;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.qa.engine.ProjectBase.logInfo;

public class WithdrawPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Withdraw')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Withdraw')]")
    protected WebElement withdraw;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Payment Details']/following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Payment Details']/following-sibling::XCUIElementTypeTextField")
    protected WebElement paymentDetails;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'BALANCE')][1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'BALANCE')][1]")
    protected WebElement withdrawToCard;

    public WithdrawPage() {
        waitForAppToLoad();
    }

    public String fetchPageName(String PageName) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='" + PageName + "']", 60);
        return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "= '" + PageName + "']"), attribute);
    }

    public void clickOnWithdraw() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='CARD DETAILS']", 60);
        click(withdraw, "Clicking on Withdraw");
    }

    public void clickOnWithdrawTo() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Select Account']", 60);
        click(withdrawToCard, "Clicking on WithdrawTo");
    }

    public void enterPaymentDetails(String details) {
        clickAndSendKeys(this.paymentDetails, details, "entered the payment description" + details);
    }

    public float withdrawFromDetails() {
        String value = new CardPage().fetchVirtualCardDetails().split(" ")[4];
        String amount = value.replace("BALANCE\n", "");
        float balanceAmount = 0;

        balanceAmount = Float.parseFloat(amount.trim());

        logInfo("Withdrawal amount limit in the card is " + balanceAmount);
        return balanceAmount;
    }

    public WithdrawPage setAmount(String Name, float value) {
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
        String amount = String.valueOf(value);
        logInfo("Inputting the amount " + amount);
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='" + Name + "']", 90);
        char[] charArray = amount.toCharArray();
        if (getDriver() instanceof AndroidDriver) {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + Name + "']//../following-sibling::" + parentAttribute2 + "[11]"));
                else if (c == '.')
                    click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + Name + "']//../following-sibling::" + parentAttribute2 + "[10]"));
                else
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='" + Name + "']//../following-sibling::" + parentAttribute2 + ")[" + c + "]"));
            }
        } else {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]/following-sibling::XCUIElementTypeButton[11]"));
                else if (c == '.')
                    click(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]/following-sibling::XCUIElementTypeButton[10]"));
                else
                    click(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]/following-sibling::XCUIElementTypeButton[" + c + "]"));
            }

        }
        return this;
    }

    @Override
    public void waitForAppToLoad() {
    }
}