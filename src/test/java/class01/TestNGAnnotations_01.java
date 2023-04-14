package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/* When you download all repositories into pom.xml folder, and it shows red right click on pom.xml
 go to maven and click on reload, it will synchronize the dependencies with your project. If you need to download the updated
 version of dependencies just change the version number in the dependencies and reload it.
 */
public class TestNGAnnotations_01{ // We do not have any main class in testNG

    @Test(groups = "regression")
public void aFirstTestCase(){
        System.out.println("i am the first test case");
    }

    @Test
    public void bSecondTestCase(){ /* We can only run the second test case by clicking on the green button
    in the left or click on the testcase itself and run it. If we want to run all we need to click outside
     the class and run annotation */
        System.out.println("i am the second test case");
    }

    @Test
    public void cThirdTestCase(){
        System.out.println("i am the third test case");
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethods(){ /* We can run before Method anywhere inside the class the location does not matter
     and will come first in console. We basically use it for web-driver launching,
     so we do not need to launching it repetitively for every single test case or some pre-conditions.*/
        System.out.println("i am before Method");
        }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){/* We can run after Method anywhere inside the class the location does not matter
            and will come after in console. We basically use it for post-conditions such as closing browser to prevent repetitions.*/
        System.out.println(" i am after method ");
    }


}
