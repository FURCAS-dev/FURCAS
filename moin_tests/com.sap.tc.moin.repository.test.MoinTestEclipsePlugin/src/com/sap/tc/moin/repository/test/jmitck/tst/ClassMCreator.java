package com.sap.tc.moin.repository.test.jmitck.tst;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.ClassM;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.SimpleModelPackage;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.StringStructure;

/**
 * ObjectCreator for creating instances of ClassM. This class has a multivalued
 * StringStructure attribute which is given a number of StringStructure values.
 */
@SuppressWarnings( "nls" )
public class ClassMCreator implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    /**
     * Returns a new ClassM instance.
     * 
     * @param initValues ignored in this implementation
     * @param root a SimpleModelPackage instance, the extent for the returned
     * ClassM instance
     * @return a new ClassM instance
     */
    public Object createObject( String initValues, RefPackage root ) {

        SimpleModelPackage smp = (SimpleModelPackage) root;
        ClassM classM = smp.get___Connection( ).createElement( ClassM.CLASS_DESCRIPTOR );
        Collection<StringStructure> sss = classM.getMultiZeroUnboundStruct( );
        StructureFieldContainer<StringStructure> container = new StructureFieldContainer<StringStructure>( );

        container.put( StringStructure.DESCRIPTORS.FIELD1( ), "alpha one" );
        container.put( StringStructure.DESCRIPTORS.FIELD2( ), "beta two" );
        container.put( StringStructure.DESCRIPTORS.FIELD3( ), "gamma three" );
        sss.add( smp.createStringStructure( container ) );
        container.put( StringStructure.DESCRIPTORS.FIELD1( ), "delta four" );
        container.put( StringStructure.DESCRIPTORS.FIELD2( ), "epsilon five" );
        container.put( StringStructure.DESCRIPTORS.FIELD3( ), "zeta six" );
        sss.add( smp.createStringStructure( container ) );
        container.put( StringStructure.DESCRIPTORS.FIELD1( ), "eta seven" );
        container.put( StringStructure.DESCRIPTORS.FIELD2( ), "theta eight" );
        container.put( StringStructure.DESCRIPTORS.FIELD3( ), "iota nine" );
        sss.add( smp.createStringStructure( container ) );
        container.put( StringStructure.DESCRIPTORS.FIELD1( ), "kappa ten" );
        container.put( StringStructure.DESCRIPTORS.FIELD2( ), "lambda eleven" );
        container.put( StringStructure.DESCRIPTORS.FIELD3( ), "mu twelve" );
        sss.add( smp.createStringStructure( container ) );

        return classM;
    }
}
