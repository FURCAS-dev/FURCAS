/*
 * Created on 03.01.2005
 */
package com.sap.tc.moin.repository.test.core;

import java.util.Collection;
import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.CompositionCycleException;
import com.sap.tc.moin.repository.mmi.reflect.DuplicateException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;


public class TestCompositionHierarchyTraversal extends CoreMoinTest {


    private MofPackage p;

    private MofPackage tp;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        p = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        p.setName( "myPackage" );

        MofPackage c = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        c.setName( "MyPackage2" );
        c.setContainer( p );

        tp = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        MofPackage tp_child1 = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );
        MofPackage tp_child2 = getMOINConnection( ).getNullPartition( ).createElement( MofPackage.class );

        tp.getContents( ).add( tp_child1 );
        tp_child1.getContents( ).add( tp_child2 );


    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        p = null;
        tp = null;
    }

    /**
     * Intentionally causes a composition cycle exception, once by using an
     * object as its own child, and another time by causing a cycle that spans
     * two levels.
     */
    @Test
    public void testCompositionCycle( ) {

        try {
            p.getContents( ).add( p );
            fail( "No exception caused by adding package as its own contained element" );
        } catch ( CompositionCycleException cce ) {
            // expected
        }
        MofPackage c = (MofPackage) p.getContents( ).iterator( ).next( );
        try {
            c.getContents( ).add( p );
            flop( "No exception caused by adding package as contained element of a second package owned by the first package" );
        } catch ( CompositionCycleException cce ) {
            // expected
        }
    }


    @Test
    public void testCompositionTraversal( ) {

        RefObject[] rootsToVerify = new RefObject[] { p, tp };
        for ( int r = 0; r < rootsToVerify.length; r++ ) {
            testCompositionTraversalForSubtree( rootsToVerify[r] );
        }
    }

    /**
     * Tests the composition traverser for the subtree rooted by the element
     * passed.
     */
    protected void testCompositionTraversalForSubtree( RefObject subtreeRoot ) {

        JmiHelper jmiHelper = getMOINConnection( ).getJmiHelper( );
        Collection<RefObject> rootsChildren = jmiHelper.getCompositeChildren( subtreeRoot, false /* recursively */);
        for ( Iterator<RefObject> i = rootsChildren.iterator( ); i.hasNext( ); ) {
            RefObject ro = i.next( );
            assertEquals( "expected to find parent again", subtreeRoot, ro.refImmediateComposite( ) );
            testCompositionTraversalForSubtree( ro );
        }
    }

    /**
     * Creates an instance of a class that owns objects as attribute values,
     * then tests composition and delete propagation. A few tests regarding
     * uniqueness constraints are also performed.
     */
    @Test
    public void testObjectValuedAttributeComposition( ) {

        A4 a = getMOINConnection( ).createElementInPartition( A4.class, null );
        B4 b1 = getMOINConnection( ).createElementInPartition( B4.class, null );
        B4 b2 = getMOINConnection( ).createElementInPartition( B4.class, null );
        B4 b3 = getMOINConnection( ).createElementInPartition( B4.class, null );
        B4 b4 = getMOINConnection( ).createElementInPartition( B4.class, null );
        B4 b5 = getMOINConnection( ).createElementInPartition( B4.class, null );

        a.setOneBchangeable( b1 );
        boolean assocChanged = false;

        a.getManyBsNotUnique( ).add( b2 );
        a.getManyBsNotUnique( ).add( b3 );
        assocChanged = a.getManyBsNotUnique( ).add( b2 );
        verify( assocChanged, "Expected to be able to add same value again to non-unique attribute" );

        Collection<B4> listManyBsNotUnique = a.getManyBsNotUnique( );
        int countBs = 0;
        for ( B4 bFromList : listManyBsNotUnique ) {
            if ( bFromList.equals( b2 ) ) {
                countBs++;
            }
        }
        assertEquals( 2, countBs );

        a.getManyBsUnique( ).add( b4 );
        a.getManyBsUnique( ).add( b5 );
        try {
            assocChanged = a.getManyBsUnique( ).add( b4 );
            flop( "Adding same value to unique attribute again must throw a DuplicateException." );
        } catch ( DuplicateException de ) {
            // thrown as expected
        }

        RefFeatured b1Owner = b1.refImmediateComposite( );
        RefFeatured b2Owner = b2.refImmediateComposite( );
        RefFeatured b4Owner = b4.refImmediateComposite( );

        verify( a.equals( b1Owner ), "Owner of b1 should've been a but was " + b1Owner );
        verify( a.equals( b2Owner ), "Owner of b2 should've been a but was " + b2Owner );
        verify( a.equals( b4Owner ), "Owner of b4 should've been a but was " + b4Owner );
    }
}