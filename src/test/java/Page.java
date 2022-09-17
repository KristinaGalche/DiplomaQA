import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Data
@NoArgsConstructor
public class Page {
    static SelenideElement payButton = $x("//*[@id=\"root\"]/div/button[1]");
    static SelenideElement creditButton = $x("//*[@id=\"root\"]/div/button[2]");
    static SelenideElement formHead = $x("//*[@id=\"root\"]/div/h3");
    static SelenideElement form = $x("//*[@id=\"root\"]/div/form");
    static SelenideElement cardNumber = $x("//*[@id=\"root\"]/div/form/fieldset/div[1]/span/span/span[2]/input");
    static SelenideElement month = $x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[1]/span/span/span[2]/input");
    static SelenideElement year = $x("//*[@id=\"root\"]/div/form/fieldset/div[2]/span/span[2]/span/span/span[2]/input");
    static SelenideElement holder = $x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[1]/span/span/span[2]/input");
    static SelenideElement cvv = $x("//*[@id=\"root\"]/div/form/fieldset/div[3]/span/span[2]/span/span/span[2]/input");
    static SelenideElement continueButton = $x("//*[@id=\"root\"]/div/form/fieldset/div[4]/button/span/span");

    public void pay(Card card) {
        payButton.click();
        form.shouldBe(visible);
        cardNumber.setValue(card.getNumber());
        month.setValue(card.getMonth());
        year.setValue(card.getYear());
        holder.setValue(card.getHolder());
        cvv.setValue(card.getCvc());
        continueButton.click();
    }
}