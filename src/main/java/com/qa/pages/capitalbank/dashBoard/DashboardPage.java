package com.qa.pages.capitalbank.dashBoard;

import com.qa.pages.BasePage;
import com.qa.pages.blink.HomePage;
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

public class DashboardPage extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Accounts']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Accounts']")
    protected WebElement account;
    @AndroidFindBy(accessibility = "Cards")
    @iOSXCUITFindBy(accessibility = "Cards")
    protected WebElement cards;
    @AndroidFindBy(accessibility = "Term Deposits")
    @iOSXCUITFindBy(accessibility = "Term Deposits")
    protected WebElement termDeposit;
    @AndroidFindBy(accessibility = "Overdrafts")
    @iOSXCUITFindBy(accessibility = "Overdrafts")
    protected WebElement overdrafts;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Pay')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Pay')]")
    protected WebElement payBill;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='View Portfolio']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='View Portfolio']")
    protected WebElement viewPortfolio;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,\"Request\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name,\"Request\")]")
    protected WebElement requestMoney;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Letter')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Letter')]")
    protected WebElement letterOfGuarantee;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Share My IBAN to Social Security Corp\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Share My IBAN to Social Security Corp\"]")
    protected WebElement ibanLink;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Done\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    protected WebElement done;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Good')]/following-sibling::android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Good')]/following-sibling::XCUIElementTypeImage")
    protected WebElement messageButton;

    public DashboardPage() {
        waitForAppToLoad();
    }

    @Override
    protected void waitForAppToLoad() {
    }

    public void clickCards() {
        click(cards, "Clicking on cards");
    }

    public void clickPayBill() {
        waitForVisibility(payBill);
        click(payBill, "Clicking on the Pay Bill Button");
    }

    public void clickAccount() {
        waitForVisibility(account);
        click(account, "Clicking on the account Button");
    }

    public void clickTermsDeposits() {
        waitForVisibility(cards);
        Point point = cards.getLocation();
        scrollWithCoordinates("left", 0.50, point.x, point.y);
        waitForVisibility(termDeposit);
        click(termDeposit, "Clicking on Term Deposits menu");
    }

    public String getDashboardPage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Accounts']", 90);
        return getTextWithAttribute(account, attribute);
    }

    public void clickOnAccountMenu() {
        waitForVisibility(overdrafts);
        Point point = overdrafts.getLocation();
        scrollWithCoordinates("right", 0.85, point.x + 100, point.y);
        waitForVisibility(account);
        click(account, "Clicking on account menu");
    }

    public String accountDetails(String type) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", \"DETAILS\")]", 45);

        if (type.equalsIgnoreCase("DEPOSIT"))
            return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"Number\")]"), attribute).replaceAll("\n", " ").split("Number")[1].split(" ")[0];
        else
            return getAttribute(By.xpath("//*[contains(@" + attribute + ",\"No.\")]"), attribute).replaceAll("\n", " ").split("No.")[1].split(" ")[1];
    }

    public void viewPortfolio() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"View Portfolio\"]", 30);
        click(viewPortfolio, "clicking view portfolio button");
    }

    public String getCard(String account, String currency) {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Select\")]", 30);

        By type = By.xpath("//" + parentAttribute2 + "[contains(@" + attribute + ",'" + account.toUpperCase() + "') and contains(@" + attribute + ",'" + currency + "')]");

        scrollUntilElementPresent(type, "up", 0.50);
        return getAttribute(type, attribute);
    }

    public void selectCard(String account, String currency) {
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute2 = "XCUIElementTypeImage";
            attribute = "name";
        }
        By type = By.xpath("//" + parentAttribute2 + "[contains(@" + attribute + ",'" + account.toUpperCase() + "') and contains(@" + attribute + ",'" + currency + "')]");

        scrollUntilElementPresent(type, "up", 0.50);
        click(type, "Clicking " + account + " card");
    }

    public String shareMyAccountLink() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        By xpath = By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Share My Account Number\"]");
        scrollUntilElementPresent(xpath, "up", 0.50);
        return getAttribute(xpath, attribute);
    }

    public String shareMyIBANLink() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Share My IBAN to Social Security Corp\"]"), attribute);
    }

    public boolean openATMBranches() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        logInfo("Clicking the ATM/Branches menu");
        Instant timeout = Instant.now().plusSeconds(30);

        waitForVisibility(requestMoney);
        Point point = requestMoney.getLocation();
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ", \"ATM\")]";

        while (getDriver().findElements(By.xpath(xpath)).size() == 0) {
            scrollWithCoordinates("left", 0.40, point.x, point.y + 50);

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException("ATM/Branches menu is not displaying after 30 seconds");
        }
        return true;
    }

    public void clickOverdraftMenu() {
        waitForVisibility(cards);
        Point point = cards.getLocation();
        scrollWithCoordinates("left", 0.50, point.x, point.y);
        waitForVisibility(overdrafts);
        click(overdrafts, "Clicking on overdraft menu");
    }

    public void clickOnLetterOfGuarantee() {
        waitForVisibility(requestMoney);
        Point point = requestMoney.getLocation();
        scrollWithCoordinates("left", 0.70, point.x, point.y + 100);
        scrollWithCoordinates("left", 0.70, point.x, point.y + 100);
        waitForVisibility(letterOfGuarantee);
        click(letterOfGuarantee, "Clicking on letter Of Guarantee menu");
    }

    public String request(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Cheque\"]", 180);
        if (getDriver() instanceof AndroidDriver)
            return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + value.toUpperCase() + "']"), attribute);
        else
            return getAttribute(By.xpath("//XCUIElementTypeStaticText[@" + attribute + "='" + value.toUpperCase() + "']"), attribute);
    }

    public String postDated(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + value.toUpperCase() + "']"), attribute);
    }

    public void clickMyIBANLink() {
        click(ibanLink, "Clicking IBAN Link");
    }

    public String successMessageIBANLink(String message) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",\"successfully!\")]";
        utils.waitForElement(getDriver(), xpath, 30);
        return getAttribute(By.xpath(xpath), attribute);
    }

    public void done() {
        click(done, "Clicking on done button");
    }

    public void clickOnMessageButton() {
        click(messageButton, "Clicking on message Button");
    }

    public void openQRPay() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        waitForVisibility(requestMoney);
        Point point = requestMoney.getLocation();
        Instant timeout = Instant.now().plusSeconds(30);
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",'QR')]";

        if (getDriver() instanceof AndroidDriver) {
            while (getDriver().findElements(By.xpath(xpath)).size() == 0) {
                scrollWithCoordinates("left", 0.40, point.x, point.y + 50);

                if (Instant.now().isAfter(timeout))
                    throw new TimeoutException("QR Pay menu is not displaying after 30 seconds");
            }
        } else {
            scrollWithCoordinates("left", 0.60, point.x, point.y + 50);
            scrollWithCoordinates("left", 0.60, point.x, point.y + 50);
        }

        click(By.xpath(xpath), "Clicking the QR Pay menu");
    }

    public void closeButton() {
        Instant timeout = Instant.now().plusSeconds(45);
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.Button";
            attribute = "content-desc";
            if (getDriver().findElements(By.id("com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button")).size() > 0)
                getDriver().findElement(By.id("com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button")).click();
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeButton";
            attribute = "name";
        }

        String errorXpath = "//" + parentAttribute2 + "[contains(@" + attribute + ", 'Permission')]";
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",\"QR Pay\")]/" + parentAttribute2;

        if (getDriver() instanceof AndroidDriver) {
            while (getDriver().findElements(By.xpath(errorXpath)).size() > 0) {
                if (Instant.now().isAfter(timeout))
                    throw new TimeoutException();
            }

            if (getDriver().findElements(By.xpath(errorXpath)).size() == 0) {
                click(By.xpath(xpath), "Clicking close button in QR Pay");
            }
        } else {
            new HomePage().tapOnPosition(367, 72);
        }

    }

    public boolean displayQRPay() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        Instant timeout = Instant.now().plusSeconds(30);

        waitForVisibility(requestMoney);
        Point point = requestMoney.getLocation();
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ", \"QR\")]";

        while (getDriver().findElements(By.xpath(xpath)).size() == 0) {
            scrollWithCoordinates("left", 0.40, point.x, point.y + 50);

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException("QR Pay menu is not displaying after 30 seconds");
        }
        return true;
    }
}