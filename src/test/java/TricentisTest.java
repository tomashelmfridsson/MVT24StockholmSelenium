import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TricentisTest {
    // @Test
    public void testTricentis() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("img")));
        System.out.println(driver.findElement(By.className("search-box-button")).getDomAttribute("value"));
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[1]/a")).click();
        //System.out.println(driver.findElement(By.className("Books")));
        driver.quit();
    }

    /*
    Navigera till sidan: https://demowebshop.tricentis.com/
    Använd sökfunktionen för att söka efter en produkt.
    Kontrollera att sökresultaten innehåller produkten du
    sökte efter genom att hämta titlarna på resultaten och
    jämföra med söktermen.
     */
    //@Test
    public void searchComputingAndInternetBookTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.name("q")).sendKeys("Computing and Internet");
        driver.findElement(By.className("search-box-button")).click();
        Thread.sleep(2000);
        assertEquals("Computing and Internet", driver.findElement(By.className("product-title")).getText());
        driver.quit();
    }

    // Navigera till sidan: https://demowebshop.tricentis.com/register
    //Fyll i registreringsformuläret
    //Kontrollera att du hamnar på en bekräftelsesida eller får ett meddelande som säger att kontot skapades.
    @Test
    public void registerTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Ture");
        driver.findElement(By.id("LastName")).sendKeys("Testsson");
        driver.findElement(By.id("Email")).sendKeys("tomastestgubbe+"+System.currentTimeMillis()+"@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("abc123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("abc123");
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000);
        assertEquals("Your registration completed", driver.findElement(By.className("result")).getText());
        driver.quit();
    }

}
