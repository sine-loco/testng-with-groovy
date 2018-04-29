package ru.snm.misc.testng_with_groovy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * @author sine-loco
 */
public class ClassToTestJavaTest {
    private final static Logger logger = LogManager.getLogger();

    private ClassToTest ctt;

    @BeforeClass
    void beforeClass() {
        logger.info( "before class" );

        ctt = new ClassToTest();
    }

    @Test( expectedExceptions = NullPointerException.class )
    public void doSmthnWithString_throws() {
        ctt.doSmthnWithString( null );
    }

    @Test( dependsOnMethods = "doSmthnWithString_throws",
            dataProvider = "forDoSmthn" )
    public void doSmthnWithString( String input, String expected ) {
        logger.info( "test doSmthnWithString - input: [{}]", input );

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