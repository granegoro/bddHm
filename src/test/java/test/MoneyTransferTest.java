package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import data.DataHelper;
import page.DashboardPage;
import page.LoginPageV2;
import page.TransferPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {
    @Test
    void shouldTransferfromFirstToSecond() {

        var loginPage = open("http://localhost:9999", LoginPageV2.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode();
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var firstCardInfo = getFirstCardInfo();
        var secondCardInfo = getSecondCardInfo();
        var firstCardBalance = dashboardPage.getCardBalance(firstCardInfo);
        var secondCardBalance = dashboardPage.getCardBalance(secondCardInfo);
        var amount = generateValidAmount(firstCardBalance);
        var expectedBalanceFirstCard = firstCardBalance - amount;
        var expectedBalanceSecondCard = secondCardBalance + amount;
        var transferPage = dashboardPage.selectCardToTransfer(secondCardInfo);
        dashboardPage = transferPage.makeValidTransfer(String.valueOf(amount), firstCardInfo);
        var actualBalanceFirstCard = dashboardPage.getCardBalance(firstCardInfo);
        var actualBalanceSecondCard = dashboardPage.getCardBalance(secondCardInfo);
        assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard);
    }

//    @Test
//    void shouldNotTransferFromFirstToSecondIfInvalidAmount() {
//
//        var loginPage = open("http://localhost:9999", LoginPageV2.class);
//        var authInfo = DataHelper.getAuthInfo();
//        var verificationPage = loginPage.validLogin(authInfo);
//        var verificationCode = DataHelper.getVerificationCode();
//        var dashboardPage = verificationPage.validVerify(verificationCode);
//        var firstCardInfo = getFirstCardInfo();
//        var secondCardInfo = getSecondCardInfo();
//        var firstCardBalance = dashboardPage.getCardBalance(firstCardInfo);
//        var secondCardBalance = dashboardPage.getCardBalance(secondCardInfo);
//        var amount = generateInvalidAmount(firstCardBalance);
//        var transferPage = dashboardPage.selectCardToTransfer(firstCardInfo);
//        dashboardPage = transferPage.makeValidTransfer(String.valueOf(amount), secondCardInfo);
//        transferPage.findErrorMessage("");
//        var actualBalanceFirstCard = dashboardPage.getCardBalance(firstCardInfo);
//        var actualBalanceSecondCard = dashboardPage.getCardBalance(secondCardInfo);
//        assertEquals(firstCardBalance, actualBalanceFirstCard);
//        assertEquals(secondCardBalance, actualBalanceSecondCard);
//    }
}