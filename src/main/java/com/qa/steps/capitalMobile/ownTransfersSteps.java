package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.blink.HomePage;
import com.qa.pages.capitalbank.OwnTransfersPage;
import com.qa.pages.capitalbank.dashBoard.AccountsPage;
import com.qa.pages.capitalbank.overdraft.OverdraftTransferPage;
import com.qa.pages.capitalbank.transfers.TransferPayeePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ownTransfersSteps extends ProjectBase {
    protected double bankCharges = 0;
    protected boolean chargeIncluded = false;
    protected Boolean sharedRadioButton = false;
    protected Boolean overseasBeneficiary = false;
    protected Boolean domesticBeneficiary = false;
    protected Boolean setFlag = false;
    protected double transferCharges = 0;
    protected double localTransferCharges = 0;

    @When("I select payFrom account with {string} account number {string}")
    public void iSelectPayFromAccountWithPayFromAccountNumber(String currency, String accountNumber) throws InterruptedException {
        customData.setPayFromCurrency(currency);
        new OwnTransfersPage().selectPayFromAccount(accountNumber);

        customData.setTotalAccountBalance(new OwnTransfersPage().fetchDetails().split("BALANCE\n")[1].split(" ")[0].replace(",", ""));

        logInfo("The total available balance in pay From account is " + customData.getTotalAccountBalance());

        if (customData.getPayFromAccountBalanceBeforeTransaction() == 0)
            customData.setPayFromAccountBalanceBeforeTransaction(Double.parseDouble(customData.getTotalAccountBalance()));
    }

    @And("I select PayTo as {string}")
    public void iSelectPayToAs(String type) {
        new OwnTransfersPage().clickOnPayToType(type);
    }

    @And("I select the PayTo account with {string} account number {string}")
    public void iSelectThePayToAccountWithAccountNumber(String currency, String number) {
        customData.setPayToCurrency(currency);

        customData.setPayToAccountBalance(new OwnTransfersPage().selectPayToCard(number).split("BALANCE\n")[1].split(" ")[0].replace(",", ""));

        logInfo("PayTo balance" + customData.getPayToAccountBalance());

        if (customData.getPayToAccountBalanceBeforeTransaction() == 0)
            customData.setPayToAccountBalanceBeforeTransaction(Double.parseDouble(customData.getPayToAccountBalance()));
    }

    @And("I fetch the PayTo card Account Details")
    public void iFetchThePayToAccountDetails() {
        utils.waitForElement(getDriver(), "//" + customData.getViewAttribute() + "[@" + customData.getAttribute() + "='Pay to']", 30);

        new HomePage().scroll("up");
        customData.setPayToAccountBalance((new OwnTransfersPage().fetchPayToAccountBalance().split(" ")[0]).replace(",", ""));

        logInfo("Pay To Account Balance " + customData.getPayToAccountBalance());

        if (customData.getPayToAccountBalanceBeforeTransaction() == 0)
            customData.setPayToAccountBalanceBeforeTransaction(Float.parseFloat(customData.getPayToAccountBalance()));

    }

    @Then("I verify the transfer exchange rate from {string} for the amount {string}")
    public void iVerifyTheTransferExchangeRateFromForTheAmount(String country, String enteredAmount) {
        double payFromAccountDebit = Double.parseDouble(new TransferPayeePage().getAmountValue(customData.getPayFromCurrency()));
        logInfo("payFromAccountDebit" + payFromAccountDebit);

        double payToAccountCredit = Double.parseDouble(new TransferPayeePage().getAmountValue(customData.getPayToCurrency()));
        logInfo("payToAccountCredit" + payToAccountCredit);

        String exchange;

        double expectedCredit = 0;
        double exchangeRate = 0;

        if (!customData.getPayFromCurrency().equalsIgnoreCase(customData.getPayToCurrency())) {
            exchange = new TransferPayeePage().getExchangeRate();
            if (exchange.contains("=")) {
                String[] rate = exchange.split(" ");
                exchangeRate = Double.parseDouble(rate[3]);
                logInfo("exchangeRate" + exchangeRate);
            } else exchangeRate = Double.parseDouble(exchange);

            logInfo("ExchangeRate for the transaction is " + exchangeRate);
        }

        if (customData.getPayFromCurrency().equalsIgnoreCase(customData.getPayToCurrency()))
            expectedCredit = Double.parseDouble(customData.getTransactionAmount());
        else if (customData.getPayFromCurrency().equalsIgnoreCase("JOD")) {
            logInfo(exchangeRate);
            logInfo(Double.parseDouble(customData.getTransactionAmount()));
            expectedCredit = exchangeRate * Double.parseDouble(customData.getTransactionAmount());
        } else if (customData.getPayToCurrency().equalsIgnoreCase("JOD"))
            expectedCredit = Double.parseDouble(customData.getTransactionAmount()) / exchangeRate;
        else if (customData.getPayFromCurrency().equalsIgnoreCase("GBP"))
            expectedCredit = Double.parseDouble(customData.getTransactionAmount()) / exchangeRate;
        else if (customData.getPayFromCurrency().equalsIgnoreCase("EUR")) {
            if (customData.getPayToCurrency().equalsIgnoreCase("GBP"))
                expectedCredit = Double.parseDouble(customData.getTransactionAmount()) / exchangeRate;
            else expectedCredit = Double.parseDouble(customData.getTransactionAmount()) * exchangeRate;
        } else if (customData.getPayFromCurrency().equalsIgnoreCase("USD")) {
            if (customData.getPayToCurrency().equalsIgnoreCase("AED") || customData.getPayToCurrency().equalsIgnoreCase("CHF") || customData.getPayToCurrency().equalsIgnoreCase("CAD") || customData.getPayToCurrency().equalsIgnoreCase("SAR") || customData.getPayToCurrency().equalsIgnoreCase("BHD") || customData.getPayToCurrency().equalsIgnoreCase("KWD") || customData.getPayToCurrency().equalsIgnoreCase("QAR") || customData.getPayToCurrency().equalsIgnoreCase("OMR"))
                expectedCredit = Double.parseDouble(customData.getTransactionAmount()) / exchangeRate;
            else expectedCredit = Double.parseDouble(customData.getTransactionAmount()) * exchangeRate;
        } else if (customData.getPayFromCurrency().equalsIgnoreCase("AED"))
            expectedCredit = exchangeRate * Double.parseDouble(customData.getTransactionAmount());

        customData.setExchangedTransactionAmount(expectedCredit);

        Assert.assertEquals(String.format("%.2f", expectedCredit), String.format("%.2f", payFromAccountDebit));
    }

    @When("I select payFrom account with {string} account number {string} After transaction")
    public void iSelectPayFromAccountWithAccountNumberAfterTransaction(String currency, String AccountNumber) throws InterruptedException {
        new OwnTransfersPage().selectPayFromAccount(AccountNumber);

        customData.setTotalAccountBalance(new OwnTransfersPage().fetchDetails().split("BALANCE\n")[1].split(" ")[0].replace(",", ""));

        logInfo("The total available balance in pay From account after transaction is " + customData.getTotalAccountBalance());

        customData.setPayFromAccountBalanceAfterTransaction(Double.parseDouble(customData.getTotalAccountBalance()));
    }

    @When("I select payTo account with account number {string} After transaction")
    public void iSelectPayToAccountWithAccountNumberAfterTransaction(String accountNumber) throws InterruptedException {
        new HomePage().scroll("down", 0.6);
        new OwnTransfersPage().selectPayFromAccount(accountNumber);

        customData.setTotalAccountBalance(new OwnTransfersPage().fetchDetails().split("BALANCE\n")[1].split(" ")[0].replace(",", ""));

        logInfo("The total available balance in pay To account after transaction is " + customData.getTotalAccountBalance());

        customData.setPayToAccountBalanceAfterTransaction(Double.parseDouble(customData.getTotalAccountBalance()));
    }

    @Then("I should see the {string} with {string} amount in the transaction history with today's date in {string} tab")
    public void iShouldSeeTheWithAmountInTheTransactionHistoryWithTodaySDateInAccounts(String transactionEntry, String operation, String tab) throws InterruptedException {
        if (overseasBeneficiary) {
            if (!sharedRadioButton) {
                chargeIncluded = true;
                if (customData.getPayFromCurrency().equalsIgnoreCase("JOD")) {
                    if (transactionEntry.equalsIgnoreCase("Correspondent Bank Chg.")) {
                        bankCharges = 18;
                    } else if (transactionEntry.equalsIgnoreCase("Outward Transfer Charges")) {
                        transferCharges = 2;
                    }
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("USD")) {
                    if (transactionEntry.equalsIgnoreCase("Correspondent Bank Chg.")) {
                        bankCharges = 25.39;
                    } else if (transactionEntry.equalsIgnoreCase("Outward Transfer Charges")) {
                        transferCharges = 2.82;
                    }
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("EUR")) {
                    if (transactionEntry.equalsIgnoreCase("Correspondent Bank Chg.")) {
                        bankCharges = 21.41;
                    } else if (transactionEntry.equalsIgnoreCase("Outward Transfer Charges")) {
                        transferCharges = 2.38;
                    }
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("AED")) {
                    chargeIncluded = true;
                    if (transactionEntry.equalsIgnoreCase("Correspondent Bank Chg.")) {
                        bankCharges = 93.25;
                    } else if (transactionEntry.equalsIgnoreCase("Outward Transfer Charges")) {
                        transferCharges = 10.36;
                    }
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("GBP")) {
                    if (transactionEntry.equalsIgnoreCase("Correspondent Bank Chg.")) {
                        bankCharges = 19.34;
                    } else if (transactionEntry.equalsIgnoreCase("Outward Transfer Charges")) {
                        transferCharges = 2.15;
                    }
                }

            } else if (transactionEntry.equalsIgnoreCase("Outward Transfer Charges")) {
                chargeIncluded = true;
                if (customData.getPayFromCurrency().equalsIgnoreCase("JOD")) {
                    transferCharges = 2;
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("USD")) {
                    transferCharges = 2.82;
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("EUR")) {
                    transferCharges = 2.38;
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("AED")) {
                    transferCharges = 10.36;
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("GBP")) {
                    transferCharges = 2.15;
                }
            }
        }

        if (domesticBeneficiary) {
            if (!sharedRadioButton) {
                chargeIncluded = true;
                if (customData.getPayFromCurrency().equalsIgnoreCase("JOD")) {
                    if (transactionEntry.equalsIgnoreCase("Correspondent Bank Chg.")) {
                        if (customData.getPayToCurrency().equalsIgnoreCase("JOD") || customData.getPayToCurrency().equalsIgnoreCase("USD"))
                            bankCharges = 1;
                        else if (customData.getPayToCurrency().equalsIgnoreCase("GBP"))
                            bankCharges = 1.108;
                        else if (customData.getPayToCurrency().equalsIgnoreCase("EUR"))
                            bankCharges = 1.177;
                        else
                            bankCharges = 18;

                    } else if (transactionEntry.equalsIgnoreCase("Local Transfer Charges")) {
                        localTransferCharges = 2;
                    } else if (transactionEntry.equalsIgnoreCase("Outward Transfer Charges"))
                        transferCharges = 2;
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("USD")) {
                    if (transactionEntry.equalsIgnoreCase("Correspondent Bank Chg.")) {
                        if (setFlag) {
                            if (customData.getPayToCurrency().equalsIgnoreCase("JOD") || customData.getPayToCurrency().equalsIgnoreCase("USD"))
                                bankCharges = 1.41;
                            else if (customData.getPayToCurrency().equalsIgnoreCase("GBP"))
                                bankCharges = 1.56;
                            else if (customData.getPayToCurrency().equalsIgnoreCase("EUR"))
                                bankCharges = 1.66;
                            else
                                bankCharges = 25.39;
                        } else
                            bankCharges = 1.41;
                    } else if (transactionEntry.equalsIgnoreCase("Local Transfer Charges")) {
                        localTransferCharges = 2.82;
                    } else if (transactionEntry.equalsIgnoreCase("Outward Transfer Charges"))
                        transferCharges = 2.82;
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("AED")) {
                    if (transactionEntry.equalsIgnoreCase("Correspondent Bank Chg.")) {
                        if (setFlag) {
                            if (customData.getPayToCurrency().equalsIgnoreCase("JOD") || customData.getPayToCurrency().equalsIgnoreCase("USD"))
                                bankCharges = 5.18;
                            else if (customData.getPayToCurrency().equalsIgnoreCase("GBP"))
                                bankCharges = 5.18;
                            else if (customData.getPayToCurrency().equalsIgnoreCase("EUR"))
                                bankCharges = 6.10;
                            else
                                bankCharges = 93.25;
                        } else
                            bankCharges = 5.18;
                    } else if (transactionEntry.equalsIgnoreCase("Local Transfer Charges")) {
                        localTransferCharges = 10.36;
                    } else if (transactionEntry.equalsIgnoreCase("Outward Transfer Charges"))
                        transferCharges = 10.36;
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("EUR")) {
                    if (transactionEntry.equalsIgnoreCase("Correspondent Bank Chg.")) {
                        if (setFlag) {
                            if (customData.getPayToCurrency().equalsIgnoreCase("JOD") || customData.getPayToCurrency().equalsIgnoreCase("USD"))
                                bankCharges = 1.19;
                            else if (customData.getPayToCurrency().equalsIgnoreCase("GBP"))
                                bankCharges = 1.32;
                            else if (customData.getPayToCurrency().equalsIgnoreCase("EUR"))
                                bankCharges = 1.40;
                            else if (customData.getPayToCurrency().equalsIgnoreCase("AED"))
                                bankCharges = 1.19;
                            else
                                bankCharges = 21.41;
                        } else
                            bankCharges = 1.19;
                    } else if (transactionEntry.equalsIgnoreCase("Local Transfer Charges")) {
                        localTransferCharges = 2.38;
                    } else if (transactionEntry.equalsIgnoreCase("Outward Transfer Charges"))
                        transferCharges = 2.38;

                } else if (customData.getPayFromCurrency().equalsIgnoreCase("GBP")) {
                    if (transactionEntry.equalsIgnoreCase("Correspondent Bank Chg.")) {
                        if (setFlag) {
                            if (customData.getPayToCurrency().equalsIgnoreCase("JOD") || customData.getPayToCurrency().equalsIgnoreCase("USD"))
                                bankCharges = 1.07;
                            else if (customData.getPayToCurrency().equalsIgnoreCase("GBP"))
                                bankCharges = 1.19;
                            else if (customData.getPayToCurrency().equalsIgnoreCase("EUR"))
                                bankCharges = 1.26;
                            else
                                bankCharges = 19.34;
                        } else
                            bankCharges = 1.07;
                    } else if (transactionEntry.equalsIgnoreCase("Local Transfer Charges")) {
                        localTransferCharges = 2.15;
                    } else if (transactionEntry.equalsIgnoreCase("Outward Transfer Charges"))
                        transferCharges = 2.15;
                }
            } else if (transactionEntry.equalsIgnoreCase("Local Transfer Charges")) {
                chargeIncluded = true;
                if (customData.getPayFromCurrency().equalsIgnoreCase("JOD")) {
                    localTransferCharges = 2;
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("USD")) {
                    localTransferCharges = 2.82;
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("AED")) {
                    localTransferCharges = 10.36;
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("EUR")) {
                    localTransferCharges = 2.38;
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("GBP")) {
                    localTransferCharges = 2.15;
                }
            } else if (transactionEntry.equalsIgnoreCase("Outward Transfer Charges")) {
                chargeIncluded = true;
                if (customData.getPayFromCurrency().equalsIgnoreCase("JOD")) {
                    transferCharges = 2;
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("USD")) {
                    transferCharges = 2.82;
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("AED")) {
                    transferCharges = 10.36;
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("EUR")) {
                    transferCharges = 2.38;
                } else if (customData.getPayFromCurrency().equalsIgnoreCase("GBP")) {
                    transferCharges = 2.15;
                }
            }
        }

        String amount = "";
        AccountsPage accountsPage = new AccountsPage();

        List<String> expectedEntries = new ArrayList<>();

        List<String> actualEntries = accountsPage.clickTransactions().getLatestTransactionsEntries();

        logInfo("actualEntries" + actualEntries);

        Thread.sleep(1500);
        accountsPage.moveToAccountsTab();

        String transactionDate = LocalDate.now().getMonth().toString() + " " + LocalDate.now().getDayOfMonth() + ", " + LocalDate.now().getYear();

        expectedEntries.add(transactionEntry.toUpperCase(Locale.ROOT));
        if (operation.contains("debit")) {
            if (transactionEntry.equalsIgnoreCase("Outward Transfer") || transactionEntry.equalsIgnoreCase("Account Transaction") || transactionEntry.equalsIgnoreCase("Transfer from account")) {
                if (customData.getPayFromCurrency().equalsIgnoreCase("JOD"))
                    amount = String.format("%.3f", customData.getExchangedTransactionAmount()) + " " + customData.getPayFromCurrency();
                else
                    amount = String.format("%.2f", customData.getExchangedTransactionAmount()) + " " + customData.getPayFromCurrency();
            } else if (transactionEntry.equalsIgnoreCase("Correspondent Bank Chg.")) {
                if (customData.getPayFromCurrency().equalsIgnoreCase("JOD")) {
                    amount = String.format("%.3f", bankCharges) + " " + customData.getPayFromCurrency();
                } else
                    amount = String.format("%.2f", bankCharges) + " " + customData.getPayFromCurrency();
            } else if (transactionEntry.equalsIgnoreCase("Outward Transfer Charges")) {
                if (customData.getPayFromCurrency().equalsIgnoreCase("JOD"))
                    amount = String.format("%.3f", transferCharges) + " " + customData.getPayFromCurrency();
                else
                    amount = String.format("%.2f", transferCharges) + " " + customData.getPayFromCurrency();
            } else if (transactionEntry.equalsIgnoreCase("Local Transfer Charges")) {
                if (customData.getPayFromCurrency().equalsIgnoreCase("JOD"))
                    amount = String.format("%.3f", localTransferCharges) + " " + customData.getPayFromCurrency();
                else
                    amount = String.format("%.2f", localTransferCharges) + " " + customData.getPayFromCurrency();
            }
        } else if (operation.contains("credit"))
            if (customData.getPayToCurrency().equalsIgnoreCase("JOD")) {
                amount = String.format("%.3f", Double.parseDouble(customData.getTransactionAmount())) + " " + customData.getPayToCurrency();
            } else {
                amount = String.format("%.2f", Double.parseDouble(customData.getTransactionAmount())) + " " + customData.getPayToCurrency();
            }

        if (operation.equalsIgnoreCase("debit")) {
            expectedEntries.add("-" + amount);
            logInfo(expectedEntries.add("-" + amount));
        } else expectedEntries.add(amount);

        if (tab.equalsIgnoreCase("accounts")) expectedEntries.add(transactionDate);

        logInfo("ActualEntries for the transfer transaction");
        actualEntries.forEach(log()::info);

        logInfo("ExpectedEntries for the transfer transaction");
        expectedEntries.forEach(log()::info);

        for (String expectedEntry : expectedEntries) {
            Assert.assertTrue(actualEntries.contains(expectedEntry), "Assertion on transaction entry");
        }

        logInfo("Transaction entry is created in " + tab + " transactions");

        new HomePage().scroll("down", 0.75);
    }

    @And("I should see the amount {} is {} from the {} account balance")
    public void iShouldSeeTheAmountIsFromTheAccountBalance(String amount, String operation, String payFromOrPayTo) {
        DecimalFormat df = new DecimalFormat("#.##");
        double transactionAmount;
        double expectedAmount = 0;
        double actualAmount = 0;

        if (chargeIncluded)
            customData.setExchangedTransactionAmount(customData.getExchangedTransactionAmount() + bankCharges + transferCharges + localTransferCharges);

        if (amount.equalsIgnoreCase("exchanged")) transactionAmount = customData.getExchangedTransactionAmount();
        else transactionAmount = Double.parseDouble(customData.getTransactionAmount());

        logInfo("Exchanged/Transaction amount to debit/credit in Account is " + transactionAmount);

        if (payFromOrPayTo.equalsIgnoreCase("PayFrom")) {
            actualAmount = customData.getPayFromAccountBalanceAfterTransaction();
            if (operation.equalsIgnoreCase("increased"))
                expectedAmount = customData.getPayFromAccountBalanceBeforeTransaction() + transactionAmount;
            else if (operation.equalsIgnoreCase("reduced"))
                expectedAmount = customData.getPayFromAccountBalanceBeforeTransaction() - transactionAmount;
        } else if (payFromOrPayTo.equalsIgnoreCase("PayTo")) {
            actualAmount = customData.getPayToAccountBalanceAfterTransaction();
            if (operation.equalsIgnoreCase("increased")) {
                expectedAmount = customData.getPayToAccountBalanceBeforeTransaction() + transactionAmount;
            } else if (operation.equalsIgnoreCase("reduced"))
                expectedAmount = customData.getPayToAccountBalanceBeforeTransaction() - transactionAmount;
        }

        try {
            Assert.assertEquals(String.format("%.2f", actualAmount), String.format("%.2f", expectedAmount));
        } catch (AssertionError error) {
            logInfo("Math" + Math.round(actualAmount));
            logInfo(Math.round(expectedAmount));
            Assert.assertEquals(Math.round(actualAmount), Math.round(expectedAmount));
        }
    }

    @And("I select the currency type as {string}")
    public void iSelectTheCurrencyTypeAs(String currency) {
        new OwnTransfersPage().selectFlagCurrency();

        new TransferPayeePage().enterCurrency(currency).selectCurrency()
                .clickOnNext();
    }

    @Then("I verify the transfer exchange rate with flag from {string} for the amount {string}")
    public void iVerifyTheTransferExchangeRateWithFlagFromForTheAmount(String currency, String enteredAmount) {
        double payFromAccountDebit = Double.parseDouble(new TransferPayeePage().getAmountValue(customData.getPayFromCurrency()));
        logInfo("payFromAccountDebit" + payFromAccountDebit);

        double payToAccountCredit = Double.parseDouble(new TransferPayeePage().getAmountValue(customData.getPayToCurrency()));
        logInfo("payToAccountCredit" + payToAccountCredit);

        String exchange = "";

        double expectedCredit = 0;
        double exchangeRate = 0;

        if (!customData.getPayFromCurrency().equalsIgnoreCase(customData.getPayToCurrency())) {
            exchange = new TransferPayeePage().getExchangeRate();
            if (exchange.contains("=")) {
                String[] rate = exchange.split(" ");
                exchangeRate = Double.parseDouble(rate[3]);
                logInfo("exchangeRate" + exchangeRate);
            } else exchangeRate = Double.parseDouble(exchange);
            logInfo("ExchangeRate for the transfer transaction is " + exchangeRate);
        }

        if (customData.getPayFromCurrency().equalsIgnoreCase(customData.getPayToCurrency()))
            expectedCredit = Double.parseDouble(customData.getTransactionAmount());
        else if (customData.getPayFromCurrency().equalsIgnoreCase("JOD"))
            expectedCredit = Double.parseDouble(customData.getTransactionAmount()) / exchangeRate;
        else if (customData.getPayToCurrency().equalsIgnoreCase("JOD"))
            expectedCredit = Double.parseDouble(customData.getTransactionAmount()) * exchangeRate;
        else if (customData.getPayFromCurrency().equalsIgnoreCase("GBP"))
            expectedCredit = Double.parseDouble(customData.getTransactionAmount()) * exchangeRate;
        else if (customData.getPayFromCurrency().equalsIgnoreCase("EUR")) {
            if (customData.getPayToCurrency().equalsIgnoreCase("GBP"))
                expectedCredit = Double.parseDouble(customData.getTransactionAmount()) * exchangeRate;
            else expectedCredit = Double.parseDouble(customData.getTransactionAmount()) / exchangeRate;
        } else if (customData.getPayFromCurrency().equalsIgnoreCase("USD")) {
            if (customData.getPayToCurrency().equalsIgnoreCase("AED"))
                expectedCredit = Double.parseDouble(customData.getTransactionAmount()) * exchangeRate;
            else expectedCredit = Double.parseDouble(customData.getTransactionAmount()) / exchangeRate;
        } else if (customData.getPayFromCurrency().equalsIgnoreCase("AED"))
            expectedCredit = Double.parseDouble(customData.getTransactionAmount()) / exchangeRate;

        customData.setExchangedTransactionAmount(expectedCredit);

        if (customData.getPayToCurrency().equalsIgnoreCase("JOD"))
            Assert.assertEquals(String.format("%.3f", expectedCredit), String.format("%.3f", payToAccountCredit));
        else Assert.assertEquals(String.format("%.2f", expectedCredit), String.format("%.2f", payToAccountCredit));
    }

    @Then("I should see the {string} for flag with {string} amount in the transaction history with today's date in accounts {string}")
    public void iShouldSeeTheForFlagWithAmountInTheTransactionHistoryWithTodaySDateInAccounts(String transactionEntry, String operation, String tab) throws InterruptedException {
        String amount = null;
        AccountsPage accountsPage = new AccountsPage();

        List<String> expectedEntries = new ArrayList<>();

        List<String> actualEntries = accountsPage.clickTransactions().getLatestTransactionsEntries();
        logInfo("actualEntries" + actualEntries);

        Thread.sleep(1500);
        accountsPage.moveToAccountsTab();

        String transactionDate = LocalDate.now().getMonth().toString() + " " + LocalDate.now().getDayOfMonth() + ", " + LocalDate.now().getYear();

        expectedEntries.add(transactionEntry.toUpperCase(Locale.ROOT));

        if (operation.contains("debit")) {
            if (customData.getPayFromCurrency().equalsIgnoreCase("JOD")) {
                amount = String.format("%.3f", Double.parseDouble(customData.getTransactionAmount())) + " " + customData.getPayFromCurrency();
            } else
                amount = String.format("%.2f", Double.parseDouble(customData.getTransactionAmount())) + " " + customData.getPayFromCurrency();
        } else if (operation.contains("credit")) if (customData.getPayToCurrency().equalsIgnoreCase("JOD")) {
            amount = String.format("%.3f", customData.getExchangedTransactionAmount()) + " " + customData.getPayToCurrency();
        } else
            amount = String.format("%.2f", customData.getExchangedTransactionAmount()) + " " + customData.getPayToCurrency();

        if (operation.equalsIgnoreCase("debit")) {
            expectedEntries.add("-" + amount);
        } else expectedEntries.add(amount);

        if (tab.equalsIgnoreCase("accounts")) expectedEntries.add(transactionDate);

        logInfo("Expected Transaction entries --> ");
        expectedEntries.forEach(log()::info);

        logInfo("Actual Transaction entries --> ");
        actualEntries.forEach(log()::info);

        for (String expectedEntry : expectedEntries) {
            Assert.assertTrue(actualEntries.contains(expectedEntry), "Assertion on transaction entry");
        }

        logInfo("Transaction entry is created in " + tab + " transactions");

        new HomePage().scroll("down", 0.75);
    }

    @When("I click on the transfers menu")
    public void iClickOnTheTransfersMenu() {
        new OwnTransfersPage().clickTransfersImage();

    }

    @Then("I should see alert message {string} for Recipient Name")
    public void iShouldSeeAlertMessageFor(String message) {
        Assert.assertEquals((new OwnTransfersPage().fetchAlertMessage().replace("\n", "")), message, "Assertion on alert message");
    }

    @And("I select {string} from the existing beneficiary in Own Transfers")
    public void iSelectFromTheExistingBeneficiaryInOwnTransfers(String beneficiary) {
        if (beneficiary.equalsIgnoreCase("AUTOMATION OVERSEAS"))
            overseasBeneficiary = true;
        else if (beneficiary.equalsIgnoreCase("AUTOMATION Domestic")) {
            domesticBeneficiary = true;
        }
        new OverdraftTransferPage().clickAndEnterBeneficiary(beneficiary);
        new HomePage().scroll("up");
        new OverdraftTransferPage().selectBeneficiary(beneficiary);
    }

    @And("I enter the transfer amount with more than available balance in {string}")
    public void iEnterTheTransferAmountWithMoreThanAvailableBalanceIn(String page) {
        double enterAmount = customData.getPayFromAccountBalanceBeforeTransaction() + 2;

        new OwnTransfersPage().enterTransferAmount(String.format("%.0f", enterAmount), page);
    }

    @And("I enter the transfer amount {string} in {string} for Beneficiary")
    public void iEnterTheTransferAmountInForBeneficiary(String amount, String page) {
        if (amount.equalsIgnoreCase("random"))
            amount = utils.getRandomNumber(2);

        if (page.equalsIgnoreCase("Transfer to Overseas"))
            overseasBeneficiary = true;
        else if (page.equalsIgnoreCase("Transfer to Domestic"))
            domesticBeneficiary = true;

        customData.setTransactionAmount(amount);
        logInfo("Transaction amount is set as " + amount);
        new OwnTransfersPage().enterTransferAmount(amount, page);
    }

    @And("I set {string} currency")
    public void iSetCurrency(String currency) {
        customData.setPayToCurrency(currency);
    }

    @And("I click on new Beneficiary and enter IBAN number {string}")
    public void iClickOnNewBeneficiaryAndEnterIBANNumber(String ibanNumber) {
        new OwnTransfersPage().clickNewBeneficiary()
                .setIban(ibanNumber)
                .clickConfirm();

        customData.setIbanNumber(ibanNumber);
    }

    @Then("I verify the transfer from {string} for the amount {string}")
    public void iVerifyTheTransferFromForTheAmount(String country, String enteredAmount) {
        double payFromAccountDebit = Double.parseDouble(new TransferPayeePage().getAmountValue(customData.getPayFromCurrency()));
        logInfo("payFromAccountDebit" + payFromAccountDebit);

        double expectedCredit = 0;

        expectedCredit = Double.parseDouble(customData.getTransactionAmount());
        customData.setExchangedTransactionAmount(expectedCredit);

        Assert.assertEquals(String.format("%.2f", expectedCredit), String.format("%.2f", payFromAccountDebit));
    }

    @And("I swipe to see Back to Dashboard")
    public void iSwipeBackToSeeBackToDashboard() {
        new HomePage().scroll("up");
    }

    @When("I swipe to see end of the page")
    public void iSwipeToSeeEndOfThePage() {
        new HomePage().scroll("up");
    }

    @And("I set Flag {string} currency")
    public void iSetFlagCurrency(String currency) {
        setFlag = true;
        customData.setPayToCurrency(currency);
    }

    @And("I select the currency type as {string} for new beneficiary within CBJ")
    public void iSelectTheCurrencyTypeAsForNewBeneficiaryWithinCBJ(String currency) {
        new OwnTransfersPage().selectFlagCurrency();
        new TransferPayeePage().enterCurrency(currency)
                .selectCurrency()
                .clickOnNext();
    }

    @Then("I should see the field level error message {string} for Recipient Address")
    public void iShouldSeeTheFieldLevelErrorMessageForRecipientAddress(String message) {
        Assert.assertEquals((new OwnTransfersPage().fetchAlertMessageRecipientAddress().replace("\n", "")),
                message, "Assertion on alert message");
    }
}