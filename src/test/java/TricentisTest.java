import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Double.parseDouble;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class TricentisTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void reset(){
        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterAll
    public static void teardown(){
        // driver.quit();
    }

    // @Test
    public void testTricentis() {
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
        driver.findElement(By.name("q")).sendKeys("Computing and Internet");
        driver.findElement(By.className("search-box-button")).click();
        Thread.sleep(2000);
        assertEquals("Computing and Internet", driver.findElement(By.className("product-title")).getText());
        driver.quit();
    }

    // Navigera till sidan: https://demowebshop.tricentis.com/register
    //Fyll i registreringsformuläret
    //Kontrollera att du hamnar på en bekräftelsesida eller får ett meddelande som säger att kontot skapades.
    //@Test
    public void registerTest() throws InterruptedException {
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

    @Test
    public void bookPrices(){
        driver.findElement(By.linkText("Books")).click();
        // List<WebElement> books = driver.findElements(By.className("product-item"));
        // List<WebElement> books = driver.findElements(By.cssSelector(".product-item"));
        List<WebElement> books = driver.findElements(By.cssSelector("[data-productid='79']"));

        System.out.println(books.size());
        for (WebElement book: books){
            System.out.println(book.getText());
            String[] textArray = book.getText().split("\n");
            System.out.println(Arrays.toString(textArray));
            double actualPrice = parseDouble(textArray[2]);
            System.out.println(actualPrice);
            assertTrue(0<actualPrice && actualPrice<500);
        }
    }

    @Test
    public void categories(){
        List<WebElement> categoriesElements = driver.findElements(By.cssSelector(".block-category-navigation a"));
        System.out.println(categoriesElements.size());
        for (WebElement element: categoriesElements){
            System.out.println (element.getText() +" "+ element.getDomAttribute("href"));
            if (element.getText().equals("Jewelry")){
                element.click();
                break;
            }
        }
    }
}
