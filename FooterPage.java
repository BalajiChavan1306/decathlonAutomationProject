package pages;

import org.openqa.selenium.*;

public class FooterPage {
    WebDriver driver;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFooterLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public boolean isRedirected(String expectedUrl) {
        return driver.getCurrentUrl().contains(expectedUrl);
    }
}