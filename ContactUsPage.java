package pages;

import org.openqa.selenium.*;

public class ContactUsPage {
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    By name = By.id("name");
    By email = By.id("email");
    By message = By.id("message");
    By submitBtn = By.id("submit");
    By successMsg = By.cssSelector(".contact-success");

    public void submitForm(String user, String mail, String msg) {
        driver.findElement(name).sendKeys(user);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(message).sendKeys(msg);
        driver.findElement(submitBtn).click();
    }

    public boolean isSuccessDisplayed() {
        return driver.findElement(successMsg).isDisplayed();
    }
}
