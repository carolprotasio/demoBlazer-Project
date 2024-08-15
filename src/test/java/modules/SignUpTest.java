package modules;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SignUpPage;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Validate Sign Up functionality")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SignUpTest {
    private WebDriver driver;
    Faker faker = new Faker();
    private WebDriverWait wait;


    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();

    }
    @Test
    @Order(1)
    @DisplayName("CT-001 => Sign Up successfully")
    public void testSignUpWithSucess(){
        String user = faker.name().username();
        String password = faker.internet().password();

           String msg = new SignUpPage(driver)
                    .informationSigUp(user, password)
                    .submitSignUp();
           Assertions.assertEquals("Sign up successful.", msg);

    }
    @Test
    @Order(2)
    @DisplayName("CT-002 => Validate Sign Up with ALL fields empty - Validate Error Msg ")
    public void testEmptyFieldsSignUp(){

        String msg = new SignUpPage(driver)
                .informationSigUp("", "")
                .submitSignUp();
        Assertions.assertEquals("Please fill out Username and Password.", msg);

    }
    @Test
    @Order(3)
    @DisplayName("CT-003 => Validate Sign Up with User Name field empty - Validate Error Msg ")
    public void testUserNameEmptyField(){
        String password = faker.internet().password();
        String msg = new SignUpPage(driver)
                .informationSigUp("", password)
                .submitSignUp();
        Assertions.assertEquals("Please fill out Username and Password.", msg);

    }
    @Test
    @Order(4)
    @DisplayName("CT-004 => Validate Sign Up with Password field empty - Validate Error Msg ")
    public void testPasswordEmptyField(){
        String user = faker.name().username();
        String msg = new SignUpPage(driver)
                .informationSigUp(user, "")
                .submitSignUp();
        Assertions.assertEquals("Please fill out Username and Password.", msg);

    }
    @Test
    @Order(5)
    @DisplayName("CT-005 => Close Window Button")
    public void testCloseButton(){
        driver.findElement(By.cssSelector("#signin2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#signInModal")));
        driver.findElement(By.cssSelector("#signInModal > div > div > div.modal-footer > button.btn.btn-secondary")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#signInModal")));

        boolean isModalDisplayed = !driver.findElements(By.cssSelector("#signInModal")).isEmpty() &&
                driver.findElement(By.cssSelector("#signInModal")).isDisplayed();

        assertFalse(isModalDisplayed, "The sign-up modal should be closed.");

    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

}
