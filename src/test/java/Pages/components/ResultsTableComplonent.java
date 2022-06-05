package Pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class ResultsTableComplonent {
    public void checkResult(){
        $(".table-responsive").shouldHave(
                text("Nastya"),
                text("domnicg@egorov.com"),
                text("Female"),
                text("1234567891"),
                text("10 August,1998"),
                text("Maths"),
                text("Reading"),
                text("screenshot.png"),
                text("Minsk address"),
                text("Uttar Pradesh Merrut")
        );

    }

}
