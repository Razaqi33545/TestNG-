package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class softAssert_01 {
// Go to Syntax HRMS
// send no credentials and click on login button
// Verify the error message is "Username cannot be empty"

    public static WebDriver driver; // We declare it globally to access it driver in all methods.
    @BeforeMethod
    public void SetupBrowser(){
        WebDriverManager.chromedriver().setup(); /* We do not need to worry about set-properties because we have used
        Web-driverManager dependencies, We are using this to set up the chrome driver*/
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void CloseBrowser() throws InterruptedException {

        driver.quit();
    }

    @Test
    public void testcase(){

        // Click on the login button
     WebElement loginbtn = driver.findElement(By.xpath("//input[@type='submit']"));
    loginbtn.click();

    // get the text error message
    WebElement error = driver.findElement(By.xpath("//span[text()='Username cannot be empty']"));
        String actualError = error.getText();

        // String that contains my expected error
        String expectedError = "Username cannot be empty";

        // Declare softAssert class
        SoftAssert soft = new SoftAssert();
        //Compare
        soft.assertEquals(actualError,expectedError);

        // Verify login button is displayed
        boolean disp = loginbtn.isDisplayed();
        System.out.println("The state of the login button is : " + disp);
        // call soft assertion: We do this to verify if the value from disp is true or false if true testcase will pass otherwise fails.
        soft.assertTrue(disp);

        // Once you have made all the assertions in the testcase use soft.assetAll() at the end
        //
        soft.assertAll(); // It passes the result to the testcase telling that you have failed or passed. this is must with softAssert.

        // Use soft Assertion when there are more than one assertion in a single testcase, and you want to know which assertion is failing

        /*
        Use Hard Assertion:
        when there are more than one assertion in your testcase, despite the number of the assertions if you want your testcase to fail
        even if the first assertion fails. Which means you do not want to move forward when the first assertion fails.
         */
    }





}
