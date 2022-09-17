import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class UITest {

    static Page page;
    static Card card;

    @BeforeEach
    public void openPage() {
        open("http://localhost:8080/");
        page = new Page();
    }

    @Test
    @DisplayName("Оплата по карте: дебетовая валидная")
    public void testDebitPayValidCard() {
        card = new Card(
                "4444 4444 4444 4441",
                "09",
                "22",
                "Kristina Galchevskaya",
                "456");
        page.pay(card);
    }
}