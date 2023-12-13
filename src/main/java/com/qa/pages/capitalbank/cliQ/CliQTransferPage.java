package com.qa.pages.capitalbank.cliQ;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.qa.engine.ProjectBase.logInfo;

public class CliQTransferPage extends BasePage {

    @AndroidFindBy(accessibility = "CliQ")
    @iOSXCUITFindBy(accessibility = "CliQ")
    protected WebElement cliQButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='CLIQ ID']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CLIQ ID']")
    protected WebElement CliQID;

    @AndroidFindBy(accessibility = "TRANSACTIONS")
    @iOSXCUITFindBy(accessibility = "TRANSACTIONS")
    protected WebElement transactionButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Please Enter']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Please Enter']")
    protected WebElement enterBeneficiary;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter recipient name']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Enter recipient name']")
    protected WebElement recipientName;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Please enter at least 3 names')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Please enter at least 3 names')]")
    protected WebElement recipientNameError;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter Recipient Address']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Enter Recipient Address']")
    protected WebElement recipientAddress;

    @AndroidFindBy(xpath = "//android.view.View[@text='Enter purpose of transfer']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Enter purpose of transfer']")
    protected WebElement purpose;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Recipient address cannot be empty']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Recipient address cannot be empty']")
    protected WebElement recipientAddressError;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Please enter description']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Please enter description']")
    protected WebElement description;

    @AndroidFindBy(accessibility = "Confirm")
    @iOSXCUITFindBy(accessibility = "Confirm")
    protected WebElement confirmButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Transfer successful!']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Transfer successful!']")
    protected WebElement transferSuccessMessage;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Ref No']/following-sibling::android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Ref No']/following-sibling::XCUIElementTypeOther")
    protected WebElement transferReferenceNumber;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Amount']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Amount']/following-sibling::XCUIElementTypeOther[1]")
    protected WebElement transferAmount;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='CLIQ ID']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='CLIQ ID']/following-sibling::XCUIElementTypeOther[1]")
    protected WebElement cliQid;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Amount']/following-sibling::android.view.View[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Amount']/following-sibling::XCUIElementTypeOther[3]")
    protected WebElement transferRecipientName;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Add as Beneficiary']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Add as Beneficiary']")
    protected WebElement addAsBeneficiary;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@text='Search']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Search']")
    protected WebElement savedBeneficiary;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Pay To\"]/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Pay To\"]/following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement confirmButton1;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='CURRENT ACCOUNT']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='CURRENT ACCOUNT']")
    protected WebElement accountType;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='TOTAL ACCOUNT BALANCE']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='TOTAL ACCOUNT BALANCE']")
    protected WebElement totalAmount;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'JOD')][2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'JOD')][2]")
    protected WebElement balanceInCard;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'ACCOUNT NUMBER')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'ACCOUNT NUMBER')]")
    protected WebElement accountNumber;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Pay To']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Pay To']/following-sibling::XCUIElementTypeOther[1]")
    protected WebElement ibanNumberPayTo;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Pay To']/following-sibling::android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Pay To']/following-sibling::XCUIElementTypeOther[1]")
    protected WebElement bankName;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Recipient Name']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Recipient Name']")
    protected WebElement paymentRecipientName;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Recipient Address']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Recipient Address']")
    protected WebElement paymentRecipientAddress;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Purpose of Transfer']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Purpose of Transfer']")
    protected WebElement purposeTransfer;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Description (Optional)']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Description (Optional)']")
    protected WebElement descriptionOptional;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='JOD']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='JOD']")
    protected WebElement jodCurrency;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'TOTAL ACCOUNT BALANCE')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'TOTAL ACCOUNT BALANCE')]")
    protected WebElement cardBalance;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Pay To\"]/following-sibling::android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Pay To\"]/following-sibling::XCUIElementTypeStaticText[2]")
    protected WebElement verifyPayTo;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Next']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next']")
    protected WebElement nextButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Pay To\"]/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Pay To\"]//following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement fetchIBAN;

    @Override
    protected void waitForAppToLoad() {
    }

    public StringBuilder getCliQTransferDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        StringBuilder message = new StringBuilder();
        message.append(accountType.getAttribute(attribute)).append("\n ")
                .append(totalAmount.getAttribute(attribute)).append(" \n ")
                .append(balanceInCard.getAttribute(attribute)).append("\n")
                .append(accountNumber.getAttribute(attribute)).append(" \n ")
                .append(ibanNumberPayTo.getAttribute(attribute)).append(" \n ")
                .append(bankName.getAttribute(attribute));
        scroll("up", 0.70);
        message.append(paymentRecipientName.getAttribute(attribute)).append("\n ")
                .append(paymentRecipientAddress.getAttribute(attribute)).append("\n")
                .append(purposeTransfer.getAttribute(attribute)).append("\n")
                .append(descriptionOptional.getAttribute(attribute));
        logInfo(" Retrieving CliQ Transfer details " + message);
        return message;
    }

    public void searchForSavedBeneficiary(String saveBeneficiary) {
        String parentAttribute = "";
        String attribute = "";
        String parentAttribute2 = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            parentAttribute2 = "android.view.View";
            attribute = "content-desc";

        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeTextField";
            parentAttribute2 = "XCUIElementTypeStaticText";
            attribute = "name";
        }

        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@text='Search']", 60);
        else
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@name='Search']", 60);

        clickAndSendKeys(savedBeneficiary, saveBeneficiary);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Search\"]")).click();

        logInfo("Text is entering as" + saveBeneficiary);
        click(By.xpath("//" + parentAttribute2 + "[contains(@" + attribute + ", '" + saveBeneficiary + "')]"), "Clicking on biller " + saveBeneficiary);
    }

    public void clickOnCliQ() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='CliQ']", 90);
        click(cliQButton, "Clicking on CliQ");
    }

    public void clickOnCliQTransfer(String CliQID) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), By.xpath("//" + parentAttribute + "[@" + attribute + "='" + CliQID + "']"), 60);
        By xpath = By.xpath("//" + parentAttribute + "[@" + attribute + "='" + CliQID + "']");
        click(xpath, "Selecting Beneficiary Type " + getAttribute(xpath, attribute).replaceAll("\n", " "));
    }

    public boolean getSavedBiller(String biller) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//*[@" + attribute + "='CliQ']", 60);
        scroll("up", 0.30);
        return getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + biller + "')]")).size() == 1;
    }

    public String iShouldBeInCliQTransferPage(String page) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='" + page + "']", 60);
        String message = getTextWithAttribute(CliQID, attribute);
        logInfo("App is in " + message + "page");
        return message;
    }

    public void clickBeneficiaryType(String BeneficiaryType) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='CLIQ ID']", 60);
        By xpath = By.xpath("//" + parentAttribute + "[@" + attribute + "='" + BeneficiaryType + "']");
        click(xpath, "Selecting Beneficiary Type " + getAttribute(xpath, attribute).replaceAll("\n", " "));
    }

    public void enterBeneficiary(String beneficiary) {
        clickAndSendKeys(enterBeneficiary, beneficiary, "Entering the IBAN  " + beneficiary);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public void enterMobileNumberOrAlias(String text) {
        clickAndSendKeys(enterBeneficiary, text, "Entering the Alias " + text);

        getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public CliQTransferPage enterAmount(String amount, String page) {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='" + page + "']", 60);
        logInfo("Inputting the amount " + amount);

        if (getDriver() instanceof AndroidDriver)
            click(By.xpath("//" + parentAttribute + "[@" + attribute + "='Amount']/following-sibling::" + parentAttribute + "[1]"));
        else
            click(By.xpath("//XCUIElementTypeStaticText[@" + attribute + "='Amount']/following-sibling::" + parentAttribute + "[1]"));

        char[] charArray = amount.toCharArray();
        if (getDriver() instanceof AndroidDriver) {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='" + page + "']//../following-sibling::" + parentAttribute2 + ")[11]"));
                else
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='" + page + "']//../following-sibling::" + parentAttribute2 + ")[" + c + "]"));
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
        return new CliQTransferPage();
    }

    public void clickOk() {
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
            click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='CLIQ Transfer']//../following-sibling::" + parentAttribute2 + ")[12]"));
        else
            click(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[12]"));
        new CliQTransferPage();
    }

    public void enterRecipientName(String name) {
        scroll("up", 0.50);
        clickAndSendKeys(recipientName, name, "Entering the recipientName " + name);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public String recipientNameError() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Please enter at least 3 names')]", 60);
        String error = getTextWithAttribute(recipientNameError, attribute);
        logInfo(error);
        return error;
    }

    public void enterRecipientAddress(String address) {
        clickAndSendKeys(recipientAddress, address, "Entering the address  " + address);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[contains(@name,\"D\") or contains(@name,\"one\")]")).click();
    }

    public void selectPurpose(String purposeOption) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        click(purpose, "Clicking on purpose dropdown");
        utils.waitForElement(getDriver(), By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + purposeOption + "')]"), 60);
        By xpath = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + purposeOption + "')]");
        click(xpath, "Selecting purpose Type " + getAttribute(xpath, attribute).replaceAll("\n", " "));
    }

    public String recipientAddressError() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'address cannot be empty')]", 60);
        return getTextWithAttribute(recipientAddressError, attribute);
    }

    public void enterDescription(String descriptionText) {
        scroll("up", 0.30);
        clickAndSendKeys(description, descriptionText, "Entering the Description  " + descriptionText);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public void clickOnConfirm() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"CLIQ Transfer\"]", 60);
        click(confirmButton, "Clicking on confirm");
    }

    public void clickOnBeneficiary() {
        click(addAsBeneficiary, "Clicking on addBeneficiary ");
    }

    public void selectPurposeFromDropdown(String purposeOption) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        scroll("up", 0.50);
        click(purpose, "Clicking on purpose dropdown");
        utils.waitForElement(getDriver(), By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + purposeOption + "')]"), 60);
        By xpath = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + purposeOption + "')]");
        click(xpath, "Selecting purpose Type " + getAttribute(xpath, attribute).replaceAll("\n", " "));
    }

    public StringBuilder getTransferSuccessfulMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Transfer successful!\"]", 90);
        StringBuilder message = new StringBuilder();
        message.append(transferSuccessMessage.getAttribute(attribute)).append("\n ")
                .append(cliQid.getAttribute(attribute)).append(" \n ")
                .append(transferAmount.getAttribute(attribute)).append(" \n ")
                .append(transferRecipientName.getAttribute(attribute)).append("\n")
                .append(transferReferenceNumber.getAttribute(attribute));
        logInfo("successfully message " + message);
        return message;
    }

    public StringBuilder getTransferSuccessfulDetails(float enteredAmount) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Transfer successful!']", 90);
        StringBuilder message = new StringBuilder();
        message.append(transferSuccessMessage.getAttribute(attribute)).append("\n ")
                .append(cliQid.getAttribute(attribute)).append(" \n ")
                .append(transferAmount.getAttribute(attribute)).append(" \n ")
                .append(transferReferenceNumber.getAttribute(attribute)).append("\n");
        logInfo("successfully message " + message);
        return message;
    }

    public String confirmPage() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(confirmButton1);
        String error = getTextWithAttribute(confirmButton1, attribute);
        logInfo(error);
        return error;
    }

    public boolean isCurrencyButtonIsClickable() {
        logInfo("currency not allowed to amand");
        if (getDriver() instanceof AndroidDriver)
            return Boolean.parseBoolean(getTextWithAttribute(jodCurrency, "checkable"));
        else
            return Boolean.parseBoolean(getTextWithAttribute(jodCurrency, "visible"));
    }

    public String fetchCardDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='CliQ']", 90);
        String cardDetails = getAttribute(cardBalance, attribute);
        logInfo(cardDetails);
        return cardDetails;
    }

    public void enterAmountInTransfer(String amount, String page) {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='" + page + "']", 60);
        //click(By.xpath("//" + parentAttribute + "[@" + attribute + "='Amount']/following-sibling::" + parentAttribute + "[1]"));

        char[] charArray = amount.toCharArray();
        if (getDriver() instanceof AndroidDriver) {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='" + page + "']//../following-sibling::" + parentAttribute2 + ")[11]"));
                else
                    click(By.xpath("(//" + parentAttribute + "[@" + attribute + "='" + page + "']//../following-sibling::" + parentAttribute2 + ")[" + c + "]"));
            }
        } else {
            click(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]/following-sibling::XCUIElementTypeOther[1]"));
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[11]"));
                else if (c == '.')
                    click(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[10]"));
                else
                    getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[" + c + "]")).get(0).click();
            }
        }
        logInfo("Inputting the amount " + amount);
    }

    public void clickOnOkInKeypad() {
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
            click(By.xpath("//" + parentAttribute + "[@" + attribute + "='Transfers']//../following-sibling::" + parentAttribute2 + "[12]"));
        else
            click(By.xpath("//XCUIElementTypeStaticText[@name=\"Amount\"]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[12]"));
    }

    public void clickConfirm() {
        click(confirmButton, "Clicking on confirm");
    }

    public void clickOnNext() {
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
        click(nextButton, "Clicking on Next Button");
    }

    public String getTransactionDetails() {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Accounts\"]", 90);
        scrollUntilElementPresent(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"TRANSACTIONS\"]"), "up", 0.80);

        click(transactionButton, "Clicking in transfers");

        return getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "='Latest Transactions']/ancestor::" + parentAttribute2))
                .getAttribute(attribute).replaceAll("\n", " ");
    }

    public String iShouldTheIBANInTransferPage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Confirm Transfer\"]", 60);
        return getTextWithAttribute(fetchIBAN, attribute);
    }

    public String fetchDetailsOfPayTo() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(verifyPayTo);
        return getTextWithAttribute(verifyPayTo, attribute);
    }
}