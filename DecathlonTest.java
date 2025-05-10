import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class DecathlonTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login.decathlon.net/?client_id=bce9a8f8-7197-4ea8-859e-3ace085db2e7#/sign-in");
        Thread.sleep(3000);
    }

    @Test
    public void testHomePageElements() {
        HomePage home = new HomePage(driver);
        assert home.getNavigationMenus().size() > 0;
        home.interactWithBanner();
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        LoginPage login = new LoginPage(driver);
        login.login("invalid@user.com", "wrongpass");
        assert login.isLoginErrorDisplayed();
    }

    @Test
    public void testSearchAndFilterProduct() {
        HomePage home = new HomePage(driver);
        home.searchProduct("backpack");

        ProductListingPage listing = new ProductListingPage(driver);
        listing.applyBrandFilter("quechua");
        listing.sortBy("Price: Low to High");
    }

    @Test
    public void testProductDetailsAndAddToCart() {
        HomePage home = new HomePage(driver);
        home.searchProduct("tent");

        ProductListingPage listing = new ProductListingPage(driver);
        listing.getDisplayedProducts().get(0).click();

        ProductDetailsPage details = new ProductDetailsPage(driver);
        assert details.getProductTitle().toLowerCase().contains("tent");
        details.addToCart();
    }

    @Test
    public void testCartFunctionality() {
        CartPage cart = new CartPage(driver);
        cart.updateQuantity(2);
        cart.applyPromoCode("WELCOME10");
        System.out.println("Total Price: " + cart.getTotalPrice());
    }

    @Test
    public void testCheckoutFlow() {
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.completeCheckout();
        assert checkout.isConfirmationDisplayed();
    }

    @Test
    public void testContactUsForm() {
        ContactUsPage contact = new ContactUsPage(driver);
        contact.submitForm("Test User", "test@mail.com", "Test message");
        assert contact.isSuccessDisplayed();
    }

    @Test
    public void testFooterLinks() {
        FooterPage footer = new FooterPage(driver);
        footer.clickFooterLink("Privacy Policy");
        assert footer.isRedirected("privacy-policy");
    }

    @AfterMethod
	
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
