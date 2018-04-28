package ru.snm.misc.testng_with_groovy;

import java.util.Objects;

/**
 * @author sine-loco
 */
public class ClassToTest {
    static final String PREFIX = "prefix-";

    String doSmthnWithString( String input ) {
        Objects.requireNonNull( input, "input string must not be null!" );

        if ( input.isEmpty() ) {
            return input;
        }
        return PREFIX + input;
    }
}
