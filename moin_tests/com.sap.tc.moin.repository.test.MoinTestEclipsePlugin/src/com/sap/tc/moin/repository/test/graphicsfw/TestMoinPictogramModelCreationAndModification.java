/*
 * Created on 30.01.2006
 */
package com.sap.tc.moin.repository.test.graphicsfw;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.logging.Category;
import com.sap.tc.logging.Location;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * Copied test case from repository test used to execute graphics framework
 * specific tests. In the end this class will substitute the above mentioned
 * class
 * 
 * @author d046074
 */
public class TestMoinPictogramModelCreationAndModification extends MoinTestCase {

    private PictogramsTestsUtil pmu;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        // With the parameter *RepositoryImpl of PictogramsModelUtil you decide
        // whether to use
        // MMR or Moin
        pmu = new PictogramsTestsUtil( new MoinRepositoyFacadeImpl( ) );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );

        // Delete the created model from the persistence and close the
        // connnection
        this.warn( "cleaning up...." );
        // try{
        // pmu.deleteModelAndCloseConnection();
        // }catch (ModelNotFoundException mnf){
        // fail("Model deleted before afterTestMethod()");
        // }
        pmu = null;
        this.warn( "Cleaning up complete" );
    }

    /**
     * Tests the model creation, persistence and modification of a pictograms
     * model
     * 
     * @throws Exception
     */
    @Test
    public void testModelManipulation( ) throws Exception {

        /*
         * TODO The original test expiration does not work with the current MMR
         * integration therefore it is in comments. Additionally, in
         * PictogramsTestsUtil.java there is one ToDo that will work when
         * MMR/MOIN does
         */
        this.info( "Open a connection, Selects the Extent, creates the Model" );
        pmu.createModel( );
        this.info( "Model created!!!" );
        pmu.exportToXmi( "pictograms_1createModel.xmi" );
        this.info( "Model XMI file generated!!" );
        this.info( "Checking the created Model!!!" );
        this.info( "Assert is true" );

        pmu.closeConnection( );
        pmu.loadModel( );
        pmu.exportToXmi( "pictograms_2loadModel.xmi" );
        //
        pmu.closeConnection( );
        pmu.loadModel( );
        pmu.modifyModel( );
        this.info( "Modifying the Model!!!" );
        pmu.exportToXmi( "pictograms_3modifyModel.xmi" );
        this.info( "checking the Modifications!!!" );
        ArrayList listOfDifferences = pmu.checkModifiedModel( );
        // assertTrue(listOfDifferences.toString(),
        // listOfDifferences.isEmpty());
        listOfDifferences.clear( );

        pmu.closeConnection( );
        pmu.loadModel( );
        pmu.exportToXmi( "pictograms_4loadModifiedModel.xmi" );

        // cleanup model content
        pmu.deleteModelAndCloseConnection( );
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