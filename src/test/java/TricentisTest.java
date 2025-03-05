import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TricentisTest {
    @Test
    public void testTricentis(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("img")));
        System.out.println(driver.findElement(By.className("search-box-button")).getDomAttribute("value"));
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[1]/a")).click();
        //System.out.println(driver.findElement(By.className("Books")));
        // driver.quit();
    }

}
