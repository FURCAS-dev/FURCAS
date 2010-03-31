package com.sap.tc.moin.repository.test.core;

import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;

import org.junit.Test;

import com.sap.moin.mm.gfw.datatypes.Point;
import com.sap.moin.mm.gfw.pictograms.Polygon;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionManager;

public class TestCrossPartitionObjectValuedAttributes extends CoreMoinTest {

    @Test
    public void testCrossPartitionObjectValuedAttributes( ) throws Exception {

        Connection connection = getMOINConnection( );

        Polygon polygon1 = connection.createElementInPartition( Polygon.class, null );
        Point point1 = connection.createElementInPartition( Point.class, null );
        Point point2 = connection.createElementInPartition( Point.class, null );

        List<Point> points = polygon1.getPoints( );
        points.add( point1 );
        points.add( point2 );

        getPartitionOne( ).assignElement( polygon1 );
        getPartitionOne( ).assignElement( point1 );
        getPartitionTwo( ).assignElement( point2 );

        connection.save( );

        evictPartitions1and2( );

        //        Collection<Partitionable> elements = getPartitionOne().getElements();
        //        for (Partitionable partitionable : elements) {
        //            if (partitionable instanceof Polygon) {
        //                List<Point> readPoints = ((Polygon) partitionable).getPoints();
        //                assertTrue("Expected Polygon instance to have two Point instances", readPoints.size() == 2);
        //                assertTrue("Expected Point 1 to be a member of partitionOne", ((Partitionable) readPoints.get(0))
        //                    .get___Partition().equals(getPartitionOne()));
        //                assertTrue("Expected Point 2 to be a member of partitionTwo", ((Partitionable) readPoints.get(1))
        //                    .get___Partition().equals(getPartitionTwo()));
        //                break;
        //            }
        //        }

        //        evictPartitions1and2();

        Point readPoint2 = (Point) getPartitionTwo( ).getElements( ).iterator( ).next( );
        RefFeatured refImmediateComposite = readPoint2.refImmediateComposite( );
        assertTrue( "Expected composite parent of Point 2 to be the Polygon", refImmediateComposite.equals( polygon1 ) );
    }

    private void evictPartitions1and2( ) {

        CoreConnection conn = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        CorePartitionManager partitionManager = conn.getSession( ).getWorkspace( ).getPartitionManager( );
        partitionManager.evictPartitionForced( getTestHelper( ).getCoreModelPartition( getPartitionOne( ) ) );
        partitionManager.evictPartitionForced( getTestHelper( ).getCoreModelPartition( getPartitionTwo( ) ) );
    }
}