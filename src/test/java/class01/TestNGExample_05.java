package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGExample_05 {

    /*
     *  testCase 1
     * goto Syntax HRMS
     * enter the username and password, verify that u logged in
     * close the browser
     */

    public static WebDriver driver; // This is called global declaration. We do it, so we can access driver allover the class.


    // Pre-conditions ---> to open the browser and to set implicit wait.
    @BeforeMethod(alwaysRun = true) // Add this when want to run in groups in xml to run pre- and post-condition and not get error.
    public void SetupBrowser(){
        WebDriverManager.chromedriver().setup(); /* We do not need to worry about set-properties because we have used
        Web-driverManager dependencies */
       driver = new ChromeDriver();
      driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

// Post-Condition--> to close the browser
    @AfterMethod(alwaysRun = true)
    public void CloseBrowser() throws InterruptedException {

        Thread.sleep(2000); // This is used for testing purpose and should be removed for final code.

        driver.quit();
    }

    @Test (groups = "regression")
    public void loginFunctionality() throws InterruptedException {
       WebElement username = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        username.sendKeys("Admin");
        Thread.sleep(2000);
       WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
       password.sendKeys("Hum@nhrm123");
      WebElement loginBtn = driver.findElement(By.xpath("//*[@id='btnLogin']")); // * means any tag that has id="btnLogin"
        loginBtn.click();
    }

            /*
                    testCase2
                    * Verify that password text-box is displayed on the login page.
            */
@Test
    public void passwordTextBoxVerification(){
    // Find the element password text-box
    WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
    System.out.println(password.isDisplayed());

}






}
