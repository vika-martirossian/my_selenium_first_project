import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class InvalidLoginTest {
    private ChromeDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/vika/selenium-drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void invalidLogin() {
        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("testtest");
        driver.findElement(By.id("password")).sendKeys("TestTest");
        driver.findElement(By.cssSelector("#login button")).click();

        assertTrue("Login was not succeed",
                driver.findElement(By.id("flash")).isDisplayed());
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
