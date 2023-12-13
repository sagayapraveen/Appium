package com.qa.pages.capitalbank.transfers;

import com.qa.pages.BasePage;
import com.qa.pages.capitalbank.cards.CardPage;
import com.qa.pages.capitalbank.cliQ.CliQTransferPage;
import com.qa.pages.capitalbank.dashBoard.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.qa.engine.ProjectBase.logInfo;

public class TransferPayeePage extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Beneficiary Name']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Enter recipient name\"]")
    protected WebElement beneficiaryName;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Beneficiary Address']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Enter Recipient Address\"]")
    protected WebElement beneficiaryAddress;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Routing Number/Fedwire']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Routing Number/Fedwire\"]//following-sibling::XCUIElementTypeTextField[1]")
    protected WebElement routingNumber;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.EditText[3]/following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,\"SWIFT\")]")
    protected WebElement swiftValue;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Recipient Name']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Recipient Name']/following-sibling::XCUIElementTypeTextField[1]")
    protected WebElement recipientName;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Recipient Address']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Recipient Address']/following-sibling::XCUIElementTypeTextField[1]")
    protected WebElement recipientAddress;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Purpose of Transfer']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Purpose of Transfer']/following-sibling::XCUIElementTypeOther[1]")
    protected WebElement purposeOfTransfer;

    @AndroidFindBy(accessibility = "Personal")
    @iOSXCUITFindBy(accessibility = "Personal")
    protected WebElement purposePersonal;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Detailed Purpose of Transfer']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Enter detailed purpose of transfer\"]")
    protected WebElement detailedPurposeOfTransfer;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Shared Fees']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Shared Fees']")
    protected WebElement sharedFeesRadioButton;

    @AndroidFindBy(accessibility = "Standing Orders")
    @iOSXCUITFindBy(accessibility = "Standing Orders")
    protected WebElement standingOrders;

    @AndroidFindBy(accessibility = "Next")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Ne\") or contains(@name,\"Next\")]")
    protected WebElement next;

    @AndroidFindBy(accessibility = "Confirm")
    @iOSXCUITFindBy(accessibility = "Confirm")
    protected WebElement confirm;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Amount in (JOD)']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Amount in (JOD)']/following-sibling::XCUIElementTypeOther[1]")
    protected WebElement exchangeAmount;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Amount']/following-sibling::android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Amount']/following-sibling::XCUIElementTypeOther[2]/XCUIElementTypeOther")
    protected WebElement selectAmount;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='JOD']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='JOD']")
    protected WebElement selectAmountCurrency;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='TRANSACTIONS']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='TRANSACTIONS']")
    protected WebElement transactions;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Select Currency']/android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name,\"Se\") or contains(@name,\"Select\")]/following-sibling::XCUIElementTypeImage[1]")
    protected WebElement clickOnCurrency;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Transfer to Overseas']//../following-sibling::android.widget.ImageView)[12]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name='Transfer to Overseas']//../following-sibling::XCUIElementTypeImage)[12]")
    protected WebElement clickOk;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Exchange Rate']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Exchange Rate']/following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement exchangeRate;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Select Currency']/android.widget.ImageView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Search\"]")
    protected WebElement currency;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'BALANCE')]/android.widget.ImageView[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"ACCOUNT BALANCE\")]//following-sibling::XCUIElementTypeImage[3]")
    protected WebElement clickForwardArrow;

    @Override
    protected void waitForAppToLoad() {
    }

    public TransferPayeePage setAmount(String beneficiary, String amount) {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Transfer to " + beneficiary + "']", 90);
        logInfo("Inputting the amount " + amount);
        char[] charArray = amount.toCharArray();
        if (getDriver() instanceof AndroidDriver) {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='Transfer to " + beneficiary + "']//../following-sibling::" + parentAttribute2 + ")[11]"));
                else if (c == '.')
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='Transfer to " + beneficiary + "']//../following-sibling::" + parentAttribute2 + ")[10]"));
                else
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='Transfer to " + beneficiary + "']//../following-sibling::" + parentAttribute2 + ")[" + c + "]"));
            }
        } else {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[11]"));
                else if (c == '.')
                    click(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[10]"));
                else
                    getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[" + c + "]")).get(0).click();
            }
        }
        return this;
    }

    public TransferPayeePage enterBeneficiaryName(String name) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeTextField";
            attribute = "name";
        }
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Beneficiary Name']/following-sibling::" + parentAttribute2 + "[1]", 90);
        else
            utils.waitForElement(getDriver(), "//XCUIElementTypeTextField[@name=\"Enter recipient name\"]", 90);
        clickAndSendKeys(beneficiaryName, name, "Beneficiary name entered as " + name);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[contains(@name,\"Ne\") or contains(@name,\"Next\")]")).click();
        return this;
    }

    public void enterBeneficiaryAddress(String address) {
        clickAndSendKeys(beneficiaryAddress, address, "Beneficiary address entered as " + address);
        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[contains(@name,\"Ne\") or contains(@name,\"Next\")]")).click();
    }

    public void enterRoutingNumber(String number) {
        clickAndSendKeys(routingNumber, number, "Routing Number entered as " + number);
        if (getDriver() instanceof IOSDriver)
            scrollWithCoordinates("up", 0.5, beneficiaryName.getLocation().x, beneficiaryName.getLocation().y);
    }

    public void enterSwiftLabel(String label) {
        if (getDriver() instanceof IOSDriver) {
            tapOnPosition(swiftValue.getLocation().x + 10, swiftValue.getLocation().y + 25);
            swiftValue.sendKeys(label);
            scrollWithCoordinates("up", 0.30, swiftValue.getLocation().x, swiftValue.getLocation().y);
        } else {
            clickAndSendKeys(swiftValue, label, "Swift Label entered as " + label);
        }
    }

    public TransferPayeePage enterRecipientName(String name) {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Recipient Name']/following-sibling::" + parentAttribute2 + "[1]", 90);
        clickAndSendKeys(recipientName, name, "Recipient name entered as " + name);
        return this;
    }

    public void enterRecipientAddress(String address) {
        clickAndSendKeys(recipientAddress, address, "Recipient name entered as " + address);
    }

    public TransferPayeePage selectPurpose(String purpose) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        click(purposeOfTransfer);
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='" + purpose + "']", 90);
        click(purposePersonal, "Purpose is selected as " + purpose);
        return this;
    }

    public TransferPayeePage enterCurrency(String currencyType) {
        waitForVisibility(currency);
        clickAndSendKeys(currency, currencyType, "selecting the currency as" + currencyType);
        return this;
    }

    public void clickOnForwardArrow() {
        if (getDriver() instanceof AndroidDriver)
            click(clickForwardArrow, "click on forward arrow");
        else
            new HomePage().tapOnPosition(361, 303);
    }

    public TransferPayeePage selectAmount() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Amount']", 90);
        click(selectAmount);
        return this;
    }

    public TransferPayeePage selectCurrencyType() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Amount']", 60);
        click(selectAmountCurrency);
        return this;
    }

    public CliQTransferPage selectCurrency() {
        if (getDriver() instanceof AndroidDriver)
            click(clickOnCurrency, "clicking on the currency");
        else {
            tapOnPosition(clickOnCurrency.getLocation().x + 10, clickOnCurrency.getLocation().y + 5);
        }
        return new CliQTransferPage();
    }

    public void clickOk(String beneficiary) {
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
        if (getDriver() instanceof AndroidDriver)
            click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='Transfer to " + beneficiary + "']//../following-sibling::" + parentAttribute2 + ")[12]"));
        else
            click(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[12]"));
    }

    public TransferPayeePage swipeToName() throws InterruptedException {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Ne\") or contains(@name,\"Next\")]", 30);
        logInfo("swiping  to name");
        Thread.sleep(500);
        scroll("up", 0.6);
        Thread.sleep(500);
        return this;
    }

    public TransferPayeePage swipeToDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Pay From']", 90);
        By xpath = By.xpath("//" + parentAttribute + "[@" + attribute + "='Payment Details']");
        if (getDriver() instanceof AndroidDriver)
            scrollUntilElementPresent(xpath, "up", 0.6);
        else
            scrollWithCoordinates("up", 0.9, getDriver().findElement(xpath).getLocation().x + 100, getDriver().findElement(xpath).getLocation().y);
        logInfo("Scrolling to payment details");
        return this;
    }

    public void selectDetailedPurpose(String purpose) {
        click(detailedPurposeOfTransfer);
        click(standingOrders, "Detailed Purpose is selected as " + purpose);
    }

    public void clickNext() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Next']", 90);
        click(next, "Clicking next");
    }

    public void confirmTransfer() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Transfer')]", 90);
        click(confirm, "Clicking confirm");
    }

    public String getAmount() {
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
        return getTextWithAttribute(exchangeAmount, attribute);
    }

    public String getAmountValue(String Country) {
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
        if (getDriver() instanceof AndroidDriver)
            return getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "='Amount in (" + Country + ")']/following-sibling::" + parentAttribute + "[1]")).getAttribute(attribute);
        else
            return getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@" + attribute + "='Amount in (" + Country + ")']/following-sibling::XCUIElementTypeStaticText[1]")).getAttribute(attribute);
    }

    public String getExchangeRate() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Transfer')]", 90);
        return getTextWithAttribute(exchangeRate, attribute);
    }

    public TransferPayeePage selectFeeRadioButton() {
        click(sharedFeesRadioButton, "Change Options is selected as Shared fee");
        return this;
    }

    public void selectCard(String CountryName) {
        int count = 0;
        while (count < 5) {
            String cardValue = new CardPage().fetchDetails();
            logInfo("The card type is " + cardValue);
            if (cardValue.contains(CountryName)) {
                new TransfersPage().clickNewBeneficiary();
                break;
            } else {
                new TransferPayeePage().clickOnForwardArrow();
            }
            count++;
        }
    }
}