package Pages;

import Pages.components.CalendarComponent;
import Pages.components.ResultsTableComponent;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;




public class RegistrationFormPage {
   // WebDriver driver;


    public CalendarComponent calendarComponent = new CalendarComponent();

    public Pages.components.ResultsTableComponent resultsTableComponent = new Pages.components.ResultsTableComponent();
    SelenideElement firstNameInput= $("#firstName"),
                    lastNameInput =  $("#lastName");




    public RegistrationFormPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;

    }


    public RegistrationFormPage setFullName(String firstName, String lastName){
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        return this;
    }


    public RegistrationFormPage setEmail(String value){
        $("#userEmail").setValue("domnicg@egorov.com");
        return this;
    }

    public RegistrationFormPage setGender(String gender){
        $("#genterWrapper").$(byText("Female")).click();
        return this;
    }

    public RegistrationFormPage setMobileNumber(String value){
        $("[id=userNumber]").setValue("1234567891");
       return this;
    }

    public RegistrationFormPage setAddress(String value){
        $("[id=currentAddress]").setValue("Minsk address");
        return this;
    }



    public RegistrationFormPage setDateOfBirth(String day, String month, String year ){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
       return this;

    }

    public RegistrationFormPage setDateOfBirthWithKeys(String day, String month, String year ){
        $("#dateOfBirthInput").sendKeys(day + ""+ month + "" + year );
        return this;

    }




    public RegistrationFormPage setStateAndCity(String value, String value1){
        $("[id=react-select-3-input]").setValue("Uttar Pradesh").pressEnter();
        $("[id=react-select-4-input]").setValue("Merrut").pressEnter();

        return this;
    }

    public RegistrationFormPage setSubject(String value){
        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();
         return this;
        }

        public RegistrationFormPage setHobbies(String value){
           // WebDriverWait wait = new WebDriverWait(driver, 30);
            $("#hobbiesWrapper").$(byText("Reading")).click();
        return this;
        }


    public RegistrationFormPage uploadFile(){
        $("#uploadPicture").uploadFile (new File("src/test/resources/screenshot.png"));
        return this;
    }


    public RegistrationFormPage checkResults(String key, String value){
     resultsTableComponent.checkResults(key, value );
     return this;

    }



    public  RegistrationFormPage clickSubmit(){
        $("[id=submit]").click();
        return this;

    }









}
