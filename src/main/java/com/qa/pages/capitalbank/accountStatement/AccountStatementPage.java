package com.qa.pages.capitalbank.accountStatement;

import com.qa.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.qa.engine.ProjectBase.logInfo;

public class AccountStatementPage extends BasePage {

    @AndroidFindBy(accessibility = "E - Statement")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"E - Statement\"]")
    protected WebElement eStatement;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Request')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'Request')]")
    protected WebElement statementYearAndMonth;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Year')]/android.view.View[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Please Select\"])[1]")
    protected WebElement yearDropDown;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Month')]/android.view.View[3]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Please Select\"])[2]")
    protected WebElement monthDropDown;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Generate PDF']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Generate PDF']")
    protected WebElement generatePDF;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text, 'pdf'])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,\"PDF\")]")
    protected WebElement sharePDF;

    @Override
    protected void waitForAppToLoad() {
    }

    public void clickTransactionButton(String text) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }

        scrollUntilElementPresent(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + text + "']"), "up", 0.50);

        if (getDriver() instanceof IOSDriver)
            scroll("up", 0.5);

        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + text + "']"), "Clicking on Transactions");
    }

    public void clickOnEStatement() {
        waitForVisibility(eStatement);

        if (getDriver() instanceof AndroidDriver)
            click(eStatement, "Clicking on E-Statement");
        else {
            eStatement.click();
            logInfo("Clicking onE-Statement");
        }
    }

    public String getStatementYearAndMonth() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='E - Statement']", 60);
        return getTextWithAttribute(statementYearAndMonth, attribute);
    }

    public void clickOnYearDropDown() {
        click(yearDropDown, "Clicking on year dropdown ");
    }

    public List<String> getStatementYear() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }

        utils.waitForElement(getDriver(), "//*[@" + attribute + "=\"Select Statement Year\"]", 60);

        List<String> values = new ArrayList<>();

        if (getDriver() instanceof AndroidDriver) {
            int size = getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", '20')]")).size();
            for (int i = 1; i <= size; i++) {
                values.add(getDriver().findElement(By.xpath("(//" + parentAttribute + "[contains(@" + attribute + ", '20')])["
                        + i + "]")).getAttribute(attribute));
            }
        } else {
            int size = getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[contains(@name,'20')]")).size();
            for (int i = 0; i < size; i++) {
                values.add(getDriver().findElements(By.xpath("//XCUIElementTypeStaticText[contains(@name,'20')]")).get(i).getAttribute(attribute));
            }
        }
        return values;
    }

    public void clickOnStatementMonthDropDown() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='E - Statement']", 60);
        click(monthDropDown, "Clicking on statement month dropdown");
    }

    public List<String> getStatementMonth() {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//" + parentAttribute + "[@" + attribute + "='Select Statement Month']", 60);
        List<String> values = new ArrayList<>();

        int size;
        if (getDriver() instanceof AndroidDriver) {
            size = getDriver().findElements(By.xpath("//" + parentAttribute + "[contains(@" + attribute + ", 'Month')]/" + parentAttribute)).size();
            for (int i = 1; i <= size; i++) {
                values.add(getDriver().findElement(By.xpath("(//" + parentAttribute + "[contains(@" + attribute + ", 'Month')]/" + parentAttribute + ")["
                        + i + "]")).getAttribute(attribute));
            }
        } else {
            size = getDriver().findElements(By.xpath("//XCUIElementTypeOther[contains(@name,Month)]/following-sibling::XCUIElementTypeStaticText")).size();
            for (int i = 1; i < size; i++) {
                values.add(getDriver().findElements(By.xpath("//XCUIElementTypeOther[contains(@name,Month)]/following-sibling::XCUIElementTypeStaticText")).get(i).getAttribute(attribute));
            }
        }
        return values;

    }

    public void selectYear(String year) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        utils.waitForElement(getDriver(), "//*[@" + attribute + "='Select Statement Year']", 60);
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + year + "']"), "Clicking on year " + year);
    }

    public void selectMonth(String month) {
        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }
        waitForVisibility(monthDropDown);
        click(monthDropDown, "Clicking on statement month dropdown");
        utils.waitForElement(getDriver(), "//*[@" + attribute + "='Select Statement Month']", 60);
        click(By.xpath("//" + parentAttribute + "[@" + attribute + "='" + month + "']"), "Clicking on year " + month);
    }

    public void clickOnGeneratePDF() {
        click(generatePDF, "Clicking on generate PDF");
    }

    public String getStatementPDF() {
        String parentAttribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.widget.TextView";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeOther";
        }
        if (getDriver() instanceof AndroidDriver) {
            utils.waitForElement(getDriver(), "(//" + parentAttribute + "[@text, 'pdf'])[1]", 60);
            return getTextWithAttribute(sharePDF, "text");
        } else {
            utils.waitForElement(getDriver(), "//" + parentAttribute + "[contains(@name,\"PDF\")]", 60);
            return getTextWithAttribute(sharePDF, "name");
        }
    }
}