import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTest {
    private ChromeDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/vika/selenium-drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void login() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("#login button")).click();
//        driver.findElement(By.cssSelector("button[type='submit']"));

        Thread.sleep(1000);
        assertTrue("Successfully logged in!",
                driver.findElement(By.cssSelector(".flash.success")).isDisplayed());
                driver.getCurrentUrl().compareTo("http://the-internet.herokuapp.com/secure");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
