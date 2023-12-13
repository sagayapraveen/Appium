package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.time.Instant;

import static com.qa.engine.ProjectBase.logInfo;

public class SendMoneyPage extends BasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Back to Payments']/android.widget.ScrollView/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Back to Payments']/XCUIElementTypeScrollView/XCUIElementTypeTextField")
    protected WebElement nickName;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Payments')]/android.view.View/android.view.View[2]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'Payments')]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    protected WebElement accountNoTextField;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Back to Payments']/android.widget.ScrollView/android.widget.ImageView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Back to Payments']/XCUIElementTypeScrollView/XCUIElementTypeImage[1]")
    protected WebElement purpose;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Swipe down')]/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'Swipe down')]//following-sibling::XCUIElementTypeImage")
    protected WebElement purposeSelect;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Purpose Details')]/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'Swipe down')]//following-sibling::XCUIElementTypeImage")
    protected WebElement purposeDetailsSelect;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='NO']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='NO']")
    protected WebElement recipientButton;
    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Back to Payments')]/android.widget.ImageView[3]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Back to Payments')]/XCUIElementTypeImage[3]")
    protected WebElement proceedPayment;
    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Back to Payments')]/android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Back to Payments')]//following-sibling::XCUIElementTypeImage[2]")
    protected WebElement proceedPaymentNext;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Mobile number')]/following-sibling::android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mobile number registered with blink\"]//following-sibling::XCUIElementTypeImage")
    protected WebElement acceptMobileVerification;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Send Money\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Send Money\")]")
    protected WebElement sendMoney;

    public SendMoneyPage() {
        waitForAppToLoad();
    }

    @Override
    protected void waitForAppToLoad() {
    }

    public SendMoneyPage sendMoneyTo(String payee) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeStaticText";
        }

        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ", '" + payee + "')]";
        utils.waitForElement(getDriver(), xpath, 60);
        click(By.xpath(xpath), "Selecting the " + payee + " payee");
        return this;
    }

    public SendMoneyPage enterMoney(String amount) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeStaticText";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='1']", 60);
        char[] charArray = amount.toCharArray();
        for (char c : charArray) {
            click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + c + "']"));
        }

        logInfo("Entering the amount : " + amount);
        return this;
    }

    public void proceedPayment() {
        click(proceedPayment, "Proceeding bill payment");
    }

    public void proceedPaymentNext() {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.widget.ImageView";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeImage";
        }
        utils.waitForElement(getDriver(), "//*[contains(@" + attribute + ", 'Back to Payments')]", 30);
        click(proceedPaymentNext, "Proceeding bill payment button has been clicked");
    }

    public void sendAccountNo(String number) {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Payments')]/" + parentAttribute + "/" + parentAttribute + "[2]/" + parentAttribute2, 45);
        clickAndSendKeys(accountNoTextField, number, "Account no has been entered :" + number);
        new Actions(getDriver()).sendKeys(Keys.TAB).perform();

        if (getDriver() instanceof IOSDriver)
            click(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]"));
    }

    public SendMoneyPage sendPurpose(String value) {
        String attribute = "";
        String parentAttribute = "";
        String parentAttribute2 = "";
        String parentAttribute3 = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
            parentAttribute3 = "android.widget.ScrollView";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeStaticText";
            parentAttribute2 = "XCUIElementTypeTextField";
            parentAttribute3 = "XCUIElementTypeScrollView";
        }

        String xpath;
        if (getDriver() instanceof AndroidDriver)
            xpath = "//" + parentAttribute + "[@" + attribute + "='Back to Payments']/" + parentAttribute3 + "/" + parentAttribute2 + "[1]";
        else
            xpath = "//XCUIElementTypeStaticText[@name=\"Select purpose\"]//following-sibling::XCUIElementTypeImage[1]";

        utils.waitForElement(getDriver(), xpath, 45);
        click(By.xpath(xpath), "Purpose dropdown is clicked");
        String data = "//" + parentAttribute + "[@" + attribute + "='" + value + "']";
        scrollUntilElementPresent(By.xpath(data), "up", 0.5);
        click(By.xpath(data));
        click(purposeSelect, "Purpose got selected" + value);
        return this;
    }

    public void sendPurposeDetails(String value) {
        String attribute = "";
        String parentAttribute = "";
        String parentAttribute2 = "";
        String parentAttribute3 = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
            parentAttribute3 = "android.widget.ScrollView";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeStaticText";
            parentAttribute2 = "XCUIElementTypeTextField";
            parentAttribute3 = "XCUIElementTypeScrollView";
        }
        String xpath;
        if (getDriver() instanceof AndroidDriver)
            xpath = "//" + parentAttribute + "[@" + attribute + "='Back to Payments']/" + parentAttribute3 + "/" + parentAttribute2 + "[2]";
        else
            xpath = "//XCUIElementTypeStaticText[@name=\"Select purpose\"]//following-sibling::XCUIElementTypeImage[2]";

        utils.waitForElement(getDriver(), xpath, 45);
        click(By.xpath(xpath), "PurposeDetails dropdown is clicked");
        String data = "//" + parentAttribute + "[@" + attribute + "='" + value + "']";
        scrollUntilElementPresent(By.xpath(data), "up", 0.5);
        click(By.xpath(data));
        click(purposeDetailsSelect, "Purpose Details got selected as" + value);
    }

    public String accountName(String value) throws InterruptedException {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeStaticText";
        }
        Thread.sleep(3000);
        if (getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",\"Mobile\")]")).size() > 0)
            click(acceptMobileVerification, "Clicking mobile accept verification");

        String xpath = "//" + parentAttribute + "[@" + attribute + "='" + value.toUpperCase() + "']";
        utils.waitForElement(getDriver(), xpath, 45);
        String name = getAttribute(By.xpath(xpath), attribute);
        logInfo("The account name is set as " + name);
        return name;
    }

    public void enterNickName(String name) {
        scroll("up", 0.5);
        click(recipientButton);
        clickAndSendKeys(nickName, name, "Nick name has been entered as " + name);
    }

    public String statusMessage(String message) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeStaticText";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", '" + message + "')]", 60);
        By xpath = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + message + "')]");
        return getAttribute(xpath, attribute);
    }

    public String swipeFromBackToPayments(String value) {
        String attribute = "";
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Back to Payments\")]", 30);
        scroll("down", 0.85);
        return getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'" + value + "')]"), attribute);
    }

    public void toolTip() {
        String attribute = "";
        String parentAttribute = "";
        String parentAttribute2 = "";
        String parentAttribute3 = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
            parentAttribute3 = "android.widget.ImageView";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeTextField";
            parentAttribute3 = "XCUIElementTypeImage";
        }
        String xpath;
        if (getDriver() instanceof AndroidDriver) {
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Payments')]/" + parentAttribute + "/" + parentAttribute + "[2]/" + parentAttribute2, 45);
            xpath = "//" + parentAttribute + "[@" + attribute + "=\"Contact information\"]";
        } else {
            utils.waitForElement(getDriver(), "//XCUIElementTypeImage[contains(@name,\"IBAN\")]", 45);
            xpath = "//XCUIElementTypeStaticText[@name=\"Number formatting\"]//following-sibling::XCUIElementTypeImage";
        }
        Point point1 = getDriver().findElement(By.xpath("//" + parentAttribute3 + "[contains(@" + attribute + ",\"IBAN\")]")).getLocation();
        Instant timeout = Instant.now().plusSeconds(120);

        int x = point1.x + 10;
        int y = point1.y + 10;
        while (getDriver().findElements(By.xpath(xpath)).size() == 0) {
            tapOnPosition(x, y);
            if (getDriver().findElements(By.xpath(xpath)).size() > 1) {
                break;
            }
            x = x + 25;

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException("Tooltip not available");
        }

        utils.waitForElement(getDriver(), xpath, 30);
        click(By.xpath(xpath));
    }

    public String getAttributePurposeDetails() {
        String attribute = "";
        String parentAttribute = "";
        String parentAttribute2 = "";
        String parentAttribute3 = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.EditText";
            parentAttribute3 = "android.widget.ScrollView";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeTextField";
            parentAttribute3 = "XCUIElementTypeScrollView";
        }
        String xpath;

        if (getDriver() instanceof AndroidDriver)
            xpath = "//" + parentAttribute + "[@" + attribute + "=\"Back to Payments\"]/" + parentAttribute3 + "/" + parentAttribute2 + "[2]";
        else
            xpath = "//XCUIElementTypeImage[contains(@name,\"ACCOUNT NO.\")]//ancestor::XCUIElementTypeOther//following-sibling::XCUIElementTypeImage[2]";
        utils.waitForElement(getDriver(), xpath, 30);
        return getAttribute(By.xpath(xpath), "focused");
    }
}
