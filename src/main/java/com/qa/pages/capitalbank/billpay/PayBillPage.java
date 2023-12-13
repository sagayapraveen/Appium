package com.qa.pages.capitalbank.billpay;

import com.qa.pages.BasePage;
import com.qa.pages.blink.HomePage;
import com.qa.utils.TestUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.time.Instant;
import java.util.List;

import static com.qa.engine.ProjectBase.logInfo;

public class PayBillPage extends BasePage {
    @AndroidFindBy(accessibility = "POSTPAID")
    @iOSXCUITFindBy(accessibility = "POSTPAID")
    protected WebElement postPaid;

    @AndroidFindBy(accessibility = "New Biller")
    @iOSXCUITFindBy(accessibility = "New Biller")
    protected WebElement newBillerButton;

    @AndroidFindBy(accessibility = "PREPAID")
    @iOSXCUITFindBy(accessibility = "PREPAID")
    protected WebElement prepaidButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Next']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Next']")
    protected WebElement nextButton;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'History')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'History')]")
    protected WebElement viewHistory;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, '2023')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, '2023')]")
    protected WebElement latestTransaction;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@text, 'Search')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name, 'Search')]")
    protected WebElement selectCategory;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Mobile Number']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Mobile Number\"]")
    protected WebElement mobileNumber;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Mobile Number']/following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Mobile Number']/following-sibling::XCUIElementTypeTextField")
    protected WebElement billerMobileNumber;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Biller Name']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Biller Name']/following-sibling::XCUIElementTypeOther[1]")
    protected WebElement billerName;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Biller Name']/following-sibling::android.view.View[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Biller Name']/following-sibling::XCUIElementTypeOther[2]")
    protected WebElement serviceType;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"asd\"]/following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"sad\"]")
    protected WebElement newRegistration;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Denomination']/following-sibling::android.view.View")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Please Select\"])[3]")
    protected WebElement selectPrepaidDenomination;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Prepaid2']/following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Prepaid2']/following-sibling::XCUIElementTypeTextField")
    protected WebElement selectPrepaid;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Bill')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Bill')]")
    protected WebElement payNewBillPage;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Biller Details']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Biller Details']/following-sibling::XCUIElementTypeOther[1]")
    protected WebElement getBiller;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'New registration')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[contains(@name, 'New registration')]")
    protected WebElement getRegistration;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Billing number')]/following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Enter Billing number\"]")
    protected WebElement billingNumber;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Back to Dashboard']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Back to Dashboard']")
    protected WebElement dashboard;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='You have successfully paid your bill!']/following-sibling::android.widget.Button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back to Dashboard\"]")
    protected WebElement postpaidDashboard;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Nickname']/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Please Enter\"]")
    protected WebElement nickName;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Total Amount']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Total Amount']/following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement totalAmount;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'BALANCE')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"TOTAL ACCOUNT BALANCE\")]")
    protected WebElement cardDetails;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@index=2])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"TOTAL ACCOUNT BALANCE\")]//following-sibling::XCUIElementTypeImage[3]")
    protected WebElement cardForwardButton;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Pay to'])[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Pay to'])[2]")
    protected WebElement payToButton;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc='Biller Name']/following-sibling::android.view.View[@text='Please Select'])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Please Select\"])[1]")
    protected WebElement clickBillerName;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Service Type']/following-sibling::android.view.View[@text='Please Select']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Please Select\"])[2]")
    protected WebElement clickServiceType;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Confirm Bill Pay']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Confirm Bill Pay']")
    protected WebElement confirmPage;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Madfooat2')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'oat2')]")
    protected WebElement savedBiller;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Delete\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Delete\"]")
    protected WebElement deleteButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Confirm\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirm\"]")
    protected WebElement confirmMessage;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'SUCCESS')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'SUCCESS')]")
    protected WebElement successfulMessage;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'billers selected')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'billers selected')]")
    protected WebElement selectAll;


    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"fees\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"fees\"]")
    protected WebElement fees;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Save Biller\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save Biller\"]")
    protected WebElement saveBillerButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Back to Dashboard\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back to Dashboard\"]")
    protected WebElement backToDashboard;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Nickname\"]/following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Nickname\"]/following-sibling::XCUIElementTypeTextField")
    protected WebElement payBillNickName;

    @Override
    protected void waitForAppToLoad() {
    }

    public void postPaidButton() {
        waitForVisibility(postPaid);
        click(postPaid, "Click on postpaid button");
    }

    public void clickPrepaidButton() {
        waitForVisibility(postPaid);
        click(prepaidButton, "Click on prepaid button");
    }

    public void clickNewBillerButton() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        waitForVisibility(newBillerButton);
        if (getDriver() instanceof AndroidDriver)
            click(newBillerButton, "Click on new biller");
        else {
            newBillerButton.click();
            logInfo("Click on new biller");
        }
    }

    public String getLatestTransaction() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(latestTransaction);
        return getTextWithAttribute(latestTransaction, attribute);
    }

    public void clickOnViewHistory() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'History')]", 90);
        click(viewHistory, "Click on View History");
    }

    public void clickOnSelectCategory(String biller) {
        waitForVisibility(selectCategory);
        if (getDriver() instanceof AndroidDriver) {
            click(selectCategory);
            clickAndSendKeys(selectCategory, biller);
        } else {
            new HomePage().tapOnPosition(selectCategory.getLocation().x + 30, selectCategory.getLocation().y + 60);
            sendKeys(selectCategory, biller);
        }
        logInfo("Text is entered as  " + biller);
    }

    public String getMobileNumber() {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Mobile Number']/following-sibling::" + parentAttribute2, 90);
        return getTextWithAttribute(mobileNumber, attribute);
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

    public String getBiller() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Biller Details']", 90);
        return getTextWithAttribute(getBiller, attribute);
    }

    public void selectNewBiller(String name) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        click(billerName);
        utils.waitForElement(getDriver(), "//*[contains(@" + attribute + ", 'Select Biller Name')]", 90);
        scrollUntilElementPresent(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + name + "')]"), "up", 0.50);
        click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + name + "')]"), "Click on biller " + name);
    }

    public void selectServiceType(String service) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        click(serviceType);
        utils.waitForElement(getDriver(), "//*[contains(@" + attribute + ", 'Select Service Type')]", 90);
        click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + service + "')]"), "Click on service " + service);
    }

    public void selectRegistration(String number) {
        clickAndSendKeys(newRegistration, number, "Selecting " + number);
    }

    public PayBillPage clickPrePaidDenomination() {
        click(selectPrepaidDenomination, "Clicking on Denomination ");
        return this;
    }

    public void clickOnPrepaid(String text) {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Prepaid2']/following-sibling::" + parentAttribute2 + "", 90);
        clickAndSendKeys(selectPrepaid, text, "Selecting Prepaid  " + text);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public void setComments(String field, String value) {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Prepaid2']", 90);
        if (getDriver() instanceof AndroidDriver)
            clickAndSendKeys(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + field + "']/following-sibling::" + parentAttribute2 + ""), value);
        else
            clickAndSendKeys(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + field + "']/following-sibling::" + parentAttribute2), value);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public PayBillPage clickOnDenomination() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Select Denomination')]", 90);
        Instant timeout = Instant.now().plusSeconds(120);

        int x = 50;
        int y = 100;
        while (getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Select Denomination')]")).size() > 0) {
            tapOnPosition(x, y);
            y = y + 5;
            logInfo(y);

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException("App not loaded after waited for 120 seconds");
        }
        logInfo("Selecting denomination");
        return this;
    }

    public String getPayBillPAge() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Bill')]", 90);
        return getTextWithAttribute(payNewBillPage, attribute);
    }

    public void enterMobileNumber() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Mobile Number']", 90);
        clickAndSendKeys(billerMobileNumber, new TestUtils().getRandomNumber(5), "Entering the mobile number");

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public PayBillPage mobileNumber(String number) {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Mobile Number']/following-sibling::" + parentAttribute2, 90);
        clickAndSendKeys(billerMobileNumber, number, "Entered mobile number " + number);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
        return this;
    }

    public PayBillPage clickDenomination(String mobile) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + mobile + "']"), "Click on Mobile Number " + mobile);
        return this;
    }

    public String getNewRegistration() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeTextField";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'New registration')]", 90);
        return getTextWithAttribute(getRegistration, attribute);
    }


    public void enterBillerNumber(String number) {
        clickAndSendKeys(billingNumber, number, "Entering the biller number " + number);

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public void clickOnAmount(String amount) {
        int value = 0;
        Point point;
        if (getDriver() instanceof AndroidDriver) {
            tapOnPosition(353, 722);
            new Actions(getDriver()).sendKeys(Keys.DELETE).sendKeys(Keys.DELETE).sendKeys(Keys.DELETE)
                    .sendKeys(Keys.DELETE).sendKeys(Keys.DELETE).sendKeys(Keys.DELETE)
                    .sendKeys(amount)
                    .perform();
        } else {
            value = getDriver().findElements(By.xpath("//XCUIElementTypeTextField[contains(@name,\"Total Amount\")]")).size();
            point = getDriver().findElement(By.xpath("//XCUIElementTypeTextField[contains(@name,\"Total Amount\")][" + value + "]")).getLocation();
            tapOnPosition(point.x + 200, point.y + 50);
            for (int i = 0; i < 6; i++)
                getDriver().findElement(By.xpath("//XCUIElementTypeKey[@name=\"0\"]//following-sibling::XCUIElementTypeKey")).click();
            new Actions(getDriver()).sendKeys(amount).perform();
        }

        tapOnPosition(50, 335);
    }

    public void clickOnDashboard() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Back to Dashboard\"]", 90);
        click(dashboard, "Clicking on Dashboard");
    }

    public String getSavedBiller() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        List<WebElement> biller = getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Madfooat2')]"));

        String name = "";
        for (WebElement b : biller) {
            name = b.getAttribute(attribute);
            logInfo("Biller name " + name);
        }
        return name;
    }

    public void clickOnBiller() throws InterruptedException {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        new HomePage().scroll("up");
        List<WebElement> list = getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'oat2') or contains(@" + attribute + ", 'Madfooat2')]"));
        list.get(list.size() - 1).click();
        logInfo("Selecting last two biller");
        Thread.sleep(500);
        list.get(list.size() - 2).click();
    }

    public void clickOnPrepaidSavedBiller(String billerName) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'Madfooat2')]", 90);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + billerName.substring(4) + "') or contains(@" + attribute + ", '" + billerName + "')]")).click();
        logInfo("Clicking on saved biller " + billerName);
    }

    public void clickPrepaidDenomination(String mobile) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + mobile.substring(4) + "') or contains(@" + attribute + ", '" + mobile + "')]")).click();
        logInfo("Click on Mobile Number  " + mobile);
    }

    public void swipePayTo(String direction) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeTextField";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Pay New Bill']", 90);

        if (getDriver() instanceof IOSDriver) {
            Point point = getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Pay From\"]")).getLocation();
            scrollWithCoordinates("up", 0.75, point.x + 150, point.y + 10);
        } else {
            scrollUntilElementPresent(By.xpath("//" + parentAttribute2 + "[contains(@" + attribute + ", 'Fees')]"), direction, .7);
        }
        logInfo("Scrolling to bottom of the page");
    }

    public void clickBackToDashBoardPostpaid() {
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
        if (getDriver() instanceof AndroidDriver)
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='You have successfully paid your bill!']/following-sibling::" + parentAttribute2, 90);
        else
            utils.waitForElement(getDriver(), "//XCUIElementTypeButton[@name=\"Back to Dashboard\"]", 90);

        click(postpaidDashboard, "clicking on dashboard");
    }

    public boolean billerIsSelected(int i) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        List<WebElement> list = getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Madfooat2')]"));
        return list.get(list.size() - i).isSelected();
    }

    public void prepaidSavedBiller() throws InterruptedException {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        List<WebElement> list = getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Madfooat2')]"));
        list.get(list.size() - 1).click();
        Thread.sleep(500);
        list.get(list.size() - 2).click();
        logInfo(list);
    }

    public void enterNickName(String name) {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Nickname']/" + parentAttribute2, 60);
        clickAndSendKeys(nickName, name, "Nickname has been set to " + name);
    }

    public StringBuilder getPayBillPage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'View History')]", 90);

        StringBuilder message = new StringBuilder();
        if (getDriver() instanceof AndroidDriver) {
            message.append(payToButton.getAttribute(attribute)).append("\n ")
                    .append(postPaid.getAttribute(attribute)).append(" \n ")
                    .append(newBillerButton.getAttribute(attribute)).append("\n")
                    .append(prepaidButton.getAttribute(attribute)).append(" - ");

            scroll("up", 0.50);
            message.append(newBillerButton.getAttribute(attribute));
            logInfo(message);
            return message;
        } else {
            return message.append(getAttribute(By.xpath("//XCUIElementTypeStaticText[@name=\"PREPAID\"]"), "name"));
        }

    }

    public boolean isAmountClickable() {
        String parentAttribute = "";
        String attribute = "";
        String value = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
            value = "checkable";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
            value = "enabled";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Total Amount']/following-sibling::" + parentAttribute + "[1]", 90);
        if (getDriver() instanceof AndroidDriver)
            return Boolean.parseBoolean(getTextWithAttribute(totalAmount, value));
        else
            return false;
    }

    public void clickOnSavedBiller() throws InterruptedException {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        List<WebElement> list = getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'at2') or contains(@" + attribute + ", 'Madfooat2')]"));
        list.get(0).click();
        logInfo("Selecting the first saved biller");
        Thread.sleep(500);
        list.get(1).click();
        logInfo("Selecting the two saved biller");
    }

    public void swipeAmountTextFiled(String direction) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeTextField";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Pay New Bill']", 90);
       if(getDriver() instanceof AndroidDriver)
           scrollUntilElementPresent(By.xpath("//" + parentAttribute2 + "[contains(@text, 'Fees')]"), direction, .55);
           else {
           int value = getDriver().findElements(By.xpath("//" + parentAttribute2 + "[contains(@name,'Fees')]")).size();
           for (int i = 1; i <= value; i++) {
               new HomePage().scrollWithCoordinates("up", 0.5, 200, 100);
           }
       }
        logInfo("Scroll to amount filed");
    }

    public void clickOnBillerAmount(String amounts) {
        String amount;
        int value = 0;
        Point point;
        if (getDriver() instanceof AndroidDriver) {
            tapOnPosition(357, 798);
            new Actions(getDriver()).sendKeys(Keys.DELETE).sendKeys(Keys.DELETE)
                    .sendKeys(amounts)
                    .perform();
            tapOnPosition(850, 1891);
            logInfo("Entering amount");
        } else {
            value = getDriver().findElements(By.xpath("//XCUIElementTypeTextField[contains(@name,\"Total Amount\")]")).size();
            point = getDriver().findElement(By.xpath("//XCUIElementTypeTextField[contains(@name,\"Total Amount\")][" + value + "]")).getLocation();
            tapOnPosition(point.x + 160, point.y + 80);
            for (int j = 0; j < 6; j++)
                getDriver().findElement(By.xpath("//XCUIElementTypeKey[@name=\"0\"]//following-sibling::XCUIElementTypeKey")).click();

            new Actions(getDriver()).sendKeys(amounts).perform();
            tapOnPosition(50, 335);
        }
    }

    public String fetchCardDetails() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='View History']", 60);
        return getTextWithAttribute(cardDetails, attribute);
    }

    public String clickOnCard() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='View History']", 60);
        String cardValue = "";
        int count = 0;
        while (count < 5) {
            cardValue = new PayBillPage().fetchCardDetails();

            if (cardValue.contains("VISA")) {
                new PayBillPage().fetchCardDetails();
                break;

            } else {
                click(cardForwardButton, "Clicking on forward button");
            }
            count++;
        }
        return cardValue;
    }

    public void searchCategory(String billerName) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        waitForVisibility(selectCategory);
        if (getDriver() instanceof IOSDriver)
            new HomePage().tapOnPosition(60, 292);

        new Actions(getDriver()).sendKeys(Keys.TAB)
                .sendKeys(billerName)
                .perform();
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + billerName + "']"), "Clicking on " + billerName);
    }

    public PayBillPage clickBillerName() {
        click(clickBillerName, "Click on Biller Name ");
        return new PayBillPage();
    }

    public PayBillPage swipeToBiller(String direction, String type) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Select Biller Name\"]", 45);
        if (getDriver() instanceof AndroidDriver) {
            scrollUntilElementPresent(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + type + "']"), direction, .65);
            click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + type + "']"));
        } else {
            scrollUntilElementPresent(By.xpath("//XCUIElementTypeStaticText[@" + attribute + "='" + type + "']"), direction, .65);
            if (!type.startsWith("A"))
                scroll("up", 0.5);

            click(By.xpath("//XCUIElementTypeStaticText[@" + attribute + "='" + type + "']"));
        }
        logInfo("Text is entered as " + type);

        return this;
    }

    public PayBillPage clickOnServiceTypeButton() {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            parentAttribute2 = "XCUIElementTypeTextField";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Service Type']", 90);
        click(clickServiceType, "Clicking on service type ");
        return this;
    }

    public void clickBillerNameWithValue(String direction, String type) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        scrollUntilElementPresent(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + type + "']"), direction, .5);
        if (getDriver() instanceof IOSDriver)
            scroll("up", 0.5);

        String xpath = "//" + parentAttribute + "[@" + attribute + "='" + type + "']";
        click(By.xpath(xpath), "Click on Mobile Prepaid " + type);
    }

    public void clickPayTo(String account) {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute2 + "[@" + attribute + "=\"New Biller\"]", 45);
        if (getDriver() instanceof AndroidDriver)
            click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + account + "']"), "Clicking on " + account);
        else
            click(By.xpath("//XCUIElementTypeStaticText[@" + attribute + "='" + account + "']"), "Clicking on " + account);
    }

    public String getConfirmDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        return getAttribute(confirmPage, attribute);
    }

    public void swipeBiller() {
        waitForVisibility(savedBiller);
        Point point = savedBiller.getLocation();
        scrollWithCoordinates("left", 0.6, point.x + 200, point.y + 50);
    }

    public void clickOnDelete() {
        waitForVisibility(deleteButton);
        click(deleteButton, "Clicking on delete biller ");
    }

    public void clickOnConfirm() {
        waitForVisibility(confirmMessage);
        click(confirmMessage, "Clicking on confirm");
    }

    public String getConfirmMessage() {
        String attribute = "";
        String parentAttribute = "";
        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'SUCCESS')]", 60);
        return getAttribute(successfulMessage, attribute).replaceAll("\n", " ");
    }

    public void selectAndDeselect(String select) {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute2 + "[@" + attribute + "=\"New Biller\"]", 45);
        new HomePage().scroll("up", 0.30);
        if (getDriver() instanceof AndroidDriver)
            click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + select + "']"), "Clicking on Select All");
        else {
            Point point = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + select + "']")).getLocation();
            new HomePage().tapOnPosition(point.x + 40, point.y + 30);
            logInfo("Selecting " + select + " button");
        }
    }

    public String isBillerSelected() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'billers selected')]", 45);
        return getAttribute(selectAll, attribute).replaceAll("\n", " ");
    }

    public String getFeesDetails() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }
        waitForVisibility(fees);
        return getAttribute(fees, attribute);
    }

    public String getTotalAmount() {
        if (getDriver() instanceof AndroidDriver)
            return getAttribute(totalAmount, "clickable");
        else
            return getAttribute(totalAmount, "enabled");
    }

    public void clickOnSaveBiller() {
        waitForVisibility(saveBillerButton);
        click(saveBillerButton, "Clicking on save biller");
    }

    public void enterNickNameAs(String billerName) {
        waitForVisibility(nickName);
        String number = utils.getRandomNumber(3);
        clickAndSendKeys(nickName, billerName + number, "Entering the nick name as Nick name");
    }

    public void clickOnBackToDashboard() {
        waitForVisibility(backToDashboard);
        click(backToDashboard, "Clicking to back to Dashboard");
    }

    public void enterPayBillNickName(String name) {
        waitForVisibility(payBillNickName);
        clickAndSendKeys(payBillNickName, name, "Entering the nick name");

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();

    }

    public void clickOnContinueToPay() {

        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Continue')]"), "Clicking on continue to payment");
    }
}