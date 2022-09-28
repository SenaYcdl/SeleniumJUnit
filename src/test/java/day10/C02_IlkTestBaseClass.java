package day10;

import utilities.TestBaseBeforeClassAfterClass;
import org.junit.Test;

public class C02_IlkTestBaseClass extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1(){

        driver.get("https://www.amazon.com");

    }
}
