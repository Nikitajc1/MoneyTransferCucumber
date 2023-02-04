package steps;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import loginData.*;

public class TemplateSteps {
    LoginPage loginPage = new LoginPage();
    PersonalAccount account = new PersonalAccount();
    VerificationCodePage code = new VerificationCodePage();
    ReplenishTheBalance replenish = new ReplenishTheBalance();


    @Пусть("открыта страница с формой авторизации {string}")
    public void openAuthPage(String url) {
        loginPage = Selenide.open(url, LoginPage.class);
    }

    @Когда("пользователь пытается авторизоваться с именем {string} и паролем {string}")
    public void loginWithNameAndPass(String name, String password) {
        loginPage.validLoginCucumber(name, password);
    }

    @И("пользователь вводит проверочный код из смс {string}")
    public void setCode(String verificationCode) {
        code.setVerificationCodeCucumber(verificationCode);
    }

    @Тогда("происходит успешная авторизация и пользователь попадает на страницу 'Личный кабинет'")
    public void verifyMainPage() {
        account.mainPageCheck();
    }

    @Когда("пользователь переводит {string} рублей с карты с номером {string} на свою 1 карту с главной страницы")
    public void moneyTransfer(String rubles, String card2) {
        account.firstButtonCheckAndClick();
        replenish.amountSet(rubles);
        replenish.fromSet(card2);
        replenish.confirmButtonClick();
    }

    @Тогда("баланс его 1 карты из списка на главной странице должен стать {string} рублей")
    public void compare(String number) {
        int balance = account.getFirstCardBalance();
        String stringBalance = Integer.toString(balance);
        stringBalance.equals(number);
    }

}