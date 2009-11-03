package com.sap.tc.moin.repository.test.graphicsfw;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.moin.mm.gfw.datatypes.Point;
import com.sap.moin.mm.gfw.graphics.GraphicsPackage;
import com.sap.moin.mm.gfw.pictograms.ContainerShape;
import com.sap.moin.mm.gfw.pictograms.Diagram;
import com.sap.moin.mm.gfw.pictograms.GraphicsAlgorithm;
import com.sap.moin.mm.gfw.pictograms.PictogramElement;
import com.sap.tc.logging.Category;
import com.sap.tc.logging.Location;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * Performance test for graphics framework test and JMI generation. TODO:
 * consider moving this test outside of GFW tests TODO: adjust method
 * generateJmi so that it is independent of environment (local XMI files)
 */
public class TestMoinPerformance extends MoinTestCase {

    private boolean confirm = false;

    private int repetitions = 1000;

    private long startTime = 0;

    private long generationTime = 0;

    private long startupTime = 0;

    private long mmTime = 0;

    private long saveTime = 0;

    private long repeatedModificationTime = 0;

    private long navigationTime = 0;

    private long modelCreationTime = 0;

    private long modelModificationTime = 0;

    private long shutdownTime = 0;

    protected RepositoryFacade repository;

    protected GraphicsPackage graphicsPackage;

    protected ModelPackage modelPackage;

    private Diagram diagram = null;

    protected Map mapOfElements;

    public TestMoinPerformance( String arg0 ) {

        super( arg0 );
    }

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        repository = new MoinRepositoyFacadeImpl( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );

