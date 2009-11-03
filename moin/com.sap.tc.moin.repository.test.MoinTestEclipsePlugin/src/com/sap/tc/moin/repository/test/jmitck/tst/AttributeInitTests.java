package com.sap.tc.moin.repository.test.jmitck.tst;

import java.util.List;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.modelsem.SemModelTests;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.Aclass;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.ColorKind;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.SimpleModelPackage;

/**
 * Provides tests of attribute initialization -- the initial values given to
 * attributes before explicitly being set. These tests reside in this package so
 * they can use the
 * <code>com.sap.tc.moin.repository.test.jmitck.tst.simplemodel</code> generated
 * interfaces.
 */
@SuppressWarnings( "nls" )
public class AttributeInitTests extends SemModelTests {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, AttributeInitTests.class );

    /**
     * Defines the objectAttributeInitialization test. This test examines values
     * of instance attributes after the no-args factory method creates the
     * instance, but before the attributes have been set with the generated
     * "set" methods, add methods on returned collections, or refSetValue
     * methods.
     * <p>
     * This test examines a single-valued int attribute; a multi-valued int
     * attribute, and single-valued enumeration typed attribute
     * 
     * @return a <code>Status</code> value, showing the results of the test
     */
    public Status objectAttributeInitialization( ) {

        SimpleModelPackage smp = (SimpleModelPackage) rp;
        Aclass ac = null;
        try {
            ac = (Aclass) smp.getAclass( ).refCreateInstance( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " creating object with the no-args factory " + "methods" );
        }
        int intAttr;
        Status passedStatus = null;
        try {
            intAttr = ac.getAttribute( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " when accessing the uninitialized " + "attribute SimpleModel.AClass.attribute" );

        }
        if ( intAttr != 0 ) {
            return Status.failed( "Expected the uninitialized attribute " + "SimpleModel.AClass.attribute" + "to have a value of 0; instead, value was " + intAttr );
        }
        passedStatus = Status.passed( "Access of uninitialized {0:1} int " + "attribute returned 0, as expected" );

        ColorKind color;
        try {
            color = ac.getColor( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " when accessing the uninitialized attribute " + "SimpleModel.Aclass.color" );

        }
        if ( color != null ) {
            return Status.failed( "Expected the access of uninitialized static " + "attribute " + "SimpleModel.ClassA.color" + "to return null; instead, a Color enum with " + "the value " + color + " was returned" );
        }

        passedStatus.augment( "Access of uninitialized {1:1} " + "attribute of an enum type returned null, " + "as expected" );

        List<Integer> intColl;
        try {
            intColl = ac.getAttributeColl( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " when accessing the uninitialized  " + "attribute " + "SimpleModel.AClass.attributeColl" );

        }
        if ( intColl == null ) {
            return Status.failed( "Expected the access of uninitialized " + "attribute " + "SimpleModel.AClass.attributeColl " + "to return an empty collection; instead, " + " null was returned" );
        }
        if ( !intColl.isEmpty( ) ) {
            return Status.failed( "Expected the access of uninitialized " + "attribute " + "SimpleModel.ASubClass.attributeColl " + "to return an empty collection; instead, " + "the returned collection had " + intColl.size( ) + " elements" );
        }
        return passedStatus.augment( "Access of uninitialized {0:-1} attribute " + "of type int returned an empty collection, " + "as expected" );

    }
}
