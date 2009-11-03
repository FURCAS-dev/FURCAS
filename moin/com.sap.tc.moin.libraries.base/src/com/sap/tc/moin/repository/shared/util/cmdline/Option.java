package com.sap.tc.moin.repository.shared.util.cmdline;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention( RetentionPolicy.RUNTIME )
@Target( { ElementType.FIELD } )
public @interface Option {

    String name( ) default "";

    String desc( ) default "";

    boolean mandatory( ) default false;

    boolean hasParameter( ) default true;

    String separator( ) default ";";
}
