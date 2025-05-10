package pages;

import org.openqa.selenium.*;
import java.util.*;

public class ProductDetailsPage {
    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    By productTitle = By.cssSelector("h1.ProductTitle_title__3swln");
    By reviews = By.cssSelector(".ReviewCard_reviewCard__3XcY4");
    By specifications = By.cssSelector(".ProductTechnicalInformation_infoContainer__");
    By addToCartBtn = By.cssSelector("button[data-testid='add-to-cart-button']");

    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public List<WebElement> getReviews() {
        return driver.findElements(reviews);
    }

    public String getSpecifications() {
        return driver.findElement(specifications).getText();
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }
}
