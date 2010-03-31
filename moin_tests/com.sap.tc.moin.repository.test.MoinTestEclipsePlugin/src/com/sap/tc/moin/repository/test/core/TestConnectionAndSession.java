package com.sap.tc.moin.repository.test.core;

import java.util.Collection;
import java.util.HashSet;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.InvalidConnectionException;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.impl.MoinImpl;
import com.sap.tc.moin.repository.core.impl.SessionImpl;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * Tests connections, sessions etc.
 */
public class TestConnectionAndSession extends CoreMoinTest {

    private CoreMoin moin;

    private CompoundClientSpec compoundClientSpec0_user0;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        this.moin = getTestHelper( ).getCoreMoin( );

        SpiCompoundDataAreaManager dataAreaManager = (SpiCompoundDataAreaManager) moin.getCompoundDataAreaManager( );

        compoundClientSpec0_user0 = dataAreaManager.getDefaultCompoundClientSpec( _testClient1.getClientSpec( ) );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        moin = null;
        compoundClientSpec0_user0 = null;
    }

    @Test
    public void testUnmodifiableGetClientSpecs( ) throws Exception {

        Collection<ClientSpec> clientSpecs = this.compoundClientSpec0_user0.getClientSpecs( );
        assertUnmodifiableCollection( clientSpecs );
    }

    /**
     * Gets a Connection from a Facility and verifies it
     */
    @Test
    public void testSessionGrouping( ) throws Exception {

        int initialNumberOfSessions = ( (MoinImpl) this.moin ).getNumberOfSessions( );

        Connection connection0 = null;
        Connection connection1 = null;
        {
            //use the same clientspec twice in order to see if that is handled correctly by the MOIN
            CompoundClientSpec compoundClientSpec0 = this.compoundClientSpec0_user0;
            CompoundClientSpec compoundClientSpec1 = this.compoundClientSpec0_user0;

            connection0 = this.moin.createSession( compoundClientSpec0 ).createConnection( );
            connection1 = this.moin.createSession( compoundClientSpec1 ).createConnection( );
        }

        CoreSession session = ( (CoreConnection) connection0 ).getSession( );
        // verify removed: createConnection creates more than one session        
        //        verify(session == ((CoreConnection) connection1).getSession(),
        //            "expected to receive the same session");

        Collection<Connection> allConnections = new HashSet<Connection>( );
        allConnections.addAll( ( (SessionImpl) connection0.getSession( ) ).getConnections( ) );
        allConnections.addAll( ( (SessionImpl) connection1.getSession( ) ).getConnections( ) );

        verify( allConnections.contains( connection0 ) && allConnections.contains( connection1 ), "one or more connections are missing" );

        //connection0.save();
        for ( Connection connection : allConnections ) {
            connection.close( );
        }

        if ( session.isAlive( ) ) {
            verify( ( ( (SessionImpl) session ).getConnections( ).size( ) - initialNumberOfSessions ) == 0, "not all connections removed from Session" );
        }

    }



    @Test( expected = IllegalArgumentException.class )
    public void testGetPackage( ) throws Exception {

        getMOINConnection( ).getPackage( "DummyContainer" );
    }

    private void gc( long sleepUntilGarbageCollection ) throws InterruptedException {

        for ( int i = 0; i < 10; i++ ) {
            System.gc( );
        }
        Thread.sleep( sleepUntilGarbageCollection );
        for ( int i = 0; i < 10; i++ ) {
            System.gc( );
        }
    }

    /**
     * Tests ID/Label API functionality
     */
    @Test
    public void testIdAndLabel( ) throws Exception {

        // label testing
        String originalLabel = "originalLabel";
        String changedLabel = "changedLabel";

        // Assumption that internal ID is session counter + connection counter (should be 2nd session)
        String connectionId = "002-001";
        Session session = getTestHelper( ).getMoin( ).createSession( compoundClientSpec0_user0 );
        Connection labeledConnection = session.createConnection( originalLabel );
        assertEquals( originalLabel, labeledConnection.getLabel( ) );
        labeledConnection.setLabel( changedLabel );
        assertEquals( changedLabel, labeledConnection.getLabel( ) );

        // id testing (since id is dynamic not assertEquals but just a assertNotNull) 
        assertNotNull( labeledConnection.getId( ) );

        // closed connection handling
        labeledConnection.close( );
        assertEquals( changedLabel, labeledConnection.getLabel( ) );
        assertNotNull( labeledConnection.getId( ) );
        try {
            labeledConnection.setLabel( originalLabel );
            throw new Exception( "Since Connection has been closed, setLabel should throw InvalidConnectionException." );
        } catch ( InvalidConnectionException e ) {
            // expected exception
        }

        // default handling
        session = getTestHelper( ).getMoin( ).createSession( compoundClientSpec0_user0 );
        Connection defaultConnection = session.createConnection( );
        assertEquals( null, defaultConnection.getLabel( ) );
        defaultConnection.close( );

        // Test for CSN  0120031469 0001602955 2007 - START
        // label containing MRI resulted in 
        // com.sap.tc.moin.repository.InvalidResourceIdentifierException: A partition resource identifier (PRI) must not contain a MOF id.
        session = getTestHelper( ).getMoin( ).createSession( compoundClientSpec0_user0 );
        Connection mriLabelConnection = session.createConnection( );

        ModelPackage mp = (ModelPackage) mriLabelConnection.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        MRI mri = ( (Partitionable) mp ).get___Mri( );
        mriLabelConnection.setLabel( "" + mri );
        mriLabelConnection.isDirty( );
        // Test for CSN  0120031469 0001602955 2007 - END

    }

    @Test
    public void testToString( ) throws Exception {

        Connection conn = getMOINConnection( );

        // Check that "toString" does not contain "dead"
        String toStringBeforeClose = conn.toString( );
        assertEquals( -1, toStringBeforeClose.indexOf( "DEAD" ) );

        // Close the connection
        conn.close( );

        // Check that "toString" now not contain "dead"
        String toStringAfterClose = conn.toString( );
        assertFalse( toStringAfterClose.indexOf( "DEAD" ) == -1 );
    }
}