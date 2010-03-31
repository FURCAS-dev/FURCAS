package com.sap.tc.moin.primary.facility.test.ide;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sap.junit.Staged;
import com.sap.mi.gfw.mm.datatypes.Color;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.pictograms.Polygon;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreInstanceManager;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionManager;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.testcases.case004.A4;

/**
 */
public class TestCrossPartitionAttributeLinks extends FacilityIdeMoinTest {


    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

    }

    @Test
    public void testCrossPartitionObjectValuedAttributes( ) throws Exception {

        Connection connection = getMoinConnection( );

        RefClass polygonClass = connection.getClass( Polygon.CLASS_DESCRIPTOR );
        RefClass pointClass = connection.getClass( Point.CLASS_DESCRIPTOR );

        Polygon polygon1 = (Polygon) polygonClass.refCreateInstance( );
        Point location = (Point) pointClass.refCreateInstance( );
        polygon1.setLocation( location );

        Color color = (Color) connection.getClass( Color.CLASS_DESCRIPTOR ).refCreateInstance( );
        polygon1.setBackground( color );

        Point point1 = (Point) pointClass.refCreateInstance( );
        Point point2 = (Point) pointClass.refCreateInstance( );

        List<Point> points = polygon1.getPoints( );
        points.add( point1 );
        points.add( point2 );

        getPartitionOne( ).assignElement( polygon1 );
        getPartitionOne( ).assignElement( location );
        getPartitionOne( ).assignElement( point1 );
        getPartitionTwo( ).assignElement( point2 );
        getPartitionTwo( ).assignElement( color );

        connection.save( );

        CoreConnection conn = getTestHelper( ).getCoreConnection( connection );

        //make sure that the data is read from the filesystem again as we want to test 
        //that the index gets the correct information about cross attribute links from the file
        getIdeFacilityDispatcher( ).refreshFromFileSystem( getIdeFacilityDispatcher( ).getProject( getPartitionOne( ).getPri( ).getCri( ) ), true );

        Color readColor = null;
        Point readPoint2 = null;
        for ( Partitionable element : getPartitionTwo( ).getElements( ) ) {
            if ( element instanceof Color ) {
                readColor = (Color) element;
            } else if ( element instanceof Point ) {
                readPoint2 = (Point) element;
            }
        }

        assertEquals( "Expected composite parent of Color to be the Polygon", polygon1, readColor.refImmediateComposite( ) );
        assertEquals( "Expected composite parent of Point2 to be the Polygon", polygon1, readPoint2.refImmediateComposite( ) );
    }

    @Test( timeout = 30000 )
    // the test can currently run into a deadlock!!! 
    @Staged
    public void testErrorOnPartitionLoad( ) throws Exception {

        // Create elements
        A4 a4 = this.getPartitionOne( ).createElement( A4.class );
        getMoinConnection( ).save( );

        // Get stream of saved partition
        IdeCompoundDataAreaManager dispatcher = getIdeFacilityDispatcher( );
        File file = dispatcher.getFile( getPartitionOne( ).getPri( ) ).getLocation( ).toFile( );
        try {
            InputStream stream = new FileInputStream( file );
            String text = parseIsToString( stream );
            // remove the very last XML element, resulting in a corrupt XML file
            StringBuffer buffer = new StringBuffer( text );
            String endPartitionString = "</Partition";
            int indexOfEndPartitionStart = text.indexOf( endPartitionString );
            int indexOfEndPartitionEnd = text.indexOf( ">", indexOfEndPartitionStart + endPartitionString.length( ) ) + 1;
            assertTrue( indexOfEndPartitionStart != -1 );
            buffer.replace( indexOfEndPartitionStart, indexOfEndPartitionEnd, " " );
            String newText = buffer.toString( );
            // use java.io.File for writing the modified file to avoid resource change events and bypass the index
            FileOutputStream fos = new FileOutputStream( file );
            fos.write( newText.getBytes( ) );
            fos.close( );
            // now trigger the loading of the corrupt partition
            ModelPartition mp = getSecondMOINConnection( ).getPartition( getPartitionOne( ).getPri( ) );
            assertNull( mp );
            CorePartitionManager partitionManager = getTestHelper( ).getCoreConnection( getSecondMOINConnection( ) ).getSession( ).getWorkspace( ).getPartitionManager( );
            Collection<CoreModelPartition> loadedPartitionsLive = partitionManager.getLoadedPartitionsLive( );
            assertFalse( loadedPartitionsLive.contains( getTestHelper( ).getCoreModelPartition( mp ) ) );
            // The partition was not returned at the API and is not contained in the 'loadedPartitions' collection.
            // Now check the existence of the A4 instance via API and by inspecting the InstanceManager.
            MRI mri = ( (Partitionable) a4 ).get___Mri( );
            RefBaseObject element = getSecondMOINConnection( ).getElement( mri );
            assertNull( element );
            CoreInstanceManager instanceManager = getTestHelper( ).getCoreConnection( getSecondMOINConnection( ) ).getSession( ).getWorkspace( ).getInstanceManager( );
            CorePartitionable instance = instanceManager.getInstance( mri );
            assertNull( instance );
        } finally {
            if ( file != null ) {
                file.delete( );
                dispatcher.refreshFromFileSystem( dispatcher.getProject( getPartitionOne( ).getPri( ).getCri( ) ), true /* forced */);
            }
        }
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
