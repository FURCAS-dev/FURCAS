/*
 * Created on 31.01.2006
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
 * JUnit test for the creation, modification and persistence of models with a
 * link between meta-models. This test class coordinates the expiration of the
 * test which is described in {@link GraphicsTestsUtil} but the execution is
 * done in {@link LinkTestsUtil}.
 * 
 * @author d043982
 */
public class TestMoinLinkModelCreationAndModification extends MoinTestCase {

    private LinkTestsUtil lmu;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        /*
         * With the parameter *RepositoryImpl of PictogramsModelUtil you decide
         * whether to use MMR or Moin
         */
        lmu = new LinkTestsUtil( new MoinRepositoyFacadeImpl( ) );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );

        /*
         * Delete the created model from the persistence and close the
         * connnection
         */
        this.warn( "cleaning up...." );
        //        try{ 
        //            lmu.deleteModelAndCloseConnection();
        //        }catch (ModelNotFoundException mnf){
        //            fail("Model deleted before afterTestMethod()");
        //        }
        lmu = null;
        this.warn( "Cleaning up complete" );

    }

    /**
     * Tests the model creation, persistence and modification of a model with a
     * link between two meta-models.
     * 
     * @throws Exception
     */
    @Test
    public void testModelManipulation( ) throws Exception {

        /*
         * TODO The original test operation does not work with the current MMR
         * integration therefore it is in comments. Additionally, in
         * PictogramsTestsUtil.java there is one ToDo that will work when
         * MMR/MOIN does
         */

        this.info( "Open a connection, Selects the Extent, creates the Model" );
        lmu.createModel( );
        this.info( "Model created!!!" );
        lmu.exportToXmi( "link_1createModel.xmi" );
        this.info( "Model XMI file generated!!" );
        this.info( "Checking the created Model!!!" );
        assertTrue( "Problem accessing Diargam Link over Association", lmu.testLinkOverAssociation( ) );
        this.warn( "Assert is true" );

        lmu.closeConnection( );
        lmu.loadModel( );
        lmu.exportToXmi( "link_2loadModel.xmi" );

        lmu.closeConnection( );
        lmu.loadModel( );
        lmu.modifyModel( );
        this.info( "Modifying the Model!!!" );
        lmu.exportToXmi( "link_3modifyModel.xmi" );
        this.info( "checking the Modifications!!!" );
        ArrayList listOfDifferences = lmu.checkModifiedModel( );
        //assertTrue(listOfDifferences.toString(), listOfDifferences.isEmpty());
        assertTrue( listOfDifferences.toString( ), listOfDifferences.isEmpty( ) );
        listOfDifferences.clear( );

        lmu.closeConnection( );
        lmu.loadModel( );
        lmu.exportToXmi( "link_4loadModifiedModel.xmi" );
        listOfDifferences = lmu.checkModifiedModel( );
        //      assertTrue(listOfDifferences.toString(), listOfDifferences.isEmpty());
        listOfDifferences.clear( );

        // cleanup model content
        lmu.deleteModelAndCloseConnection( );

    }

    //    /**
    //     * Tests if the exceptions are thrown correctly during the test case. Incorrect situations are provoced
    //     * and the exception handling is done.<br>
    //     * <br>
    //     * The following situations are tested:
    //     * <ul>
    //     * <li>Deleting the model from the persistence and then trying to load it again</li>
    //     * </ul>
    //     * @throws RepositoryException
    //     * @throws ModelNotFoundException
    //     */
    //    @Test public void testInvokeException()throws RepositoryException, ModelNotFoundException {
    //        
    //        //**** ModelNotFoundException Invocation BEGIN 
    //        boolean exInvoke = false;
    //        this.info("Create the Model");
    //        lmu.createModel();
    //        
    //        this.warn("Delete the model and close conenction");
    //        lmu.deleteModelAndCloseConnection();
    //        
    //        this.warn("Trying to load the deleted Model");
    //        try {
    //            lmu.loadModel();
    //        }
    //        catch (ModelNotFoundException mnfe) {
    //             exInvoke = true;
    //             this.warn("Exception Invoked");
    //             this.assertTrueAndContinue("Exception Invocation", exInvoke);
    //        }
    //        
    //        if(!exInvoke) {
    //            this.errorAndContinue(" Exception Handling Failed, Deleted Model found");
    //        }
    //        exInvoke = false;
    //        //**** ModelNotFoundException Invocation END        
    //        
    //        
    //        
    //    }

    // trace location and logging category
    private static final Location LOCATION = Location.getLocation( TestMoinLinkModelCreationAndModification.class );

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