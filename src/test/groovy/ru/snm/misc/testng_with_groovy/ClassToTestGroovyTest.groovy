package ru.snm.misc.testng_with_groovy;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author sine-loco
 */
class ClassToTestGroovyTest {

    private ClassToTest ctt

    @BeforeClass
    void beforeClass() {
        ctt = new ClassToTest()
    }

    @Test( expectedExceptions = NullPointerException.class )
    void doSmthnWithString_throws() {
        ctt.doSmthnWithString null
    }

    @Test( dependsOnMethods = 'doSmthnWithString_throws',
            dataProvider = 'forDoSmthn' )
    void doSmthnWithString( String input, String expected ) {
        // when
        def actual = ctt.doSmthnWithString input

        // expect
        assertEquals actual, expected

    }

    @DataProvider
    Object[][] forDoSmthn() {
        [
                [ '', '' ],
                [ 'input', "${ClassToTest.PREFIX}input".toString() ]
        ]
    }
}