package com.sap.tc.moin.facility.primary.test.index;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.facility.primary.query.index.memory.IndexBugException;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexModelElement;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexMofId;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexNamedModelElement;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexPri;
import com.sap.tc.moin.facility.primary.query.index.memory.IndexWeakHashReference;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.testcases.case002.B2;

public class TestIndexBasicDataStructures extends IndexTestCase {

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    @Test
    public void testIndexPri( ) throws Exception {

        ModelPartition mp = this._testClient1.getOrCreatePartition( "indexPri" );
        B2 b2 = this.createB2( );
        mp.assignElement( b2 );
        this.saveConnectionOne( );

        IndexPri idxPri = new IndexPri( mp.getPri( ), 1L );

        // getCachedPri()
        assertTrue( "getCachedPri(): Cached PRI is not the same instance as model partition PRI", idxPri.getCachedPri( ) == mp.getPri( ) );

        boolean failed = false;
        // hashCode()
        try {
            idxPri.hashCode( );
        } catch ( UnsupportedOperationException t ) {
            failed = true;
        }
        if ( failed ) {
            fail( "UnsupportedOperationException expected when calling hashCode() on IndexPri. Check if JVM is started with -ea." );
        }

        // getKeyElement() with unknown ID
        try {
            idxPri.getKeyElement( Integer.MAX_VALUE );
            fail( "IllegalArgumentException expected for getting" );
        } catch ( IndexBugException i ) {
            // expected
        }

        // equals() with an Object
        assertFalse( "Equals with a new Object should not be true", idxPri.equals( new Object( ) ) );

        mp.delete( );
        saveConnectionOne( );
    }

    @Test
    public void testIndexModelElement( ) throws Exception {

        IndexModelElement ime = this.index.getMofIdToElements( ).get( this.index.getMofIdFactory( ).getMofId( this.first ) );
        assertTrue( ime != null );

        // getKeyElement() with unknown ID
        try {
            ime.getKeyElement( Integer.MAX_VALUE );
            fail( "IllegalArgumentException expected for getting" );
        } catch ( IndexBugException i ) {
            // expected
        }

        boolean failed = false;
        // hashCode()
        try {
            ime.hashCode( );
            failed = true;
        } catch ( UnsupportedOperationException t ) {
            // expected
        }
        if ( failed ) {
            fail( "UnsupportedOperationException expected when calling hashCode() on IndexMOdelElement" );
        }

        // toString()
        try {
            String s = ime.toString( );
        } catch ( Exception e ) {
            fail( "Exception raised in toString() on IndexModelElement " + e.toString( ) );
        }

        // equals()
        assertTrue( "Identity comparison returns false", ime.equals( ime ) );
        assertFalse( "Comparison with an Object returns true", ime.equals( new Object( ) ) );
    }

    @Test
    public void testIndexNamedModelElement( ) throws Exception {

        String serviceInteractionTLPackage = "45ED7613F3D29ABA79E14F0301459ED01AB1D0C1";

        IndexNamedModelElement inme = (IndexNamedModelElement) this.index.getMofIdToElements( ).get( this.index.getMofIdFactory( ).getMofId( serviceInteractionTLPackage ) );

        // equals()
        assertTrue( "Identity comparison returns false", inme.equals( inme ) );
        assertFalse( "Comparison with an Object returns true", inme.equals( new Object( ) ) );

        boolean failed = false;
        // hashCode()
        try {
            inme.hashCode( );
            failed = true;
        } catch ( UnsupportedOperationException t ) {
            // expected
        }
        if ( failed ) {
            fail( "UnsupportedOperationException expected when calling hashCode() on IndexNamedModelElement" );
        }
    }

    @Test
    public void testIndexWeakHashReference( ) throws Exception {

        String serviceInteractionTLPackage = "45ED7613F3D29ABA79E14F0301459ED01AB1D0C1";

        IndexMofId mofId = this.index.getMofIdFactory( ).createMofId( serviceInteractionTLPackage );

        IndexWeakHashReference<IndexMofId> ref = new IndexWeakHashReference<IndexMofId>( mofId, null, 1 );
        IndexWeakHashReference<IndexMofId> ref2 = new IndexWeakHashReference<IndexMofId>( mofId, null, 1 );
        IndexWeakHashReference<IndexMofId> ref3 = new IndexWeakHashReference<IndexMofId>( mofId, null, 2 );

        // toString()
        ref.toString( );

        // hashCode()
        boolean failed = false;
        try {
            ref.hashCode( );
            failed = true;
        } catch ( UnsupportedOperationException ae ) {
            // expected
        }
        if ( failed ) {
            fail( "expected UnsupportedOperationException when calling hashCode()" );
        }

        // equals()
        assertTrue( "identity comparison returned false", ref.equals( ref ) );
        assertFalse( "comparison with Object returned true", ref.equals( new Object( ) ) );
        assertTrue( "compairson of references with same position returned false", ref.equals( ref2 ) );
        assertFalse( "comparison of references with different positions returned true", ref.equals( ref3 ) );
    }
}
