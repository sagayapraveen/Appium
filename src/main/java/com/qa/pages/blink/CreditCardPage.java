package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.qa.engine.ProjectBase.logInfo;

public class CreditCardPage extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Transaction History\"]/android.widget.ImageView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Transaction History\"]/XCUIElementTypeImage[1]")
    protected WebElement transactionDownload;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Download Statement\"]/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Download Statement\"]/XCUIElementTypeImage")
    protected WebElement doneButtonTransaction;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Credit\")]/android.widget.ImageView[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Credit\")]/XCUIElementTypeImage[3]")
    protected WebElement creditCardSetting;

    @AndroidFindBy(accessibility = "Manage settlement")
    @iOSXCUITFindBy(accessibility = "Manage settlement")
    protected WebElement manageSettlement;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Current')]/android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Current')]/XCUIElementTypeImage[2]")
    protected WebElement newSettlement;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Account balance\"]/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Account balance\"]/following-sibling::XCUIElementTypeOther[1]")
    protected WebElement availableBalance;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Credit Card')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Credit Card')]")
    protected WebElement payToMessage;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Error')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Error')]")
    protected WebElement errorMessage;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Account balance\"]/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Account balance\"]/following-sibling::XCUIElementTypeOther[1]")
    protected WebElement availablePayBackBalance;

    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc, 'NEW PIN')]/android.widget.EditText)[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[contains(@name, 'NEW PIN')]/XCUIElementTypeTextField)[1]")
    protected WebElement newPin;

    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc, 'NEW PIN')]/android.widget.EditText)[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[contains(@name, 'NEW PIN')]/XCUIElementTypeTextField)[2]")
    protected WebElement confirmNewPin;

    @AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc, 'Error')])[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[contains(@name, 'Error')])[2]")
    protected WebElement errorInNewPin;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Swipe to proceed')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Swipe to proceed')]")
    protected WebElement scrollLeft;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Back to Card Settings\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Back to Card Settings\"]")
    protected WebElement backToSetting;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'AVAILABLE BALANCE')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'AVAILABLE BALANCE')]")
    protected WebElement homePageBalance;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,  'Credit Card')]")
    @iOSXCUITFindBy(xpath = " //XCUIElementTypeOther[contains(@name,  'Credit Card')]")
    protected WebElement creditCardPage;


    @Override
    protected void waitForAppToLoad() {
    }

    public void clickOnSetting() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Credit Card')]", 60);
        click(creditCardSetting, "Clicking on setting on credit card");
    }

    public String accountDetails() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'CARD NUMBER')]"), attribute);
    }

    public String creditCard() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"Credit Card\")]"), attribute).replaceAll("\n", " ");
    }

    public void clickManageSettlement() {
        waitForVisibility(manageSettlement);
        click(manageSettlement, "Clicking on manage settlement ");
    }

    public void clickSettlementOption() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        Point point = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Manage settlement\"]")).getLocation();
        logInfo(point);
        tapOnPosition(point.x, point.y + 510);
    }

    public void clickOnNewSettlement() {
        waitForVisibility(newSettlement);
        click(newSettlement, "Clicking on new settlement");
    }

    public void selectSettlementPercentage(String value) {
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

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='25 %']", 60);
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + value + "']"));
        click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Settlement')]/" + parentAttribute2), "Clicking on ok ");
    }

    public String getCreditSuccessMessage() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Card details')]", 60);
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Card details')]"), attribute);
    }

    public void clickOnPayBack() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Credit Card')]", 60);
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Pay back\"]"), "Clicking on Pay Back");
    }

    public CreditCardPage enterPayAmount(String amount) throws InterruptedException {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }

        waitForVisibility(availableBalance);
        Thread.sleep(3000);
        char[] charArray = amount.toCharArray();
        for (char c : charArray) {
            click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + c + "']"));
        }

        logInfo("Entering the amount : " + amount);

        return this;
    }

    public void proceedPaymentNext() {
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
        String xpath = "//" + parentAttribute + "[@" + attribute + "=\"Back to Dashboard\"]/" + parentAttribute + "/" + parentAttribute2;
        utils.waitForElement(getDriver(), xpath, 30);
        click(By.xpath(xpath), "Proceeding bill payment button has been clicked");
    }

    public String getTransactionDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }

        waitForVisibility(payToMessage);
        return getAttribute(payToMessage, attribute).replaceAll("\n", " ");
    }

    public String getErrorMessage() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(errorMessage);
        return getAttribute(errorMessage, attribute).replaceAll("\n", " ");
    }

    public void swipeDown() {
        waitForVisibility(availableBalance);
        Point point = availableBalance.getLocation();
        scrollWithCoordinates("down", 0.70, point.x + 100, point.y - 100);
    }

    public String getPayBackBalance() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(availablePayBackBalance);
        return getAttribute(availablePayBackBalance, attribute).replaceAll("\n", " ");
    }

    public void enterNewPin(String pin) {
        waitForVisibility(newPin);
        clickAndSendKeys(newPin, pin, "Entering the new pin" + pin);
    }

    public void confirmNewPin(String pin) {
        waitForVisibility(newPin);
        clickAndSendKeys(confirmNewPin, pin, "Confirming new pin" + pin);
    }

    public String getErrorMessageInChangePin() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(errorInNewPin);
        return getAttribute(errorInNewPin, attribute).replaceAll("\n", " ");
    }

    public void swipeLeft() {
        waitForVisibility(scrollLeft);
        Point point = scrollLeft.getLocation();
        scrollWithCoordinates("left", 0.80, point.x, point.y);
    }

    public String currentSettlementPercentage() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Current')]"), attribute).replaceAll("\n", " ");
    }

    public void clickOnBackToCard() {
        waitForVisibility(backToSetting);
        click(backToSetting, "Clicking on back to Setting");
    }

    public void editAmount(String value, String type) {
        String attribute = "";
        String parentAttribute = "";
        String parentAttribute2 = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeTextField";
        }

        utils.waitForElement(getDriver(), By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Manage card limits\"]"), 60);
        String textXpath;
        String toggleXpath;
        if (type.equalsIgnoreCase("Merchant Payments"))
            toggleXpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + type + "')]//following-sibling::" + parentAttribute + "[2]";
        else
            toggleXpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + type + "')]//following-sibling::" + parentAttribute + "[1]";

        By toggle = By.xpath(toggleXpath);

        if (getAttribute(toggle, "content-desc").equalsIgnoreCase("NO"))
            click(toggle, "Clicking" + type + "Toggle");

        if (getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'" + type + "')]//following-sibling::" + parentAttribute + "[1]"), attribute).equalsIgnoreCase("Yes") && type.equalsIgnoreCase("Merchant Payments"))
            textXpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + type + "')]//following-sibling::" + parentAttribute2 + "[2]";
        else
            textXpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + type + "')]//following-sibling::" + parentAttribute2 + "[1]";

        By text = By.xpath(textXpath);

        if (!(value.equals(getAttribute(text, "text")))) {
            click(text);
            getDriver().findElement(text).clear();
            clickAndSendKeys(text, value, value + " is entered");
            Dimension point = getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"changes\")]")).getSize();
            tapOnPosition(point.width / 2, point.height - 75);
        }
    }

    public String cardDetails() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"Credit\")]"), 60);
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"Credit\")]"), attribute).replaceAll("\n", " ");
    }

    public CreditCardPage downloadTransaction(String month) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }

        click(transactionDownload, "Clicking download button");
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + month + "')]";
        scrollUntilElementPresent(By.xpath(xpath), "up", 0.5);
        click(By.xpath(xpath), "Clicking month");
        return this;
    }

    public void doneTransaction() {
        click(doneButtonTransaction, "Clicking done button");
    }

    public Map<String, String> statementVerification() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.widget.ImageView";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeImage";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Name\")]", 30);

        Map<String, String> map = new HashMap<String, String>();
        String[] statement = getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"Name\")]"), attribute).replaceAll("\n", " ").split(" ");

        map.put(statement[0], statement[3]);
        map.put(statement[1], statement[4]);
        map.put(statement[2], statement[5]);

        map.put(statement[6], statement[9]);
        map.put(statement[7], statement[10]);
        map.put(statement[8], statement[11]);

        return map;
    }

    public boolean transactionDetails() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Transaction History\"]", 30);
        return getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"JOD\")]")).size() > 0;
    }

    public Set<String> transactionList(String month) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }

        Instant timeout = Instant.now().plusSeconds(240);
        Set<String> transactionEntries = new HashSet<>();

        do {
            int size = getDriver().findElements(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Transaction History\"]/" + parentAttribute + "[2]/" + parentAttribute + "//" + parentAttribute + "[contains(@" + attribute + ",'" + month + "')]")).size();

            for (int j = 1; j <= size; j++) {
                int containerSize = getDriver().findElements(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Transaction History\"]/" + parentAttribute + "[2]/" + parentAttribute + "//" + parentAttribute + "[contains(@" + attribute + ",'" + month + "')][" + j + "]/" + parentAttribute + "/" + parentAttribute + "/" + parentAttribute + "//" + parentAttribute + "")).size();
                for (int k = 1; k <= containerSize; k++) {
                    if (!getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Transaction History\"]/" + parentAttribute + "[2]/" + parentAttribute + "//" + parentAttribute + "[contains(@" + attribute + ",'" + month + "')][" + j + "]/" + parentAttribute + "/" + parentAttribute + "/" + parentAttribute + "//" + parentAttribute + "[" + k + "]")).getAttribute(attribute).replaceAll("\n", " ").contains("Interest"))
                        transactionEntries.add(getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Transaction History\"]/" + parentAttribute + "[2]/" + parentAttribute + "//" + parentAttribute + "[contains(@" + attribute + ",'" + month + "')][" + j + "]/" + parentAttribute + "/" + parentAttribute + "/" + parentAttribute + "//" + parentAttribute + "[" + k + "]"))
                                .getAttribute(attribute).replaceAll("\n", " "));
                }
            }

            scroll("Up", 0.5);

            if (getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'" + month + "')]")).size() == 0)
                break;

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException();
        } while (getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'" + month + "')]")).size() > 0);

        return transactionEntries;
    }

    public String transactionStatementVerification() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.widget.ImageView";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeImage";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"Name\")]"), attribute).replaceAll("\n", " ");
    }

    public void navigateToCreditCard() {
        waitForVisibility(homePageBalance);

        Point point = homePageBalance.getLocation();
        scrollWithCoordinates("left", 0.35, point.x, point.y);

        waitForVisibility(creditCardPage);
    }

}