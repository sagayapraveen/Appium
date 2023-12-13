package com.qa.pages.capitalbank.overdraft;

import com.qa.pages.BasePage;
import com.qa.pages.capitalbank.termDeposit.TermDepositPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import static com.qa.engine.ProjectBase.logInfo;

public class ManageCliQIdPage extends BasePage {
    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc, 'CliQ')]//..//../android.widget.ImageView)[last()]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Manage CliQ ID\"]//ancestor::XCUIElementTypeOther[1]/following-sibling::XCUIElementTypeButton")
    protected WebElement createCliQ;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Edit Details\"]/following-sibling::android.widget.CheckBox  ")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Edit Details\"]/following-sibling::XCUIElementTypeSwitch")
    protected WebElement checkBox;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'BALANCE')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'BALANCE')]")
    protected WebElement account;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Confirm\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirm\"]")
    protected WebElement confirmButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Request')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Request')]")
    protected WebElement requestMoney;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'History')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'History')]")
    protected WebElement requestHistory;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"CliQ ID Type\"]/following-sibling::android.widget.EditText/android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"ID Type\")]//following-sibling::XCUIElementTypeOther/XCUIElementTypeOther")
    protected WebElement alertMessage;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'CliQ ID created')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'created')]")
    protected WebElement createCliQId;


    @Override
    protected void waitForAppToLoad() {
    }

    public void clickCreateCliQ() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Manage CliQ ID\"]", 90);
        click(createCliQ, "Clicking on + symbol for creating a new cliQ");
    }

    public void clickRadioButton(String radioButton) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + radioButton + "']"));
        logInfo("clicking on " + radioButton + " button");
    }

    public void clickCheckBox() {
        click(checkBox, "Clicking on check box for accepting conditions");
    }

    public void enterAlias(String name, String value) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            parentAttribute2 = "XCUIElementTypeTextField";
            attribute = "name";
        }
        String number;
        if (value.equalsIgnoreCase("G"))
            number = utils.getRandomNumber(1);
        else
            number = utils.getRandomNumber(2);

        if (getDriver() instanceof AndroidDriver) {
            clickAndSendKeys(By.xpath("(//" + parentAttribute + "[@" + attribute + "='" + name + "'])[2]/following-sibling::" + parentAttribute2),
                    value + number, name + " has set to " + value + number);
        } else {
            By xpath = By.xpath("//XCUIElementTypeTextField[contains(@name,\"XXXX\") or contains(@name,\"Enter\")]");
            Point point = getDriver().findElement(xpath).getLocation();
            tapOnPosition(point.x + 200, point.y + 10);
            getDriver().findElement(xpath).sendKeys(value + number);
        }

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[contains(@name,\"D\") or contains(@name,\"Done\")]")).click();
    }

    public void selectCard(String cardNumber) {
        int count = 0;
        while (count < 5) {
            String cardValue = new ManageCliQIdPage().fetchCardValue();
            logInfo("The card type is " + cardValue);
            if (cardValue.contains(cardNumber)) {
                new ManageCliQIdPage().clickOnCard();
                break;
            } else {
                new TermDepositPage().clickOnForwardArrow();
            }
            count++;
        }
    }

    public String fetchCardValue() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(account);
        return getAttribute(account, attribute);
    }

    public void clickOnCard() {
        click(account, "Clicking on card");
    }

    public void clickConfirmButton() {
        click(confirmButton, "Clicking confirm button");
    }

    public void clickOnRequestHistory() {
        waitForVisibility(requestMoney);
        Point point = requestMoney.getLocation();
        scrollWithCoordinates("left", 0.65, point.x, point.y);
        waitForVisibility(requestHistory);
        click(requestHistory, "Clicking on account menu");
    }

    public String fetchAlertMessage() {
        waitForVisibility(alertMessage);
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getAttribute(alertMessage, attribute);
    }

    public String fetchSuccessMessage() {
        if (getDriver() instanceof AndroidDriver)
            waitForVisibility(createCliQId);
        else
            utils.waitForElement(getDriver(), "//XCUIElementTypeStaticText[contains(@name, 'created')]", 30);
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'created')]"), attribute);
    }
}