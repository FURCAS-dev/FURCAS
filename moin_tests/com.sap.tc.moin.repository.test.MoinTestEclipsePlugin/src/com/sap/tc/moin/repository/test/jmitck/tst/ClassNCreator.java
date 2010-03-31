package com.sap.tc.moin.repository.test.jmitck.tst;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.ClassN;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.SimpleModelPackage;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.StringStructure;

/**
 * ObjectCreator for creating instances of ClassN. This class has a multivalued
 * StringStructure attribute which is given a number of StringStructure values.
 */
@SuppressWarnings( "nls" )
public class ClassNCreator implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    /**
     * Returns a new ClassN instance.
     * 
     * @param initValues ignored in this implementation
     * @param root a SimpleModelPackage instance, the extent for the returned
     * ClassN instance
     * @return a new ClassN instance
     */
    public Object createObject( String initValues, RefPackage root ) {

        SimpleModelPackage smp = (SimpleModelPackage) root;
        ClassN classN = smp.get___Connection( ).createElement( ClassN.CLASS_DESCRIPTOR );
        Collection<StringStructure> sss = classN.getMultiOneUnboundStruct( );
        StructureFieldContainer<StringStructure> container = new StructureFieldContainer<StringStructure>( );

        container.put( StringStructure.DESCRIPTORS.FIELD1( ), "alpha one N" );
        container.put( StringStructure.DESCRIPTORS.FIELD2( ), "beta two N" );
        container.put( StringStructure.DESCRIPTORS.FIELD3( ), "gamma three N" );
        sss.add( smp.createStringStructure( container ) );
        container.put( StringStructure.DESCRIPTORS.FIELD1( ), "delta four N" );
        container.put( StringStructure.DESCRIPTORS.FIELD2( ), "epsilon five N" );
        container.put( StringStructure.DESCRIPTORS.FIELD3( ), "zeta six N" );
        sss.add( smp.createStringStructure( container ) );
        container.put( StringStructure.DESCRIPTORS.FIELD1( ), "eta seven N" );
        container.put( StringStructure.DESCRIPTORS.FIELD2( ), "theta eight N" );
        container.put( StringStructure.DESCRIPTORS.FIELD3( ), "iota nine N" );
        sss.add( smp.createStringStructure( container ) );
        container.put( StringStructure.DESCRIPTORS.FIELD1( ), "kappa ten N" );
        container.put( StringStructure.DESCRIPTORS.FIELD2( ), "lambda eleven N" );
        container.put( StringStructure.DESCRIPTORS.FIELD3( ), "mu twelve N" );
        sss.add( smp.createStringStructure( container ) );

        return classN;
    }
}
