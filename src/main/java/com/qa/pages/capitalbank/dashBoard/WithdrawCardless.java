package com.qa.pages.capitalbank.dashBoard;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.time.Instant;

import static com.qa.engine.ProjectBase.logInfo;

public class WithdrawCardless extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Withdraw')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Withdraw')]")
    protected WebElement clickCardlessWithdraw;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Amount to Withdraw\"]//ancestor::android.widget.ScrollView//following-sibling::android.widget.ImageView[11]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Amount to Withdraw\"]//ancestor::XCUIElementTypeOther[1]/following-sibling::XCUIElementTypeButton[12]")
    protected WebElement clickOk;

    @AndroidFindBy(accessibility = "Confirm")
    @iOSXCUITFindBy(accessibility = "Confirm")
    protected WebElement confirm;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Back to DashBoard\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Dashboard\")]")
    protected WebElement backToDashboard;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,\"Request\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name,\"Request\")]")
    protected WebElement requestMoney;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Date\"]//following-sibling::android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Date\"]//following-sibling::XCUIElementTypeStaticText")
    protected WebElement date;

    @Override
    protected void waitForAppToLoad() {
    }

    public WithdrawCardless openWithdrawCardless() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        logInfo("Clicking the Cardless withdraw menu");
        Instant timeout = Instant.now().plusSeconds(30);
        waitForVisibility(requestMoney);
        Point point = requestMoney.getLocation();
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ", \"Withdraw\")]";

        if (getDriver() instanceof AndroidDriver) {
            while (getDriver().findElements(By.xpath(xpath)).size() == 0) {
                scrollWithCoordinates("left", 0.40, point.x, point.y + 50);

                if (Instant.now().isAfter(timeout))
                    throw new TimeoutException("cardless withdraw menu is not displaying after 30 seconds");
            }
        } else {
            scrollWithCoordinates("left", 0.60, point.x, point.y + 50);
        }
        return this;
    }

    public WithdrawCardless inputAmount(String amount) {
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

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Withdraw Cardless']", 90);

        logInfo("Inputting the amount " + amount);

        char[] charArray = amount.toCharArray();

        if (getDriver() instanceof AndroidDriver) {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='Amount to Withdraw']//../following-sibling::" + parentAttribute2 + ")[10]"));
                else
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='Amount to Withdraw']//../following-sibling::" + parentAttribute2 + ")[" + c + "]"));
            }
        } else {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount to Withdraw\"]//ancestor::XCUIElementTypeOther[1]/following-sibling::XCUIElementTypeButton[11]"));
                else if (c == '.')
                    click(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount to Withdraw\"]//ancestor::XCUIElementTypeOther[1]/following-sibling::XCUIElementTypeButton[10]"));
                else
                    click(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount to Withdraw\"]//ancestor::XCUIElementTypeOther[1]/following-sibling::XCUIElementTypeButton[" + c + "]"));
            }
        }
        return this;
    }

    public void clickOk() {
        click(clickOk);
    }

    public void clickCardlessWithdraw() {
        click(clickCardlessWithdraw, "Clicking card less withdraw.");
    }

    public void confirmPayment() {
        click(confirm, "Confirm the payment");
    }

    public StringBuilder fetchSuccessMessage(String name) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", '" + name + "')]", 90);
        StringBuilder message = new StringBuilder();
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
                        .getAttribute(attribute)).append("\n");
        return message;
    }

    public void backToDashboard() {
        if (getDriver() instanceof AndroidDriver)
            waitForVisibility(backToDashboard);
        else
            utils.waitForElement(getDriver(), "//XCUIElementTypeButton[contains(@name,\"Dashboard\")]", 30);
        click(backToDashboard, "Click the Back To Dashboard button");
    }

    public String confirmPageDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", \"Amount\")]"), attribute);
    }

    public String successMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Withdraw cardless is successfull!\"]", 30);
        return getAttribute(date, attribute);
    }
}