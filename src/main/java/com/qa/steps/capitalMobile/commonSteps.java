package com.qa.steps.capitalMobile;

import com.qa.engine.DriverManager;
import com.qa.engine.ProjectBase;
import com.qa.pages.capitalbank.LauncherPage;
import com.qa.pages.capitalbank.LoginPage;
import com.qa.pages.capitalbank.OtpPinSetUpPage;
import com.qa.pages.capitalbank.cards.CardPage;
import com.qa.pages.capitalbank.dashBoard.AccountsPage;
import com.qa.pages.capitalbank.dashBoard.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import java.time.Instant;
import java.util.List;
import java.util.Locale;

public class commonSteps extends ProjectBase {
    @Given("I have launched the CBJ app")
    public void iHaveLaunchedTheCBJApp() {
        try {
            if (getDriver() != null)
                getDriver().quit();
            new DriverManager().initializeDriver(CAPITAL_BANK);
            logInfo("CapitalMobile app is launched");
            Thread.sleep(5000);
        } catch (Exception e) {
            logInfo("Error while launching the CapitalMobile app");
            throw new RuntimeException(e);
        }

        new LauncherPage().clickLogin();

        if (getDriver() instanceof AndroidDriver) {
            customData.setViewAttribute("android.view.View");
            customData.setStaticAttribute("android.view.View");
            customData.setButtonAttribute("android.widget.Button");
            customData.setTextAttribute("android.widget.EditText");
            customData.setImageAttribute("android.widget.ImageView");
            customData.setAttribute("content-desc");
        } else if (getDriver() instanceof IOSDriver) {
            customData.setViewAttribute("XCUIElementTypeOther");
            customData.setButtonAttribute("XCUIElementTypeButton");
            customData.setTextAttribute("XCUIElementTypeTextField");
            customData.setImageAttribute("XCUIElementTypeImage");
            customData.setStaticAttribute("XCUIElementTypeStaticText");
            customData.setAttribute("name");
        }
    }

