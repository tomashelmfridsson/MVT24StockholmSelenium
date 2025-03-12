import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class EBayTest {
    @Test
    public void vanGoghSearch(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        Select selectCategories = new Select(driver.findElement(By.cssSelector("select[id='gh-cat']")));
        //selectCategories.selectByVisibleText("Art");
        selectCategories.selectByIndex(2);
        driver.findElement(By.cssSelector("#gh-ac")).sendKeys("van Gogh", Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".srp-results")));

        System.out.println(driver.findElements(By.cssSelector(".srp-results li")).size());
        assertTrue(driver.findElements(By.cssSelector(".srp-results li")).size() >0);
        driver.quit();
    }
}
