package steps;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import loginData.*;
import org.junit.jupiter.api.Assertions;

public class TemplateSteps {

//    int rublesGlobal;
//    int check1;
//    int check2;

    public int number(int number) {
        if (number == 1) {
            return 1;
        } else if (number == 2) {
            return 2;
        }
        return -1;
    }

    @Пусть("открыта страница с формой авторизации {string}")
    public void openAuthPage(String url) {
        LoginPage loginPage = Selenide.open(url, LoginPage.class);
    }

    @Когда("пользователь пытается авторизоваться с именем {string} и паролем {string}")
    public void loginWithNameAndPass(String name, String password) {
        LoginPage loginPage = new LoginPage();

        loginPage.validLoginCucumber(name, password);
    }

    @И("пользователь вводит проверочный код из смс {string}")
    public void setCode(String verificationCode) {
        VerificationCodePage code = new VerificationCodePage();

        code.setVerificationCodeCucumber(verificationCode);
    }

    @Тогда("происходит успешная авторизация и пользователь попадает на страницу 'Личный кабинет'")
    public void verifyMainPage() {
        PersonalAccount account = new PersonalAccount();

        account.mainPageCheck();
    }

    @Когда("пользователь переводит {string} рублей с карты с номером {string} на свою {int} карту с главной страницы,")
    public void moneyTransfer(String rubles, String card, int cardNumber) {
        PersonalAccount account = new PersonalAccount();
        ReplenishTheBalance replenish = new ReplenishTheBalance();
//        check1 = account.firstCardBalance();
//        check2 = account.secondCardBalance();

        if (card.equals("5559 0000 0000 0001")) {
            account.secondButtonCheckAndClick();
        } else if (card.equals("5559 0000 0000 0002")) {
            account.firstButtonCheckAndClick();
        }

        replenish.amountSet(rubles);
//        rublesGlobal = Integer.parseInt(rubles);
        replenish.fromSet(card);
        replenish.confirmButtonClick();

        number(cardNumber);
    }

    @Тогда("баланс его карты {string} из списка на главной странице должен стать {int} рублей")
    public void compare(String numberCard, int amount) {
        PersonalAccount account = new PersonalAccount();

        int balance = account.getCardBalance(numberCard);
//        int result = 0;
//
//        if (numberCard.equals("5559 0000 0000 0001")) {
//            result = check1 + rublesGlobal;
//        } else if (numberCard.equals("5559 0000 0000 0002")) {
//            result = check2 + rublesGlobal;
//        }

        int actual = balance;
        int expected = amount;

        Assertions.assertEquals(expected, actual);
    }
}