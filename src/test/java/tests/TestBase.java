package tests;

import Pages.RegistrationFormPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @BeforeAll
    static void setUp() {
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;


        Configuration.baseUrl = config.baseurl();
        Configuration.browser = System.getProperty("browser");
        Configuration.browserVersion = System.getProperty("version");
        Configuration.browserSize = System.getProperty("browserSize");

        System.out.println(config.baseurl());
        //Configuration.baseUrl = "https://demoqa.com";
        String remoteDriverUrl = System.getProperty("remoteDriverUrl");
        Configuration.remote = "https://" + config.login() + ":" + config.password() + "@" + remoteDriverUrl;
        System.out.println(Configuration.remote = "https://" + config.login() + ":" + config.password() + "@" + remoteDriverUrl);
        System.out.println(config.login());
        System.out.println(config.password());
        System.out.println(Configuration.remote = "https://" + config.login() + ":" + config.password() + "@" + remoteDriverUrl);
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wb/hub";





        }


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }


}
