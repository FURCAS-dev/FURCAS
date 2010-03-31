package com.sap.tc.moin.repository.test.jmitck.tst;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.ClassO;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.SimpleModelPackage;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.StringStructure;

/**
 * ObjectCreator for creating instances of ClassO. This class has a multivalued
 * StringStructure attribute which may be given a value.
 */
@SuppressWarnings( "nls" )
public class ClassOCreator implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    /**
     * Returns a new ClassO instance. The multivalued StringStructure typed
     * attribute may be given a value, depending on the value of the initValue
     * argument
     * 
     * @param initValues if "1", the StringStructure typed attribute will be
     * given a value
     * @param root a SimpleModelPackage instance, the extent for the returned
     * ClassO instance
     * @return a new ClassO instance
     */
    public Object createObject( String initValues, RefPackage root ) {

        SimpleModelPackage smp = (SimpleModelPackage) root;
        ClassO classO = smp.get___Connection( ).createElement( ClassO.CLASS_DESCRIPTOR );
        Collection<StringStructure> sss = classO.getMultiZeroTwoStruct( );
        StructureFieldContainer<StringStructure> container = new StructureFieldContainer<StringStructure>( );

        container.put( StringStructure.DESCRIPTORS.FIELD1( ), "alpha one O" );
        container.put( StringStructure.DESCRIPTORS.FIELD2( ), "beta two O" );
        container.put( StringStructure.DESCRIPTORS.FIELD3( ), "gamma three O" );
        sss.add( smp.createStringStructure( container ) );
        if ( !"1".equals( initValues.trim( ) ) ) {
            container.put( StringStructure.DESCRIPTORS.FIELD1( ), "delta four O" );
            container.put( StringStructure.DESCRIPTORS.FIELD2( ), "epsilon five O" );
            container.put( StringStructure.DESCRIPTORS.FIELD3( ), "zeta six O" );
            sss.add( smp.createStringStructure( container ) );
        }

        return classO;
    }
}
