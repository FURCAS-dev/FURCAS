/**
 * 
 */
package com.sap.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author D048997
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( { ElementType.METHOD } )
@SuppressWarnings( "nls" )
public @interface Staged {

    public static final String CENTRAL_STRING = "CENTRAL";

    public static final String ISOLATED_STRING = "ISOLATED";

    public static final String OCCASIONAL_STRING = "OCCASIONAL";

    public static final String ALL_STRING = "ALL";

    /**
     * Possible values for tests:
     * <ul>
     * <li>LKG</li>
     * <li>NO_LKG</li>
     * <li>NO_TEAM</li>
     * </ul>
     * All LKG tests are executed ("is part of") in LKG, NO_LKG and NO_TEAM.<br>
     * All NO_LKG tests are executed in NO_LKG and NO_TEAM<br>
     * All NO_TEAM tests are executed in NO_TEAM
     * 
     * @author D048997
     */
    public static enum StageLevel {

        CENTRAL, ISOLATED, ALL, OCCASIONAL;
    }

    StageLevel value( ) default StageLevel.ISOLATED;
}