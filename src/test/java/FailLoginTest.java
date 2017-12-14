import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.LoginPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class FailLoginTest {
    private ChromeDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/vika/selenium-drivers/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void invalidLogin() throws InterruptedException {
        loginPage.loginWith("test", "test");
        Thread.sleep(3000);
        assertTrue("Login was succeessful!", loginPage.isErrorDisplayed());
        assertTrue("Error message is not correct",
                loginPage.getErrorMessage().contains("Your username is invalid!"));
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
