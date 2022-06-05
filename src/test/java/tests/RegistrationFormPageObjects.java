package tests;

import Pages.RegistrationFormPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationFormPageObjects extends TestBase {



    @Test
    void successfulTest (){
        String firstName = "Nastya";
        String lastName = "Domnich";


        registrationFormPage.OpenPage()
                            .setFullName(firstName, lastName)
                            .setEmail("domnicg@egorov.com")
                            .setGender()
                            .setMobileNumber()
                            .setDateOfBirth("10", "August", "1998" )
                            .setSubject()
                            .setHobbies()
                             .uploadFile()
                            .setAddress()
                            .setStateAndCity()
                            .clickSubmit()
                            .checkResults();


    }

    }