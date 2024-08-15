package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LogInPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public LogInPage loginInformation(String userName, String password){
        driver.findElement(By.cssSelector("#login2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginusername"))).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginpassword"))).sendKeys(password);
        return this;

    }
    public String submitLogIn(){
        driver.findElement(By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-primary")).click();

        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nameofuser"))).getText();

        return text;
    }
    public String submitLogInWithError(){
        driver.findElement(By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-primary")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertMessage;
    }


}
