package com.sap.tc.moin.primary.facility.test.ide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.eclipse.core.resources.IFile;
import org.junit.Test;

import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;


/**
 * Test the partition load for merge
 * 
 * @author D046220
 */
public class TestLoadPartitionForMerge extends FacilityIdeMoinTest {

    @Test
    public void testLoadPartitionForMerge( ) throws Exception {

        MofClass mofClass = this.getPartitionOne( ).createElement( MofClass.class );
        mofClass.setName( "MofClassName1" );
        getConnectionOne( ).save( );
        LRI lri = ( (Partitionable) mofClass ).get___Mri( ).getLri( );

        IdeCompoundDataAreaManager dispatcher = getIdeFacilityDispatcher( );
        IFile file = dispatcher.getFile( getPartitionOne( ).getPri( ) );
        InputStream stream = file.getContents( );

        String text = parseIsToString( stream );
        StringBuffer buffer = new StringBuffer( text );
        int indexOfMofClassName = text.indexOf( "MofClassName1" );
        buffer.replace( indexOfMofClassName, indexOfMofClassName + ( "MofClassName1".length( ) ), "MofClassName2" );

        String newText = buffer.toString( );

        InputStream newContent = parseStringToIs( newText );

        ModelPartition mp = UtilitiesFactory.getConnectionUtil( ).loadPartition( getConnectionTwo( ), getPartitionOne( ).getPri( ), newContent );
        assertNotNull( mp );
        assertEquals( getPartitionOne( ).getPri( ), mp.getPri( ) );

        // Check if loaded partition is considered as "dirty"
        Collection<ModelPartition> partitionsToBeSaved = getConnectionTwo( ).getPartitionsToBeSaved( );
        boolean loadedPartitionIsDirty = false;
        for ( ModelPartition modelPartition : partitionsToBeSaved ) {
            if ( modelPartition.getPri( ).equals( mp.getPri( ) ) ) {
                loadedPartitionIsDirty = true;
                break;
            }
        }
        assertTrue( loadedPartitionIsDirty );


        MofClass mofClassFromConn1 = (MofClass) getConnectionOne( ).getElement( lri );
        MofClass mofClassFromConn2 = (MofClass) getConnectionTwo( ).getElement( lri );
        assertEquals( "MofClassName1", mofClassFromConn1.getName( ) );
        assertEquals( "MofClassName2", mofClassFromConn2.getName( ) );
        // no-op
        getConnectionTwo( ).save( );

        // With first connection save should be OK
        getConnectionOne( ).save( );

        // Revert connection and see if save is OK again
        getConnectionTwo( ).revert( );
        getConnectionTwo( ).save( );

        // Now both connections should show up with the old name again
        mofClassFromConn1 = (MofClass) getConnectionOne( ).getElement( lri );
        mofClassFromConn2 = (MofClass) getConnectionTwo( ).getElement( lri );
        assertEquals( "MofClassName1", mofClassFromConn1.getName( ) );
        assertEquals( "MofClassName1", mofClassFromConn2.getName( ) );

    }

    @Test
    public void testLoadNonExistingPri( ) throws Exception {

        MofClass mofClass = this.getPartitionOne( ).createElement( MofClass.class );
        mofClass.setName( "MofClassName1" );
        getConnectionOne( ).save( );
        LRI lri = ( (Partitionable) mofClass ).get___Mri( ).getLri( );

        IdeCompoundDataAreaManager dispatcher = getIdeFacilityDispatcher( );
        IFile file = dispatcher.getFile( getPartitionOne( ).getPri( ) );
        InputStream stream = file.getContents( );

        String text = parseIsToString( stream );
        StringBuffer buffer = new StringBuffer( text );
        int indexOfMofClassName = text.indexOf( "MofClassName1" );
        buffer.replace( indexOfMofClassName, indexOfMofClassName + ( "MofClassName1".length( ) ), "MofClassName2" );

        String newText = buffer.toString( );

        InputStream newContent = parseStringToIs( newText );

        String priString = getPartitionOne( ).getPri( ).toString( );
        priString = priString.substring( 0, priString.lastIndexOf( '.' ) ) + "NonExisting" + priString.substring( priString.lastIndexOf( '.' ) );
        PRI nonExistingPri = getFacility( ).getRIFactory( ).createPri( priString );

        ModelPartition mp = UtilitiesFactory.getConnectionUtil( ).loadPartition( getConnectionTwo( ), nonExistingPri, newContent );
        assertNotNull( mp );
        assertEquals( nonExistingPri, mp.getPri( ) );

        // Check if loaded partition is considered as "dirty"
        Collection<ModelPartition> partitionsToBeSaved = getConnectionTwo( ).getPartitionsToBeSaved( );
        boolean loadedPartitionIsDirty = false;
        for ( ModelPartition modelPartition : partitionsToBeSaved ) {
            if ( modelPartition.getPri( ).equals( nonExistingPri ) ) {
                loadedPartitionIsDirty = true;
                break;
            }
        }
        assertTrue( loadedPartitionIsDirty );


        MofClass mofClassFromConn1 = (MofClass) getConnectionOne( ).getElement( lri );
        MofClass mofClassFromConn2 = (MofClass) getConnectionTwo( ).getElement( lri );
        assertEquals( "MofClassName1", mofClassFromConn1.getName( ) );
        assertEquals( "MofClassName2", mofClassFromConn2.getName( ) );
        // no-op
        getConnectionTwo( ).save( );

        // With first connection save should be OK
        getConnectionOne( ).save( );

        // Revert connection and see if save is OK again
        getConnectionTwo( ).revert( );
        getConnectionTwo( ).save( );

        // Now both connections should show up with the old name again
        mofClassFromConn1 = (MofClass) getConnectionOne( ).getElement( lri );
        mofClassFromConn2 = (MofClass) getConnectionTwo( ).getElement( lri );
        assertEquals( "MofClassName1", mofClassFromConn1.getName( ) );
        assertEquals( "MofClassName1", mofClassFromConn2.getName( ) );

    }

    public String parseIsToString( InputStream is ) throws IOException {

        BufferedReader din = new BufferedReader( new InputStreamReader( is, "UTF-8" ) );
        StringBuffer sb = new StringBuffer( );
        try {
            String line = null;
            while ( ( line = din.readLine( ) ) != null ) {
                sb.append( line + "\n" );
            }
        } catch ( Exception ex ) {
            ex.getMessage( );
        } finally {
            try {
                is.close( );
            } catch ( Exception ex ) {
            }
        }
        return sb.toString( );
    }

    public InputStream parseStringToIs( String str ) {

        if ( str == null ) {
            return null;
        }
        str = str.trim( );
        InputStream in = null;
        try {
            in = new java.io.ByteArrayInputStream( str.getBytes( "UTF-8" ) );
        } catch ( Exception ex ) {
        }
        return in;
    }



}
