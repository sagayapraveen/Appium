package com.qa.pages.blink;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class BillPaymentPage extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Back to Payments')]/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Back to Payments')]/XCUIElementTypeImage")
    protected WebElement textBox;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Government Service']//following-sibling::android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='Government Service']//following-sibling::XCUIElementTypeImage[2]")
    protected WebElement serviceType;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Biller name']//following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Biller name']//following-sibling::XCUIElementTypeTextField")
    protected WebElement billerTextBox;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Biller name']/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Biller name']/XCUIElementTypeImage")
    protected WebElement okButtonBiller;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Services']/android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='Services']/XCUIElementTypeImage")
    protected WebElement okButtonServices;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='NO']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='NO']")
    protected WebElement addBill;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'NICKNAME')]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'NICKNAME')]/XCUIElementTypeTextField")
    protected WebElement nickName;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'Payments')]/android.view.View/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'Payments')]/XCUIElementTypeOther/XCUIElementTypeTextField")
    protected WebElement amountField;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,'AMOUNT')]/android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,'AMOUNT')]/XCUIElementTypeTextField")
    protected WebElement amountPrepaid;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Pay\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Pay\")]")
    protected WebElement payButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@index=3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@index=3]")
    protected WebElement doneButton;

    @Override
    protected void waitForAppToLoad() {

    }

    public void swipeCard(int count) throws InterruptedException {
        for (int card = 0; card < count; card++) {
            Thread.sleep(3000);
            scroll("left", 0.5);
        }
    }

    public void selectBill(String type, String service) {
        String parentAttribute = "";
        String attribute = "";
        String parentAttribute2 = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            parentAttribute2 = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Back to Payments')]/" + parentAttribute2, 60);
        clickAndSendKeys(textBox, type, "Text has been entered as " + type);
        String serviceType = "//" + parentAttribute2 + "[@" + attribute + "='" + service + "']";
        utils.waitForElement(getDriver(), serviceType, 60);
        click(By.xpath(serviceType), "Text has been entered as " + service);
    }

    public void selectBillerType(String service) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        By governmentService = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'" + service + "')]/following-sibling::" + parentAttribute + "[1]");
        click(governmentService, "Service has been selected as " + service);
    }

    public BillPaymentPage enterBillerType(String biller) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        String billValue = "//" + parentAttribute + "[@" + attribute + "='Biller name']";
        utils.waitForElement(getDriver(), billValue, 30);
        By billerName = By.xpath("//" + parentAttribute + "[@" + attribute + "='" + biller + "']");
        clickAndSendKeys(billerTextBox, biller);
        click(billerName, "Biller is clicked as " + biller);
        return this;
    }

    public void clickOkBiller() {
        click(okButtonBiller, "Biller has been selected");
    }

    public BillPaymentPage enterServiceType(String service) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        click(serviceType);
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Services\"]", 25);

        By electricity = By.xpath("//" + parentAttribute + "[@" + attribute + "='" + service + "']");

        scrollUntilElementPresent(electricity, "up", 0.5);
        click(electricity, "Service has been clicked as " + service);
        return this;
    }

    public void clickOkServices() {
        click(okButtonServices, "Service has been selected");
    }

    public void enterBillNo(String service, String billNo) {
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
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + service.toUpperCase() + "')]/" + parentAttribute2;
        utils.waitForElement(getDriver(), xpath, 30);
        By bill = By.xpath(xpath);
        clickAndSendKeys(bill, billNo, "Bill no has been entered as " + billNo);
        scroll("up", 0.5);
    }

    public void enterMobileNo(String field, String number) {
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
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + field + "')]/" + parentAttribute2;
        utils.waitForElement(getDriver(), xpath, 30);
        clickAndSendKeys(By.xpath(xpath), number, "Mobile number has been entered as " + number);
    }

    public void selectDenomination(String field, String data, String doneButton) {
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
        String denominationXpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + field + "')]/following-sibling::" + parentAttribute2;
        utils.waitForElement(getDriver(), denominationXpath, 30);
        click(By.xpath(denominationXpath));

        String dataFieldXpath = "//" + parentAttribute + "[@" + attribute + "='" + data + "']";
        utils.waitForElement(getDriver(), dataFieldXpath, 30);
        click(By.xpath(dataFieldXpath));

        click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'" + doneButton + "')]/" + parentAttribute2), "Denomination has been selected");
    }

    public String iVerifyBill(String biller) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        By value = By.xpath("//" + parentAttribute + "[@" + attribute + "='" + biller + "']");
        utils.waitForElement(getDriver(), value, 30);
        return getAttribute(value, attribute);
    }

    public void addBill() {
        click(addBill, "Clicking Save bill option");
    }

    public BillPaymentPage nickName(String name) {
        clickAndSendKeys(nickName, name, "Nick name is entered as " + name);
        return this;
    }

    public void editAmount(String amount) {
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
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Back to Payments']/" + parentAttribute + "/" + parentAttribute2, 60);
        click(amountField);
        amountField.clear();
        sendKeys(amountField, amount, "The  amount has been entered as " + amount);
    }

    public void selectBillsType(String bill) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Manage my bills']", 30);
        String xpath = "//" + parentAttribute + "[@" + attribute + "='" + bill + "']";
        click(By.xpath(xpath), "Selecting " + bill);
    }

    public BillPaymentPage deleteBill(String bill) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            parentAttribute2 = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            parentAttribute2 = "XCUIElementTypeImage";
            attribute = "name";
        }
        Point point = getDriver().findElement(By.xpath("//" + parentAttribute2 + "[contains(@" + attribute + ",'" + bill + "')]")).getLocation();
        scrollWithCoordinates("left", 0.5, point.x + 100, point.y + 10);

        String xpath = "//" + parentAttribute2 + "[contains(@" + attribute + ",'" + bill + "')]/" + parentAttribute;
        utils.waitForElement(getDriver(), xpath, 60);
        click(By.xpath(xpath), "Clicking the delete button");
        return this;
    }

    public String billDetail(String bill) {
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
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",\"Pay\")]";
        utils.waitForElement(getDriver(), xpath, 30);

        if (getDriver().findElements(By.xpath("//" + parentAttribute2 + "[contains(@" + attribute + ",'" + bill + "')]")).size() > 0)
            return "Bill not deleted";
        else
            return "Bill deleted";
    }

    public void doneBiller() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@index=3]", 30);
        click(doneButton, "Clicking done button");
    }

    public void enterPrepaidAmount(String amount) {
        clickAndSendKeys(amountPrepaid, amount, "Amount has been entered " + amount);
    }

    public String statusMessage(String message) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Paid to\"]", 30);

        By xpath = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'" + message + "')]");
        return getAttribute(xpath, attribute);
    }

    public void swipeWithSwipeLocation(String direction) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        scroll("up", 0.5);
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Swipe to proceed\"]", 10);
        Point point = getDriver().findElement(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Swipe to proceed\"]")).getLocation();
        tapOnPosition(point.x, point.y);
        scroll(direction, 0.5);
    }

    public BillPaymentPage clickPayBillButton() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"Pay\")]", 30);
        click(payButton, "Clicking pay button");
        return this;
    }

    public String getRequestMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        return getAttribute(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"We are processing your request and we will notify you once ready\"]"), attribute).replace("\n", " ");
    }
}