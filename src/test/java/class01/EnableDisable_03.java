package class01;

import org.testng.annotations.Test;

public class EnableDisable_03 { // We can enable and disable the test cases in TestNG.

    @Test(enabled = false) // When its false it is disabled and when nothing its enabled.
    public void Atest(){
        System.out.println(" i am the first test case");
    }

    @Test
    public void Btest(){
        System.out.println(" i am the second test case");
    }

    @Test(enabled = false)
    public void Ctest(){
        System.out.println(" i am the third test case");
    }
}
