package com.sap.tc.moin.repository.test.jmitck.tst;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.SimpleModelPackage;

/**
 * ObjectCreator for ClassAClass instances. Unlike most ObjectCreator
 * implementations, does not actually create the instance -- just retrieves it.
 */
public class ClassAClassGet implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    /**
     * Returns the ClassAClass instance in the current SimpleModelPackage
     * extent.
     * 
     * @param initValues ignored in this implementation
     * @param root the SimpleModelPackage of the current test
     * @return the ClassAClass of this SimpleModelPackage
     */
    public Object createObject( String initValues, RefPackage root ) {

        SimpleModelPackage smp = (SimpleModelPackage) root;
        return smp.getClassA( );
    }
}
