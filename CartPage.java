package pages;

import org.openqa.selenium.*;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By removeBtn = By.cssSelector("button[data-testid='remove-item']");
    By quantityInput = By.cssSelector("input[type='number']");
    By promoCodeInput = By.id("promo-code");
    By applyPromoBtn = By.id("apply-promo");
    By totalPrice = By.cssSelector(".CartSummary_totalPrice__");

    public void removeItem() {
        driver.findElement(removeBtn).click();
    }

    public void updateQuantity(int quantity) {
        WebElement qty = driver.findElement(quantityInput);
        qty.clear();
        qty.sendKeys(String.valueOf(quantity));
    }

    public void applyPromoCode(String code) {
        driver.findElement(promoCodeInput).sendKeys(code);
        driver.findElement(applyPromoBtn).click();
    }

    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }
}