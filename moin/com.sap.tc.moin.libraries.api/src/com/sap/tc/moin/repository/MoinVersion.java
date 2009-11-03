package com.sap.tc.moin.repository;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author d024227
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( { ElementType.TYPE } )
public @interface MoinVersion {

    /**
     * Returns the version number .
     * 
     * @return the version number
     */
    String versionNumber( );

    /**
     * Returns the date of the version.
     * 
     * @return the date of the version
     */
    String versionDate( ); // String date()    default "[unimplemented]"; 

    /**
     * Returns the comment to this version.
     * 
     * @return the comment to this version
     */
    String versionComment( );
}
