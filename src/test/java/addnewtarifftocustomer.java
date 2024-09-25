import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;




public class addnewtarifftocustomer {
    public static void main(String[] args) throws InterruptedException {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "D:\\Automaion projects using BDD framework\\BirdiSolutions\\target\\chromedrivernew129.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to the website
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");


        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20,SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

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

        // Wait for the confirmation page to load and display the customer ID
        WebElement customerIdElement = driver.findElement(By.xpath("//table[@class='alt access']//td//h3"));
       //  //table[@class='alt access']//td//h3
        // Extract the Customer ID text
        String customerId = customerIdElement.getText();
        System.out.println("Customer ID: " + customerId);

        //click on homepage button
        WebElement homepage=driver.findElement(By.xpath("//a[@class='button']"));
        homepage.click();

        WebElement addtarifftocustomer=driver.findElement(By.linkText("Add Tariff Plan to Customer"));
        addtarifftocustomer.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0']")));
        WebElement dimiss=driver.findElement(By.xpath("//div[@class='toprow']//div[@id='dismiss-button']"));
        dimiss.click();
        driver.switchTo().defaultContent();

        WebElement addcustomerid=driver.findElement(By.id("customer_id"));
        addcustomerid.sendKeys(customerId);

        WebElement Submit=driver.findElement(By.xpath("//input[@type='submit']"));
        Submit.click();

        if(driver.getPageSource().contains("Add Tariff Plan to Customer")) {
            System.out.println("you are succesfully redirected to add tarif plan page ");
        } else {
            System.out.println("page is not open for add customer to tariff plan");
        }



        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)", "");

       Thread.sleep(5000);
//        WebDriverWait wait = new WebDriverWait(driver, (5000));
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='main']//following-sibling::label")));
//        element.click();


//        WebElement tariffplanselect=driver.findElement(By.xpath("(//section[@class='wrapper']//div//form//td//label"));
//        tariffplanselect.click();
//
//        Thread.sleep(5000);

        WebElement addtariffplantocustomer=driver.findElement(By.xpath("//input[@value='Add Tariff Plan to Customer']"));
        addtariffplantocustomer.click();

        if(driver.getPageSource().contains("Congratulation Tariff Plan assigned")) {
            System.out.println("tarrif paln is asigned to customer succesfully ");
        } else {
            System.out.println("tarriff plan is not assigned");
        }


        // Close the browser
        driver.quit();

    }
}
