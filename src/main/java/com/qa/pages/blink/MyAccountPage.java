package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class MyAccountPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"HOME\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"HOME\"]")
    protected WebElement homeButton;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'My Account')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'My Account')]")
    protected WebElement myAccountDetails;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Debit Card')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Debit Card')]")
    protected WebElement accountActivationDate;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'My Account')]/android.widget.ImageView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'My Account')]/XCUIElementTypeImage[1]")
    protected WebElement refreshButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Add money\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Add money\"]")
    protected WebElement addMoneyButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Transaction History\"]/android.view.View[1]/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Transaction History\"]/XCUIElementTypeOther[1]/XCUIElementTypeImage")
    protected WebElement searchButton;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'ATM')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'ATM')]")
    protected WebElement transactionHistory;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Transaction History']/android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Transaction History']/XCUIElementTypeImage[2]")
    protected WebElement transactionPeriodButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Transaction History\"]/android.widget.ImageView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Transaction History\"]/XCUIElementTypeImage[1]")
    protected WebElement downloadButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Download Statement']/android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Download Statement']/XCUIElementTypeOther")
    protected WebElement selectMonth;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Statement')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Statement')]")
    protected WebElement accountStatement;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Request money from']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Request money from']")
    protected WebElement requestMoneyPage;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Download Statement\"]/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@nmae=\"Download Statement\"]/XCUIElementTypeImage")
    protected WebElement clickOnOkButton;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Statement')]/android.widget.ImageView[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Statement')]/XCUIElementTypeImage[3]")
    protected WebElement okButton;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Ways')]//ancestor::android.view.View[1]/android.widget.ImageView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Ways')]//ancestor::XCUIElementTypeOther[1]/XCUIElementTypeImage[1]")
    protected WebElement backButton;

    @Override
    protected void waitForAppToLoad() {
    }

    public void homeButton() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.widget.ImageView";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeImage";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"HOME\"]", 60);
        click(homeButton, "Clicking home button ");
    }

    public String getAccountDetails() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'My Account')]", 60);
        return getTextWithAttribute(myAccountDetails, attribute).replaceAll("\n", " ");
    }

    public String getAccountActivationDate() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Debit Card')]", 60);
        return getTextWithAttribute(accountActivationDate, attribute);
    }

    public void clickOnRefresh() {
        waitForVisibility(refreshButton);
        click(refreshButton, "Clicking on refresh button");
    }

    public void clickOnAddMoney() {
        waitForVisibility(addMoneyButton);
        click(addMoneyButton, "Clicking in add money");
    }

    public void clickOnRequestMoney(String money) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Ways to add')]", 60);
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "= '" + money + "']"), "Clicking on " + money);
    }

    public String requestMoneyPage() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(requestMoneyPage);
        return getTextWithAttribute(requestMoneyPage, attribute);
    }

    public void searchTransaction(String transaction) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Transaction History\"]", 60);
        clickAndSendKeys(searchButton, transaction, "Entering " + transaction);
        new Actions(getDriver()).sendKeys(Keys.ENTER)
                .perform();
    }

    public String getTransactionDetails() {
        return getAttribute(transactionHistory, "content-desc");
    }

    public void transactionButton() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Transaction History']", 60);
        click(transactionPeriodButton, "Clicking on Transaction period button");
    }

    public List<String> getTransactionPeriod() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Last 30 days\"]", 60);

        List<String> values = new ArrayList<>();

        int size = getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Last')]")).size();

        for (int i = 0; i <= size; i++) {
            values.add(getDriver().findElement(By.xpath("(//" + parentAttribute + "[contains(@" + attribute + ", 'Last')])["
                    + i + "]")).getAttribute(attribute));
        }
        return values;
    }

    public void clickOnDownloadButton() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Transaction History']", 60);
        click(downloadButton, "Clicking on download button");
    }

    public void selectMonth() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Download Statement\"]", 60);
        click(selectMonth, "Selecting month");
        click(clickOnOkButton, "Click on Ok button");
    }

    public String getStatement() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(accountStatement);
        return getAttribute(accountStatement, attribute);
    }

    public void clickOnTransactionPeriod(String period) {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Last 30 days']", 60);
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + period + "']"), "Clicking on period " + period);
        click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Transaction Period')]/" + parentAttribute2), "Clicking on ok ");
    }

    public int getTransactionHist0ryDetails() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Transaction History']", 60);
        return getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"JOD\")]")).size();
    }

    public void clickOnBackButton() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Ways to add')]", 60);
        click(backButton, "Clicking on back button");
    }

    public void clickOnOkButton() {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Statement')]/" + parentAttribute2 + "[3]", 60);
        click(okButton, "Clicking on Ok button");
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
        return getAttribute(By.xpath
                        ("//" + parentAttribute + "[contains(@" + attribute + ",'" + value + "')]"),
                attribute).replaceAll("\n", " ");
    }
}