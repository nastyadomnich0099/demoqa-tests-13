package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.FIRST_NAME;
import static tests.TestData.LAST_NAME;

public class RegistrationFormWithTestDataTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest (){



        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver();
       driver.get("https://demoqa.com/automation-practice-form");

       open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=firstName]").setValue(FIRST_NAME);
        $("[id=lastName]").setValue(LAST_NAME);
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
        $("#uploadPicture").uploadFile (new File("src/test/resources/screenshot.png"));
        $("[id=currentAddress]").setValue("Minsk address");
        $("[id=react-select-3-input]").setValue("Uttar Pradesh").pressEnter();
        $("[id=react-select-4-input]").setValue("Merrut").pressEnter();
        $("[id=submit]").click();
        $(".table-responsive").shouldHave(
                text(FIRST_NAME),
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