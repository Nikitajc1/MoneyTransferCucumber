package loginData;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;

public class PersonalAccount {
    private final SelenideElement mainPage = $(by("data-test-id", "dashboard"));
    private final SelenideElement yourCards = $x("//h1");
    private final ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    private final ElementsCollection topUpButtons = $$("[data-test-id=action-deposit]");

    public void mainPageCheck() {
        mainPage.should(Condition.appear).shouldHave(Condition.exactText("Личный кабинет"));
        yourCards.should(Condition.appear).shouldHave(Condition.exactText("Ваши карты"));
    }

    public int getCardBalance(String cardNumber) {
        var card1 = cards.first().text();
        var card2 = cards.last().text();
        if (cardNumber.equals("5559 0000 0000 0002")) {
            return extractBalance(card2);
        } else {
            return extractBalance(card1);
        }
    }

    public int firstCardBalance() {
        var card1 = cards.first().text();
        return extractBalance(card1);
    }

    public int secondCardBalance() {
        var card2 = cards.last().text();
        return extractBalance(card2);
    }

    private int extractBalance(String text) {
        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public void firstButtonCheckAndClick() {
        topUpButtons.get(0).shouldHave(Condition.exactText("Пополнить")).click();
    }

    public void secondButtonCheckAndClick() {
        topUpButtons.get(1).shouldHave(Condition.exactText("Пополнить")).click();
    }

}
