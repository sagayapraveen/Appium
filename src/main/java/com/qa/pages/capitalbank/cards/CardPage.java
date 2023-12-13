package com.qa.pages.capitalbank.cards;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.qa.engine.ProjectBase.logInfo;

public class CardPage extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'TOTAL ACCOUNT BALANCE')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'TOTAL ACCOUNT BALANCE')]")
    protected WebElement getAccountBalance;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'BALANCE')]//following-sibling::android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'BALANCE')]//following-sibling::XCUIElementTypeImage[3]")
    protected WebElement cardForward;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Limits')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Limits')]")
    protected WebElement cardLimit;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Used Balance')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Used Balance')]")
    protected WebElement usedBalance;

    @AndroidFindBy(accessibility = "Settle Card")
    @iOSXCUITFindBy(accessibility = "Settle Card")
    protected WebElement settleCard;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Top')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Top')]")
    protected WebElement topUp;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='CVV']/following-sibling::android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='CVV']/following-sibling::XCUIElementTypeImage")
    protected WebElement cvvPin;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Select Account']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Select Account']")
    protected WebElement selectAccountPage;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Card Limits']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Card Limits']")
    protected WebElement pageName;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'VIRTUAL')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'VIRTUAL')]")
    protected WebElement virtualPrepaidCardDetails;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'BALANCE')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'BALANCE')]")
    protected WebElement currentAccount;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Card Number']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Card Number\"]")
    protected WebElement cardNumber;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Card Number']/following-sibling::android.widget.ImageView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Card Number\"]/following-sibling::XCUIElementTypeImage[1]")
    protected WebElement cardNumberValue;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Card Number']//..//android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CVV\"]")
    protected WebElement cvv;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Card Number']/following-sibling::android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"CVV\"]/following-sibling::XCUIElementTypeImage[1]")
    protected WebElement cvvValue;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Card Number']//..//android.view.View[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Expiry Date\"]")
    protected WebElement expiryDate;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Card Number']//..//android.view.View[4]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Expiry Date\"]/following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement expiryDateValue;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Status')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Status')]")
    protected WebElement activeCardDetails;

    @AndroidFindBy(accessibility = "Cards")
    @iOSXCUITFindBy(accessibility = "Cards")
    protected WebElement cards;

    @AndroidFindBy(accessibility = "Loans")
    @iOSXCUITFindBy(accessibility = "Loans")
    protected WebElement loans;

    @AndroidFindBy(accessibility = "Accounts")
    @iOSXCUITFindBy(accessibility = "Accounts")
    protected WebElement accounts;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'BALANCE')]//following-sibling::android.widget.ImageView[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'BALANCE')]//following-sibling::XCUIElementTypeImage[3]")
    protected WebElement rightArrowVPC;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'BALANCE')]/android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'BALANCE')]//following-sibling::XCUIElementTypeImage[2]")
    protected WebElement rightArrow;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'BALANCE')]/android.widget.ImageView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'BALANCE')]/XCUIElementTypeImage[1]")
    protected WebElement leftArrow;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'BALANCE')]/android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'BALANCE')]/XCUIElementTypeImage[2]")
    protected WebElement leftArrowVPC;

    @AndroidFindBy(accessibility = "CARD DETAILS")
    @iOSXCUITFindBy(accessibility = "CARD DETAILS")
    protected WebElement cardDetailsTab;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='CARD DETAILS']/ancestor::android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CARD DETAILS']/ancestor::XCUIElementTypeOther[1]/XCUIElementTypeImage")
    protected WebElement cardDetails;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Details')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Details')]")
    protected WebElement cardDetailsVPC;

    @AndroidFindBy(accessibility = "Transfers")
    @iOSXCUITFindBy(accessibility = "Transfers")
    protected WebElement transfers;

    @Override
    public void waitForAppToLoad() {
    }

    public void clickOnCardForward() {
        click(cardForward, "Clicking on CardForward Button");
    }

    public void clickOnCardForwardArrow() {
        click(rightArrowVPC, "Clicking on CardForward Button");
    }

    public void clickOnCardLimit() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='CARD DETAILS']", 90);
        click(cardLimit, "Clicking on cardLimit");
    }

    public CardPage clickOnCardDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        scrollUntilElementPresent(By.xpath("//" + parentAttribute + "[@" + attribute + "='CARD DETAILS']"), "up", 0.2);

        click(cardDetailsTab, "Clicking on Card Details");
        return this;
    }

    public void clickOnCardDetailsWidget() {
        click(cardDetailsVPC, "Clicking on Card Details");
    }

    public void clickOnTopUp() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='CARD DETAILS']", 90);
        click(topUp, "Clicking on TopUp Button");
    }

    public boolean isMenuClickable(String menu) {
        String attribute = "";
        String parentAttribute = "";
        String data = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.widget.ImageView";
            data = "clickable";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
            data = "enabled";
        }
        waitForVisibility(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + menu + "')]"));
        return Boolean.parseBoolean(getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + menu + "')]"), data));
    }

    public String getCvvNumber() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";
        String data = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ImageView";
            attribute = "content-desc";
            data = "text";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            parentAttribute2 = "XCUIElementTypeImage";
            attribute = "name";
            data = "value";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='CVV']/following-sibling::" + parentAttribute2, 90);
        return getAttribute(cvvPin, data);
    }

    public String fetchSelectAccount() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Select Account']", 60);
        return getTextWithAttribute(selectAccountPage, attribute);
    }

    public String fetchVirtualCardDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'VIRTUAL')]", 60);
        return getAttribute(virtualPrepaidCardDetails, attribute);
    }

    public String fetchDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'BALANCE')]", 60);
        return getAttribute(currentAccount, attribute);
    }

    public String fetchCardStatus() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='CARD DETAILS']", 60);
        String value = getTextWithAttribute(activeCardDetails, attribute).replaceAll("\n", "\t");
        logInfo(value);
        return value;
    }

    public void clickOnCard() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='CARD DETAILS']", 90);
        click(currentAccount, "Clicking on card");
    }

    public void selectCard(String cardName) throws InterruptedException {
        int count = 0;
        while (count < 5) {
            String cardValue = new CardPage().fetchDetails();
            logInfo("The card type is " + cardValue);
            if (cardValue.contains(cardName)) {
                new AddNewCard().swipeToAddToCard().clickOnAddNewCard();
                break;
            } else {
                new CardPage().clickOnCardForward();
            }
            count++;
        }
    }

    public StringBuilder fetchSuccessMessage() {
        String parentAttribute = "";
        String attribute = "";
        String data = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
            data = "text";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
            data = "value";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='View Card Details']", 90);
        StringBuilder message = new StringBuilder();
        message.append(cardNumber.getAttribute(attribute))
                .append("-").append(cardNumberValue.getAttribute(data).replace(", Please Enter", "")).append("\n")
                .append(cvv.getAttribute(attribute)).append("-")
                .append(cvvValue.getAttribute(data).replace(", Please Enter", "")).append("\n")
                .append(expiryDate.getAttribute(attribute)).append("-")
                .append(expiryDateValue.getAttribute(attribute)).append("\n");

        logInfo(message.toString());
        return message;
    }

    public boolean isCardDetailsClickable() {
        return Boolean.parseBoolean(getAttribute(cardDetailsTab, "clickable"));
    }

    public String fetchVirtualCardDetails(String nameInCard) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'" + nameInCard + "')]"),
                attribute);
    }

    public void navigateToAccountsTab() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Loans']", 30);
        Point point = loans.getLocation();
        scrollWithCoordinates("right", 0.50, point.x, point.y);
        click(accounts);
    }

    public void clickUsedBalance() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Used Balance')]", 30);
        logInfo("Clicking used balance");
        Point point = usedBalance.getLocation();
        tapOnPosition(point.x, point.y + 100);
    }

    public void clickSettleCard() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Settle Card']", 90);
        click(settleCard, "Clicking Settle card");
    }

    public List<String> getAllCardAccountDetails() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute2 + "[@" + attribute + "='Settle Card']", 60);
        List<String> cardsDetails = new ArrayList<>();

        String cardDetails = getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'TOTAL ACCOUNT BALANCE')]"),
                attribute).replaceAll("\n", " ").toUpperCase(Locale.ROOT);
        String temp = "";
        cardsDetails.add(cardDetails);

        Instant timeout = Instant.now().plusSeconds(90);

        while (!cardDetails.equals(temp)) {
            temp = cardDetails;

            click(rightArrow, "Clicking right arrow");

            if (fetchDetails().toUpperCase(Locale.ROOT).contains("VIRTUAL")) {
                click(leftArrowVPC);
                break;
            }

            cardDetails = getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'TOTAL ACCOUNT BALANCE')]"),
                    attribute).replaceAll("\n", " ").toUpperCase(Locale.ROOT);

            if (cardDetails.equals(temp))
                break;

            cardsDetails.add(cardDetails);

            if (Instant.now().isAfter(timeout))
                break;
        }
        return cardsDetails;
    }

    public void backToHome(int size) throws InterruptedException {
        for (int i = 1; i <= size; i++) {
            Thread.sleep(500);
            click(leftArrow, "Clicking left arrow");
        }
    }

    public void selectCardWithCurrency(String currency) throws InterruptedException {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        String cardDetails = getAttribute(getAccountBalance, attribute).replace("\n", " ").toUpperCase(Locale.ROOT);

        if (!cardDetails.contains("JOD")) {
            Thread.sleep(500);
            leftArrow.click();
            Thread.sleep(500);
            leftArrow.click();
            Thread.sleep(500);
            leftArrow.click();
            Thread.sleep(500);
            leftArrow.click();
        }

        Instant timeout = Instant.now().plusSeconds(180);

        while (!cardDetails.contains(currency)) {
            try {
                cardDetails = getAttribute(getAccountBalance, attribute).replace("\n", " ").toUpperCase(Locale.ROOT);
            } catch (StaleElementReferenceException exception) {
                try {
                    cardDetails = getAttribute(getAccountBalance, attribute).replace("\n", " ").toUpperCase(Locale.ROOT);
                } catch (Exception e) {
                    throw e;
                }
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

    public String fetchCardDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'TOTAL ACCOUNT BALANCE')]"),
                attribute);
    }

    public boolean isTransfersClickable() {
        return Boolean.parseBoolean(getAttribute(transfers, "clickable"));
    }


    public CardPage selectCardDropdown() {
        waitForVisibility(cards);
        Point point = cards.getLocation();

        if (getDriver() instanceof AndroidDriver)
            tapOnPosition(point.x, point.y + 250);
        else tapOnPosition(90, 230);

        logInfo("Clicking on dropdown");
        return this;
    }

    public void clickCard(String cardType) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "= '" + cardType + "']"), "clicking on " + cardType);
    }

    public String getEntireCardAllDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return cardDetails.getAttribute(attribute);
    }
}
