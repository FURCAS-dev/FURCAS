package com.sap.tc.moin.repository.test.jmitck.tst;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.ClassP;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.SimpleModelPackage;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.StringStructure;

/**
 * ObjectCreator for creating instances of ClassP. This class has an optional
 * ([0:1]) StringStructure attribute which is given an initial value.
 */
@SuppressWarnings( "nls" )
public class ClassPCreator implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    /**
     * Returns a new ClassP instance. The optional StringStructure typed
     * attribute is given an initial value.
     * 
     * @param initValues ignored in this implementation
     * @param root a SimpleModelPackage instance, the extent for the returned
     * ClassP instance
     * @return a new ClassP instance
     */
    public Object createObject( String initValues, RefPackage root ) {

        SimpleModelPackage smp = (SimpleModelPackage) root;
        ClassP classP = smp.get___Connection( ).createElement( ClassP.CLASS_DESCRIPTOR );
        StructureFieldContainer<StringStructure> container = new StructureFieldContainer<StringStructure>( );

        container.put( StringStructure.DESCRIPTORS.FIELD1( ), "alpha one P" );
        container.put( StringStructure.DESCRIPTORS.FIELD2( ), "beta two P" );
        container.put( StringStructure.DESCRIPTORS.FIELD3( ), "gamma three P" );
        classP.setSvZeroOneStruct( smp.createStringStructure( container ) );

        return classP;
    }
}
