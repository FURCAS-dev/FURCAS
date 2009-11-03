package com.sap.tc.moin.repository.test.jmitck.tst4;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.modelsem.SemModelTests;
import com.sap.tc.moin.repository.test.jmitck.tst4.containment.ContainmentPackage;

/**
 * Defines tests on methods of RefFeatured. Even though testing
 * com.sap.tc.moin.repository.mmi.reflective methods, these tests have compilation dependencies on
 * interfaces generated from the Containment metamodel.
 */
@SuppressWarnings( "nls" )
public class RefFeaturedTests extends SemModelTests {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, RefFeaturedTests.class );

    private ContainmentExtent initializeExtent( String testDesc ) {

        try {
            return ContainmentExtent.makeExtent( (ContainmentPackage) rp );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            throw new TestErrorException( "Could not construct the pretest " + "state for " + testDesc + " encountered unexpected exception of " + " type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) );
        }
    }

    /**
     * Tests the type mismatch boundary condition for refSetValue on a
     * RefObject.
     * 
     * @return a <code>Status</code> value
     */
    public Status refFeaturedTypeMismatch( ) {

        String testDesc = "TypeMismatchException test";
        ContainmentExtent ce = initializeExtent( testDesc );
        RefObject ro = null;
        ro = ce.classInTopLevel1;
        try {
            List<Integer> args = new ArrayList<Integer>( );
            args.add( new Integer( 9 ) );
            ro.refSetValue( "name", args );
            // ro.refSetValue("Containment.ClassInTopLevel.name", args);
            return Status.failed( "Use of an argument of an invalid type " + " in refSetValue invocation on a " + "Containment.ClassInTopLevel did not result in " + "any exception" );
        } catch ( TypeMismatchException ice ) {
            return Status.passed( "Use of an argument of an invalid type " + " in refSetValue invocation on a " + "Containment.ClassInTopLevel resulted in an " + "TypeMismatchException, as expected" );
        } catch ( Throwable th ) {
            return Status.failed( "Use of an argument of an invalid type " + "(a String for the second element) " + " in refSetValue invocation on a " + "Containment.ClassInTopLevel resulted in an " + "exception, but not the expected " + "TypeMismatchException; it was a " + th.getClass( ).getName( )
                                  + " with a message " + th );
        }
    }

}
