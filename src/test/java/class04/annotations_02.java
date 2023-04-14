package class04;

import org.testng.annotations.*;

public class annotations_02 {

    @BeforeTest
    public void beforeTest(){ // @BeforeTest will also be executed only once before @Test does not matter how many @Test are there.
        System.out.println("I am Before Test");
    }
@BeforeClass
public void beforeClass(){ // Before and After class is executed only once.

    System.out.println("I am Before Class");
}
    @BeforeMethod
    public void before(){
        System.out.println("I am Before Method");
    }

    @AfterMethod
    public void after(){
        System.out.println("I am After Method");
    }
@AfterClass
public void afterClass(){
    System.out.println("I am After Class");
}
    @Test
    public void TestA() {
        System.out.println("I am test A");
    }
        @Test
        public void TestB(){
            System.out.println("I am test B");
    }





}
