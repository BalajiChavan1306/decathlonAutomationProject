package pages;

import org.openqa.selenium.*;
import java.util.*;

public class ProductListingPage {
    WebDriver driver;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
    }

    By products = By.cssSelector(".ProductCard_card__1fjfq");
    By sortDropdown = By.cssSelector("select[name='sort']");
    By brandFilter = By.xpath("//input[@type='checkbox' and contains(@name, 'brand')]");

    public void sortBy(String sortOption) {
        driver.findElement(sortDropdown).sendKeys(sortOption);
    }

    public List<WebElement> getDisplayedProducts() {
        return driver.findElements(products);
    }

    public void applyBrandFilter(String brand) {
        List<WebElement> filters = driver.findElements(brandFilter);
        for (WebElement filter : filters) {
            if (filter.getAttribute("name").contains(brand)) {
                filter.click();
                break;
            }
        }
    }
}
