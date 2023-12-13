package com.qa.pages.capitalbank.loans;

import com.qa.pages.BasePage;
import com.qa.pages.capitalbank.dashBoard.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Instant;
import java.util.Locale;

import static com.qa.engine.ProjectBase.logInfo;

public class LoansPage extends BasePage {

    @AndroidFindBy(accessibility = "Transfers")
    @iOSXCUITFindBy(accessibility = "Transfers")
    protected WebElement transferButton;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Pay From\"]/following-sibling::android.view.View//android.widget.ImageView)[3]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Pay From\"]/following-sibling::XCUIElementTypeOther//XCUIElementTypeImage)[3]")
    protected WebElement rightArrow;

    @AndroidFindBy(accessibility = "Loans")
    @iOSXCUITFindBy(accessibility = "Loans")
    protected WebElement loansButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"TOTAL ACCOUNT BALANCE\"]/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TOTAL ACCOUNT BALANCE\"]/following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement payFromAccountDetails;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Own Account\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Own Account\"]")
    protected WebElement ownAccount;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"View Portfolio\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"View Portfolio\"]")
    protected WebElement portfolioButton;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'ACCOUNT NUMBER')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'ACCOUNT NUMBER')]")
    protected WebElement payBillAccount;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"LOANS\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"LOANS\"]")
    protected WebElement loansOption;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Contract Number')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Contract Number')]")
    protected WebElement loanDetails;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Settle Card\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Settle Card\"]")
    protected WebElement settleCard;

    @AndroidFindBy(xpath = "//android.view.View[contains(@text, '0.00, Any')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Any Amount\"]")
    protected WebElement anyAmount;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Pay From')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Pay From')]")
    protected WebElement creditCardPayment;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'ACCOUNT NUMBER')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'ACCOUNT NUMBER')]")
    protected WebElement payFromTransfer;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"CURRENT ACCOUNT\"]/following-sibling::android.view.View[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CURRENT ACCOUNT\"]/following-sibling::XCUIElementTypeStaticText[3]")
    protected WebElement ownAccountTransfer;

    @Override
    protected void waitForAppToLoad() {
    }

    public void clickOnTransfer() {
        waitForVisibility(transferButton);
        click(transferButton, "Clicking on Transfer button");
    }

    public void clickOnPortfolio() {
        waitForVisibility(portfolioButton);
        click(portfolioButton);
    }

    public String loans(String accountType) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"ACCOUNTS\"]", 60);
        scrollUntilElementPresent(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"LOANS\"]"), "up", 0.5);
        return getTextWithAttribute(loansOption, attribute);
    }

    public void clickOnOwnAccount() {
        if (getDriver() instanceof AndroidDriver)
            waitForVisibility(ownAccount);
        else
            utils.waitForElement(getDriver(), "//XCUIElementTypeImage[@name=\"Own Account\"]", 20);
        click(ownAccount, "Clicking on own Account");
    }

    public void clickOnLoans() {
        waitForVisibility(loansButton);
        click(loansButton, "Clicking on Loans");
    }

    public String payFromAccountDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Pay From\"]", 60);
        scroll("up", 0.4);
        return getTextWithAttribute(payFromAccountDetails, attribute);
    }

    public void clickOnOwnAccount(String currency) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", '" + currency + "')]", 30);
        click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + currency + "')]"));
    }

    public void scrollDownInLoans(String name) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Lo\")]", 60);
        scrollUntilElementPresent(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + name + "']"), "up", 0.5);
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + name + "']"), "Clicking on " + name);
    }

    public String fetchLoanDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Contract Number')]", 60);
        return getTextWithAttribute(loanDetails, attribute);
    }

    public boolean isLoanSchedulePresent(String Loan) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//*[@" + attribute + "=\"Loan Schedule\"]", 60);

        return getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + Loan + "')]")).size() > 0;
    }

    public void selectCardFromDropDown(String card) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Select Card Type\"]", 60);
        click(By.xpath("//*[@" + attribute + "='" + card + "']"), "Clicking on " + card);
    }

    public void selectPayBillAccount(String currency) {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(payBillAccount);
        String cardDetails = getAttribute(payBillAccount, attribute).replaceAll("\n", " ").toUpperCase(Locale.ROOT);
        Instant timeout = Instant.now().plusSeconds(90);

        while (!cardDetails.contains(currency)) {
            cardDetails = getAttribute(payBillAccount, attribute).replaceAll("\n", " ").toUpperCase(Locale.ROOT);

            if (cardDetails.contains(currency))
                break;

            if (getDriver() instanceof AndroidDriver)
                click(rightArrow, "Clicking right arrow");
            else
                new HomePage().tapOnPosition(361, 303);

            if (Instant.now().isAfter(timeout)) {
                logInfo(currency + " Card is not available");
                break;
            }
        }
    }

    public void settleCard() {
        click(settleCard, "Clicking on Settle card");
    }

    public void enterAmount() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Credit Card Payment\"]", 60);
        if (getDriver() instanceof AndroidDriver)
            scrollUntilElementPresent(By.xpath("//" + parentAttribute + "[contains(@text, 'Any Amount')]"), "up", 0.5);
        else
            new HomePage().scroll("up");

        click(anyAmount);
    }

    public void enterAmount(String amount, String page) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        logInfo("Inputting the amount " + amount);
        char[] charArray = amount.toCharArray();
        if (getDriver() instanceof AndroidDriver) {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='" + page + "']//../following-sibling::" + parentAttribute2 + ")[12]"));
                else
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='" + page + "']//../following-sibling::" + parentAttribute2 + ")[" + c + "]"));
            }
        } else {
            for (char c : charArray) {
                {
                    if (c == '0')
                        click(By.xpath("//XCUIElementTypeStaticText[@name=\"Pay to\"]//ancestor::XCUIElementTypeOther[1]//following-sibling::XCUIElementTypeButton[11]"));
                    else if (c == '.')
                        click(By.xpath("//XCUIElementTypeStaticText[@name=\"Pay to\"]//ancestor::XCUIElementTypeOther[1]//following-sibling::XCUIElementTypeButton[10]"));
                    else
                        click(By.xpath("//XCUIElementTypeStaticText[@name=\"Pay to\"]//ancestor::XCUIElementTypeOther[1]//following-sibling::XCUIElementTypeButton[" + c + "]"));
                }
            }
            click(By.xpath("//XCUIElementTypeStaticText[@name=\"Pay to\"]//ancestor::XCUIElementTypeOther[1]//following-sibling::XCUIElementTypeButton[12]"));
        }
        new LoansPage();
    }

    public String getPayFromDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(creditCardPayment);
        return getTextWithAttribute(creditCardPayment, attribute);
    }

    public String payAccountDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Pay From\"]", 60);
        return getTextWithAttribute(payFromTransfer, attribute);
    }

    public String payAccountTransfer() {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Pay From\"]", 60);
        if (getDriver() instanceof AndroidDriver)
            click(By.xpath("(//" + parentAttribute + "[@" + attribute + "=\"Transfer to Own Account\"]//../following-sibling::" + parentAttribute2 + ")[12]"));
        else
            click(By.xpath("//XCUIElementTypeStaticText[contains(@name,\"Pay\")]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[12]"));

        waitForVisibility(ownAccountTransfer);
        return getTextWithAttribute(ownAccountTransfer, attribute);
    }
}