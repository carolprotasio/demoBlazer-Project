package modules;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.IndexPage;

import java.time.Duration;
import java.util.List;


@DisplayName("Validate Cart functionality")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartTest {
    private WebDriver driver;
    Faker faker = new Faker();
    private WebDriverWait wait;
    private String name;


    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
    }
    @Test
    @Order(1)
    @DisplayName("CT-001 => Purchase One Product successfully")
    public void testPurchaseOneProduct(){
        String msg = new IndexPage(driver)
                .selectOneProduct()
                .placeOrderInfo()
                .completePurchase();
        Assertions.assertEquals("Thank you for your purchase!", msg);
    }
    @Test
    @Order(2)
    @DisplayName("CT-002 => Purchase FOUR Product successfully")
    public void testPurchaseFourProduct(){
        String msg = new IndexPage(driver)
                .addFourProductToCart()
                .placeOrderInfo()
                .completePurchase();
        Assertions.assertEquals("Thank you for your purchase!", msg);

    }
    @Test
    @Order(3)
    @DisplayName("CT-003 => Add One Products To Cart and Delete it")
    public void testDeleteProductInCart(){
        new IndexPage(driver)
                .selectOneProduct()
                .placeOrderToCart()
                .deleteProduct();

        List<WebElement> cartItems = driver.findElements(By.cssSelector("#tbodyid > tr"));
        Assertions.assertTrue(cartItems.isEmpty(), "Cart is not empty.");

    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
