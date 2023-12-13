package com.qa.pages.capitalbank.termDeposit;

import com.qa.pages.BasePage;
import com.qa.pages.blink.HomePage;
import com.qa.pages.capitalbank.transfers.TransferPayeePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import java.time.Instant;

import static com.qa.engine.ProjectBase.logInfo;

public class TermDepositPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Create')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Create')]")
    protected WebElement createNewDeposit;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'MATURITY')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'MATURITY')]")
    protected WebElement cardType;

    @AndroidFindBy(accessibility = "Get Started")
    @iOSXCUITFindBy(accessibility = "Get Started")
    protected WebElement getStartedButton;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'BALANCE')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'BALANCE')]")
    protected WebElement account;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'BALANCE')]/android.widget.ImageView[3]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'BALANCE')]/XCUIElementTypeImage[3]")
    protected WebElement clickForwardArrow;

    @AndroidFindBy(accessibility = "Next")
    @iOSXCUITFindBy(accessibility = "Next")
    protected WebElement nextButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Deposit Account Number\"]/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Account Number\")]/following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement accountNumber;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,  'MATURITY')]/android.widget.ImageView[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,  'MATURITY')]/following-sibling::XCUIElementTypeImage[3]")
    protected WebElement forwardArrowForCurrency;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Deposit Details']/following-sibling::android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Details')]/following-sibling::XCUIElementTypeOther")
    protected WebElement depositDetails;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Interest Amount After Tax\"]/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Interest Amount After Tax\"]/following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement interestAmount;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Total Amount at Maturity\"]/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total Amount at Maturity\"]/following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement totalAmount;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Your Term Deposit is created successfully!\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"successfully!\")]")
    protected WebElement successMessage;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'MATURITY')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'MATURITY')]")
    protected WebElement termDeposit;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Contract')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Contract')]")
    protected WebElement termDepositDetails;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Total Interest Amount\"]/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total Interest Amount\"]/following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement totalInterestAmount;

    @Override
    protected void waitForAppToLoad() {
    }

    public void clickOnCreateNewDeposit() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"View Portfolio\"]", 60);
        click(createNewDeposit, "Clicking on create new deposit menu");
    }

    public String fetchDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getAttribute(cardType, attribute);
    }

    public void clickOnCard() {
        click(cardType, "Clicking on card");
    }

    public void clickOnGetStartedButton() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Get Started\"]", 60);
        click(getStartedButton, "Clicking on get started button");
    }

    public void clickOnForwardArrow() {
        click(clickForwardArrow, "Clicking on forward arrow");
    }

    public void clickForwardArrowForCurrency() {
        if (getDriver() instanceof AndroidDriver)
            click(forwardArrowForCurrency, "Clicking Forward button");
        else {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        new HomePage().tapOnPosition(361, 303);
    }

    public void clickOnNextButton() {
        click(nextButton, "Clicking on Next button");
    }

    public TermDepositPage clickDepositDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Deposit Details\"]", 90);
        click(depositDetails, "Clicking on deposit details");
        return this;
    }

    public TermDepositPage swipeToDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Pay to\"]", 90);
        By xpath = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"Details\")]");
        scrollUntilElementPresent(xpath, "up", 0.65);
        logInfo("Scrolling to deposit details");
        return this;
    }

    public TermDepositPage clickOnFundingAccount() {
        click(account, "Clicking on funding Account card");
        return this;
    }

    public String fetchCardValue() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//*[contains(@" + attribute + ", 'BALANCE')]", 60);
        return getAttribute(account, attribute);
    }

    public void clickOnDepositPeriod(String depositPeriod) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Period')]", 90);
        if (getDriver() instanceof AndroidDriver)
            click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + depositPeriod + "')]"), "Clicking on depositPeriod");
        else
            click(By.xpath("//XCUIElementTypeStaticText[contains(@name,'" + depositPeriod.substring(1) + "') or contains(@name,'" + depositPeriod + "')]"), "Clicking on depositPeriod");
    }

    public String fetchTermDepositValue() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        if (getDriver() instanceof AndroidDriver)
            waitForVisibility(termDeposit);
        else
            utils.waitForElement(getDriver(), "//XCUIElementTypeOther[contains(@name, 'MATURITY')]", 30);
        return termDeposit.getAttribute(attribute);
    }

    public void selectCard(String currency) {
        int count = 0;
        while (count < 3) {
            String cardValue = new TermDepositPage().fetchDetails();
            logInfo("The card type is " + cardValue);
            if (cardValue.contains(currency)) {
                new TermDepositPage().clickOnCard();
                break;
            } else {
                new TermDepositPage().clickForwardArrowForCurrency();
            }
            count++;
        }
    }

    public void selectFundingCardWithNumber(String number) {
        Instant timeout = Instant.now().plusSeconds(45);
        String cardValue = new TermDepositPage().fetchCardValue();

        while (!cardValue.contains(number)) {
            new TransferPayeePage().clickOnForwardArrow();

            cardValue = new TermDepositPage().fetchCardValue();

            if (cardValue.contains(number))
                break;

            if (Instant.now().isAfter(timeout)) {
                break;
            }
        }
    }

    public void selectCreditAccountWithNumber(String number) {
        int count = 0;
        while (count < 3) {
            String cardValue = new TermDepositPage().fetchCardValue();
            if (cardValue.contains(number)) {
                new TermDepositPage().clickOnFundingAccount();
                break;
            } else {
                if (getDriver() instanceof AndroidDriver)
                    waitForVisibility(account);
                else
                    utils.waitForElement(getDriver(), "//*[contains(@name, 'BALANCE')]", 30);
                Point point = account.getLocation();
                scrollWithCoordinates("up", 0.50, point.x, point.y);
            }
            count++;
        }
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
        logInfo("Clicking on radio button '" + radioButton + "'");
    }

    public String getInterestAmount() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Confirm Transfer']", 90);
        return getTextWithAttribute(interestAmount, attribute);
    }

    public String getTotalAmount() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Confirm Transfer']", 90);
        return getTextWithAttribute(totalAmount, attribute);
    }

    public String fetchSuccessMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'successfully!')]", 60);
        return getTextWithAttribute(successMessage, attribute);
    }

    public String fetchCardNumber() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getAttribute(accountNumber, attribute);
    }

    public String fetchTermDepositDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getTextWithAttribute(termDepositDetails, attribute);
    }

    public String fetchTotalInterestAmount() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getAttribute(totalInterestAmount, attribute);
    }
}