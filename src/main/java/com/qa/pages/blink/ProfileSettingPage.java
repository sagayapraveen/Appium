package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class ProfileSettingPage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Profile')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Profile')]")
    protected WebElement profileSettingButton;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Total Balance')]/android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Total Balance')]/XCUIElementTypeImage[2]")
    protected WebElement blinkLogo;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Email Address')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Email Address')]")
    protected WebElement emailID;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Error')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Error')]")
    protected WebElement errorMessage;
    @AndroidFindBy(accessibility = "Bills & Payments")
    @iOSXCUITFindBy(accessibility = "Bills & Payments")
    protected WebElement billPayments;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Mobile Number')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Mobile Number')]")
    protected WebElement mobileNumber;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'EMAIL ADDRESS')]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'EMAIL ADDRESS')]/XCUIElementTypeTextField")
    protected WebElement email;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'MOBILE NUMBER')]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'MOBILE NUMBER')]/XCUIElementTypeTextField")
    protected WebElement enterMobileNumber;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, '+')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, '+')]")
    protected WebElement countryDropdown;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mobile Number\"]/android.view.View[1]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Mobile Number\"]/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    protected WebElement searchCountry;
    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'India')][2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'India')][2]")
    protected WebElement selectCountry;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Mobile Number\"]/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Mobile Number\"]/XCUIElementTypeImage")
    protected WebElement okButton;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Change Password']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Change Password']")
    protected WebElement changePassword;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'CURRENT PASSWORD')]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'CURRENT PASSWORD')]/XCUIElementTypeTextField")
    protected WebElement currentPassword;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'NEW PASSWORD')]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'NEW PASSWORD')]/XCUIElementTypeTextField")
    protected WebElement newPassword;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'CONFIRM PASSWORD')]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'CONFIRM PASSWORD')]/XCUIElementTypeTextField")
    protected WebElement confirmPassword;

    @Override
    protected void waitForAppToLoad() {
    }

    public void clickProfileSetting() {
        waitForVisibility(billPayments);

        Point point = billPayments.getLocation();
        scrollWithCoordinates("left", 0.35, point.x + 10, point.y + 10);
        scrollWithCoordinates("left", 0.35, point.x + 10, point.y + 10);
        scrollWithCoordinates("left", 0.35, point.x + 10, point.y + 10);
        scrollWithCoordinates("left", 0.35, point.x + 10, point.y + 10);
        scrollWithCoordinates("left", 0.35, point.x + 10, point.y + 10);

        waitForVisibility(profileSettingButton);
        click(profileSettingButton, "Clicking the profile setting ");
    }

    public void clickOnLogo() {
        waitForVisibility(blinkLogo);
        click(blinkLogo, "Clicking on logo");
    }

    public void clickOnEmail() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Email Address')]", 60);
        click(emailID, "Clicking on email ID");
    }

    public void enterMailID(String emailID) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Please enter your')]", 60);
        clickAndSendKeys(email, emailID, "Entering the email ID");
        scroll("left", 0.50);
    }

    public String errorMessage() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Error')]", 60);
        return getTextWithAttribute(errorMessage, attribute).replaceAll("\n", " ");
    }

    public void clickOnMobileNumber() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Mobile Number')]", 60);
        click(mobileNumber, "Clicking on Mobile Number");
    }

    public void enterMobileNumber(String number) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", '+')]", 60);
        clickAndSendKeys(enterMobileNumber, number, "Entering mobile number");
        scroll("left", 0.50);
    }

    public ProfileSettingPage clickOnCountryDropdown(String country) throws InterruptedException {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", '+')]", 60);
        click(countryDropdown, "Clicking on country drop down");
        clickAndSendKeys(searchCountry, country, "Entering country ");
        Thread.sleep(2000);
        click(selectCountry, "Selecting country");
        return this;
    }

    public void clickOk() {
        click(okButton, "Clicking on ok ");
    }

    public void clickOnChangePassword() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Change Password']", 60);
        click(changePassword, "Clicking on change password");
    }

    public void currentPassword(String password) {
        waitForVisibility(currentPassword);
        clickAndSendKeys(currentPassword, password, "Entering current password ");
    }

    public void newPassword(String password) {
        clickAndSendKeys(newPassword, password, "Entering new password ");
    }

    public void confirmPassword(String password) {
        clickAndSendKeys(confirmPassword, password, "Confirming password ");
        scroll("left", 0.50);
    }

    public String fetchMobileNumber() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Mobile Number')]", 60);
        return getTextWithAttribute(mobileNumber, attribute).replaceAll("\n", " ");
    }
}