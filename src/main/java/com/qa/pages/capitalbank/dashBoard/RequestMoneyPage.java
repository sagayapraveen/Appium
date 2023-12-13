package com.qa.pages.capitalbank.dashBoard;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.time.Instant;

import static com.qa.engine.ProjectBase.logInfo;

public class RequestMoneyPage extends BasePage {
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'CAPITAL')]/android.view.View[3]/android.widget.ImageView[12]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"CAPITAL\")]//following-sibling::XCUIElementTypeOther[3]//XCUIElementTypeButton[12]")
    protected WebElement selectOk;

    @AndroidFindBy(accessibility = "My Benefeciaries")
    @iOSXCUITFindBy(accessibility = "My Benefeciaries")
    protected WebElement myBeneficiaries;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Purpose of Request']/following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Please Enter\" or @name=\"Enter Select\"]")
    protected WebElement purposeOfRequest;

    @AndroidFindBy(accessibility = "Next")
    @iOSXCUITFindBy(accessibility = "Next")
    protected WebElement next;

    @AndroidFindBy(accessibility = "Confirm")
    @iOSXCUITFindBy(accessibility = "Confirm")
    protected WebElement confirm;

    @AndroidFindBy(accessibility = "New Beneficiary")
    @iOSXCUITFindBy(accessibility = "New Beneficiary")
    protected WebElement newBeneficiary;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Beneficiary Type\"]//following-sibling::android.view.View")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Please Select Beneficiary Type\"]")
    protected WebElement beneficiaryTypeDropDown;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Beneficiary Type\"]//following-sibling::android.widget.EditText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Beneficiary Type\"]//following::XCUIElementTypeTextField")
    protected WebElement beneficiaryValue;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,\"Request\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name,\"Request\")]")
    protected WebElement requestMoney;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Recipient Name\"]//following-sibling::android.widget.EditText[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Recipient Name\"]//following-sibling::XCUIElementTypeStaticText[2]")
    protected WebElement recipientAddress;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Date\")]//following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"Date\")]//following-sibling::XCUIElementTypeOther[1]")
    protected WebElement date;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Recipient Name\"]//following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Recipient Name\"]//following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement recipientName;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Description\")]//following-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Description\")]//following-sibling::XCUIElementTypeTextField[1]")
    protected WebElement aliasDescription;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"From\")]//following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"From\")]//following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement name;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"From\")]//following-sibling::android.view.View[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"From\")]//following-sibling::XCUIElementTypeStaticText[2]")
    protected WebElement beneficiary;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Amount\")]//following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Amount\")]//following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement amount;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Purpose\")]//following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Purpose\")]//following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement purpose;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Recipient\")]//following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Recipient\")]//following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement address;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc,\"Description\")]//following-sibling::android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Description\")]//following-sibling::XCUIElementTypeStaticText[1]")
    protected WebElement description;

    @Override
    protected void waitForAppToLoad() {
    }

    public RequestMoneyPage enterMoney(String amount) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
            parentAttribute2 = "android.widget.ImageView";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeImage";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Request Money With CliQ']", 60);

        logInfo("Inputting the amount " + amount);

        char[] charArray = amount.toCharArray();
        if (getDriver() instanceof AndroidDriver) {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'CAPITAL')]/" + parentAttribute + "[3]/" + parentAttribute2 + "[11]"));
                else
                    click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'CAPITAL')]/" + parentAttribute + "[3]/" + parentAttribute2 + "[" + c + "]"));
            }
        } else {
            for (char c : charArray) {
                if (c == '0')
                    click(By.xpath("//XCUIElementTypeOther[contains(@name,\"CAPITAL\")]//following-sibling::XCUIElementTypeOther[3]//XCUIElementTypeButton[11]"));
                else if (c == '.')
                    click(By.xpath("//XCUIElementTypeOther[contains(@name,\"CAPITAL\")]//following-sibling::XCUIElementTypeOther[3]//XCUIElementTypeButton[10]"));
                else
                    click(By.xpath("//XCUIElementTypeOther[contains(@name,\"CAPITAL\")]//following-sibling::XCUIElementTypeOther[3]//XCUIElementTypeButton[" + c + "]"));
            }
        }

        return this;
    }

    public RequestMoneyPage myBeneficiaries() {
        click(myBeneficiaries, "Clicking My Beneficiaries");
        return this;
    }

    public void clickExistingBeneficiary(String beneficiary) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeImage";
            attribute = "name";
        }

        if (getDriver() instanceof AndroidDriver) {
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", '" + beneficiary + "')]", 30);
            click(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '" + beneficiary + "')]"), "Clicking existing beneficiary " + beneficiary);
        } else {
            utils.waitForElement(getDriver(), "//XCUIElementTypeStaticText[contains(@" + attribute + ", '" + beneficiary + "')]", 180);
            click(By.xpath("//XCUIElementTypeStaticText[contains(@" + attribute + ", '" + beneficiary + "')]"), "Clicking existing beneficiary " + beneficiary);
        }
    }

    public RequestMoneyPage selectPurpose(String purpose) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Request')]", 30);
        click(purposeOfRequest);
        utils.waitForElement(getDriver(), "//*[@" + attribute + "='Select Purpose of Request']", 30);
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + purpose + "']"), "Purpose is selected as " + purpose);
        return this;
    }

    public void clickNext() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Request')]", 30);
        click(next, "Clicking next");
    }

    public RequestMoneyPage selectOk() {
        click(selectOk);
        return this;
    }

    public void confirmRequest() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",'Confirm')]", 30);
        click(confirm, "Clicking confirm");
    }

    public String fetchConfirmationMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'successful')]", 30);
        String message;
        if (getDriver() instanceof AndroidDriver) {
            message = getDriver().findElement(By.xpath("(//" + parentAttribute + "[contains(@" + attribute + ", 'successful')]//..//" + parentAttribute + ")[1]"))
                    .getAttribute(attribute).replaceAll("\n", " ") + "\n";
            message = message + getDriver().findElement(By.xpath("(//" + parentAttribute + "[contains(@" + attribute + ", 'successful')]//..//" + parentAttribute + ")[2]"))
                    .getAttribute(attribute) + " - ";
            message = message + getDriver().findElement(By.xpath("(//" + parentAttribute + "[contains(@" + attribute + ", 'successful')]//..//" + parentAttribute + ")[3]"))
                    .getAttribute(attribute) + "\n";
            message = message + getDriver().findElement(By.xpath("(//" + parentAttribute + "[contains(@" + attribute + ", 'successful')]//..//" + parentAttribute + ")[4]"))
                    .getAttribute(attribute) + " - ";
            message = message + getDriver().findElement(By.xpath("(//" + parentAttribute + "[contains(@" + attribute + ", 'successful')]//..//" + parentAttribute + ")[5]"))
                    .getAttribute(attribute) + "\n";
        } else {
            message = getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'successful')]//following-sibling::XCUIElementTypeStaticText[1]"))
                    .getAttribute(attribute).replaceAll("\n", " ") + "\n";
            message = message + getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'successful')]//following-sibling::XCUIElementTypeStaticText[2]"))
                    .getAttribute(attribute) + " - ";
            message = message + getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'successful')]//following-sibling::XCUIElementTypeStaticText[3]"))
                    .getAttribute(attribute) + "\n";
            message = message + getDriver().findElement(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'successful')]//following-sibling::XCUIElementTypeStaticText[4]"))
                    .getAttribute(attribute) + "\n";

        }
        return message;
    }

    public RequestMoneyPage purposePageSelectOk() {
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
        String xpath;
        if (getDriver() instanceof AndroidDriver)
            xpath = "//" + parentAttribute + "[@" + attribute + "=\"CAPITAL\"]//ancestor::" + parentAttribute + "//following-sibling::" + parentAttribute2 + "[12]";
        else
            xpath = "//XCUIElementTypeStaticText[contains(@name,\"CAPITAL\")]//ancestor::XCUIElementTypeOther[2]//following-sibling::XCUIElementTypeButton[12]";
        utils.waitForElement(getDriver(), xpath, 45);
        click(By.xpath(xpath), "Clicking done button");
        return this;
    }

    public RequestMoneyPage clickNewBeneficiary() {
        click(newBeneficiary, "Clicking new beneficiary");
        return this;
    }

    public RequestMoneyPage beneficiaryDropDown() {
        click(beneficiaryTypeDropDown, "Clicking beneficiary type drop down");
        return this;
    }

    public void selectBeneficiaryIBAN(String val) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + val + "')]";
        utils.waitForElement(getDriver(), xpath, 30);
        click(By.xpath(xpath), "Clicking IBAN");

        if (getDriver() instanceof IOSDriver)
            click(By.xpath("//XCUIElementTypeButton[@name=\"Next\"]//following-sibling::XCUIElementTypeButton"));
    }

    public RequestMoneyPage enterBeneficiaryValue(String value) {
        clickAndSendKeys(beneficiaryValue, value, "Entering the beneficiary value");

        if (getDriver() instanceof IOSDriver)
            click(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]"));
        return this;
    }

    public void enterBeneficiaryNullValue() {
        click(beneficiaryValue, "Clicking the beneficiary value");
        new Actions(getDriver())
                .sendKeys(Keys.SPACE).perform();
    }

    public RequestMoneyPage enterRecipientName(String value) {
        clickAndSendKeys(recipientName, value, "Entering the Recipient name");
        return this;
    }

    public RequestMoneyPage enterRecipientAddress(String value) {
        clickAndSendKeys(recipientAddress, value, "Entering the Recipient address");
        return this;
    }

    public void enterDescription(String value) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "=\"Request From\"]", 30);
        scroll("up", 0.50);
        clickAndSendKeys(aliasDescription, value, "Entering the Recipient address");

        if (getDriver() instanceof IOSDriver)
            getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\"]")).click();
    }

    public String recipientName() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        scroll("up", 0.5);
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ",\"From\")]//following-sibling::" + parentAttribute + "[1]", 30);
        return getAttribute(name, attribute);
    }

    public String requestType() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }

        return getAttribute(beneficiary, attribute);
    }

    public String recipientAddress() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }

        return getAttribute(address, attribute);
    }

    public String descriptionConfirm() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }

        return getAttribute(description, attribute);
    }

    public String amount() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }

        return getAttribute(amount, attribute);
    }

    public String purpose() {
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            attribute = "name";
        }

        scroll("up", 0.5);
        return getAttribute(purpose, attribute);
    }

    public String successPageDate() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@" + attribute + ", 'successful')]", 30);

        String day = getAttribute(date, attribute).split(" ")[5];
        String[] confirmPageValue = getAttribute(date, attribute).split(" ")[4].split(":");
        int totalMinutes = Integer.parseInt(confirmPageValue[0]) * 60 + Integer.parseInt(confirmPageValue[1]);
        int reducedHours;
        String newDay;

        if (Integer.parseInt(confirmPageValue[0]) == 12 || Integer.parseInt(confirmPageValue[0]) == 1 || (Integer.parseInt(confirmPageValue[0]) == 2 && Integer.parseInt(confirmPageValue[1]) < 30) && day.equals("PM"))
            newDay = "AM";
        else if (Integer.parseInt(confirmPageValue[0]) == 12 || Integer.parseInt(confirmPageValue[0]) == 1 || (Integer.parseInt(confirmPageValue[0]) == 2 && Integer.parseInt(confirmPageValue[1]) < 30) && day.equals("AM"))
            newDay = "PM";
        else newDay = day;


        if (day.equals("PM") && totalMinutes - 150 < 0)
            reducedHours = 720 + totalMinutes - 150;
        else if (day.equals("AM") && totalMinutes - 150 < 0)
            reducedHours = 720 + totalMinutes - 150;
        else
            reducedHours = totalMinutes - 150;

        int hours = reducedHours / 60;
        int minutes = reducedHours % 60;

        String newTime;

        if (String.valueOf(minutes).length() == 1 && String.valueOf(hours).length() == 1)
            newTime = 0 + String.valueOf(hours) + ":" + 0 + minutes + " " + newDay;
        else if (String.valueOf(minutes).length() == 1)
            newTime = hours + ":" + 0 + minutes + " " + newDay;
        else if (String.valueOf(hours).length() == 1)
            newTime = 0 + String.valueOf(hours) + ":" + minutes + " " + newDay;
        else
            newTime = hours + ":" + minutes + " " + newDay;

        if (hours == 0 && String.valueOf(minutes).length() == 1)
            newTime = "12:0" + minutes + " " + newDay;
        else if (hours == 0 && String.valueOf(minutes).length() == 2)
            newTime = "12:" + minutes + " " + newDay;

        return newTime;
    }

    public void openRequestHistory() {
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute2 = "android.widget.ImageView";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute2 = "XCUIElementTypeImage";
            attribute = "name";
        }
        logInfo("Clicking the Request History menu");
        Instant timeout = Instant.now().plusSeconds(30);
        //waitForVisibility(requestMoney);
        utils.waitForElement(getDriver(), "//" + parentAttribute2 + "[contains(@" + attribute + ",\"Request\")]", 60);
        Point point = requestMoney.getLocation();
        String xpath = "//" + parentAttribute2 + "[contains(@" + attribute + ", \"History\")]";

        if (getDriver() instanceof AndroidDriver) {
            while (getDriver().findElements(By.xpath(xpath)).size() == 0) {
                scrollWithCoordinates("left", 0.40, point.x, point.y + 50);

                if (Instant.now().isAfter(timeout))
                    throw new TimeoutException("Request History menu is not displaying after 30 seconds");
            }
        } else {
            scrollWithCoordinates("left", 0.60, point.x, point.y + 50);
        }

        click(By.xpath(xpath), "Clicking Request History");
    }

    public String getTransactionDetails(Float amount) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",'" + amount + "')]";
        utils.waitForElement(getDriver(), xpath, 45);
        return getAttribute(By.xpath(xpath), attribute).replaceAll("\n", " ");
    }

    public void selectRequest() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//*[@" + attribute + "=\"CliQ\"]", 30);
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "=\"Request\"]"), "Clicking request tab");
    }

    public void actionRequest(String value, String date) {
        String parentAttribute = "";
        String parentAttribute2 = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            parentAttribute2 = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            parentAttribute2 = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute2 + "[contains(@" + attribute + ",'" + date + "')]", 60);
        if (value.equalsIgnoreCase("ACCEPT"))
            if (getDriver() instanceof IOSDriver)
                click(By.xpath("//XCUIElementTypeButton[@name=\"ACCEPT\"]"), "Clicking accept");
            else
                click(By.xpath("//" + parentAttribute2 + "[contains(@" + attribute + ",'" + date + "')]//" + parentAttribute + "[1]"), "Clicking accept");
        else {
            if (getDriver() instanceof AndroidDriver) {
                click(By.xpath("//" + parentAttribute2 + "[contains(@" + attribute + ",'" + date + "')]//" + parentAttribute + "[2]"), "Clicking reject");
                click(By.xpath("//" + parentAttribute2 + "[@" + attribute + "=\"Unrecognized Request\"]"), "Clicking unrecognized request");
            } else {
                click(By.xpath("//XCUIElementTypeButton[@name=\"REJECT\"]"), "Clicking reject");
                click(By.xpath("//" + parentAttribute2 + "[@" + attribute + "=\"Unrecognized Request\"]"), "Clicking unrecognized request");
            }
        }
    }

    public String acceptTime(String amount) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        String[] value = getAttribute(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'" + amount + "')]"), attribute).replaceAll("\n", " ").split("you")[1].split(" ");
        return value[1] + " " + value[2];
    }

    public String successMessage() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.Button";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeButton";
            attribute = "name";
        }
        String xpath = "//" + parentAttribute + "[contains(@" + attribute + ",\"SUCCESS\")]";
        utils.waitForElement(getDriver(), xpath, 30);
        return getAttribute(By.xpath(xpath), attribute).replaceAll("\n", " ");
    }
}