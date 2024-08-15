package modules;

import enums.Category;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.IndexPage;
import java.time.Duration;
import java.util.List;

@DisplayName("Validate Product functionality")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductTest {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeEach
    public void beforeEach() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
    }
    @Test
    @Order(1)
    @DisplayName("CT-001 => Select & Add ONE Product to the cart successfully")
    public void testAddOneProductToCart(){
        String msg = new IndexPage(driver)
                .selectOneProduct()
                .placeOrder();
        Assertions.assertEquals("Product added", msg);
    }
    @Test
    @Order(2)
    @DisplayName("CT-002 => Select & Add FOUR Products to the cart successfully")
    public void testAddFourProductToCart(){
        List<String> messages = new IndexPage(driver)
                .selectFourProductToCart();

        for (String msg : messages) {
            Assertions.assertEquals("Product added", msg);
        }
    }
    @Test
    @Order(3)
    @DisplayName("CT-003 => From Phones Category Add ONE Product to the cart successfully")
    public void testFromCategoryPhoneAddOneProductToCart(){
        IndexPage indexPage = new IndexPage(driver);

        String confirmationMessage = indexPage.selectProductFromCategory("Phones", 3);
        Assertions.assertEquals("Product added", confirmationMessage);

    }
    @Test
    @Order(4)
    @DisplayName("CT-004 => From Laptops Category Add ONE Product to the cart successfully")
    public void testFromCategoryPLaptopsAddOneProductToCart(){
        IndexPage indexPage = new IndexPage(driver);

        String confirmationMessage = indexPage.selectProductFromCategory("Laptops", 1);
        Assertions.assertEquals("Product added", confirmationMessage);

    }
    @Test
    @Order(5)
    @DisplayName("CT-005 => From Monitors Category Add ONE Product to the cart successfully")
    public void testFromCategoryMonitorsAddOneProductToCart(){
        IndexPage indexPage = new IndexPage(driver);

        String confirmationMessage = indexPage.selectProductFromCategory("Monitors", 6);
        Assertions.assertEquals("Product added", confirmationMessage);

    }
    @Test
    @Order(6)
    @DisplayName("CT-006 => Should get One product from each category to the cart successfully")
    public void testOneProductFromEachCategoryToCart(){
        IndexPage indexPage = new IndexPage(driver);

        String confirmationMonitor = indexPage.selectProductFromCategory("Monitors",2);
        Assertions.assertEquals("Product added", confirmationMonitor);

        indexPage.goHome();
        String confirmationPhone = indexPage.selectProductFromCategory("Phones",1);
        Assertions.assertEquals("Product added", confirmationPhone);

        indexPage.goHome();
        String confirmationLaptop = indexPage.selectProductFromCategory("Laptops",1);
        Assertions.assertEquals("Product added", confirmationLaptop);

    }
    @Test
    @Order(7)
    @DisplayName("CT-007 => Navigate to Product Description successfully")
    public void testProdutoDetails(){
        String msg = new IndexPage(driver)
                .selectOneProduct()
                .productDetail();
        Assertions.assertEquals("Product description", msg);
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
    

}
