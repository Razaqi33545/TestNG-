package class01;

import org.testng.annotations.Test;

public class DependsOn_04 {


    @Test
    public void  Login(){ // If we set Login to something else than its value such as 6/0 it will fail the test case.
        System.out.println("I am here");
    }

    @Test (dependsOnMethods = {"Login"})
    public  void DashBoardVerification(){ /* The Dashboard will only be verified once we are successfully logged in,
     So if the Login fails we do not need to run dashBoardVerification.
    */
        System.out.println("after login i am verifying dashboard");
    }
}
