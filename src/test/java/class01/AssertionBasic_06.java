package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AssertionBasic_06 {
    public static WebDriver driver;

    // Pre-Conditions
    @BeforeMethod
    public void SetupBrowser(){
        WebDriverManager.chromedriver().setup(); /* We do not need to worry about set-properties because we have used
        Web-driverManager dependencies */
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    // Post-Condition
    @AfterMethod
    public void CloseBrowser() throws InterruptedException {

        Thread.sleep(2000); // This is used for testing purpose and should be removed from final code.

        driver.quit();
    }

    /*
                Test Case
    * enter the user-name: Admin
    * enter the password: Abracadabra
    * click login button
    * verify that the message invalid credentials is displayed

     */

    @Test
    public void invalidCredentials(){
        // locate the Web-element username and send keys
        WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys("Admin");

        // locate the webElement password and send keys
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("abracadabra");

//        locate login button and click login
        WebElement loginBtn = driver.findElement(By.xpath("//input[@name='Submit']"));
        loginBtn.click();

//      verify the error message
        WebElement error = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String errorMsg = error.getText();

//        check if the error message is correct
        String expectedError = "Invalid credentials";

//      In TestNG we have assertion that allows us to compare the two values, and We are using assertions to verify results are correct.
        // Assert the value
        Assert.assertEquals(expectedError,errorMsg); // Before , expected result and after , actual result

        // Finding the password again as it is discarded when the clicked on login button happened it refreshed the DOM.
        WebElement password1 = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));

        // Password text box is displayed
           boolean passwordDisplayed = password1.isDisplayed();

           // verify that the text box is displayed
        Assert.assertTrue(passwordDisplayed);
    }
    // Both of the following are hard assertions:
    // We use Assert.assertEquals(actual,expected) when we compare two String, int and booleans
    // We use AssertTrue(boolean) We want to verify if a boolean value is true

    // Soft Assertion:To compare to Strings use assertEquals(actual,expected) and we must call it from SoftAssert soft = new SoftAssert()
    // Verify that if a boolean is true: Use soft.assertTrue(Boolean) and we must call it from SoftAssert soft = new SoftAssert()
   /* Soft assertions will not mark the testcase as "Failed" immediately even if "One Assertion" has failed. it is going to keep on
   asserting other conditions and at the end will return u with the result.
    */

    /* Catch in hard assertion : As soon as one of assert statements is failed the test will be marked as "Failed" and it won't
    bother to check other assert statements or execute even the rest of the code.
     */
}
