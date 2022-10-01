package test.ui;

import com.codeborne.selenide.Condition;
import data.Card;
import data.DataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.CreditPage;
import page.MainPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static page.MainPage.errorNotification;
import static page.MainPage.successNotification;

public class UICreditPageTest {

    static CreditPage page;
    static Card card;

    @BeforeEach
    public void openPage() {
        open("http://localhost:8080/");
        page = new MainPage().getCreditPage();
    }

    @Test
    @DisplayName("Оплата по карте: кредитная со статусом APPROVED")
    public void testDebitPayApprovedCard() {
        card = DataGenerator.getValidApprovedCard();
        page.pay(card);
        successNotification.should(Condition.visible, Duration.ofSeconds(15));
        successNotification.$x("./div[@class='notification__content']").should(Condition.text("Операция одобрена Банком."));
    }

    @Test
    @DisplayName("Оплата по карте: кредитная со статусом DECLINED")
    public void testDebitPayDeclinedCard() {
        card = DataGenerator.getValidDeclinedCard();
        page.pay(card);
        errorNotification.should(Condition.visible, Duration.ofSeconds(15));
        errorNotification.$x("./div[@class='notification__content']").should(Condition.text("Ошибка! Банк отказал в проведении операции."));
    }
}