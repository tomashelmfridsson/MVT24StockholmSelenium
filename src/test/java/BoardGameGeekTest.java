import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class BoardGameGeekTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.get("http://www.boardgamegeek.com/");
        driver.findElement(By.cssSelector(".fc-button-label")).click();
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

    @Test
    @DisplayName("Search for Things In Rings")
    public void searchTest() throws InterruptedException{
        driver.findElement(By.cssSelector("input[name='searchTerm'")).sendKeys("Thing in Rings", Keys.ENTER);
        driver.findElement(By.linkText("Things in Rings")).click();
        driver.findElement(By.cssSelector(".game-header-image img")).click();
        // System.out.println(driver.getTitle());
        // Thread.sleep(1000);
        assertTrue(driver.findElement(By.cssSelector("[href=\"/image/8085670/things-in-rings\"]")).isDisplayed());
        assertEquals("Things in Rings | Image | BoardGameGeek",driver.getTitle());
    }
}
