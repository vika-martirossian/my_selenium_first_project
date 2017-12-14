package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public WebDriver driver;
    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By submitLocator = By.cssSelector("#login button");
    private By successLocator = By.cssSelector(".flash.success");
    private By errorLocator = By.cssSelector(".flash.error");

    public LoginPage(WebDriver webDriver){
        this.driver = webDriver;
        driver.get("http://the-internet.herokuapp.com/login");
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public void loginWith(String username, String password){
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitLocator).click();
    }

    public boolean isSuccessDisplayed(){
        return driver.findElement(successLocator).isDisplayed();
    }

    public boolean isErrorDisplayed(){
        return driver.findElement(By.cssSelector(".flash.error")).isDisplayed();
    }

    public  String getErrorMessage(){
        return driver.findElement(errorLocator).getText();
    }
}
