package tests;

import Pages.RegistrationFormPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;



public class RegistrationFormPageObjects extends TestBase {

    TestData testData = new TestData();

    @Test
    @Tag("test1")
    void successfulTest(){


        registrationFormPage.openPage()
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