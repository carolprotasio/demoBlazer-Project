package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public SignUpPage informationSigUp(String user, String password){
        driver.findElement(By.cssSelector("#signin2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sign-username"))).sendKeys(user);
        driver.findElement(By.cssSelector("#sign-password")).sendKeys(password);
        return this;
    }
    public String submitSignUp(){
        driver.findElement(By.cssSelector("#signInModal > div > div > div.modal-footer > button.btn.btn-primary")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertMessage;

    }

}
