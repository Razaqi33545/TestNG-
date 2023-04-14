package class04;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class annotationsBeforeClass {

@BeforeClass
    public void hello(){
    System.out.println("I am Before Class");
}

@Test
    public void TestB(){
    System.out.println("I am TestB");
}




}
