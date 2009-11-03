package com.sap.tc.moin.repository.test.jmitck.modelsem;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * Creates an object for use in a test.
 */
public interface ObjectCreator {

    /**
     * Returns a new instance for use in a test.
     * 
     * @param initValues String which may be used to provide initialization
     * values
     * @param root the <code>RefPackage</code> extent where the object must be
     * created
     * @return the new instance
     */
    public Object createObject( String initValues, RefPackage root );
}
