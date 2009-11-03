package com.sap.tc.moin.repository.test.jmitck.tst;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.DuplicateException;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.modelsem.SemModelTests;
import com.sap.tc.moin.repository.test.jmitck.modelsem.Util;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.ClassA;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.ClassE;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.SimpleModelPackage;

/**
 * Defines tests on Collections returned from attribute access methods.
 */
@SuppressWarnings( "nls" )
public class CollectionTests extends SemModelTests {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, CollectionTests.class );

    /**
     * Defines the removeAll test, which tests the implementation of
     * java.util.Colllection.removeAll on collections corresponding to
     * multi-valued attributes. This test modifies the collection returned by a
     * multivalued int attribute, and compares the result to the behavior of the
     * implementation of ArrayList.
     * 
     * @return a <code>Status</code> value, the results of the test
     */
    public Status removeAllTest( ) {

        SimpleModelPackage smp = (SimpleModelPackage) rp;
        List<Integer> attrValues = new ArrayList<Integer>( );
        attrValues.add( new Integer( 1 ) );
        attrValues.add( new Integer( 2 ) );
        attrValues.add( new Integer( 3 ) );
        attrValues.add( new Integer( 4 ) );
        attrValues.add( new Integer( 5 ) );
        attrValues.add( new Integer( 6 ) );
        attrValues.add( new Integer( 7 ) );
        attrValues.add( new Integer( 8 ) );
        attrValues.add( new Integer( 9 ) );
        attrValues.add( new Integer( 10 ) );
        attrValues.add( new Integer( 11 ) );
        attrValues.add( new Integer( 12 ) );
        Collection<Integer> control = new ArrayList<Integer>( attrValues );
        Collection<Integer> currentAttrValues = null;
        ClassA ca = null;
        try {
            ca = (ClassA) smp.getClassA( ).refCreateInstance( );
            ca.getMultiZeroUnboundInt( ).addAll( attrValues );
            currentAttrValues = ca.getMultiZeroUnboundInt( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.error( "Failed to perform test setup; unexpected " + "exception " + th.getClass( ).getName( ) + " with message: " + th.getMessage( ) );
        }
        List<Integer> toRemove = new ArrayList<Integer>( );
        toRemove.add( new Integer( 2 ) );
        toRemove.add( new Integer( 4 ) );
        toRemove.add( new Integer( 6 ) );
        toRemove.add( new Integer( 8 ) );
        toRemove.add( new Integer( 10 ) );
        toRemove.add( new Integer( 12 ) );

        boolean changed = false;
        try {
            changed = currentAttrValues.removeAll( toRemove );
        } catch ( Throwable th ) {
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message: " + th.getMessage( ) + " encountered in invoking " + " the removeAll method on the collection of " + " attribute values" );
        }
        if ( !changed ) {
            return Status.failed( "The removeAll method failed to return true " + " when invoked with an argument that should " + " have caused the collection to change" );
        }
        control.removeAll( toRemove );

        Collection<Integer> after = null;
        try {
            after = ca.getMultiZeroUnboundInt( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message: " + th.getMessage( ) + " encountered when accessing the multivalued " + "attribute after invoking the removeAll method" );
        }

        if ( !Util.equalCollections( control, after ) ) {
            return Status.failed( "After removeAll invocation, expected attribute " + " to have the value " + collString( control ) + " but it had the value " + collString( after ) );
        } else {
            return Status.passed( "After removeAll invocation, attribute value is " + collString( control ) + " as expected" );
        }
    }

    private String collString( Collection<? extends Object> c ) {

        StringBuffer sb = new StringBuffer( "{" );
        int cnt = 0;
        for ( Iterator<? extends Object> i = c.iterator( ); i.hasNext( ); cnt++ ) {
            if ( cnt > 0 ) {
                sb.append( ", " );
            }
            sb.append( i.next( ) );
        }
        return sb.append( "}" ).toString( );
    }

    /**
     * Defines the attributeOrdering test. The test insures that ordering is
     * maintained for a multi-valued, ordered attribute.
     * 
     * @return a <code>Status</code> value, the results of the test
     */
    public Status checkAttributeValueOrdering( ) {

        SimpleModelPackage smp = (SimpleModelPackage) rp;
        List<String> attrValues = new ArrayList<String>( );
        attrValues.add( "a" );
        attrValues.add( "b" );
        attrValues.add( "c" );
        attrValues.add( "d" );
        attrValues.add( "e" );
        List<String> control = new ArrayList<String>( attrValues );
        List<String> currentAttrValues = null;
        ClassE cb = null;
        try {
            cb = (ClassE) smp.getClassE( ).refCreateInstance( );
            cb.getMultiZeroUnboundString( ).addAll( attrValues );
            currentAttrValues = cb.getMultiZeroUnboundString( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.error( "Failed to perform test setup; unexpected " + "exception " + th.getClass( ).getName( ) + " with message: " + th.getMessage( ) );
        }
        List<String> toAdd = new ArrayList<String>( );
        toAdd.add( "f" );
        toAdd.add( "g" );
        try {
            currentAttrValues.addAll( toAdd );
            control.addAll( toAdd );
            currentAttrValues.add( 0, "z" );
            control.add( 0, "z" );
            currentAttrValues.add( 8, "q" );
            control.add( 8, "q" );
            currentAttrValues.remove( "c" );
            control.remove( "c" );
            currentAttrValues.remove( 5 );
            control.remove( 5 );

        } catch ( Throwable th ) {
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message: " + th.getMessage( ) + " encountered while adding " + "elements to the collection of attribute " + "values" );
        }
        List<String> after = null;
        try {
            after = cb.getMultiZeroUnboundString( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message: " + th.getMessage( ) + " encountered when accessing the multivalued " + "attribute after adding values" );
        }
        if ( !equalLists( control, after ) ) {
            return Status.failed( "After manipulation, expected attribute " + " to have the value " + collString( control ) + " but it had the value " + collString( after ) );
        } else {
            return Status.passed( "After removeAll invocation, attribute value is " + collString( control ) + " as expected" );
        }
    }

    /**
     * Defines the checkUniqueness test, which insures that the uniqueness
     * constraint is enforced for a multi-valued attribute defined as unique.
     * 
     * @return a <code>Status</code> value, the results of the test
     */
    public Status checkUniqueness( ) {

        SimpleModelPackage smp = (SimpleModelPackage) rp;
        List<Integer> attrValues = new ArrayList<Integer>( );
        attrValues.add( new Integer( 1 ) );
        attrValues.add( new Integer( 2 ) );
        attrValues.add( new Integer( 3 ) );
        attrValues.add( new Integer( 4 ) );
        attrValues.add( new Integer( 5 ) );
        attrValues.add( new Integer( 6 ) );
        attrValues.add( new Integer( 7 ) );
        attrValues.add( new Integer( 8 ) );
        attrValues.add( new Integer( 9 ) );
        attrValues.add( new Integer( 10 ) );
        attrValues.add( new Integer( 11 ) );
        attrValues.add( new Integer( 12 ) );
        Collection<Integer> control = new ArrayList<Integer>( attrValues );
        Collection<Integer> currentAttrValues = null;
        ClassA ca = null;
        try {
            ca = (ClassA) smp.getClassA( ).refCreateInstance( );
            ca.getMultiZeroUnboundInt( ).addAll( attrValues );
            currentAttrValues = ca.getMultiZeroUnboundInt( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.error( "Failed to perform test setup; unexpected " + "exception " + th.getClass( ).getName( ) + " with message: " + th.getMessage( ) );
        }
        boolean changed = false;
        try {
            changed = currentAttrValues.add( new Integer( 4 ) );
        } catch ( DuplicateException th ) {
        } catch ( Throwable th ) {
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message: " + th.getMessage( ) + " encountered in invoking " + " the add method on the collection of " + " attribute values" );
        }
        if ( changed ) {
            return Status.failed( "The add method failed to returned false " + " when a duplicate value add was attempted" );
        }
        Collection<Integer> after = null;
        try {
            after = ca.getMultiZeroUnboundInt( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            return Status.failed( "Unexpected exception " + th.getClass( ).getName( ) + " with message: " + th.getMessage( ) + " encountered when accessing the multivalued " + "attribute after invoking the add method" );
        }
        if ( !Util.equalCollections( control, after ) ) {
            return Status.failed( "After removeAll invocation, expected attribute " + " to have the value " + collString( control ) + " but it had the value " + collString( after ) );
        } else {
            return Status.passed( "After removeAll invocation, attribute value is " + collString( control ) + " (duplicate value was " + "rejected" );
        }
    }

    private boolean equalLists( List<? extends Object> a, List<? extends Object> b ) {

        if ( a.size( ) != b.size( ) ) {
            return false;
        }
        for ( int i = 0; i < a.size( ); i++ ) {
            if ( !a.get( i ).equals( b.get( i ) ) ) {
                return false;
            }
        }
        return true;
    }

}
