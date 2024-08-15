package pages;

import DataGenerator.DataGenerator;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private DataGenerator dataGenerator;

    public CartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.dataGenerator = new DataGenerator();
    }
    public CartPage placeOrderInCart(){
        driver.get("https://www.demoblaze.com/cart.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-success"))).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return this;
    }

    public String placeOrder(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tbodyid > div.row > div > a"))).click();

        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertMessage;
    }
    public CartPage placeOrderToCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tbodyid > div.row > div > a"))).click();

        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return this;
    }
    public String productDetail(){
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#more-information > strong"))).getText();
        return text;
    }
    public CartPage placeOrderInfo(){
        Faker faker = new Faker();

        driver.get("https://www.demoblaze.com/cart.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#page-wrapper > div > div.col-lg-1 > button"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModal")));

        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#name")));
        WebElement countryInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#country")));
        WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#city")));
        WebElement cardInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#card")));
        WebElement monthInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#month")));
        WebElement yearInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#year")));

        nameInput.sendKeys(faker.name().fullName());
        countryInput.sendKeys(faker.country().name());
        cityInput.sendKeys(faker.country().capital());
        cardInput.sendKeys(faker.business().creditCardNumber());

        String month = dataGenerator.getRandomMonth();
        String year = dataGenerator.getRandomYear();

        monthInput.sendKeys(month);
        yearInput.sendKeys(year);
        return this;

    }
    public String completePurchase(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#orderModal > div > div > div.modal-footer > button.btn.btn-primary"))).click();
        String confirmationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.sweet-alert.showSweetAlert.visible > h2"))).getText();
        return confirmationMsg;
    }
    public CartPage deleteProduct(){
        driver.get("https://www.demoblaze.com/cart.html#");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tbodyid > tr > td:nth-child(4) > a"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@id = 'totalp' and not(text())]")));
        return this;

    }
}
