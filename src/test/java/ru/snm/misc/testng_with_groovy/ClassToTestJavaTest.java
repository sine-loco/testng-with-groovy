package ru.snm.misc.testng_with_groovy;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author sine-loco
 */
public class ClassToTestJavaTest {

    private ClassToTest ctt;

    @BeforeClass
    void beforeClass() {
        ctt = new ClassToTest();
    }

    @Test( expectedExceptions = NullPointerException.class )
    public void doSmthnWithString_throws() {
        ctt.doSmthnWithString( null );
    }

    @Test( dependsOnMethods = "doSmthnWithString_throws",
            dataProvider = "forDoSmthn" )
    public void doSmthnWithString( String input, String expected ) {
        // when
        String actual = ctt.doSmthnWithString( input );

        // expect
        assertEquals( actual, expected );

    }

    @DataProvider
    Object[][] forDoSmthn() {
        return new Object[][] {
                { "", "" },
                { "input", ClassToTest.PREFIX + "input" }
        };
    }
}