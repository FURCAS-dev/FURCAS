package com.sap.tc.moin.repository.jmx;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation describing the name of parameters of JMX MBean operations.
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( { ElementType.PARAMETER } )
public @interface ParameterName {

    /**
     * the name of the parameter
     */
    String value( );
}
