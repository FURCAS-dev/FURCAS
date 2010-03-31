package com.sap.tc.moin.repository.test.jmitck.tst;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.Child;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.Owner1;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.SimpleModelPackage;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.StringStructure;

/**
 * ObjectCreator for creating instances of the Owner1 type.
 */
@SuppressWarnings( "nls" )
public class CreateOwner1 implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    /**
     * Returns a new Owner1 instance.
     * 
     * @param initValues ignored in this implementation.
     * @param root a SimpleModelPackage instance, the extent for the returned
     * Owner1 instance
     * @return a new Owner1 instance
     */
    public Object createObject( String initValues, RefPackage root ) {

        SimpleModelPackage smp = (SimpleModelPackage) root;
        Child child = smp.get___Connection( ).createElement( Child.CLASS_DESCRIPTOR );
        Owner1 owner1 = smp.get___Connection( ).createElement( Owner1.CLASS_DESCRIPTOR );
        StructureFieldContainer<StringStructure> container = new StructureFieldContainer<StringStructure>( );

        child.setAttribute( "initial value" ); //$NON-NLS-1$
        container.put( StringStructure.DESCRIPTORS.FIELD1( ), "d" );
        container.put( StringStructure.DESCRIPTORS.FIELD2( ), "e" );
        container.put( StringStructure.DESCRIPTORS.FIELD3( ), "f" );
        owner1.setChildAttr( child );
        owner1.setStructAttr( smp.createStringStructure( container ) );

        return owner1;
    }
}
