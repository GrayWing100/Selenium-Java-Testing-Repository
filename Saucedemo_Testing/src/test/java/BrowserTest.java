
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {

    public static void main(String[] args) {

        // Set the path to geckodriver if it's not already set in PATH
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver/geckodriver");

        // Create a new instance of FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Open a website, for example, Google
        driver.get("https://www.google.com");

        driver.manage().window().fullscreen();

        driver.manage().window().minimize();

        System.out.println("The URL on my browser: " + driver.getCurrentUrl());

        // Get the current page source
        String pageSource = driver.getPageSource();

        if (pageSource.contains("Google")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        System.out.println("My browser current handle: " + driver.getWindowHandle());

        // Loop through all window handles
        for (String handle : driver.getWindowHandles()) {
            System.out.println("Browser window handle: " + handle);
        }

        // Close the browser
        driver.quit();
    }
}
