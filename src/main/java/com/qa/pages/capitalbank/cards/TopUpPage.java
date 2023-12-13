package com.qa.pages.capitalbank.cards;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.time.Instant;
import java.util.List;

import static com.qa.engine.ProjectBase.logInfo;

public class TopUpPage extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Amount']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Amount']/following-sibling::XCUIElementTypeOther[1]")
    protected WebElement amount;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Next')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Next')]")
    protected WebElement next;

    @AndroidFindBy(accessibility = "Confirm")
    @iOSXCUITFindBy(accessibility = "Confirm")
    protected WebElement confirm;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Top up failed!']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Top up failed!']")
    protected WebElement topUpMessage;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Top Up To']//following-sibling::android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Top Up To']//following-sibling::XCUIElementTypeOther[2]")
    protected WebElement totalBalance;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'VIRTUAL')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'VIRTUAL')]")
    protected WebElement virtualCard;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Withdraw']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='Withdraw']")
    protected WebElement withdraw;

    public TopUpPage() {
        waitForAppToLoad();
    }

    public void clickOnVirtualCard() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'VIRTUAL')]", 90);
        click(virtualCard, "Clicking on Virtual CardButton");
    }

    public void clickOnWithdraw() {
        click(withdraw, "Clicking on Withdraw Button");
    }

    public void clickOnNext() {
        click(next, "Clicking on Next");
    }

    public void clickOnConfirm() {
        waitForVisibility(confirm);
        click(confirm, "Clicking on Confirm Button");
    }

    public TopUpPage setAmount(String amount, String name) {
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

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='" + name + "']", 90);
        logInfo("Inputting the amount " + amount);
        char[] charArray = amount.toCharArray();
        if (getDriver() instanceof AndroidDriver) {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + name + "']//../following-sibling::" + parentAttribute2 + "[11]"));
                else if (c == '.')
                    click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + name + "']//../following-sibling::" + parentAttribute2 + "[10]"));
                else
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='" + name + "']//../following-sibling::" + parentAttribute2 + ")[" + c + "]"));
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

    public String fetchTopUpCardDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getAttribute(By.xpath("//*[contains(@" + attribute + ", 'BALANCE')]"), attribute);
    }

    public void clickTopUpFromCard() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'CURRENT')]"));
    }


    public String fetchFailedMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Top up failed!']", 60);
        return getTextWithAttribute(topUpMessage, attribute);
    }

    public void clickOk(String name) {
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
        if (getDriver() instanceof AndroidDriver)
            click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + name + "']//../following-sibling::" + parentAttribute2 + " [12]"));
        else
            click(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]/following-sibling::XCUIElementTypeButton[12]"));
        logInfo("Clicking on OK for " + name);
    }

    public String fetchTotalBalance() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Confirm Top Up']", 90);
        return getTextWithAttribute(totalBalance, attribute);
    }

    public StringBuilder fetchSuccessMessage(String name) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", '" + name + "')]", 90);
        StringBuilder message = new StringBuilder();
        if (getDriver() instanceof AndroidDriver) {
            message.append(getDriver().findElement(By.xpath("(//" + parentAttribute + "[contains(@" + attribute + ", '" + name + "')]//..//" + parentAttribute + ")[2]"))
                            .getAttribute(attribute)).append("-")
                    .append(getDriver().findElement(By.xpath("(//" + parentAttribute + "[contains(@" + attribute + ", '" + name + "')]//..//" + parentAttribute + ")[3]"))
                            .getAttribute(attribute)).append("\n")
                    .append(getDriver().findElement(By.xpath("(//" + parentAttribute + "[contains(@" + attribute + ", '" + name + "')]//..//" + parentAttribute + ")[4]"))
                            .getAttribute(attribute)).append("-")
                    .append(getDriver().findElement(By.xpath("(//" + parentAttribute + "[contains(@" + attribute + ", '" + name + "')]//..//" + parentAttribute + ")[5]"))
                            .getAttribute(attribute)).append("\n")
                    .append(getDriver().findElement(By.xpath("(//" + parentAttribute + "[contains(@" + attribute + ", '" + name + "')]//..//" + parentAttribute + ")[6]"))
                            .getAttribute(attribute)).append("-")
                    .append(getDriver().findElement(By.xpath("(//" + parentAttribute + "[contains(@" + attribute + ", '" + name + "')]//..//" + parentAttribute + ")[7]"))
                            .getAttribute(attribute)).append("\n")
                    .append(getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + name + " successful!']//..//following-sibling::" + parentAttribute + "[1]"))
                            .getAttribute(attribute)).append("\n");
        } else {
            List<WebElement> values = getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Top up successful!\"]//following-sibling::XCUIElementTypeStaticText"));
            values.stream().forEach((m) -> message.append(m.getAttribute("name") + " "));
        }

        logInfo(message);
        return message;
    }

    public void selectTopUPFromCard(String accountNumber) {
        int count = 0;
        Instant timeout = Instant.now().plusSeconds(90);

        while (count < 5) {
            String cardValue = new TopUpPage().fetchTopUpCardDetails();
            logInfo("The card type is " + cardValue);

            if (cardValue.contains(accountNumber)) {
                new TopUpPage().clickTopUpFromCard();
                break;
            } else {
                new CardPage().clickOnCardForward();
            }
            count++;

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException();
        }
    }

    public void selectCard(String cardName) throws InterruptedException {
        int count = 0;
        while (count < 5) {
            String cardValue = new CardPage().fetchVirtualCardDetails();
            logInfo("The card type is " + cardValue);
            if (cardValue.contains(cardName)) {
                new CardPage().clickOnCard();
                break;
            } else {
                new CancelCardPage().clickOnForwardArrow();
            }
            count++;
        }
    }

    @Override
    public void waitForAppToLoad() {

    }
}