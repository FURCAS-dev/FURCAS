/**
 * 
 */
package com.sap.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to set the class name for the scenario specific
 * implementation of MoinTestHelper as system property. It must only be used for
 * the top level test suite.
 * 
 * @author D048997
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.TYPE )
public @interface TestHelper {

    String value( ) default "com.sap.tc.moin.test.fw.ide.IdeProductiveTestHelperImpl";
}