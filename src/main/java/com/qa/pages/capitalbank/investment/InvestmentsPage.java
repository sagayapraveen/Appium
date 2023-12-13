package com.qa.pages.capitalbank.investment;

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

public class InvestmentsPage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Loans']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Loans']")
    protected WebElement loans;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Next']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next']")
    protected WebElement next;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Description (Optional)']//following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Description (Optional)']//following-sibling::XCUIElementTypeTextField")
    protected WebElement description;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Ref No']//following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Ref No']//following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement refNo;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Amount']//following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Amount']//following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement currency;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Pay From']//following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pay From']//following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement payFrom;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Pay to']//following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pay to']//following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement payTo;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Amount']//ancestor::android.view.View[2]//android.view.View[2]//following-sibling::android.widget.ImageView[12]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Amount']//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[12]")
    protected WebElement amountDone;

    @AndroidFindBy(accessibility = "TRANSACTIONS")
    @iOSXCUITFindBy(accessibility = "TRANSACTIONS")
    protected WebElement transactions;

    @AndroidFindBy(accessibility = "Investments")
    @iOSXCUITFindBy(accessibility = "Investments")
    protected WebElement investments;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Transactions']//ancestor::android.view.View/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transactions']//ancestor::XCUIElementTypeOther/XCUIElementTypeImage")
    protected WebElement back;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
    protected WebElement done;

    public void amountDoneButton() {
        click(amountDone, "Clicking amount button");
    }

    public String refNo() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }

        return refNo.getAttribute(attribute);
    }

    public String currency() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return currency.getAttribute(attribute);
    }

    public String payFrom() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return payFrom.getAttribute(attribute);
    }

    public String payTo() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return payTo.getAttribute(attribute);
    }

    @Override
    protected void waitForAppToLoad() {
    }

    public void swipeToInvestment() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        waitForVisibility(loans);
        Point point = loans.getLocation();
        Instant timeout = Instant.now().plusSeconds(30);
        String xpath = "//" + parentAttribute + "[@" + attribute + "='Investments']";

        if (getDriver() instanceof AndroidDriver) {
            while (getDriver().findElements(By.xpath(xpath)).size() == 0) {
                scrollWithCoordinates("left", 0.50, point.x, point.y);

                if (Instant.now().isAfter(timeout))
                    throw new TimeoutException("Investment menu is not displaying after 30 seconds");
            }
        } else {
            scrollWithCoordinates("left", 0.50, point.x, point.y);
            scrollWithCoordinates("left", 0.50, point.x, point.y);
        }
        click(By.xpath(xpath), "Clicking Investment Tab");
    }

    public void options(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='" + value + "']", 30);
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + value + "']"), "Clicking " + value + " option");
    }

    public void enterAmount(String amount) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String parentAttribute4 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ImageView";
            parentAttribute4 = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeImage";
            parentAttribute4 = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute4 + "[@" + attribute + "='Amount']/following-sibling::" + parentAttribute2 + "[1]", 30);

        char[] ch = amount.toCharArray();

        if (getDriver() instanceof AndroidDriver) {
            for (char a : ch) {
                By value = By.xpath("//" + parentAttribute4 + "[@" + attribute + "='Amount']//ancestor::" + parentAttribute + "[2]//" + parentAttribute + "[2]//following-sibling::" + parentAttribute2 + "[" + a + "]");
                int size = getDriver().findElements(value).size();
                if ('.' == a)
                    getDriver().findElement(By.xpath("//" + parentAttribute4 + "[@" + attribute + "='Amount']//ancestor::" + parentAttribute + "[2]//" + parentAttribute + "[2]//following-sibling::" + parentAttribute2 + "[10]")).click();
                else if ('0' == a)
                    getDriver().findElement(By.xpath("//" + parentAttribute4 + "[@" + attribute + "='Amount']//ancestor::" + parentAttribute + "[2]//" + parentAttribute + "[2]//following-sibling::" + parentAttribute2 + "[11]")).click();
                else if (a == '1' || a == '2' || a == '3')
                    getDriver().findElements(value).get(size - 1).click();
                else
                    getDriver().findElement(value).click();
            }
        } else {
            for (char a : ch) {
                By value = By.xpath("//XCUIElementTypeStaticText[@name='Amount']//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[" + a + "]");
                int size = getDriver().findElements(value).size();
                if ('.' == a)
                    getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name='Amount']//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[10]")).click();
                else if ('0' == a)
                    getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name='Amount']//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[11]")).click();
                else if (a == '1' || a == '2' || a == '3')
                    getDriver().findElements(value).get(0).click();
                else
                    getDriver().findElement(value).click();
            }
        }
    }

    public void enterDescription(String value) {
        scroll("up", 0.20);
        clickAndSendKeys(description, value, "Setting description as " + value);

        if (getDriver() instanceof IOSDriver) {
            new HomePage().scroll("down");
        }
    }

    public void nextButton() {
        click(next, "Clicking Next button");
    }

    public String selectPayToCard(String option, String country) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",'BALANCE')]";
        utils.waitForElement(getDriver(), xpath, 30);
        String selectedCard = "";
        int i = 0;

        if (option.equalsIgnoreCase("withdraw")) i = 1;

        while (i <= 10) {
            WebElement card = getDriver().findElements(By.xpath(xpath)).get(i);
            if (card.getAttribute(attribute).contains(country)) {
                selectedCard = card.getAttribute(attribute);
                click(card, "Clicking withdrawal card");
                break;
            }

            scroll("up", 0.10);
            i++;
        }
        return selectedCard;
    }

    public InvestmentsPage selectPayFromCard(String currency) throws InterruptedException {
        String parentAttribute = "";
        String attribute = "";
        By selectCard = null;

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
            selectCard = By.xpath("//*[contains(@content-desc,'BALANCE')]");
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
            selectCard = By.xpath("//*[contains(@name,'BALANCE')]");
        }

        By arrow;

        if (getDriver() instanceof AndroidDriver)
            arrow = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'BALANCE')]//android.widget.ImageView[3]");
        else
            arrow = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'BALANCE')]//following-sibling::XCUIElementTypeImage[3]");

        utils.waitForElement(getDriver(), selectCard, 45);
        Instant timeout = Instant.now().plusSeconds(45);

        String currentCard = getDriver().findElement(selectCard).getAttribute(attribute);
        String newCard = "";

        if (!(getDriver().findElement(selectCard).getAttribute(attribute).contains(currency)) && getDriver().findElements(arrow).size() > 0) {
            while (!currentCard.equals(newCard)) {
                currentCard = getDriver().findElement(selectCard).getAttribute(attribute);

                if (getDriver() instanceof AndroidDriver)
                    click(arrow);
                else if (getDriver().findElements(arrow).size() > 0)
                    click(arrow);
                else
                    new HomePage().tapOnPosition(360, 302);

                Thread.sleep(1500);

                if (getDriver().findElement(selectCard).getAttribute(attribute).contains(currency))
                    break;

                newCard = getDriver().findElement(selectCard).getAttribute(attribute);

                if (Instant.now().isAfter(timeout))
                    throw new TimeoutException("APP is not loaded properly.");
            }
        }
        return this;
    }

    public String selectPayToCardUpdate(String option, String cardDetails, String currency) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",'BALANCE')]";
        utils.waitForElement(getDriver(), xpath, 30);

        String selectedCard = null;
        int i = 0;

        if (option.equalsIgnoreCase("withdraw")) i = 1;

        while (i <= 10) {
            WebElement card = getDriver().findElements(By.xpath(xpath)).get(i);
            if (!card.getAttribute(attribute).contains(cardDetails) && card.getAttribute(attribute).contains(currency)) {
                selectedCard = card.getAttribute(attribute);
                click(card, "Clicking withdrawal card");
                break;
            }
            scroll("up", 0.10);
            i++;
        }
        return selectedCard;
    }

    public String payFromCard(String value) {
        String attribute = "";
        By selectCard = null;

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            selectCard = By.xpath("//*[contains(@content-desc,'BALANCE')]");
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            selectCard = By.xpath("//*[contains(@name,'BALANCE')]");
        }
        utils.waitForElement(getDriver(), "//*[contains(@" + attribute + ",'BALANCE')]", 30);
        if (getAttribute(selectCard, attribute).contains(value))
            return getAttribute(selectCard, attribute);
        else
            throw new RuntimeException(value + "Card not found");
    }

    public String getRequestMessage(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + value + "')]";
        utils.waitForElement(getDriver(), xpath, 45);
        return getAttribute(By.xpath(xpath), attribute);
    }

    public boolean isAmountClickable() {
        return Boolean.parseBoolean(getTextWithAttribute(amountDone, "checkable"));
    }

    public String accountDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        By xpath = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'Account Number')]");
        return getAttribute(xpath, attribute).replaceAll("\n", " ");
    }

    public void selectTransaction() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"TRANSACTIONS\"]", 30);
        click(transactions, "Clicking transaction");
    }

    public String latestTransactions(String refNo) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        Instant timeout = Instant.now().plusSeconds(60);

        String transaction = "//" + parentAttribute + "[contains(@" + attribute + ",'" + refNo + "')]";
        while (getDriver().findElements(By.xpath(transaction)).size() == 0) {
            if (getDriver().findElements(By.xpath(transaction)).size() == 1)
                break;

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException("Ref No is not loaded properly.");
        }
        return getAttribute(By.xpath(transaction), attribute);
    }

    public void viewMore() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        By xpath = By.xpath("//" + parentAttribute + "[@" + attribute + "=\"View more\"]");

        if (getDriver() instanceof AndroidDriver)
            scrollUntilElementPresent(xpath, "up", .75);
        else
            new HomePage().scroll("up");

        getDriver().findElement(xpath).click();
        logInfo("Clicking view more button");
    }

    public String[] getTransactionWithDate(String date) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'" + date + "')]"), attribute)
                .replaceAll("\n", " ").split("immediately");
    }
}