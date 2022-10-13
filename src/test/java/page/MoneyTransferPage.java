package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {

    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement fromField = $("[data-test-id=from] input");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");

    public CardsListPage validTransfer(DataHelper.TransferInfo info) {
        amountField.setValue(info.getAmount());
        fromField.setValue(info.getFrom());
        transferButton.click();
        return new CardsListPage();
    }


    }

