package com.qa.pages.capitalbank.beneficiary;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BeneficiaryDetailsPage extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Beneficiary Details']/following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"IBAN/Account No.\" or @name=\"IBAN\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField")
    protected WebElement iban;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Nick Name']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Nick Name']/following-sibling::XCUIElementTypeTextField[1]")
    protected WebElement nickName;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Nick Name']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Nick\")]//following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField")
    protected WebElement editedNickName;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Name']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Name']/following-sibling::XCUIElementTypeTextField[1]")
    protected WebElement name;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Name']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Name']/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField[1]")
    protected WebElement editedName;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Alias']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Alias']/following-sibling::XCUIElementTypeTextField[1]")
    protected WebElement alias;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Mobile Number']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile Number']/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField[1]")
    protected WebElement mobileNumber;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Address']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Address']/following-sibling::XCUIElementTypeTextField[1]")
    protected WebElement address;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Address']/following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Address']/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField[1]")
    protected WebElement editedAddress;

    @AndroidFindBy(accessibility = "Next")
    @iOSXCUITFindBy(accessibility = "Next")
    protected WebElement next;

    @AndroidFindBy(accessibility = "Confirm")
    @iOSXCUITFindBy(accessibility = "Confirm")
    protected WebElement confirm;

    @AndroidFindBy(accessibility = "Domestic")
    @iOSXCUITFindBy(accessibility = "Domestic")
    protected WebElement domestic;

    @AndroidFindBy(accessibility = "CliQ")
    @iOSXCUITFindBy(accessibility = "CliQ")
    protected WebElement cliq;

    @AndroidFindBy(accessibility = "Save")
    @iOSXCUITFindBy(accessibility = "Save")
    protected WebElement save;

    @AndroidFindBy(accessibility = "CliQ ID Alias")
    @iOSXCUITFindBy(accessibility = "CliQ ID Alias")
    protected WebElement cliqAlias;

    @AndroidFindBy(accessibility = "CliQ ID Mobile Number")
    @iOSXCUITFindBy(accessibility = "CliQ ID Mobile Number")
    protected WebElement cliqMobileNumber;

    @AndroidFindBy(accessibility = "IBAN")
    @iOSXCUITFindBy(accessibility = "IBAN")
    protected WebElement typeIban;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Beneficiary Type']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Beneficiary Type']/following-sibling::XCUIElementTypeOther[1]")
    protected WebElement beneficiaryType;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Bank Country']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Bank Country']/following-sibling::XCUIElementTypeOther[1]")
    protected WebElement bankCountryDropdown;

    @Override
    protected void waitForAppToLoad() {
    }

    public BeneficiaryDetailsPage domesticTransaction() {
        click(domestic, "Selecting Domestic as Transaction type");
        return this;
    }

    public BeneficiaryDetailsPage cliQ() {
        click(cliq, "Selecting CliQ as Transaction type");
        return this;
    }

    public BeneficiaryDetailsPage setIban(String ibanNumber) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Details')]", 90);

        if (getDriver() instanceof IOSDriver)
            tapOnPosition(iban.getLocation().x + 100, iban.getLocation().y + 5);

        clear(iban);
        clickAndSendKeys(iban, ibanNumber, "IBAN/Account is set to " + ibanNumber);

        if (getDriver() instanceof AndroidDriver)
            new Actions(getDriver()).sendKeys(Keys.TAB).perform();
        else
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[contains(@name,\"D\") or contains(@name,\"one\") or contains(@name,\"N\") or contains(@name,\"ext\")]")).click();

        waitForVisibility(iban);
        return this;
    }

    public BeneficiaryDetailsPage setNickName(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Nick')]", 90);
        if (getDriver() instanceof IOSDriver)
            tapOnPosition(nickName.getLocation().x + 250, nickName.getLocation().y + 5);
        nickName.sendKeys(value);
        clear(nickName);
        clickAndSendKeys(editedNickName, value, "Nickname is set to " + value);

        if (getDriver() instanceof AndroidDriver)
            new Actions(getDriver()).sendKeys(Keys.TAB).perform();
        else
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[contains(@name,\"D\") or contains(@name,\"one\")]")).click();
        return this;
    }

    public BeneficiaryDetailsPage setAlias(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Beneficiary Details']", 90);
        if (getDriver() instanceof IOSDriver)
            tapOnPosition(alias.getLocation().x + 100, alias.getLocation().y + 5);
        clear(alias);
        clickAndSendKeys(alias, value, "Alias has set to " + value);
        return this;
    }

    public BeneficiaryDetailsPage setMobileNumber(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Beneficiary Details']", 90);
        if (getDriver() instanceof IOSDriver)
            tapOnPosition(mobileNumber.getLocation().x + 100, mobileNumber.getLocation().y + 5);
        clear(mobileNumber);
        clickAndSendKeys(mobileNumber, value, "MobileNumber has set to " + value);
        return this;
    }

    public BeneficiaryDetailsPage setName(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Name']", 90);
        scroll("up", 0.2);
        if (getDriver() instanceof IOSDriver)
            tapOnPosition(name.getLocation().x + 200, name.getLocation().y + 5);
        clear(name);
        clickAndSendKeys(name, value, "Name is set to " + value);
        if (getDriver() instanceof AndroidDriver)
            new Actions(getDriver()).sendKeys(Keys.TAB).perform();
        else
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Next:\"]")).click();

        return this;
    }

    public BeneficiaryDetailsPage setAddress(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        if (getDriver() instanceof IOSDriver)
            scrollUntilElementPresent(By.xpath("//XCUIElementTypeStaticText[@name='Address']/following-sibling::XCUIElementTypeTextField[1]"), "up", 0.5);

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Address']", 90);
        if (getDriver() instanceof IOSDriver)
            tapOnPosition(address.getLocation().x + 100, address.getLocation().y + 5);
        clear(address);
        clickAndSendKeys(address, value, "Address is set to " + value);
        if (getDriver() instanceof AndroidDriver)
            new Actions(getDriver()).sendKeys(Keys.TAB).perform();
        else
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Next:\"]")).click();
        return this;
    }

    public BeneficiaryDetailsPage updatingNickname(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Beneficiary Details']", 90);

        if (getDriver() instanceof IOSDriver) {
            By xpath = By.xpath("//XCUIElementTypeStaticText[@name='Nick Name']//following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeTextField");
            tapOnPosition(getDriver().findElement(xpath).getLocation().x + 150, getDriver().findElement(xpath).getLocation().y + 5);
            getDriver().findElement(xpath).clear();
            getDriver().findElement(xpath).sendKeys(value);
            getDriver().findElement(By.xpath("//*[contains(@name,\"D\") or contains(@name,\"one\") or contains(@name,'N') or contains(@name,\"ext\")]")).click();
        } else {
            clear(nickName);
            clickAndSendKeys(nickName, value, "Nickname is updated to " + value);
            new Actions(getDriver()).sendKeys(Keys.ENTER).perform();
        }

        return this;
    }

    public void updatingIban(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Beneficiary Details']", 90);
        if (getDriver() instanceof IOSDriver) {
            By xpath = By.xpath("//XCUIElementTypeStaticText[@name='IBAN']//following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeTextField");
            tapOnPosition(getDriver().findElement(xpath).getLocation().x + 150, getDriver().findElement(xpath).getLocation().y + 5);
            getDriver().findElement(xpath).clear();
            getDriver().findElement(xpath).sendKeys(value);
            getDriver().findElement(By.xpath("//*[contains(@name,\"D\") or contains(@name,\"one\") or contains(@name,'N') or contains(@name,\"ext\")]")).click();
        } else {
            clear(iban);
            clickAndSendKeys(iban, value, "IBAN is updated to " + value);
            new Actions(getDriver()).sendKeys(Keys.TAB).perform();
        }
    }

    public void clearNickName() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Beneficiary Details']", 90);
        if (getDriver() instanceof IOSDriver)
            tapOnPosition(nickName.getLocation().x + 200, nickName.getLocation().y + 5);
        else
            click(nickName);
        clear(nickName);

        new Actions(getDriver()).sendKeys(Keys.TAB).perform();
    }

    public void clearName() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Beneficiary Details']", 90);
        if (getDriver() instanceof IOSDriver)
            tapOnPosition(editedName.getLocation().x + 100, editedName.getLocation().y + 5);
        clear(editedName, "Name field is cleared");
        if (getDriver() instanceof AndroidDriver)
            new Actions(getDriver()).sendKeys(Keys.TAB).perform();
        else
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Next:\"]")).click();
    }

    public void clearAddress() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Address']", 90);
        if (getDriver() instanceof IOSDriver)
            tapOnPosition(address.getLocation().x + 100, address.getLocation().y + 5);
        address.clear();
        scrollWithCoordinates("up", 0.5, nickName.getLocation().x, nickName.getLocation().y);
    }

    public void clickNext() {
        click(next, "Clicking next");
    }

    public void saveChanges() {
        click(save, "Saving the changes");
    }

    public void clickConfirm() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Add profile image']", 60);
        click(confirm, "Clicking confirm");
    }

    public String getSuccessMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Successfully added as beneficiary!']", 90);

        String message = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "='Successfully added as beneficiary!']")).getAttribute(attribute);

        message = message + getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "='Successfully added as beneficiary!']/following-sibling::" + parentAttribute))
                .getAttribute(attribute);
        return message;
    }

    public BeneficiaryDetailsPage selectCliqAlias() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        click(beneficiaryType);
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Beneficiary Type')]", 60);
        click(cliqAlias, "Selecting CliQ ID Alias as type");
        return this;
    }

    public BeneficiaryDetailsPage selectCliqMobileNumber() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        click(beneficiaryType);
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Select Beneficiary Type']", 60);
        click(cliqMobileNumber, "Selecting CliQ ID Mobile Number as type");
        return this;
    }

    public BeneficiaryDetailsPage selectCliqIban() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        click(beneficiaryType);
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Select Beneficiary Type']", 60);
        click(typeIban, "Selecting CliQ IBAN as type");
        return this;
    }

    public void selectBankCountry(String country) {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Beneficiary Details']", 90);

        click(bankCountryDropdown);

        By xpath = By.xpath("//" + parentAttribute2 + "[@" + attribute + "='" + country + "']");

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Select Bank Country']", 60);

        scrollUntilElementPresent(xpath, "up", 0.5);

        click(xpath, "Selecting the Bank country as " + country);
    }

    public void editedNickName(String value) {
        clickAndSendKeys(editedNickName, value, "Entered nick name");
    }

    public void editedAddress(String value) {
        clickAndSendKeys(editedAddress, value, "Entered nick name");
    }

    public BeneficiaryDetailsPage updatedName(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Beneficiary Details']", 90);
        if (getDriver() instanceof IOSDriver)
            tapOnPosition(name.getLocation().x + 200, name.getLocation().y + 5);
        clear(name, "Name field is cleared");
        clickAndSendKeys(editedName, value, "Name has been entered");
        if (getDriver() instanceof AndroidDriver)
            new Actions(getDriver()).sendKeys(Keys.TAB).perform();
        else
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Next:\"]")).click();

        return this;
    }
}