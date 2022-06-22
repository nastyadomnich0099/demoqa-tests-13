package tests;

import Pages.RegistrationFormPage;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationFormPageObjects extends TestBase {


    TestData testData = new TestData();


    @Test
    void successfulTest (){


        registrationFormPage.OpenPage()
                            .setFullName(testData.firstName, testData.lastName)
                            .setEmail(testData.email)
                            .setGender(testData.gender)
                            .setMobileNumber(testData.phone)
                            .setDateOfBirth(testData.day, testData.month, testData.year )
                            .setSubject(testData.subject)
                            .setHobbies(testData.hobby)
                             .uploadFile()
                            .setAddress(testData.address)
                            .setStateAndCity(testData.state, testData.city)
                            .clickSubmit()
                .checkResults("Student Name", testData.firstName + " " + testData.lastName)
                .checkResults("Date of Birth", testData.dateOfBirth)
                .checkResults("Student Email", testData.email)
                .checkResults("Address", testData.address);


    }

    }