package com.qa.steps.capitalMobile;

import com.qa.engine.ProjectBase;
import com.qa.pages.capitalbank.dashBoard.DashboardPage;
import com.qa.pages.capitalbank.notification.InboxPage;
import com.qa.pages.capitalbank.notification.MessageCentrePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class notificationSteps extends ProjectBase {
    @And("I click on messageCentre button")
    public void iClickOnMessageCentreButton() {
        new DashboardPage().clickOnMessageButton();
    }

    @And("I click on inbox tab")
    public void iClickOnInboxTab() {
        new MessageCentrePage().clickInboxMenu();
    }

    @And("I click on add Button")
    public void iClickOnAddButton() {
        new InboxPage().clickAddButton();
    }

    @And("I select the new message details")
    public void iSelectTheNewMessageDetails(Map<String, String> beneficiary) {
        new InboxPage().selectNeed(beneficiary.get("I need to")).selectAbout(beneficiary.get("About"));
    }

    @And("I click on start chat button")
    public void iClickOnStartChatButton() {
        new InboxPage().clickStartChatButton();
    }

    @And("I enter the message as {string}")
    public void iEnterTheMessageAs(String message) {
        new InboxPage().enterMessage(message)
                .clickSendButton();
        customData.setMessage(message);
    }

    @Then("I should see the entered message in the screen with time")
    public void iShouldSeeTheEnteredMessageInTheScreenWithTime() {
        SoftAssert softAssert = new SoftAssert();
        ZoneId jordanZone = ZoneId.of("Asia/Amman");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        String formattedTime = LocalTime.now(jordanZone).format(formatter);
        softAssert.assertTrue(new InboxPage().fetchMessage().replaceAll("\n", " ").contains(formattedTime.toUpperCase()), "Assertion on time appeared on screen");
        softAssert.assertTrue(new InboxPage().fetchMessage().contains(customData.getMessage()), "Assertion on message appeared on screen");
        softAssert.assertAll();
    }

    @And("I click on back button from inbox page")
    public void iClickOnBackButtonFromInboxPage() {
        new InboxPage().clickBackButton();
    }

    @Then("I should see the latest conversation details in message centre")
    public void iShouldSeeTheLatestConversationDetailsInMessageCentre() {
        SoftAssert softAssert = new SoftAssert();
        ZoneId jordanZone = ZoneId.of("Asia/Amman");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        String formattedTime = LocalTime.now(jordanZone).format(formatter);
        softAssert.assertTrue(new InboxPage().fetchConversationDetails().replaceAll("\n", " ").contains(formattedTime.toUpperCase()), "Assertion on time appeared on screen");
        softAssert.assertTrue(new InboxPage().fetchConversationDetails().contains(LocalDate.now().getDayOfMonth() + " " + LocalDate.now().getMonth().toString() + " " + LocalDate.now().getYear()), "");
        softAssert.assertAll();
    }

    @And("I click on notification tab")
    public void iClickOnNotificationTab() {
        new MessageCentrePage().clickOnNotificationMenu();
    }


    @When("I click on the menu button")
    public void iClickOnTheMenuButton() {
        new MessageCentrePage().clickMenuIcon();
    }

    @And("I click on selectAll option in the page")
    public void iClickOnSelectAllOptionInThePage() {
        new MessageCentrePage().clickSelectAllLink();
    }

    @And("I select the action as {string}")
    public void iSelectTheActionAs(String action) {
        new MessageCentrePage().clickActionsLink()
                .selectAction(action);
    }

    @Then("I click the read or unread symbol in the notification {string}")
    public void iClickTheSymbolInTheNotification(String name) throws InterruptedException {
        new MessageCentrePage().scrollInNotification(name);
        if (new MessageCentrePage().fetchAction(name).contains("Read")) {
            new MessageCentrePage().clickOnActionSymbol(name);

        } else if (new MessageCentrePage().fetchAction(name).contains("Unread"))
            new MessageCentrePage().clickOnActionSymbol(name);
    }

    @And("I select the notification {string}")
    public void iSelectTheNotification(String name) {
        new MessageCentrePage().swipeBackFromDelete()
                .clickNotification(name);
        customData.setDescription(name);
    }

    @Then("I should see the notification details in the screen")
    public void iShouldSeeTheNotificationDetailsInTheScreen() {
        logInfo(new MessageCentrePage().fetchNotificationDate());
        Assert.assertTrue(new MessageCentrePage().fetchNotificationDetails().contains(customData.getDescription())
                , "Assertion on Notification details");
    }

    @Then("I should see the updated status for notification {string}")
    public void iShouldSeeTheUpdatedStatusForNotification(String name) {
        new MessageCentrePage().scrollInNotification(name);
        if (new MessageCentrePage().fetchAction(name).contains("Read")) {
            Assert.assertTrue(new MessageCentrePage().fetchAction(name).contains("Read"), "Assertion on updated status");

        } else if (new MessageCentrePage().fetchAction(name).contains("Unread"))
            Assert.assertTrue(new MessageCentrePage().fetchAction(name).contains("Unread"), "Assertion on updated status");
    }

    @Then("I click on back button from notificationPage")
    public void iClickOnBackButtonFromNotificationPage() {
        new MessageCentrePage().clickBackButton();
    }

    @And("I swipe to delete the notification of {string}")
    public void iSwipeToDeleteTheNotificationOf(String name) {
        new MessageCentrePage().scrollToDelete(name);
        Assert.assertTrue(new MessageCentrePage().fetchAction(name).contains("Delete"), "Assertion on Delete Notification");
    }

    @Then("I should see the message in the inbox")
    public void iShouldSeeTheMessageInTheInbox() {
        if (new InboxPage().fetchInboxMessage().contains("message"))
            Assert.assertTrue(new InboxPage().fetchInboxMessage().replaceAll("\n", " ").contains("You have no new messages"),
                    "Assertion on Inbox message");
        else if (new InboxPage().fetchInboxMessage().contains("About"))
            Assert.assertTrue(new InboxPage().fetchInboxMessage().toUpperCase().contains(new InboxPage().fetchConversationDetails()),
                    "Assertion on Inbox conversation");
    }

    @When("I click on view conversation")
    public void iClickOnViewConversation() {
        new InboxPage().clickViewConversation();
    }

    @Then("I should verify the date of conversation on the screen")
    public void iShouldVerifyTheDateOfConversationOnTheScreen() {
        Assert.assertTrue(new InboxPage().fetchMessageDetails().replaceAll("\n", " ")
                        .contains(LocalDate.now().getMonth().toString() + " "
                                + LocalDate.now().getDayOfMonth() + ", " + LocalDate.now().getYear()),
                "Assertion on conversation date");
    }

    @And("I should see the {string} action in the list")
    public void iShouldSeeTheActionInTheList(String action) {
        MessageCentrePage page = new MessageCentrePage();
        page.clickActionsLink();
        Assert.assertEquals(page.fetchAction(action), "Delete Message(s)",
                "Assertion on Delete message");
    }
}