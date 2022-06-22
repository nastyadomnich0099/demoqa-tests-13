package tests;

import java.io.File;
import java.util.List;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.impl.WebElementSelector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

import org.openqa.selenium.support.ui.Select;

public class SecondHomeTask extends TestBase{


    @Test
    @DisplayName("Successful fill form")
    void successfulTest (){

        String name = "Nastya";
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver();
       driver.get("https://demoqa.com/automation-practice-form");



       step("Open Practice from page ",() -> {
           open("/automation-practice-form");
           executeJavaScript("$('footer').remove()");
           executeJavaScript("$('#fixedban').remove()");
       });


        step("Fill in form ",() -> {
            $("[id=firstName]").setValue(name);
                    $("[id=lastName]").setValue("Domnich");
                    $("[id=userEmail]").setValue("domnicg@egorov.com");


                    $("#genterWrapper").$(byText("Female")).click();

                    $("[id=userNumber]").setValue("1234567891");
                    $("[id=currentAddress]").setValue("Minsk address");


                    $("#dateOfBirthInput").click();
                    $(".react-datepicker__month-select").selectOption("August");
                    $(".react-datepicker__year-select").selectOption("1998");
                    $("[aria-label = 'Choose Monday, August 10th, 1998']").click();

                    $("#subjectsInput").sendKeys("Maths");
                    $("#subjectsInput").pressEnter();

                    $("#hobbiesWrapper").$(byText("Reading")).click();

                    $("#uploadPicture").uploadFile(new File("src/test/resources/screenshot.png"));

                    $("[id=currentAddress]").setValue("Minsk address");

                    $("[id=react-select-3-input]").setValue("Uttar Pradesh").pressEnter();
                    $("[id=react-select-4-input]").setValue("Merrut").pressEnter();

                    $("[id=submit]").click();
                });


        step("Check form results",()-> {
            $(".table-responsive").shouldHave(
                    text(name),
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
        });
    }

    }