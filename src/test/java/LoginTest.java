import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.LoginPage;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTest {
    private ChromeDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/vika/selenium-drivers/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }


    @Test
    public void login() throws InterruptedException {

        loginPage.loginWith("tomsmith", "SuperSecretPassword!");
        Thread.sleep(3000);
        assertTrue("Login was not succeed!", loginPage.isSuccessDisplayed());
        assertTrue("Login was not succeed",
                loginPage.getUrl().contains("/secure"));
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
