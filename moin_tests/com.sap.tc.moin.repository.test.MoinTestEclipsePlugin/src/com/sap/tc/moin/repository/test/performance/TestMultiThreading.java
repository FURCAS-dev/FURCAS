package com.sap.tc.moin.repository.test.performance;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.moin.mm.gfw.datatypes.Color;
import com.sap.moin.mm.gfw.datatypes.Dimension;
import com.sap.moin.mm.gfw.datatypes.Point;
import com.sap.moin.mm.gfw.graphics.GraphicsPackage;
import com.sap.moin.mm.gfw.pictograms.ChopboxAnchor;
import com.sap.moin.mm.gfw.pictograms.ContainerShape;
import com.sap.moin.mm.gfw.pictograms.Diagram;
import com.sap.moin.mm.gfw.pictograms.HorizontalConnection;
import com.sap.moin.mm.gfw.pictograms.Polyline;
import com.sap.moin.mm.gfw.pictograms.Rectangle;
import com.sap.moin.mm.gfw.pictograms.Shape;
import com.sap.moin.mm.gfw.pictograms.Text;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestClientFactory;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * This test case simulates several different users working on the same Moin
 * instance in parallel, performing tasks like creating an in-memory model,
 * assigning the model elements to a partition, saving the partition and
 * executing a query.
 */
public class TestMultiThreading extends CoreMoinTest {

    private static final int NUM_THREADS = 10;

    private static final int NUM_RUNS_PER_THREAD = 10;

    private Thread[] workers = new Thread[NUM_THREADS];

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
    public void testMultiThreading( ) throws Exception {

        ConcurrentLinkedQueue<String> report = new ConcurrentLinkedQueue<String>( );
        TestClientFactory factory = getTestHelper( ).getTestClientFactory( "PF" );
        for ( int i = 0; i < NUM_THREADS; i++ ) {
            TestClient testClient = factory.getTestClient( i, i, true );
            String name = "Worker-" + ( i + 1 );
            workers[i] = new Thread( new Worker( name, testClient, report ), name );
        }
        long startTime = System.nanoTime( );
        for ( int i = 0; i < NUM_THREADS; i++ ) {
            workers[i].start( );
        }
        for ( int i = 0; i < NUM_THREADS; i++ ) {
            workers[i].join( );
        }
        long duration = System.nanoTime( ) - startTime;
        for ( String item : report ) {
            System.out.println( item );
        }
        System.out.println( "Total runtime: " + ( duration / 1e9 ) + " sec" );
    }

    private static final class Worker implements Runnable {

        private final String name;

        private final Connection connection;

        private long startTime;

        private GraphicsPackage graphicsPackage;

        private Queue<String> report;

        private Worker( String name, TestClient testClient, Queue<String> report ) {

            this.name = name;
            this.connection = testClient.getConnection( );
            this.report = report;
        }

        public void run( ) {

            startTime = System.nanoTime( );
            try {
                getGraphicsPackage( );
                for ( int i = 0; i < NUM_RUNS_PER_THREAD; i++ ) {
                    executeQuery( saveModel( createModel( ) ) );
                }
                reportTime( );
                // Thread.sleep(1000000);
            } catch ( RuntimeException ex ) {
                throw ex;
            } catch ( Exception ex ) {
                throw new RuntimeException( ex );
            } finally {
                connection.close( );
            }
        }

        private void getGraphicsPackage( ) {

            graphicsPackage = (GraphicsPackage) connection.getPackage( TestMetaModels.GFW_CN, TestMetaModels.GFW_TPE );
        }

