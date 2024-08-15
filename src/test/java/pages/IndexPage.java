package pages;

import enums.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

import java.time.Duration;

public class IndexPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public IndexPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public CartPage selectOneProduct(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tbodyid > div:nth-child(1) > div > div > h4"))).click();
        return new CartPage(driver);
    }

    public void goHome() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#navbarExample > ul > li.nav-item.active > a"))).click();
    }
    private void addProductToCart(int productIndex, List<String> messages) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tbodyid > div:nth-child(" + productIndex + ") > div > div > h4 > a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[onclick^='addToCart']"))).click();

        wait.until(ExpectedConditions.alertIsPresent());
        messages.add(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        goHome();
    }

    public  List<String> selectFourProductToCart(){
        List<String> messages = new ArrayList<>();

        addProductToCart(1, messages);
        addProductToCart(2, messages);
        addProductToCart(5, messages);
        addProductToCart(9, messages);

        return messages;

    }
    public CartPage addFourProductToCart(){
        List<String> messages = new ArrayList<>();

        addProductToCart(1, messages);
        addProductToCart(2, messages);
        addProductToCart(5, messages);
        addProductToCart(9, messages);

        return new CartPage(driver);

    }

    public CartPage goToCartPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cartur"))).click();
        return new CartPage(driver);
    }

    public void selectCategory(Category category){
        WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(category.getCategoryName())));
        categoryElement.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-title")));
    }
    public String selectProductFromCategoryTest(int productIndex) {
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tbodyid > div:nth-child(" + productIndex + ") > div > div > h4 > a")));
        productElement.click();

        // Adiciona o produto ao carrinho
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[onclick^='addToCart']")));
        addToCartButton.click();

        // Aguarde o alerta de confirmação e capture a mensagem
        String alertText = wait.until(ExpectedConditions.alertIsPresent()).getText();
        driver.switchTo().alert().accept();

        return alertText;
    }


    public String selectProductFromCategory(String categoryName, int productIndex) {
        // Selecionar a categoria
        WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(categoryName)));
        categoryElement.click();

        // Selecionar o produto
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#tbodyid > div:nth-child(" + productIndex + ") > div > div > h4 > a")));
        productElement.click();

        // Adicionar ao carrinho
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[onclick^='addToCart']")));
        addToCartButton.click();

        // Capturar a mensagem do alerta
        String alertText = wait.until(ExpectedConditions.alertIsPresent()).getText();
        driver.switchTo().alert().accept();

        return alertText;
    }

}
