package com.sap.tc.moin.repository.test.jmitck.tst;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.Child;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.Owner2;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.SimpleModelPackage;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.StringStructure;

/**
 * ObjectCreator for creating instances of the Owner2 type.
 */
@SuppressWarnings( "nls" )
public class CreateOwner2 implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    /**
     * Returns a new Owner2 instance.
     * 
     * @param initValues ignored in this implementation.
     * @param root a SimpleModelPackage instance, the extent for the returned
     * Owner2 instance
     * @return a new Owner2 instance
     */
    public Object createObject( String initValues, RefPackage root ) {

        SimpleModelPackage smp = (SimpleModelPackage) root;
        Child child = smp.get___Connection( ).createElement( Child.CLASS_DESCRIPTOR );
        Owner2 owner2 = smp.get___Connection( ).createElement( Owner2.CLASS_DESCRIPTOR );
        StructureFieldContainer<StringStructure> container = new StructureFieldContainer<StringStructure>( );

        child.setAttribute( "initial value 2" );
        container.put( StringStructure.DESCRIPTORS.FIELD1( ), "a" );
        container.put( StringStructure.DESCRIPTORS.FIELD2( ), "b" );
        container.put( StringStructure.DESCRIPTORS.FIELD3( ), "c" );
        owner2.setChildAttr( child );
        owner2.setStructAttr( smp.createStringStructure( container ) );

        return owner2;
    }
}
