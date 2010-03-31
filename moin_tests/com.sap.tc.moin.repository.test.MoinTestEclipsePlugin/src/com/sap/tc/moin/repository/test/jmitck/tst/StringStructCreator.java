package com.sap.tc.moin.repository.test.jmitck.tst;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.SimpleModelPackage;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.StringStructure;

/**
 * ObjectCreator for creating instances of the StringStruct type.
 */
@SuppressWarnings( "nls" )
public class StringStructCreator implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    /**
     * Returns a new StringStruct instance.
     * 
     * @param initValues ignored in this implementation.
     * @param root a SimpleModelPackage instance, the extent for the returned
     * StringStruct instance.
     * @return a new StringStruct instance.
     */
    public Object createObject( String initValues, RefPackage root ) {

        SimpleModelPackage smp = (SimpleModelPackage) root;
        StructureFieldContainer<StringStructure> container = new StructureFieldContainer<StringStructure>( );

        container.put( StringStructure.DESCRIPTORS.FIELD1( ), "f1" );
        container.put( StringStructure.DESCRIPTORS.FIELD2( ), "f2" );
        container.put( StringStructure.DESCRIPTORS.FIELD3( ), "f3" );

        return smp.createStringStructure( container );
    }
}
