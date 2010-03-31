package com.sap.tc.moin.repository.test.jmitck.tst2;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * ObjectCreator for returning null.
 */
public class NullCreator implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    /**
     * Returns null.
     * 
     * @param initValues ignored in this implementation.
     * @param root ignored in this implementation.
     * @return null.
     */
    public Object createObject( String initValues, RefPackage root ) {

        return null;
    }
}
