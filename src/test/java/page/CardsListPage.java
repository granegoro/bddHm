package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import lombok.val;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CardsListPage {

    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    public CardsListPage() {
    }

    public int getFirstCardBalance() {
        val text=$("[data-test-id=92df3f1c-a033-48e6-8390-206f6b1f56c0]").text();

        return extractBalance(text);
    }


    protected int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }


    /*private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");*/
    private SelenideElement depositButton = $("[data-test-id=action-deposit]");

    public MoneyTransferPage deposit() {

        depositButton.click();
        return new MoneyTransferPage();
    }
}
