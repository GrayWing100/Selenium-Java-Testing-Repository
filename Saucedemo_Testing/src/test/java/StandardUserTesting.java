
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardUserTesting {

    private WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        // Set up WebDriverManager to manage the Firefox driver
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver/geckodriver");
        WebDriver driver = new FirefoxDriver();
    }

    @BeforeEach
    public void setupTest() {
        // Create a new instance of FirefoxDriver before each test
        driver = new FirefoxDriver();
        driver.manage().window().fullscreen();

        driver.get("https://www.saucedemo.com");
        // Perform login
        // Locate the username and password fields
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        // Enter credentials
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        // Locate and click the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify successful login by checking the URL
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        assertEquals(expectedUrl, actualUrl, "Login failed or unexpected page loaded.");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Browser closed.");
    }

    @Test
    public void testAddItemToCart() {
        // Test code for adding an item to the cart
        WebElement addItemButton = driver.findElement(By.className("btn_inventory"));
        addItemButton.click();

        // Validate the item was added, such as by checking the cart count
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        assertEquals("1", cartBadge.getText(), "Item not added to cart.");
    }

    @Test
    public void testRemoveItemFromCart() {
        // Test code for removing an item from the cart
        WebElement addItemButton = driver.findElement(By.className("btn_inventory"));
        addItemButton.click();
        WebElement removeItemButton = driver.findElement(By.className("btn_secondary"));
        removeItemButton.click();

        // Validate the item was removed, e.g., by checking if the cart badge disappears
        boolean cartBadgeExists = driver.findElements(By.className("shopping_cart_badge")).isEmpty();
        assertEquals(true, cartBadgeExists, "Item not removed from cart.");
    }
}
