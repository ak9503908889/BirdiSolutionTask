import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;

public class AddCustomerTest {
    public static void main(String[] args) throws InterruptedException {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "D:\\Automaion projects using BDD framework\\BirdiSolutions\\target\\chromedrivernew129.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,SECONDS);

        // Add customer details
        WebElement doneButton = driver.findElement(By.xpath("//label[@for='done']"));
        doneButton.click();


        WebElement firstName = driver.findElement(By.id("fname"));
        firstName.sendKeys("Amit");
//
        WebElement lastName = driver.findElement(By.id("lname"));
        lastName.sendKeys("kale");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("Amit.kale@example.com");

        WebElement address = driver.findElement(By.name("addr"));
        address.sendKeys("123 Main Street");

        WebElement phone = driver.findElement(By.id("telephoneno"));
        phone.sendKeys("1234567890");

        // Submit the form
        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.click();

        // Validate customer is added successfully
        if(driver.getPageSource().contains("Access Details to Guru99 Telecom")) {
            System.out.println("Customer added successfully!");
        } else {
            System.out.println("Customer addition failed!");
        }

        // Close the browser
        driver.quit();
    }
}