    @Given("I have logged in the CBJ app")
    public void iHaveLoggedInTheCBJApp() {
        iHaveLaunchedTheCBJApp();

        loggedInUser = properties.getProperty("capitalBank.username");

        if (getDriver() instanceof AndroidDriver) {
            if (getDriver().findElements(By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Please enter a 6-digit PIN for the app.']"))
                    .size() > 0) {
                getDriver().findElement(By.xpath("//" + customData.getButtonAttribute() + "[@" + customData.getAttribute() + "='Close']")).click();
            }

            Instant timeout = Instant.now().plusSeconds(45);

            while (getDriver().findElements(By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Please enter a 6-digit PIN for the app.']"))
                    .size() == 0) {
                if (getDriver().findElements(By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Please enter a 6-digit PIN for the app.']"))
                        .size() > 0) {
                    getDriver().findElement(By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Close']")).click();
                    break;
                }

                if (getDriver().findElements(By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Username']/" + customData.getTextAttribute()))
                        .size() > 0)
                    break;

                if (Instant.now().isAfter(timeout))
                    throw new TimeoutException("APP is not loaded properly.");
            }
        } else {
            if (getDriver().findElements(By.xpath("//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "='Please enter a 6-digit PIN for the app.']"))
                    .size() > 0) {
                getDriver().findElement(By.xpath("//" + customData.getButtonAttribute() + "[@" + customData.getAttribute() + "='Close']")).click();
            }

            Instant timeout = Instant.now().plusSeconds(45);

            while (getDriver().findElements(By.xpath("//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "='Please enter a 6-digit PIN for the app.']"))
                    .size() == 0) {
                if (getDriver().findElements(By.xpath("//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "='Please enter a 6-digit PIN for the app.']"))
                        .size() > 0) {
                    getDriver().findElement(By.xpath("//" + customData.getButtonAttribute() + "[@" + customData.getAttribute() + "='Close']")).click();
                    break;
                }

                if (getDriver().findElements(By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Username']"))
                        .size() > 0)
                    break;

                if (Instant.now().isAfter(timeout))
                    throw new TimeoutException("APP is not loaded properly.");
            }


        }

        new LoginPage().userName(loggedInUser)
                .password(properties.getProperty("capitalBank.password"))
                .login();
    }

    @Given("I have logged in the CBJ app with username as {string}")
    public void iHaveLoggedInTheCBJAppWithUsername(String username) {
        loggedInUser = username;

        String xpath;

        if (getDriver() instanceof AndroidDriver)
            xpath = "//android.view.View[@content-desc='Username']/android.widget.EditText";
        else
            xpath = "//XCUIElementTypeTextField[@name='Enter your username']";

        if (getDriver().findElements(By.xpath("//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "='Please enter a 6-digit PIN for the app.']"))
                .size() > 0) {
            if (getDriver() instanceof AndroidDriver)
                getDriver().findElement(By.xpath("//" + customData.getButtonAttribute() + "[@" + customData.getAttribute() + "='Close']")).click();
            else
                new HomePage().tapOnPosition(383, 77);
        }

        Instant timeout = Instant.now().plusSeconds(45);

        while (getDriver().findElements(By.xpath("//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "='Please enter a 6-digit PIN for the app.']"))
                .size() == 0) {
            if (getDriver().findElements(By.xpath("//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "='Please enter a 6-digit PIN for the app.']"))
                    .size() > 0) {
                if (getDriver() instanceof AndroidDriver)
                    getDriver().findElement(By.xpath("//" + customData.getButtonAttribute() + "[@" + customData.getAttribute() + "='Close']")).click();
                else
                    new HomePage().tapOnPosition(383, 77);
                break;
            }

            if (getDriver().findElements(By.xpath(xpath)).size() > 0)
                break;

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException("APP is not loaded properly.");
        }

        new LoginPage().userName(loggedInUser)
                .password(properties.getProperty(loggedInUser + ".password"))
                .login();
    }

    @Given("I have logged in the CBJ app with username as {string} and password as {string}")
    public void iHaveLoggedInTheCBJAppWithUsernameAndPasswordAs(String username, String password) {
        if (getDriver().findElements(By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Please enter a 6-digit PIN for the app.']"))
                .size() > 0)
            getDriver().findElement(By.xpath("//" + customData.getButtonAttribute() + "[@" + customData.getAttribute() + "='Close']")).click();

        new LoginPage().userName(username)
                .password(password)
                .login();
    }

    @And("I navigate to ios dashboard page")
    public void iNavigateToIosDashboardPage() throws InterruptedException {
        By takeTourNext = By.xpath("//" + customData.getButtonAttribute() + "[@" + customData.getAttribute() + "='Next']");
        By ratingPop = By.xpath("(//" + customData.getViewAttribute() + "[@name='Horizontal scroll bar, 1 page'])[4]");
        By accounts = By.xpath("//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "='Accounts']");
        By mayBeLater = By.xpath("//" + customData.getButtonAttribute() + "[contains(@" + customData.getAttribute() + ", 'Maybe Later')]");
        By createAppPin = By.xpath("(//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Create App PIN'])[1]");
        By ibanTerms = By.xpath("//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ", 'IBAN Terms and Conditions')]");
        By ibanAgree = By.xpath("//" + customData.getButtonAttribute() + "[@" + customData.getAttribute() + "='Agree']");
        By verificationCode = By.xpath("//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "='6-digits code']");
        By verifyMobile = By.xpath("//XCUIElementTypeStaticText[@name='Verify Mobile']");
        Instant timeout = Instant.now().plusSeconds(120);

        while (getDriver().findElements(verifyMobile).size() == 0) {
            if (getDriver().findElements(verifyMobile).size() > 0)
                break;

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException("Problem while navigating to the app dashboard");
        }

        if (getDriver().findElements(verifyMobile).size() > 0 || getDriver().findElements(verificationCode).size() > 0) {
            new OtpPinSetUpPage().verifyMobile("654321").next();
            Thread.sleep(2000);
        }

        if (getDriver().findElements(createAppPin).size() > 0) {
            new OtpPinSetUpPage().createAppPin().next().createAppPin().next();
            Thread.sleep(2000);
        }

        if (getDriver().findElements(ratingPop).size() > 0) {
            new HomePage().tapOnPosition(205, 555);
            Thread.sleep(2000);
        }

        if (getDriver().findElements(takeTourNext).size() > 0) {
            new HomePage().proceedTakeTour();
            Thread.sleep(2000);
        }

        if (getDriver().findElements(ibanTerms).size() > 0) {
            getDriver().findElement(ibanAgree).click();
            Thread.sleep(2000);
        }
    }

    @And("I navigate to dashboard page")
    public void iNavigateToDashboardPage() throws InterruptedException {
        By takeTourNext = By.xpath("//" + customData.getButtonAttribute() + "[@" + customData.getAttribute() + "='Next']");
        By ratingPop = By.xpath("(//" + customData.getViewAttribute() + "[@name='Horizontal scroll bar, 1 page'])[4]");
        By accounts = By.xpath("//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "='Accounts']");
        By mayBeLater = By.xpath("//" + customData.getButtonAttribute() + "[contains(@" + customData.getAttribute() + ", 'Maybe Later')]");
        By createAppPin = By.xpath("(//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Create App PIN'])[1]");
        By ibanTerms = By.xpath("//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ", 'IBAN Terms and Conditions')]");
        By ibanAgree = By.xpath("//" + customData.getButtonAttribute() + "[@" + customData.getAttribute() + "='Agree']");
        By verificationCode = By.xpath("//" + customData.getStaticAttribute() + "[@" + customData.getAttribute() + "='6-digits code']");
        boolean appLaunchSuccess = false;
        boolean appPinCreate = false;

        By enableBiometric;
        By verifyMobile;

        if (getDriver() instanceof IOSDriver) {
            enableBiometric = By.xpath("(//XCUIElementTypeImage[contains(@" + customData.getAttribute() + ",'Enable Biometric')])[1]");
            verifyMobile = By.xpath("//XCUIElementTypeStaticText[@name='Verify Mobile']");
        } else {
            enableBiometric = By.xpath("(//" + customData.getButtonAttribute() + "[contains(@" + customData.getAttribute() + ",'Enable Biometric')])[1]");
            verifyMobile = By.xpath("//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Verify Mobile']");
        }

        if (getDriver() instanceof AndroidDriver) {
            Instant timeout = Instant.now().plusSeconds(120);
            Instant timeout1 = Instant.now().plusSeconds(120);
            Instant timeout2 = Instant.now().plusSeconds(120);
            Instant timeout3 = Instant.now().plusSeconds(120);

            while (getDriver().findElements(verifyMobile).size() == 0) {
                if (getDriver().findElements(verifyMobile).size() > 0 || getDriver().findElements(verificationCode).size() > 0) {
                    new OtpPinSetUpPage().verifyMobile("654321").next();
                    break;
                }

                Thread.sleep(1000);

                if (getDriver().findElements(enableBiometric).size() > 0) {
                    getDriver().findElement(mayBeLater).click();
                    break;
                }


                if (getDriver().findElements(takeTourNext).size() > 0) {
                    new HomePage().proceedTakeTour();
                    appLaunchSuccess = true;
                    break;
                }

                if (getDriver().findElements(accounts).size() > 0)
                    break;

                if (Instant.now().isAfter(timeout))
                    throw new TimeoutException("Problem while navigating to the app dashboard");
            }

            Thread.sleep(2000);

            if (getDriver().findElements(createAppPin).size() > 0) {
                new OtpPinSetUpPage().createAppPin().next().createAppPin().next();
                logInfo("App pin is created.");
                appPinCreate = true;
            }

            if (!appLaunchSuccess) {
                while (getDriver().findElements(verifyMobile).size() == 0) {
                    if (getDriver().findElements(verifyMobile).size() > 0 || getDriver().findElements(verificationCode).size() > 0) {
                        new OtpPinSetUpPage().verifyMobile("654321");
                        break;
                    }

                    if (getDriver().findElements(mayBeLater).size() > 0) {
                        getDriver().findElement(mayBeLater).click();
                    }

                    if (getDriver().findElements(createAppPin).size() > 0) {
                        new OtpPinSetUpPage().createAppPin().next().createAppPin().next();
                        appPinCreate = true;
                        break;
                    }

                    if (getDriver().findElements(takeTourNext).size() > 0) {
                        new HomePage().proceedTakeTour();
                        break;
                    }

                    if (getDriver().findElements(accounts).size() > 0)
                        break;

                    if (Instant.now().isAfter(timeout1))
                        throw new TimeoutException("problem while navigating to the app dashboard");

                }

                if (!appPinCreate) {
                    while (getDriver().findElements(createAppPin).size() == 0) {
                        if (getDriver().findElements(createAppPin).size() > 0) {
                            new OtpPinSetUpPage().createAppPin().next().createAppPin().next();
                            break;
                        }

                        if (getDriver().findElements(accounts).size() > 0)
                            break;

                        if (Instant.now().isAfter(timeout2))
                            throw new TimeoutException("problem while navigating to the app dashboard");
                    }
                }

                while (getDriver().findElements(takeTourNext).size() == 0) {
                    if (getDriver().findElements(takeTourNext).size() > 0) {
                        new HomePage().proceedTakeTour();
                        break;
                    }

                    if (getDriver().findElements(accounts).size() > 0)
                        break;

                    if (Instant.now().isAfter(timeout3))
                        throw new TimeoutException("Problem while navigating to the app dashboard");
                }
            }

            Thread.sleep(5000);

            Instant timeout4 = Instant.now().plusSeconds(120);
            if (getDriver().findElements(ibanTerms).size() > 0) {
                getDriver().findElement(ibanAgree).click();
            } else {
                while (getDriver().findElements(ibanTerms).size() == 0) {
                    if (getDriver().findElements(accounts).size() > 0)
                        break;

                    if (getDriver().findElements(ibanTerms).size() > 0) {
                        getDriver().findElement(ibanAgree).click();
                        break;
                    }

                    if (getDriver().findElements(takeTourNext).size() > 0) {
                        new HomePage().proceedTakeTour();
                        break;
                    }

                    if (Instant.now().isAfter(timeout4))
                        throw new TimeoutException("Problem while navigating to the app dashboard");
                }
            }
            Thread.sleep(2000);

            if (getDriver().findElements(verifyMobile).size() > 0 || getDriver().findElements(verificationCode).size() > 0) {
                new OtpPinSetUpPage().verifyMobile("654321");
                Thread.sleep(2000);
            }

            if (getDriver().findElements(createAppPin).size() > 0) {
                new OtpPinSetUpPage().createAppPin().next().createAppPin().next();
                Thread.sleep(2000);
            }

            if (getDriver() instanceof IOSDriver) {
                if (getDriver().findElements(ratingPop).size() > 0) {
                    new HomePage().tapOnPosition(205, 555);
                    Thread.sleep(2000);
                }
            }

            if (getDriver().findElements(takeTourNext).size() > 0) {
                new HomePage().proceedTakeTour();
                Thread.sleep(2000);
            }

            if (getDriver().findElements(ibanTerms).size() > 0) {
                getDriver().findElement(ibanAgree).click();
                Thread.sleep(2000);
            }
        } else if (getDriver() instanceof IOSDriver) {
            Instant timeout = Instant.now().plusSeconds(120);
            Instant timeout1 = Instant.now().plusSeconds(20);
            Instant timeout2 = Instant.now().plusSeconds(20);
            Instant timeout3 = Instant.now().plusSeconds(120);

            while (getDriver().findElements(verifyMobile).size() == 0) {
                if (getDriver().findElements(verifyMobile).size() > 0) {
                    break;
                }
                if (Instant.now().isAfter(timeout1))
                    break;
            }

            if (getDriver().findElements(verifyMobile).size() > 0)
                new OtpPinSetUpPage().verifyMobile("654321").next();

            while (getDriver().findElements(verifyMobile).size() == 0) {
                if (getDriver().findElements(verifyMobile).size() > 0 || getDriver().findElements(verificationCode).size() > 0) {
                    new OtpPinSetUpPage().verifyMobile("654321").next();
                    break;
                }

                if (getDriver().findElements(createAppPin).size() > 0) {
                    new OtpPinSetUpPage().createAppPin().next().createAppPin().next();
                    logInfo("App pin is created.");
                }

                if (getDriver().findElements(enableBiometric).size() > 0) {
                    getDriver().findElement(mayBeLater).click();
                    break;
                }

                if (getDriver().findElements(ratingPop).size() > 0) {
                    new HomePage().tapOnPosition(205, 555);
                    Thread.sleep(2000);
                }

                if (getDriver() instanceof IOSDriver)
                new HomePage().tapOnPosition(190, 523);

                if (getDriver().findElements(takeTourNext).size() > 0) {
                    new HomePage().proceedTakeTour();
                    break;
                }

                if (getDriver().findElements(accounts).size() > 0)
                    break;

                if (Instant.now().isAfter(timeout))
                    throw new TimeoutException("Problem while navigating to the app dashboard");
            }

            while (getDriver().findElements(createAppPin).size() == 0) {
                if (getDriver().findElements(createAppPin).size() > 0) {
                    break;
                }
                if (Instant.now().isAfter(timeout2))
                    break;
            }

            if (getDriver().findElements(createAppPin).size() > 0) {
                new OtpPinSetUpPage().createAppPin().next().createAppPin().next();
                logInfo("App pin is created.");
                appPinCreate = true;
            }

            if (getDriver().findElements(ratingPop).size() > 0) {
                new HomePage().tapOnPosition(205, 555);
                Thread.sleep(2000);
            }

            if (getDriver() instanceof IOSDriver)
            new HomePage().tapOnPosition(190, 523);
            if (getDriver().findElements(takeTourNext).size() > 0)
                new HomePage().proceedTakeTour();
            else {
                while (getDriver().findElements(takeTourNext).size() == 0) {
                    if (getDriver().findElements(takeTourNext).size() > 0) {
                        new HomePage().proceedTakeTour();
                        break;
                    }

                    if (getDriver().findElements(accounts).size() > 0)
                        break;

                    if (Instant.now().isAfter(timeout3))
                        throw new TimeoutException("Problem while navigating to the app dashboard");
                }
            }

            Instant timeout4 = Instant.now().plusSeconds(120);
            if (getDriver().findElements(ibanAgree).size() > 0) {
                getDriver().findElement(ibanAgree).click();
            } else {
                while (getDriver().findElements(ibanTerms).size() == 0) {
                    if (getDriver().findElements(accounts).size() > 0)
                        break;

                    if (getDriver().findElements(ibanTerms).size() > 0) {
                        getDriver().findElement(ibanAgree).click();
                        break;
                    }

                    if (getDriver().findElements(ratingPop).size() > 0) {
                        new HomePage().tapOnPosition(205, 555);
                        Thread.sleep(2000);
                    }
                    if (getDriver() instanceof IOSDriver)
                    new HomePage().tapOnPosition(190, 523);

                    if (getDriver().findElements(takeTourNext).size() > 0) {
                        new HomePage().proceedTakeTour();
                        break;
                    }

                    if (Instant.now().isAfter(timeout4))
                        throw new TimeoutException("Problem while navigating to the app dashboard");
                }
            }
        }

        if (getDriver() instanceof IOSDriver)
        new HomePage().tapOnPosition(190, 523);

    }

    @And("I verify the mobile 6 digit pin for the transaction")
    public void iVerifyTheMobileDigitPinForTheTransaction() throws InterruptedException {
        By verifyMobile;
        if (getDriver() instanceof AndroidDriver)
            verifyMobile = By.xpath("//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ",'verification code')]");
        else
            verifyMobile = By.xpath("//*[contains(@" + customData.getAttribute() + ",'verification code')]");

        Instant timeout = Instant.now().plusSeconds(60);

        while (getDriver().findElements(verifyMobile).size() == 0) {
            if (getDriver().findElements(verifyMobile).size() > 0) {
                break;
            }

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException("Verify mobile page is not loaded properly.");
        }

        logInfo("Verifying the mobile with the 6-digit OTP");

        if (getDriver() instanceof IOSDriver)
            new HomePage().tapOnPosition(50, 390);
        else
            new HomePage().tapOnPosition(50, 350);

        new Actions(getDriver())
                .sendKeys("654321")
                .perform();

        getDriver().findElement(By.xpath("//" + customData.getButtonAttribute() + "[contains(@" + customData.getAttribute() + ",\"Ne\")]")).click();
    }

    @And("I verify the mobile otp pin {}")
    public void iVerifyTheMobilePinForTheTransaction(String otp) throws InterruptedException {
        By verifyMobile;
        if (getDriver() instanceof AndroidDriver)
            verifyMobile = By.xpath("//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ",'verification code')]");
        else
            verifyMobile = By.xpath("//" + customData.getStaticAttribute() + "[contains(@" + customData.getAttribute() + ",'verification code')]");

        Instant timeout = Instant.now().plusSeconds(60);

        while (getDriver().findElements(verifyMobile).size() == 0) {
            if (getDriver().findElements(verifyMobile).size() > 0) {
                break;
            }

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException("Verify mobile page is not loaded properly.");
        }
        if (getDriver() instanceof IOSDriver)
            new HomePage().tapOnPosition(50, 390);
        else
            new HomePage().tapOnPosition(50, 350);

        new Actions(getDriver())
                .sendKeys(otp)
                .perform();
    }

    @And("I fetch the all Current account details from the dashboard")
    public void iFetchAllTheCurrentAccountDetailsFromTheDashboard() throws InterruptedException {
        List<String> accountsDetails = new AccountsPage().getAllCurrentAccountDetails();

        accountsDetails.forEach(log()::info);

        for (String accountsDetail : accountsDetails) {
            if (accountsDetail.contains("JOD")) {
                customData.setJodAccountDetails(accountsDetail);
            } else if (accountsDetail.contains("AED")) {
                customData.setAedAccountDetails(accountsDetail);
            } else if (accountsDetail.contains("USD")) {
                customData.setUsdAccountDetails(accountsDetail);
            } else if (accountsDetail.contains("GBP")) {
                customData.setGbpAccountDetails(accountsDetail);
            } else if (accountsDetail.contains("EUR")) {
                customData.setEurAccountDetails(accountsDetail);
            }
        }

        new AccountsPage().backToHome(accountsDetails.size());
    }

    @When("I navigate to {} account in Accounts tab")
    public void iNavigateToAccount(String currency) throws InterruptedException {

        customData.setPayFromCurrency(currency);
        double accountBalance;
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[contains(@" + customData.getAttribute() + ",'CURRENT ACCOUNT')]", 60);

        AccountsPage accountsPage = new AccountsPage();

        Thread.sleep(1500);
        accountsPage.selectAccount(currency);

        List<String> accountDetails = List.of(accountsPage.fetchCurrentAccountDetails().toUpperCase(Locale.ROOT).split("\n"));

        logInfo("Fetching account details as ");
        accountDetails.forEach(log()::info);

        for (int i = 0; i < accountDetails.size(); i++) {
            if (accountDetails.get(i).contains("TOTAL ACCOUNT BALANCE")) {
                customData.setTotalAccountBalance(accountDetails.get(i + 1));
                break;
            }
        }

        logInfo("Total Available balance in Current account is " + customData.getTotalAccountBalance());

        accountBalance = Double.parseDouble(customData.getTotalAccountBalance().split(" ")[0].replace(",", ""));

        if (customData.getAccountBalanceBeforeTransaction() == 0) {
            customData.setAccountBalanceBeforeTransaction(accountBalance);
            logInfo("Total account balance before transaction is " + accountBalance);
        }
    }

    @When("I navigate to {} card in Cards tab")
    public void iNavigateToCardInCardsTab(String currency) throws InterruptedException {
        utils.waitForElement(getDriver(), "//" + customData.getImageAttribute() + "[@" + customData.getAttribute() + "='Transfers']", 60);
        customData.setPayToCurrency(currency);

        new CardPage().selectCardWithCurrency(currency);

        String balance = "";

        List<String> cardDetails = List.of(new CardPage().fetchCardDetails().toUpperCase(Locale.ROOT).split("\n"));

        cardDetails.forEach(log()::info);

        for (int i = 0; i < cardDetails.size(); i++) {
            if (cardDetails.get(i).contains("XXXX"))
                customData.setMaskedCreditCardNumber(cardDetails.get(i));
            else if (cardDetails.get(i).contains("/"))
                customData.setCreditCardExpiryDate(cardDetails.get(i));
            else if (cardDetails.get(i).contains("TOTAL ACCOUNT BALANCE"))
                balance = cardDetails.get(i + 1);
        }

        logInfo("Total Available balance in Card is " + balance);

        customData.setCreditCardTotalAccountBalance(balance);
        customData.setTotalCardBalance(balance.split(" ")[0].replace(",", ""));

        if (customData.getCardBalanceBeforeTransaction() == 0)
            customData.setCardBalanceBeforeTransaction(Double.parseDouble(customData.getTotalCardBalance()));
    }

    @And("I fetch the all Card account details from the dashboard")
    public void iFetchAllTheCardAccountDetailsFromTheDashboard() throws InterruptedException {
        List<String> cardsDetails = new CardPage().getAllCardAccountDetails();

        cardsDetails.forEach(log()::info);

        for (String cardDetail : cardsDetails) {
            if (cardDetail.contains("JOD"))
                customData.setJodAccountDetails(cardDetail);
            else if (cardDetail.contains("AED"))
                customData.setAedAccountDetails(cardDetail);
            else if (cardDetail.contains("USD"))
                customData.setUsdAccountDetails(cardDetail);
            else if (cardDetail.contains("GBP"))
                customData.setGbpAccountDetails(cardDetail);
            else if (cardDetail.contains("EUR"))
                customData.setEurAccountDetails(cardDetail);
        }
        new AccountsPage().backToHome(cardsDetails.size());
    }

    @And("I verify the otp {string} in paybill transfer page")
    public void iVerifyTheOtpInPaybillTransferPage(String otp) throws InterruptedException {

        String parentAttribute = "";
        String attribute = "";

        if (getDriver() instanceof AndroidDriver) {
            parentAttribute = "android.view.View";
            attribute = "content-desc";
        } else if (getDriver() instanceof IOSDriver) {
            parentAttribute = "XCUIElementTypeStaticText";
            attribute = "name";
        }

        By verifyMobile = By.xpath("//" + parentAttribute + "[contains(@" + attribute + ",'verification code')]");

        Instant timeout = Instant.now().plusSeconds(60);

        while (getDriver().findElements(verifyMobile).size() == 0) {
            if (getDriver().findElements(verifyMobile).size() > 0) {
                break;
            }

            if (Instant.now().isAfter(timeout))
                throw new TimeoutException("Verify mobile page is not loaded properly.");
        }
        new OtpPinSetUpPage().verifyMobileOTP(otp).next();
    }
}
