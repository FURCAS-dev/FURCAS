package com.sap.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.METHOD )
public @interface CheckPropertyFile {

    /**
     * Parameter defines system property containing required property file
     * location, from which properties starting with prefix like "sys." are
     * loaded. An additional redirection option is accounted for by specifying a
     * property in the first property file pointing to the second one in the
     * same directory
     * 
     * @return String[0] is the system property to load the primary property
     * file from, String[1] is the considered prefix, String[2] the redirection
     * property pointing to the secondary property file containing the required
     * parameters. String[0] is mandatory, the other ones might be omitted or
     * represented by an empty string. If the property file(s) or properties
     * with prefix as specified are not present, the test case is skipped
     */
    String[] value( );
}