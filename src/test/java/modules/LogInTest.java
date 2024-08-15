package modules;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LogInPage;
import pages.SignUpPage;

import java.time.Duration;

@DisplayName("Validate Log In functionality")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LogInTest {
    private WebDriver driver;
    Faker faker = new Faker();
    private WebDriverWait wait;
    private String userName;
    private String password;


    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();

        userName = "user_" + faker.lorem().characters(8);
        password = faker.internet().password();

         new SignUpPage(driver)
                .informationSigUp(userName, password)
                .submitSignUp();

    }
    @Test
    @Order(1)
    @DisplayName("CT-001 => Log In successfully")
    public void testLogInWithSucess(){

            String text = new LogInPage(driver)
                    .loginInformation(userName, password)
                    .submitLogIn();
            Assertions.assertEquals("Welcome " + userName, text);

    }
    @Test
    @Order(2)
    @DisplayName("CT-002 => Login with invalidate user name - Validate error msg ")
    public void testLogInInvalidateData(){
        String text = new LogInPage(driver)
                .loginInformation("invalid123", password)
                .submitLogInWithError();
        Assertions.assertEquals("User does not exist." , text);

    }
    @Test
    @Order(3)
    @DisplayName("CT-003 => Login with invalidate password - Validate error msg")
    public void testLogInInvalidatePass(){
        String text = new LogInPage(driver)
                .loginInformation(userName, "12345")
                .submitLogInWithError();
        Assertions.assertEquals("Wrong password." , text);

    }
    @Test
    @Order(4)
    @DisplayName("CT-004 => Login with empty fields - Validate error msg")
    public void testLogInIEmptyField(){
        String text = new LogInPage(driver)
                .loginInformation("", "")
                .submitLogInWithError();
        Assertions.assertEquals("Please fill out Username and Password." , text);

    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
