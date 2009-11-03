package com.sap.tc.moin.repository.test.jmitck.tst;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.modelsem.SemModelTests;
import com.sap.tc.moin.repository.test.jmitck.modelsem.Util;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.NestedStruct;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.NestedStructOwner;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.SimpleModelPackage;

/**
 * Defines tests using the NestedStruct type. This Structure type contains three
 * fields:
 * <ul>
 * <li>descr : String</li>
 * <li>link : NestedStruct</li>
 * <li>longNum : Long</li>
 * </ul>
 * Test cases create an instance of NestedStruct which links to a second
 * NestedStruct instance, which in turn links to a third NestedStruct instance.
 */
@SuppressWarnings( "nls" )
public class NestedStructureTests extends SemModelTests {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, NestedStructureTests.class );

    /**
     * Defines the svNestedStructure test. This method tests the setting and
     * getting of an attribute of the NestedStructure type.
     * 
     * @return a <code>Status</code> value
     */
    public Status setGetNestedStruct( ) {

        SimpleModelPackage smp = (SimpleModelPackage) rp;
        StructureFieldContainer<NestedStruct> container = new StructureFieldContainer<NestedStruct>( );
        container.put( NestedStruct.DESCRIPTORS.DESCR( ), "initial" );
        container.put( NestedStruct.DESCRIPTORS.LINK( ), null );
        container.put( NestedStruct.DESCRIPTORS.LONG_NUM( ), 0L );
        NestedStruct parent = makeNestedStruct( smp );
        NestedStruct initial = smp.createNestedStruct( container );
        NestedStructOwner nso = (NestedStructOwner) smp.getNestedStructOwner( ).refCreateInstance( );
        nso.setNestedStructAttr( initial );
        String attrName = "SimpleModel.NestedStructOwner.nestedStructAttr";
        try {
            String msg = "Setting the value of the nestedStructAttr attribute " + "of a NestedStructOwner instance to the value: " + parent;
            if ( isStrReflectiveTest ) {
                trOut.println( msg + " using String-designated JMI reflection" );
                nso.refSetValue( Util.simpleNameOf( attrName ), parent );
            } else if ( isObjReflectiveTest ) {
                RefObject metaAttr = Util.getMetaFeature( nso, attrName );
                trOut.println( msg + " with JMI reflection, designating the " + "attribute with: " + metaAttr );
                nso.refSetValue( metaAttr, parent );
            } else {
                trOut.println( msg + " using the setNestedStructAttr method" );
                nso.setNestedStructAttr( parent );
            }
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " caught when setting the attribute value" );
        }
        NestedStruct returnedVal = null;
        try {
            String msg = "Retrieving the value of the nestedStructAttr attribute";
            if ( isStrReflectiveTest ) {
                trOut.println( msg + " using String-designated JMI reflection" );
                String simpleName = Util.simpleNameOf( attrName );
                returnedVal = (NestedStruct) nso.refGetValue( simpleName );
            } else if ( isObjReflectiveTest ) {
                RefObject metaAttr = Util.getMetaFeature( nso, attrName );
                trOut.println( msg + " with JMI reflection, designating the " + "attribute with: " + metaAttr );
                returnedVal = (NestedStruct) nso.refGetValue( metaAttr );
            } else {
                trOut.println( msg + " using the getNestedStructAttr method" );
                returnedVal = nso.getNestedStructAttr( );
            }
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " caught when retrieving the attribute value" );
        }

        try {
            if ( !parent.equals( returnedVal ) ) {
                return Status.failed( "The value returned does not equal the set " + "value" );
            } else {
                return Status.passed( "The value returned equals the set value" );
            }
        } catch ( Throwable th ) {
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " caught when testing for equality" );
        }
    }

    private static NestedStruct makeNestedStruct( SimpleModelPackage smp ) {

        StructureFieldContainer<NestedStruct> container = new StructureFieldContainer<NestedStruct>( );
        container.put( NestedStruct.DESCRIPTORS.DESCR( ), "Grand Child" );
        container.put( NestedStruct.DESCRIPTORS.LINK( ), null );
        container.put( NestedStruct.DESCRIPTORS.LONG_NUM( ), -1l );
        NestedStruct gchild = smp.createNestedStruct( container );
        container.put( NestedStruct.DESCRIPTORS.DESCR( ), "Child" );
        container.put( NestedStruct.DESCRIPTORS.LINK( ), gchild );
        container.put( NestedStruct.DESCRIPTORS.LONG_NUM( ), 100l );
        NestedStruct child = smp.createNestedStruct( container );
        container.put( NestedStruct.DESCRIPTORS.DESCR( ), "Parent" );
        container.put( NestedStruct.DESCRIPTORS.LINK( ), child );
        container.put( NestedStruct.DESCRIPTORS.LONG_NUM( ), 10000l );
        NestedStruct parent = smp.createNestedStruct( container );
        return parent;

    }

    /**
     * Defines a test for the implementation of the equals method on the
     * NestedStruct type.
     * 
     * @return the test results
     */
    public Status testEqualsImpl( ) {

        SimpleModelPackage smp = (SimpleModelPackage) rp;
        NestedStruct n1 = makeNestedStruct( smp );
        NestedStruct n2 = makeNestedStruct( smp );
        try {
            if ( !n1.equals( n2 ) ) {
                return Status.failed( "NestedStruct equals() method failed: " + "Two equvelant structures should be " + "considered equal" );
            }
        } catch ( Throwable th ) {
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " caught when executing equals for NestedStruct" );
        }

        StructureFieldContainer<NestedStruct> container = new StructureFieldContainer<NestedStruct>( );
        container.put( NestedStruct.DESCRIPTORS.DESCR( ), "Grand Child" );
        container.put( NestedStruct.DESCRIPTORS.LINK( ), null );
        container.put( NestedStruct.DESCRIPTORS.LONG_NUM( ), 1l );
        NestedStruct gchild = smp.createNestedStruct( container );
        container.put( NestedStruct.DESCRIPTORS.DESCR( ), "Child" );
        container.put( NestedStruct.DESCRIPTORS.LINK( ), gchild );
        container.put( NestedStruct.DESCRIPTORS.LONG_NUM( ), 100l );
        NestedStruct child = smp.createNestedStruct( container );
        container.put( NestedStruct.DESCRIPTORS.DESCR( ), "Parent" );
        container.put( NestedStruct.DESCRIPTORS.LINK( ), child );
        container.put( NestedStruct.DESCRIPTORS.LONG_NUM( ), 10000l );
        NestedStruct parent = smp.createNestedStruct( container );

        try {
            if ( n1.equals( parent ) ) {
                return Status.failed( "NestedStruct equals() method failed: " + "failed to detect different long values in " + "nested structures" );
            }
        } catch ( Throwable th ) {
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " caught when executing equals for NestedStruct" );
        }

        try {
            if ( n1.equals( null ) ) {
                return Status.failed( "NestedStruct equals() method failed: " + "NestedStruct returned true when compared " + "to null" );
            }
        } catch ( Throwable th ) {
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " caught when executing equals for NestedStruct" );
        }

        try {
            if ( !n1.equals( n1 ) ) {
                return Status.failed( "NestedStruct equals() method failed: " + " did not return true when comparing to itself" );
            }
        } catch ( Throwable th ) {
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) + " caught when executing equals() for NestedStruct" );
        }
        return Status.passed( "NestedStruct equals() method behaves as expected" );
    }

}
