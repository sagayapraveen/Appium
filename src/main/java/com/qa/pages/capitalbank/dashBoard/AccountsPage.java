package com.qa.pages.capitalbank.dashBoard;

import com.qa.pages.BasePage;
import com.qa.pages.blink.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.qa.engine.ProjectBase.logInfo;

public class AccountsPage extends BasePage {
    @AndroidFindBy(accessibility = "TRANSACTIONS")
    @iOSXCUITFindBy(accessibility = "TRANSACTIONS")
    protected WebElement transactions;
    @AndroidFindBy(accessibility = "Cards")
    @iOSXCUITFindBy(accessibility = "Cards")
    protected WebElement cards;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'CURRENT ACCOUNT')]/android.widget.ImageView[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'ACCOUNT')]//following-sibling::XCUIElementTypeImage[3]")
    protected WebElement rightArrow;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'CURRENT ACCOUNT')]/android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'CURRENT ACCOUNT')]//following-sibling::XCUIElementTypeImage[2]")
    protected WebElement leftArrow;

    @Override
    protected void waitForAppToLoad() {
    }

    public String fetchCurrentAccountDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        scrollUntilElementPresent(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'ACCOUNT BALANCE')]"), "down", 0.5);

        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'ACCOUNT BALANCE')]"),
                attribute);
    }

    public List<String> getAllCurrentAccountDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        List<String> accountsDetails = new ArrayList<>();

        String accountDetails = getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'CURRENT ACCOUNT')]"),
                attribute).replaceAll("\n", " ").toUpperCase(Locale.ROOT);
        String temp = "";
        accountsDetails.add(accountDetails);

        Instant timeout = Instant.now().plusSeconds(90);

        while (!accountDetails.equals(temp)) {
            temp = accountDetails;

            if (getDriver() instanceof IOSDriver)
                tapOnPosition(rightArrow.getLocation().x, rightArrow.getLocation().y);
            else
                click(rightArrow, "Clicking right arrow");

            logInfo("Clicking right arrow");

            accountDetails = getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'CURRENT ACCOUNT')]"),
                    attribute).replaceAll("\n", " ").toUpperCase(Locale.ROOT);

            if (accountDetails.equals(temp))
                break;

            accountsDetails.add(accountDetails);

            if (Instant.now().isAfter(timeout))
                break;
        }
        return accountsDetails;
    }

    public void moveToAccountsTab() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        scrollUntilElementPresent(By.xpath("//" + parentAttribute + "[@" + attribute + "='Accounts']"), "down", 0.3);
    }

    public void backToHome(int size) throws InterruptedException {
        for (int i = 1; i <= size; i++) {
            Thread.sleep(500);
            click(leftArrow, "Clicking left arrow");
        }
    }

    public void selectAccount(String currency) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        String accountDetails = getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'CURRENT ACCOUNT')]"),
                attribute).replaceAll("\n", " ");

        if (!accountDetails.contains("JOD")) {
            leftArrow.click();
            leftArrow.click();
            leftArrow.click();
            leftArrow.click();
        }

        Instant timeout = Instant.now().plusSeconds(180);

        while (!accountDetails.contains(currency)) {
            try {
                waitForVisibility(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'CURRENT ACCOUNT')]"));
            } catch (Exception ignored) {
                // ignore the exception
            }

            accountDetails = getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'CURRENT ACCOUNT')]"),
                    attribute).replaceAll("\n", " ");

            if (accountDetails.contains(currency))
                break;

            if (getDriver() instanceof IOSDriver)
                tapOnPosition(rightArrow.getLocation().x, rightArrow.getLocation().y);
            else
                click(rightArrow, "Clicking right arrow");

            logInfo("Clicking right arrow");

            if (Instant.now().isAfter(timeout)) {
                logInfo(currency + " account is not available");
                break;
            }
        }

        logInfo(currency + " Account has been selected");
    }

    public AccountsPage clickTransactions() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'ACCOUNT BALANCE')]", 60);

        scrollUntilElementPresent(By.xpath("//*[@" + attribute + "='TRANSACTIONS']"), "up", 0.2);

        if (getDriver() instanceof IOSDriver)
            new HomePage().scroll("up", 0.2);

        click(transactions, "Clicking transactions tab");
        click(transactions);
        return this;
    }

    public List<String> getLatestTransactionsEntries() {
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
        List<String> transactions = new ArrayList<>();

        scrollUntilElementPresent(By.xpath("//" + parentAttribute + "[@" + attribute + "='Latest Transactions']"), "up", 0.35, 90);
        String[] values;

        if (getDriver() instanceof AndroidDriver) {
            values = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "='Latest Transactions']/ancestor::" + parentAttribute2))
                    .getAttribute(attribute)
                    .split("\n");
        } else {
            values = getDriver().findElement(By.xpath("//XCUIElementTypeImage[contains(@name,\"Weekly Spending\") or contains(@name,\"due in\")]")).getAttribute("name").split("\n");
        }

        for (String value : values) {
            transactions.add(value.toUpperCase(Locale.ROOT));
        }

        return transactions;
    }
}
