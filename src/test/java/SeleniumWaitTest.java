import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class SeleniumWaitTest {
    @Test
    public void addRedSquare(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.cssSelector("#adder")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".redbox")));
        assertTrue(driver.findElement(By.cssSelector(".redbox")).isDisplayed());
        driver.close();
    }
    @Test
    public void textField(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.cssSelector("#reveal")).click();
        WebElement textField = driver.findElement(By.cssSelector("#revealed"));
        wait.until(ExpectedConditions.elementToBeClickable(textField)).sendKeys("Hello World");
        driver.close();
    }
}
