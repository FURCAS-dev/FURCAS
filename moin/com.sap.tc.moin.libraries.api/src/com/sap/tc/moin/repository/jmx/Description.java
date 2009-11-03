package com.sap.tc.moin.repository.jmx;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation describing JMX MBean attributes and operations.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Documented
@Retention( RetentionPolicy.RUNTIME )
@Target( { ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE } )
public @interface Description {

    /**
     * the description String
     */
    String value( );
}
