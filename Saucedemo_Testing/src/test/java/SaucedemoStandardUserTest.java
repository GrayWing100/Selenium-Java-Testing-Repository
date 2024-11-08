
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SaucedemoStandardUserTest {

    public static void main(String[] args) {
        // Set the path to geckodriver if it's not already set in PATH
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver/geckodriver");

        // Create a new instance of FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        try {
            // Maximize the browser window
            driver.manage().window().fullscreen();

            // Open the Sauce Demo website
            driver.get("https://www.saucedemo.com");

            // Locate the username and password fields
            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));

            // Enter credentials (Use valid credentials for Sauce Demo)
            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");

            // Locate and click the login button
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            // Optional: Verify successful login by checking the URL or a specific element
            // For example, check if the inventory page is loaded
            String expectedUrl = "https://www.saucedemo.com/inventory.html";
            String actualUrl = driver.getCurrentUrl();

            if (actualUrl.equals(expectedUrl)) {
                System.out.println("Login successful. Navigated to Inventory page.");
            } else {
                System.out.println("Login failed or unexpected page loaded.");
            }

            // Additional interactions can be performed here

        } catch (Exception e) {
            // Handle any exceptions that occur during the test
            System.out.println("An error occurred during the test execution:");
            e.printStackTrace();
        } finally {
            // Close the browser after the test
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}

