package tests.properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class OwnerTests {
    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);


    @Test
    @Tag("owner")

    void someTest1() {
        String login = config.login();
        String password = config.password();

        System.out.println("Login: " + login);
        System.out.println("Password: " + password);

        String message = format("I logged in as %s with password %s", login, password);
        System.out.println("Message: " + message);


    }

    @Test
    @Tag("test1")
    void propTest() {
        String browser = System.getProperty("browser", "safari");
        String version = System.getProperty("version", "100");
        String browserSize = System.getProperty("browserSize", "1920x1080");


        String login = config.login1();
        String password = config.password1();

        System.out.println("Login: " + login);
        System.out.println("Password: " + password);

        String message = format("https://@selenoid.autotests.cloud/wd/hub", login, password);
        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);

    }

}
