package pages;

import org.openqa.selenium.*;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By loginButton = By.cssSelector("button[data-testid='header-login-button']");
    By email = By.id("login-form-email");
    By password = By.id("login-form-password");
    By submitLogin = By.cssSelector("button[type='submit']");

    public void login(String userEmail, String userPass) {
        driver.findElement(loginButton).click();
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(password).sendKeys(userPass);
        driver.findElement(submitLogin).click();
    }

    public boolean isLoginErrorDisplayed() {
        return driver.getPageSource().contains("incorrect"); // example check
    }
}
