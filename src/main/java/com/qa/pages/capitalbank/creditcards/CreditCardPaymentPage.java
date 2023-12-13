package com.qa.pages.capitalbank.creditcards;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.qa.engine.ProjectBase.logInfo;

public class CreditCardPaymentPage extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Select Amount']/following-sibling::android.view.View[last()]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Any Amount\"]")
    protected WebElement anyAmount;

    @AndroidFindBy(accessibility = "Confirm")
    @iOSXCUITFindBy(accessibility = "Confirm")
    protected WebElement confirm;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Credit Card Payment')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Credit Card Payment')]")
    protected WebElement confirmationDetails;

    @AndroidFindBy(accessibility = "Settle Card Now")
    @iOSXCUITFindBy(accessibility = "Settle Card Now")
    protected WebElement settleCardNow;

    @AndroidFindBy(accessibility = "PAYMENT HISTORY")
    @iOSXCUITFindBy(accessibility = "PAYMENT HISTORY")
    protected WebElement paymentHistory;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Any Amount']/ancestor::android.widget.ScrollView[1]/following-sibling::android.widget.ImageView[12]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Pay to\"]//ancestor::XCUIElementTypeOther[1]//following-sibling::XCUIElementTypeButton[12]")
    protected WebElement selectOk;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Pay From\"]/following-sibling::android.view.View//android.widget.ImageView)[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Pay From\"]//following::XCUIElementTypeImage[3]")
    protected WebElement rightArrow;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Pay From']/following-sibling::android.view.View/android.view.View/android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"ACCOUNT\")]")
    protected WebElement payFromCard;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Balance Remaining')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Balance Remaining')]")
    protected WebElement balanceRemaining;

    @Override
    protected void waitForAppToLoad() {
    }

    public CreditCardPaymentPage setAnyAmount(String amount) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String parentAttribute3 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ScrollView";
            parentAttribute3 = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeScrollView";
            parentAttribute3 = "XCUIElementTypeImage";
            attribute = "name";
        }
        scroll("up", 0.5);
        scroll("up", 0.75);

        click(anyAmount);

        logInfo("Inputting the amount " + amount);

        char[] charArray = amount.toCharArray();
        if (getDriver() instanceof AndroidDriver) {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("//" + parentAttribute + "[@" + attribute + "='Any Amount']/ancestor::" + parentAttribute2 + "[1]/following-sibling::" + parentAttribute3 + "[11]"));
                else if (c == '.')
                    click(By.xpath("//" + parentAttribute + "[@" + attribute + "='Any Amount']/ancestor::" + parentAttribute2 + "[1]/following-sibling::" + parentAttribute3 + "[10]"));
                else
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='Any Amount']/ancestor::" + parentAttribute2 + "[1]/following-sibling::" + parentAttribute3 + ")[" + c + "]"));
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

        }
        return this;
    }

    public void selectOk() {
        click(selectOk);
    }

    public void confirm() {
        click(confirm, "Clicking confirm payment");
    }

    public String getConfirmationDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return confirmationDetails.getAttribute(attribute);
    }

    public void settleCardNow() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Credit Card Info']", 30);
        scroll("up", 0.7);
        click(settleCardNow, "Clicking Settle card now");
    }

    public void paymentHistory() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='PAYMENT HISTORY']", 30);
        click(paymentHistory, "Clicking Payment history");
    }

    public List<String> getPaymentHistory() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='PAYMENT HISTORY']", 60);

        List<String> transactions = new ArrayList<>();

        String xpath;
        if (getDriver() instanceof AndroidDriver) {
            xpath = "((//" + parentAttribute + "[@" + attribute + "=\"CREDIT CARD PAYMENT\"])[1]/following-sibling::" + parentAttribute + ")";
            transactions.add(getDriver().findElement(By.xpath("(//" + parentAttribute + "[@" + attribute + "=\"CREDIT CARD PAYMENT\"])[1]")).getAttribute(attribute));
        } else
            xpath = "//" + parentAttribute + "[@" + attribute + "=\"PAYMENT HISTORY\"]//following::" + parentAttribute;

        int size = getDriver().findElements(By.xpath(xpath)).size();


        for (int i = 1; i <= size; i++) {
            try {
                transactions.add(getDriver().findElement(By.xpath(xpath + "[" + i + "]")).getAttribute(attribute).toUpperCase(Locale.ROOT));
            } catch (StaleElementReferenceException exception) {
                logInfo("Exception '" + exception + "' occurs, retrying...");
                transactions.add(getDriver().findElement(By.xpath(xpath + "[" + i + "]")).getAttribute(attribute).toUpperCase(Locale.ROOT));
            } catch (NullPointerException ignored) {
                // ignoring the exception
            }
        }
        return transactions;
    }

    public String getConfirmPayToDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        StringBuilder payToDetails = new StringBuilder();
        String temp;

        for (int i = 1; i <= 5; i++) {
            temp = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "='Pay to']//following-sibling::" + parentAttribute + "[" + i + "]"))
                    .getAttribute(attribute);

            payToDetails.append("\t").append(temp);
        }
        return payToDetails.toString();
    }

    public void selectCardWithCurrency(String currency) {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        String cardDetails = getAttribute(payFromCard, attribute).replaceAll("\n", " ").toUpperCase(Locale.ROOT);
        Instant timeout = Instant.now().plusSeconds(150);

        while (!cardDetails.contains(currency)) {
            try {
                cardDetails = getAttribute(payFromCard, attribute).replace("\n", " ").toUpperCase(Locale.ROOT);
            } catch (StaleElementReferenceException exception) {
                cardDetails = getAttribute(payFromCard, attribute).replace("\n", " ").toUpperCase(Locale.ROOT);
            }

            if (cardDetails.contains(currency))
                break;

            click(rightArrow, "Clicking right arrow");

            if (Instant.now().isAfter(timeout)) {
                logInfo(currency + " Card is not available");
                break;
            }
        }

        logInfo(currency + " Card has been selected");
    }

    public String fetchPayFromCard() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getAttribute(payFromCard, attribute).replaceAll("\n", " ").toUpperCase(Locale.ROOT);
    }

    public String getBalanceRemaining() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getAttribute(balanceRemaining, attribute).split("\n")[1];
    }
}
