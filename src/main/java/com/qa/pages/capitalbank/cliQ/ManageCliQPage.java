package com.qa.pages.capitalbank.cliQ;

import com.qa.pages.BasePage;
import com.qa.utils.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Instant;
import java.util.Locale;

import static com.qa.engine.ProjectBase.logInfo;

public class ManageCliQPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Please Enter']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Please Enter']")
    protected WebElement aliasText;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Edit Details']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Edit Details']")
    protected WebElement editDetails;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Confirm']//..//..//../android.widget.CheckBox")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"CLIQ ID\")]//preceding::XCUIElementTypeSwitch[1]")
    protected WebElement radioButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Confirm']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Confirm']")
    protected WebElement confirmButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Back to DashBoard']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back to DashBoard']")
    protected WebElement dashboard;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='CliQ ID created successfully !']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'CliQ ID')]")
    protected WebElement successfulMessage;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'TOTAL ACCOUNT BALANCE')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'TOTAL ACCOUNT BALANCE')]")
    protected WebElement cardDetails;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Mobile number should')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Mobile number should')]")
    protected WebElement mobileNumberShouldBe;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='7X XXX XXXX']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='7X XXX XXXX']")
    protected WebElement enterMobileNumber;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Minimum of 3 characters')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Minimum of 3 characters')]")
    protected WebElement minimumCharacter;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'alphanumeric characters')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'alphanumeric characters')]")
    protected WebElement alphaNumeric;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Create CliQ ID']/following-sibling::android.view.View[4]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Create CliQ ID']/following-sibling::XCUIElementTypeStaticText[4]")
    protected WebElement aliasName;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Next']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next']")
    protected WebElement nextButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Successfully added as beneficiary!']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Successfully added as beneficiary!']")
    protected WebElement successMessage;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Manage CliQ ID\"]//..//../android.widget.ImageView)[last()]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Manage\")]/ancestor::XCUIElementTypeOther[1]/following-sibling::XCUIElementTypeButton[1]")
    protected WebElement addManageCliQID;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Select Default Link Account\"]/following-sibling::android.view.View/android.view.View/android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"BALANCE\")]")
    protected WebElement payFromCard;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Select Default Link Account\"]/following-sibling::android.view.View/android.view.View/android.view.View//android.widget.ImageView)[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"BALANCE\")]//following-sibling::XCUIElementTypeImage[3]")
    protected WebElement rightArrow;

    @Override
    protected void waitForAppToLoad() {
    }

    public void clickOnManageCliQID(String CliQ) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        scrollUntilElementPresent(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + CliQ + "']"), "up", 0.5);
        By xpath = By.xpath("//" + parentAttribute + "[@" + attribute + "='" + CliQ + "']");
        click(xpath, "Selecting Manage CliQ ID " + getAttribute(xpath, attribute).replaceAll("\n", " "));
    }

    public ManageCliQPage selectAlias(String cliQID) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        By xpath;
        if (getDriver() instanceof AndroidDriver) {
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Alias']", 60);
            xpath = By.xpath("//" + parentAttribute + "[@" + attribute + "='" + cliQID + "']");
        } else {
            utils.waitForElement(getDriver(), "(//XCUIElementTypeStaticText[@name=\"Alias\"])[1]", 60);
            xpath = By.xpath("(//XCUIElementTypeStaticText[@name=\"Alias\"])[1]");
        }
        click(xpath, "Selecting alias " + getAttribute(xpath, attribute).replaceAll("\n", " "));
        return new ManageCliQPage();
    }

    public ManageCliQPage selectMobileNumber(String mobileNumber) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        By xpath;
        if (getDriver() instanceof AndroidDriver) {
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Alias']", 60);
            xpath = By.xpath("//" + parentAttribute + "[@" + attribute + "='" + mobileNumber + "']");
        } else {
            utils.waitForElement(getDriver(), "(//XCUIElementTypeStaticText[@name=\"Mobile Number\"])[1]", 60);
            xpath = By.xpath("(//XCUIElementTypeStaticText[@name=\"Mobile Number\"])[1]");
        }

        click(xpath, "Selecting Mobile Number " + getAttribute(xpath, attribute).replaceAll("\n", " "));
        return new ManageCliQPage();
    }

    public void enterAlias(String value) {
        String number = new TestUtils().getRandomNumber(2);
        clickAndSendKeys(aliasText, value + number, "Entering Alias " + value + number);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public void clickOnEditDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Confirm']", 60);
        click(editDetails, "Click on Edit details");
    }

    public void editAlias(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Alias']", 60);

        if (getDriver() instanceof AndroidDriver) {
            new Actions(getDriver()).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                    .sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                    .sendKeys(value)
                    .perform();
        } else {
            tapOnPosition(aliasText.getLocation().x + 50, aliasText.getLocation().y + 5);
            aliasText.click();
            aliasText.clear();
            clickAndSendKeys(aliasText, value);
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
        }
    }

    public void clickOnConfirm() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Confirm\"]", 60);
        scroll("up", 0.50);
        click(radioButton, "Clicking on radio button");
        click(confirmButton, "Clicking on confirm button");
    }

    public String getCliQSavedSuccessMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='CliQ ID created successfully !']", 90);
        return getTextWithAttribute(successfulMessage, attribute);

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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'TOTAL ACCOUNT BALANCE')]", 60);
        return getTextWithAttribute(cardDetails, attribute);
    }

    public void clickOnCard(String currency) {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        String cardDetails = getAttribute(payFromCard, attribute).replaceAll("\n", " ").toUpperCase(Locale.ROOT);
        Instant timeout = Instant.now().plusSeconds(150);

        while (!cardDetails.contains(currency)) {
            cardDetails = payFromCard.getAttribute(attribute).replaceAll("\n", " ").toUpperCase(Locale.ROOT);

            if (cardDetails.contains(currency))
                break;

            if (getDriver() instanceof AndroidDriver)
                click(rightArrow, "Clicking right arrow");
            else
                tapOnPosition(rightArrow.getLocation().x + 5, rightArrow.getLocation().y + 5);

            if (Instant.now().isAfter(timeout)) {
                logInfo(currency + " Card is not available");
                break;
            }
        }

        logInfo(currency + " Card has been selected");

    }

    public void enterMobileNumber(String number) {
        clickAndSendKeys(enterMobileNumber, number + new TestUtils().getRandomNumber(4));

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public StringBuilder getCliQMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Minimum of 3 characters')]", 90);
        scroll("up");
        StringBuilder message = new StringBuilder();
        message.append(minimumCharacter.getAttribute(attribute)).append("\n ")
                .append(alphaNumeric.getAttribute(attribute));
        logInfo(message);
        return message;
    }

    public String getMobileNumberShouldBeOf() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Mobile number should')]", 90);
        return getTextWithAttribute(mobileNumberShouldBe, attribute);
    }

    public boolean isNextButtonIsClickable() {
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
        if (getDriver() instanceof AndroidDriver)
            return Boolean.parseBoolean(getTextWithAttribute(nextButton, "checkable"));
        else
            return Boolean.parseBoolean(getTextWithAttribute(nextButton, "enabled"));
    }

    public boolean isConfirmButtonIsClickable() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Confirm']", 90);
        if (getDriver() instanceof AndroidDriver)
            return Boolean.parseBoolean(getTextWithAttribute(confirmButton, "checkable"));
        else
            return Boolean.parseBoolean(getTextWithAttribute(confirmButton, "enabled"));
    }

    public void editAliasName(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Alias']", 90);
        if (getDriver() instanceof AndroidDriver) {
            new Actions(getDriver()).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                    .sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                    .sendKeys(value)
                    .perform();
        } else {
            tapOnPosition(aliasText.getLocation().x + 50, aliasText.getLocation().y + 5);
            aliasText.click();
            aliasText.clear();
            clickAndSendKeys(aliasText, value);
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
        }
    }

    public String getEditedAlias() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Create CliQ ID']/following-sibling::" + parentAttribute + "[4]", 90);
        String name = getTextWithAttribute(aliasName, attribute);
        logInfo(name);
        return name;
    }

    public String successMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Successfully added as beneficiary!']", 60);
        return getTextWithAttribute(successMessage, attribute);
    }

    public void clickingAddCliQ() {
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
            utils.waitForElement(getDriver(), "(//" + parentAttribute + "[@" + attribute + "='Manage CliQ ID']//..//../" + parentAttribute2 + ")[last()]", 60);
        else
            utils.waitForElement(getDriver(), "//XCUIElementTypeOther[@name=\"Manage CliQ ID\"]", 60);

        click(addManageCliQID, "Clicking on Add CliQ");
    }

    public void enterAliasText(String value) {
        clickAndSendKeys(aliasText, value, "Entering Alias as " + value);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public void enterTheMobileNumber(String number) {
        clickAndSendKeys(enterMobileNumber, number, "Entering Mobile Number as " + number);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }
}