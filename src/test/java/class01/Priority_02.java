package class01;

import org.testng.annotations.Test;

public class Priority_02 {
    /* Test Cases are executed based on the alphabetical order not writing order in intellij,
     because test cases are independent in TestNG.
     */


    @Test(priority = 3) // We can set priority to test case, and it will be printed based on priority number.
    public void Atest(){
        System.out.println("I am testA");
    }

    @Test(priority = 1)
    public void Btest(){ // If priority is set to default which is zero, it is the highest priority.
        System.out.println("I am testB");
    }

    @Test(priority = 2)
    public void Ctest(){
        System.out.println("I am testC");
    }
}
