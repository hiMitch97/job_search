package jobs.scrape.scraper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scraper {
    public static void main(String[] args) {
        // Use WebDriverManager to manage the ChromeDriver binary
        WebDriverManager.chromedriver().setup();

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        // Initialize the ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);

        // Open the specified URL
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        System.out.println("Page title: " + driver.getTitle()); // Print the title of the page

        // Set implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // Find the text box element by its name attribute
        WebElement textBox = driver.findElement(By.name("my-text"));
        System.out.println("Text box found: " + (textBox != null)); // Confirm text box found

        // Find the submit button by its CSS selector
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        System.out.println("Submit button found: " + (submitButton != null)); // Confirm submit button found

        // Enter text into the text box
        textBox.sendKeys("Selenium");
        System.out.println("Text entered into text box."); // Confirm text entered

        // Click the submit button
        submitButton.click();
        System.out.println("Submit button clicked."); // Confirm button clicked

        // Find the message element by its ID and print its text content
        WebElement message = driver.findElement(By.id("message"));
        System.out.println("Message text: " + message.getText()); // Print the message text

        // Close the browser
        driver.quit();
        System.out.println("Browser closed."); // Confirm browser closed
    }
}