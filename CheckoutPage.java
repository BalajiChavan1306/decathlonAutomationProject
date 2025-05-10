package pages;

import org.openqa.selenium.*;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By paymentOption = By.cssSelector("input[name='payment']");
    By placeOrder = By.cssSelector("button[data-testid='place-order']");
    By confirmationText = By.cssSelector(".OrderConfirmation_message__");

    public void completeCheckout() {
        driver.findElement(paymentOption).click();
        driver.findElement(placeOrder).click();
    }

    public boolean isConfirmationDisplayed() {
        return driver.findElement(confirmationText).isDisplayed();
    }
}