package com.sap.tc.moin.repository.test.jmitck.tst4;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
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
import com.sap.tc.moin.repository.test.jmitck.tst4.containment.innercontainment.ClassInInner;

/**
 * Defines tests on methods of RefClass. Even though testing
 * com.sap.tc.moin.repository.mmi.reflective methods, these tests have compilation dependencies on
 * interfaces generated from the Containment metamodel.
 */
@SuppressWarnings( "nls" )
public class RefClassTests extends SemModelTests {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, RefClassTests.class );

    private ContainmentExtent initializeExtent( String testDesc ) {

        try {
            return ContainmentExtent.makeExtent( (ContainmentPackage) rp );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "" );
            throw new TestErrorException( "Could not construct the pretest " + "state for " + testDesc + " encountered unexpected exception of " + " type " + th.getClass( ).getName( ) + " with message " + th.getMessage( ) );
        }
    }

    /**
     * Defines a parameterized test for type mismatch boundary conditions on
     * RefClass method invocations. The <code>method</code> parameter from the
     * <code>TestDescription</code> specifies the RefClass method for the
     * current test (refCreateStruct or refCreateInstance). For each method
     * specified, an object of an invalid type is passed in.
     * 
     * @return a <code>Status</code> value
     */
    public Status refClassTypeMismatch( ) {

        String method = getParam( "method", true );

        String testDesc = "TypeMismatchException test";
        ContainmentExtent ce = initializeExtent( testDesc );
        RefClass rc = ce.classInInnerClass;
        try {
            if ( method.equals( "refCreateInstance" ) ) {
                ClassInInner cii = (ClassInInner) rc.refCreateInstance( );
                cii.refSetValue( "name", "good parameter" );
                cii.refSetValue( "point", "bad parameter" );
                return Status.failed( "Use of an argument of an invalid type " + " in " + method + " invocation on a " + "Containment.InnerContainment.ClassInInner did " + " not result in any exception" );
            } else {
                return null;
            }
        } catch ( TypeMismatchException ice ) {
            return Status.passed( "Use of an argument of an invalid type " + " in " + method + " invocation on a " + "Containment.InnerContainment.ClassInInner " + "resulted in an TypeMismatchException, as " + "expected" );
        } catch ( Throwable th ) {
            return Status.failed( "Use of an argument of an invalid type " + "(a String for the second element) " + " in " + method + " invocation on a " + "Containment.InnerContainment.ClassInInner " + "resulted in an exception, but not the " + "expected TypeMismatchException; it was a "
                                  + th.getClass( ).getName( ) + " with a message " + th );
        }
    }

}
