package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateNewCliQ extends BasePage {
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Back to Manage CliQ'])[1]/android.view.View/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name,'CLIQ ID TYPE')]")
    protected WebElement cliQType;
    @AndroidFindBy(accessibility = "Alias")
    @iOSXCUITFindBy(accessibility = "Alias")
    protected WebElement alias;
    @AndroidFindBy(accessibility = "Mobile Number")
    @iOSXCUITFindBy(accessibility = "Mobile Number")
    protected WebElement mobileNumber;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'CliQ ID Type')]/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Swipe down\")]//following-sibling::XCUIElementTypeImage")
    protected WebElement clickOk;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='ALIAS￼']/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='ALIAS']/following-sibling::XCUIElementTypeTextField")
    protected WebElement aliasName;
    @AndroidFindBy(accessibility = "NO")
    @iOSXCUITFindBy(accessibility = "NO")
    protected WebElement setAsDefaultAccount;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Back to Manage CliQ']/android.view.View/android.view.View[5]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"creation of your CliQ ID\")]/preceding::XCUIElementTypeOther[1]")
    protected WebElement acceptingCreation;

    @Override
    protected void waitForAppToLoad() {
    }

    public CreateNewCliQ selectCliQAlias() {
        String parrentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parrentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parrentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + parrentAttribute + "[contains(@" + attribute + ", 'create your new')]", 50);
        else
            utils.waitForElement(getDriver(), "//" + parrentAttribute + "[contains(@" + attribute + ", 'CREATE NEW CLIQ ID')]", 50);
        click(cliQType);
        click(clickOk, "Selecting CliQ type as Alias");
        return this;
    }

    public CreateNewCliQ selectCliQMobile() {
        String parrentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parrentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parrentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parrentAttribute + "[contains(@" + attribute + ", 'create your new')]", 50);
        click(mobileNumber);
        click(clickOk, "Selecting CliQ type as Alias");
        return this;
    }

    public CreateNewCliQ setAliasName(String name) {
        clickAndSendKeys(aliasName, name);

        if (getDriver() instanceof IOSDriver)
            click(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]"));
        return this;
    }

    public CreateNewCliQ setDefaultAccount() {
        String parrentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parrentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parrentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + parrentAttribute + "[contains(@" + attribute + ", 'Link bank account to')]", 50);
        else
            utils.waitForElement(getDriver(), "//XCUIElementTypeStaticText[@name=\"Linked Account\"]", 50);
        click(setAsDefaultAccount, "Selecting as default account");
        return this;
    }

    public void acceptCreation() {
        waitForVisibility(acceptingCreation);
        click(acceptingCreation, "Clicking accepting creation checkbox");
    }

    public String fetchSuccessMessage() {
        String parrentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parrentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parrentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        String xpath = "//" + parrentAttribute + "[contains(@" + attribute + ", 'CliQ ID created')]";
        utils.waitForElement(getDriver(), xpath, 30);
        return getAttribute(By.xpath(xpath), attribute);
    }
}