        @SuppressWarnings( "unchecked" )
        private Partitionable createModel( ) {

            assertNotNull( graphicsPackage );
            Diagram myDiagram = (Diagram) graphicsPackage.getPictograms( ).getDiagram( ).refCreateInstance( );
            assertNotNull( myDiagram );
            ContainerShape myContainerShape2 = (ContainerShape) graphicsPackage.getPictograms( ).getContainerShape( ).refCreateInstance( );
            myDiagram.getChildren( ).add( myContainerShape2 );
            Shape myShape2 = (Shape) graphicsPackage.getPictograms( ).getShape( ).refCreateInstance( );
            myContainerShape2.getChildren( ).add( myShape2 );
            Text myText2 = (Text) graphicsPackage.getPictograms( ).getText( ).refCreateInstance( );
            myShape2.setGraphicsAlgorithm( myText2 );
            myText2.setValue( "This is the text of Shape 2" );
            Color myColor1 = (Color) graphicsPackage.getDatatypes( ).getColor( ).refCreateInstance( );
            myText2.setBackground( myColor1 );
            ContainerShape myContainerShape3 = (ContainerShape) graphicsPackage.getPictograms( ).getContainerShape( ).refCreateInstance( );
            myContainerShape2.getChildren( ).add( myContainerShape3 );
            Rectangle myRectangle = (Rectangle) graphicsPackage.getPictograms( ).getRectangle( ).refCreateInstance( );
            myContainerShape3.setGraphicsAlgorithm( myRectangle );
            ChopboxAnchor myAnchor3 = (ChopboxAnchor) graphicsPackage.getPictograms( ).getChopboxAnchor( ).refCreateInstance( );
            myContainerShape3.getAnchors( ).add( myAnchor3 );
            Polyline myPolyline = (Polyline) graphicsPackage.getPictograms( ).getPolyline( ).refCreateInstance( );
            Dimension mySize = (Dimension) graphicsPackage.getDatatypes( ).getDimension( ).refCreateInstance( );
            Point myLocation = (Point) graphicsPackage.getDatatypes( ).getPoint( ).refCreateInstance( );
            Color myColor2 = (Color) graphicsPackage.getDatatypes( ).getColor( ).refCreateInstance( );
            myPolyline.setSize( mySize );
            myPolyline.setLocation( myLocation );
            myPolyline.setBackground( myColor2 );
            Point myPoint1 = (Point) graphicsPackage.getDatatypes( ).getPoint( ).refCreateInstance( );
            Point myPoint2 = (Point) graphicsPackage.getDatatypes( ).getPoint( ).refCreateInstance( );
            Point myPoint3 = (Point) graphicsPackage.getDatatypes( ).getPoint( ).refCreateInstance( );
            myPolyline.getPoints( ).add( myPoint1 );
            myPolyline.getPoints( ).add( myPoint2 );
            myPolyline.getPoints( ).add( myPoint3 );
            myContainerShape2.setGraphicsAlgorithm( myPolyline );
            ChopboxAnchor myAnchor2 = (ChopboxAnchor) graphicsPackage.getPictograms( ).getChopboxAnchor( ).refCreateInstance( );
            myContainerShape2.getAnchors( ).add( myAnchor2 );
            Shape myShape1 = (Shape) graphicsPackage.getPictograms( ).getShape( ).refCreateInstance( );
            myDiagram.getChildren( ).add( myShape1 );
            Text myText1 = (Text) graphicsPackage.getPictograms( ).getText( ).refCreateInstance( );
            myShape1.setGraphicsAlgorithm( myText1 );
            myText1.setValue( "This is the text of Shape 1" );
            Shape myShape3 = (Shape) graphicsPackage.getPictograms( ).getShape( ).refCreateInstance( );
            myDiagram.getChildren( ).add( myShape3 );
            HorizontalConnection myConnection23 = (HorizontalConnection) graphicsPackage.getPictograms( ).getHorizontalConnection( ).refCreateInstance( );
            myConnection23.setStart( myAnchor2 );
            myConnection23.setEnd( myAnchor3 );
            myDiagram.getConnections( ).add( myConnection23 );
            HorizontalConnection myConnection22 = (HorizontalConnection) graphicsPackage.getPictograms( ).getHorizontalConnection( ).refCreateInstance( );
            myConnection22.setStart( myAnchor2 );
            myConnection22.setEnd( myAnchor2 );
            myDiagram.getConnections( ).add( myConnection22 );
            return (Partitionable) myDiagram;
        }

        private PRI saveModel( Partitionable rootElement ) throws Exception {

            PRI pri = connection.getSession( ).getMoin( ).createPri( "PF.LocalDevelopment[local]:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/" + name + ".mointest" );
            ModelPartition partition = connection.getPartition( pri );
            if ( partition != null ) {
                partition.delete( );
            }
            partition = connection.createPartition( pri );
            partition.assignElementIncludingChildren( rootElement );
            connection.save( );
            return pri;
        }

        private void reportTime( ) {

            report.add( name + ": total runtime was: " + ( ( System.nanoTime( ) - startTime ) / 1e9 ) + " sec" );
        }

        private void executeQuery( PRI pri ) {

            MQLProcessor mqlProcessor = connection.getMQLProcessor( );
            String query = "select diagram from \"sap.com/com/sap/moin/mm/gfw\"#pictograms::Diagram as diagram in partitions {\"PF.LocalDevelopment[local]:DCs/test.sap.com/tc/moin/repository/test/_comp/src/moin_unit_test/" + name + ".mointest\"}";
            MQLResultSet resultSet = mqlProcessor.execute( query );
            assertTrue( resultSet.getSize( ) == 1 );
        }
    }
}