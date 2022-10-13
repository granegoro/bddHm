package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class CardsListPage {

    /*private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");*/
    private SelenideElement depositButton = $("[data-test-id=action-deposit]");

    public MoneyTransferPage deposit() {

        depositButton.click();
        return new MoneyTransferPage();
    }
}
