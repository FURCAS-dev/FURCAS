package com.sap.tc.moin.repository.test.jmitck.modelsem;

import java.lang.reflect.Method;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;

/**
 * Defines tests for manipulating single-valued references and association links
 * with single-valued ends.
 */
@SuppressWarnings( "nls" )
public class SvReferenceAccess extends ReferenceAccess {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, SvReferenceAccess.class );

    private RefObject newReference;

    /**
     * Defines the refSvSetGet test. For details on the test and its parameters,
     * see the <a
     * href="../../../../../TestTypes/refSvSetGet.html">refSvSetGet</a>
     * 
     * @return the results of the test.
     */
    public Status svSetAndGet( ) {

        logPurpose( "the set and subsequent get of a single-valued reference " + "of type " + referenceTypeName );

        if ( ( referenceSetMethod == null ) && ( linkSetMethod == null ) ) {
            String s = "Must specify either \"referenceSetMethod\" or " + "\"linkSetMethod\" parameters for this test";
            throw new TestErrorException( s );
        }

        newReference = makeReference( );

        otherEnd = makeOtherEnd( );
        Method getMethod = getGetMethod( false );
        Method setMethod = getSetMethod( false );

        Object[] setParams = getSetParams( newReference );
        Object[] getParams = getGetParams( );

        String expectedSetException = getParam( "setException", false );
        String expectedGetException = getParam( "getException", false );

        boolean initialValueAvailable = false;
        RefObject initialValue = null;
        if ( expectedSetException != null ) {
            ExMethod preStateGet = new ExMethod( getMethod, getGetTargetObject( ), getParams, null, trOut );
            trOut.println( "Accessing initial reference value, to later insure " + "the valueis maintained if the operation is not " + "completed" );
            initialValue = (RefObject) preStateGet.executeMethod( );
            if ( !preStateGet.getStatus( ).isPassed( ) ) {
                trOut.println( "Could not determine initial state of reference, " + "which may be needed to determine whether " + "pre-operation state was maintained if " + expectedSetException + " is caught" );
            } else {
                trOut.println( "Before reference is set, initial value of " + showLink( initialValue ) );
                initialValueAvailable = true;
            }
        }
        ExMethod set = new ExMethod( setMethod, getSetTargetObject( ), setParams, expectedSetException, trOut );
        StringBuffer action = new StringBuffer( "create/set the reference of " + Util.refBaseObjectAsString( otherEnd ) + " to " + Util.refBaseObjectAsString( newReference ) + " using " );
        if ( isLinkSet( ) ) {
            action.append( " method " + linkSetMethod + " on association " + associationName );
        } else {
            action.append( " method " + referenceSetMethod + " on type " + otherEndTypeName );
        }
        action.append( ( ( isReflectiveTest( ) ) ? " via JMI reflection" : "" ) );

        trOut.println( "Will " + action );
        set.executeMethod( );
        Status status = set.getStatus( );
        if ( !status.isPassed( ) ) {
            status = status.augment( "Unsuccessful attempt to " + action );
            if ( expectedSetException != null ) {
                status = status.augment( " Expected exception " + expectedSetException + " was not thrown" );
            }
        } else {
            RefObject expectedValue;
            if ( expectedSetException != null ) {
                if ( !initialValueAvailable ) {
                    throw new TestErrorException( "Could not determine whether the previous state had been " + "maintained after " + expectedSetException + " was caught.  Initial value of the reference could not " + "be accessed" );
                }
                expectedValue = initialValue;
                trOut.println( "Expected exception " + expectedSetException + " caught" );

            } else {
                expectedValue = newReference;
                trOut.println( "Reference was set to the value " + Util.refBaseObjectAsString( newReference ) );
            }
//            if ( isLinkGet( ) ) {
//                RefAssociation ra = getAssoc( );
//                Collection allLinks = ra.refAllLinks( );
//                String type = Util.dotNotation( ( (ModelElement) ra.refMetaObject( ) ).getQualifiedName( ) );
//                trOut.println( "Association " + type + " has " + allLinks.size( ) + " links" );
//                for ( Iterator i = allLinks.iterator( ); i.hasNext( ); ) {
//                    RefAssociationLink link = (RefAssociationLink) i.next( );
//                    trOut.println( "      (" + Util.refBaseObjectAsString( link.refFirstEnd( ) ) + "," + Util.refBaseObjectAsString( link.refSecondEnd( ) ) + ")" );
//                }
//            }
            ExMethod get = new ExMethod( getMethod, getGetTargetObject( ), getParams, expectedGetException, trOut );
            trOut.println( "Will access the reference to determine the current " + "value, using method " + nameOfGetMethod( ) + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) );
            RefObject resultOfGet = null;
            Object obj = get.executeMethod( );
            if ( isLinkGet( ) && isReflectiveTest( ) ) {
                int endCnt = ( (Collection<?>) obj ).size( );
                log.trace( MoinSeverity.DEBUG, "In refQuery, Collection size returned is " + endCnt );
                if ( endCnt > 1 ) {
                    return Status.failed( "Expected refQuery method to return " + "at most 1 referenced end instances, but " + "it returned " + endCnt + " objects" );
                }
                resultOfGet = ( endCnt == 0 ) ? null : (RefObject) ( (Collection<?>) obj ).iterator( ).next( );
            } else {
                try {
                    resultOfGet = (RefObject) obj;
                } catch ( ClassCastException cce ) {
                    log.trace( cce, MoinSeverity.DEBUG, "" );
                    return Status.failed( "Expected method " + nameOfGetMethod( ) + " to return a RefObject, but it returned " + "a " + obj.getClass( ).getName( ) );
                }
                if ( resultOfGet == null ) {
                    log.trace( MoinSeverity.DEBUG, "Sv link query or reference get returned a null" );
                }
            }
            status = get.getStatus( );
            if ( !status.isPassed( ) ) {
                StringBuffer sb = new StringBuffer( "Unsuccessful attempt to access " );
                if ( isLinkGet( ) ) {
                    sb.append( "link of association " + associationName + "with other end " + Util.refBaseObjectAsString( otherEnd ) );
                } else {
                    sb.append( "reference of object " + Util.refBaseObjectAsString( otherEnd ) );
                }
                sb.append( "  using method " + nameOfGetMethod( ) );

                status = status.augment( sb + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) + " after setting link/reference" );

            } else {
                trOut.print( "After the operation, " + showLink( resultOfGet ) );
                boolean areEqual = equalValues( expectedValue, resultOfGet );

                String msg = "After the operation, " + showLink( resultOfGet ) + " which is " + ( ( areEqual ) ? "equal" : "not equal" ) + " to "
                             + ( ( expectedSetException == null ) ? " the value set by method " + nameOfSetMethod( ) + ( ( isReflectiveTest( ) ) ? " using JMI reflection" : "" ) : " the initial link/reference (operation not " + " completed due to caught " + expectedSetException + ")" );
                if ( areEqual ) {
                    status = Status.passed( msg + " As Expected" );
                } else {
                    status = Status.failed( msg + " Must retain initial state for " + "failed operation" );
                }
            }
        }
        return status;
    }

    protected RefObject makeReference( ) {

        referenceType = Util.getType( referenceTypeName );
        String strReferenceInits = getParam( "referenceInitializer", false );
        String referenceCreator = getParam( "referenceCreator", false );
        String referenceEndXmi = getParam( "referenceXmi", false );
        return (RefObject) makeRefObject( referenceType, strReferenceInits, referenceCreator, referenceEndXmi );
    }

}
