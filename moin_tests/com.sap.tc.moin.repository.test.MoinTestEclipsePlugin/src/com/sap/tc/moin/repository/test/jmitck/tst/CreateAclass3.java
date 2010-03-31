package com.sap.tc.moin.repository.test.jmitck.tst;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.SimpleModelPackage;

/**
 * ObjectCreator for creating instances of the Aclass. Always uses the no-args
 * factory method.
 */
public class CreateAclass3 implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    /**
     * Returns a new Aclass instance. Uses the no-args factory method.
     * 
     * @param initValues ignored in this implementation.
     * @param root a SimpleModelPackage instance, the extent for the returned
     * Aclass instance
     * @return a new Aclass instance
     */
    public Object createObject( String initValues, RefPackage root ) {

        return ( (SimpleModelPackage) root ).getAclass3( ).refCreateInstance( );
    }
}