        // Delete the created model from the persistence and close the
        // connnection
        this.warn( "cleaning up...." );
        //        try{
        //            pmu.deleteModelAndCloseConnection();
        //        }catch (ModelNotFoundException mnf){
        //            fail("Model deleted before afterTestMethod()");
        //        }
        this.warn( "Cleaning up complete" );
    }


    /*
     * public static Test suite() { TestSuite tmpSuite= new
     * TestSuite(TestMoinPerformance.class.getName()); tmpSuite.addTest(new
     * TestMoinPerformance("testModelManipulation")); // this test uses the
     * memory facility and has to executed after the // tests using the
     * nwdi_db_facility setup. tmpSuite.addTest(new
     * TestMoinPerformance("testJmiGeneration")); return tmpSuite; }
     */
    /**
     * Tests the JMI generation
     * 
     * @throws Exception
     */
    @Test
    public void testJmiGeneration( ) throws Exception {

        if ( confirm ) {
            java.lang.System.out.println( "PAK to generate JMIs" );
            while ( java.lang.System.in.read( ) != 13 ) {
            }
            ;
        }
        this.info( "Generate JMIs" );
        startTime = System.currentTimeMillis( );
        generateJmi( );
        generationTime = System.currentTimeMillis( ) - startTime;
        this.info( "JMIs generated!!!" );
        java.lang.System.out.println( );
        java.lang.System.out.println( "Times" );
        java.lang.System.out.println( "-----------------------------" );
        java.lang.System.out.println( "Generation:      " + generationTime );
    }

    /**
     * Tests the model creation, persistence and modification of a pictograms
     * model
     * 
     * @throws Exception
     */
    @Test
    public void testModelManipulation( ) throws Exception {

        if ( confirm ) {
            java.lang.System.out.println( "Enter to initialize Moin" );
            while ( java.lang.System.in.read( ) != 13 ) {
            }
            ;
        }
        this.info( "Open a connection" );
        startTime = System.currentTimeMillis( );
        initConnection( );
        startupTime = System.currentTimeMillis( ) - startTime;
        this.info( "Connection opened!!!" );

        if ( confirm ) {
            java.lang.System.out.println( "Enter to load Metamodel" );
            while ( java.lang.System.in.read( ) != 13 ) {
            }
            ;
        }
        this.info( "Load Metamodel" );
        startTime = System.currentTimeMillis( );
        loadMetamodel( );
        mmTime = System.currentTimeMillis( ) - startTime;
        this.info( "Metamodel loaded!!!" );

        if ( confirm ) {
            java.lang.System.out.println( "Enter to Create Model" );
            while ( java.lang.System.in.read( ) != 13 ) {
            }
            ;
        }
        this.info( "Create Model" );
        startTime = System.currentTimeMillis( );
        createModel( );
        modelCreationTime = System.currentTimeMillis( ) - startTime;
        this.info( "Model created!!!" );

        if ( confirm ) {
            java.lang.System.out.println( "Enter to Navigate Model" );
            while ( java.lang.System.in.read( ) != 13 ) {
            }
            ;
        }
        this.info( "Navigate Model" );
        startTime = System.currentTimeMillis( );
        navigation( );
        navigationTime = System.currentTimeMillis( ) - startTime;
        this.info( "Model navigated!!! - noCSs:" + noCSs + " noGAs:" + noGAs );

        if ( confirm ) {
            java.lang.System.out.println( "Enter to Repeated Modification" );
            while ( java.lang.System.in.read( ) != 13 ) {
            }
            ;
        }
        this.info( "Repeated Model Modification" );
        startTime = System.currentTimeMillis( );
        repeatedModification( );
        repeatedModificationTime = System.currentTimeMillis( ) - startTime;
        this.info( "Model modified!!!" );

        if ( confirm ) {
            java.lang.System.out.println( "Enter to Modify Model" );
            while ( java.lang.System.in.read( ) != 13 ) {
            }
            ;
        }
        this.info( "Modify Model" );
        startTime = System.currentTimeMillis( );
        //modifyModel();
        modelModificationTime = System.currentTimeMillis( ) - startTime;
        this.info( "Model modified!!!" );

        if ( confirm ) {
            java.lang.System.out.println( "Enter to Save Model" );
            while ( java.lang.System.in.read( ) != 13 ) {
            }
            ;
        }
        this.info( "Save Model" );
        startTime = System.currentTimeMillis( );
        saveModel( );
        saveTime = System.currentTimeMillis( ) - startTime;
        this.info( "Model Saved!!!" );

        cleanup( );

        if ( confirm ) {
            java.lang.System.out.println( "Enter to Close Moin" );
            while ( java.lang.System.in.read( ) != 13 ) {
            }
            ;
        }
        this.info( "Close connection" );
        startTime = System.currentTimeMillis( );
        closeConnection( );
        shutdownTime = System.currentTimeMillis( ) - startTime;
        this.info( "Connection closed!!!" );

        java.lang.System.out.println( );
        java.lang.System.out.println( "Times" );
        java.lang.System.out.println( "-----------------------------" );
        java.lang.System.out.println( "Startup:      " + startupTime );
        java.lang.System.out.println( "Load MM:      " + mmTime );
        java.lang.System.out.println( "Creation:     " + modelCreationTime );
        java.lang.System.out.println( "Navigation:   " + navigationTime );
        java.lang.System.out.println( "RepeatedMod.: " + repeatedModificationTime );
        java.lang.System.out.println( "Modification: " + modelModificationTime );
        java.lang.System.out.println( "Save:         " + saveTime );
        java.lang.System.out.println( "Shutdown:     " + shutdownTime );

        java.lang.System.out.println( startupTime );
        java.lang.System.out.println( mmTime );
        java.lang.System.out.println( modelCreationTime );
        java.lang.System.out.println( navigationTime );
        java.lang.System.out.println( repeatedModificationTime );
        java.lang.System.out.println( modelModificationTime );
        java.lang.System.out.println( saveTime );
        java.lang.System.out.println( shutdownTime );
    }

    protected void generateJmi( ) throws Exception {

        throw new UnsupportedOperationException( "JMI generation not possible in new testcases project - will be replaced soon." );
        /*
         * Steffen Huester: this thing makes trouble due to compile dependencies
         * to ant and requirements to the local environment (XMI files) at
         * runtime; we take this test out for now and check with Michael how to
         * improve this String jmiOutputFolder = "C:/temp"; File f = new
         * File(jmiOutputFolder); f.mkdirs(); // dirty to use main method and
         * system property, Stefan Jesse should provide a more convenient one,
         * MM System.setProperty("moin.bootstrap.configuration",
         * "build.bootstrap.properties"); MetamodelImporterMain.main(new
         * String[]{ "-xmiFile", getFile("xmis/graphics.xml").getAbsolutePath(),
         * "-configFile", getFile("xmis/graphics.properties").getAbsolutePath(),
         * "-jmiOutputFolder", jmiOutputFolder, "-verbose"});
         */
    }

    protected File getFile( String xmiFileName ) {

        String fullFileName = classDirectory( getClass( ) ) + "/" + xmiFileName;
        URL fileUrl = getClass( ).getClassLoader( ).getResource( fullFileName );
        File file = new File( fileUrl.getFile( ) );
        return file;
    }

    /*
     * protected String classDirectory(Class object) { String className =
     * object.getName(); String packageName = className.substring(0,
     * className.lastIndexOf('.')); return packageName.replace('.', '/'); }
     */
    protected void initConnection( ) throws RepositoryException {

        repository.getConnection( );
    }

    protected void loadMetamodel( ) {

        graphicsPackage = (GraphicsPackage) repository.selectRefPackage( GraphicsTestsUtil.GRAPHICS_CONTAINER_NAME, "graphics" );
    }

    protected void createModel( ) throws RepositoryException {

        mapOfElements = new HashMap( );
        diagram = GraphicsModelManipulation.createPictogramsModel( graphicsPackage, mapOfElements );
    }

    protected void saveModel( ) throws RepositoryException {

        repository.save( );
    }

    protected void closeConnection( ) throws RepositoryException {

        repository.closeConnection( );
    }

    protected void modifyModel( ) throws RepositoryException {

        GraphicsModelManipulation.modifyPictogramsModel( graphicsPackage, diagram, mapOfElements );
    }


    private int xc = 33;

    private int yc = 17;

    protected void setDiagramGA( ) {

        com.sap.tc.moin.repository.Connection conn = ( (Partitionable) graphicsPackage ).get___Connection( );
        GraphicsAlgorithm ga = conn.createElementInPartition( GraphicsAlgorithm.class, null );
        Point p = conn.createElementInPartition( Point.class, null );
        ga.setLocation( p );
        diagram.setGraphicsAlgorithm( ga );
    }

    protected void repeatedModification( ) {

        setDiagramGA( );
        Point p = getCSLocation( diagram );
        for ( int i = 0; i < repetitions; i++ ) {
            p.setX( xc++ );
            p.setY( yc++ );
        }
    }


    private int noCSs = 0;

    private int noGAs = 0;

    protected void navigation( ) {

        noCSs = 0;
        noGAs = 0;
        for ( int i = 0; i < repetitions; i++ ) {
            navigateCSGA( diagram );
        }
    }

    protected void navigateCSGA( ContainerShape cs ) {

        noCSs++;

        PictogramElement pe;
        Point p = getCSLocation( cs );
        if ( p != null ) {
            int x = p.getX( );
            int y = p.getY( );
        }

        Iterator it = cs.getChildren( ).iterator( );
        while ( it.hasNext( ) ) {
            pe = (PictogramElement) it.next( );
            if ( pe instanceof ContainerShape ) {
                navigateCSGA( (ContainerShape) pe );
            }
        }
    }

    protected Point getCSLocation( ContainerShape cs ) {

        Point ret = null;
        GraphicsAlgorithm ga = cs.getGraphicsAlgorithm( );
        noGAs++;
        if ( ga != null ) {
            ret = ga.getLocation( );
        }
        return ret;
    }

    protected void cleanup( ) throws RepositoryException {

        diagram.refDelete( );
        repository.save( );
    }

    // trace location and logging category
    private static final Location LOCATION = Location.getLocation( TestMoinPictogramModelCreationAndModification.class );

    private static final Category CATEGORY_MOIN = Category.getCategory( Category.APPLICATIONS, "ModelingInfrastructure" );

    private static final Category CATEGORY_TEST = Category.getCategory( CATEGORY_MOIN, "TEST" );



    /**
     * Prints a message to the log. Name of calling method is included in
     * message automatically.
     * 
     * @param message the message to log
     */
    @Override
    public void info( String message ) {

        if ( LOCATION.beInfo( ) ) {
            LOCATION.infoT( CATEGORY_TEST, message );
        }
    }

    /**
     * Prints a message and a throwable to the log. Name of calling method is
     * included in message automatically.
     * 
     * @param message the message to log
     * @param t the throwable to log, including its stack trace
     */
    @Override
    public void info( String message, Throwable t ) {

        if ( LOCATION.beInfo( ) ) {
            LOCATION.infoT( CATEGORY_TEST, message + "\n" + t.toString( ) );
        }
    }

    /**
     * Prints a warning and to the log. Name of calling method is included in
     * message automatically.
     * 
     * @param message the message to log
     */
    @Override
    public void warn( String message ) {

        if ( LOCATION.beWarning( ) ) {
            LOCATION.warningT( CATEGORY_TEST, message );
        }
    }

    /**
     * Prints a warning and a throwable to the log. Name of calling method is
     * included in message automatically.
     * 
     * @param message the message to log
     * @param t the throwable to log, including its stack trace
     */
    @Override
    public void warn( String message, Throwable t ) {

        if ( LOCATION.beWarning( ) ) {
            LOCATION.warningT( CATEGORY_TEST, message + "\n" + t.toString( ) );
        }
    }
}
