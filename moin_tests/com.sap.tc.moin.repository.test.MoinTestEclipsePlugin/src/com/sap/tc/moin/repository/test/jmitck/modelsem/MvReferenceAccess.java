package com.sap.tc.moin.repository.test.jmitck.modelsem;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;

/**
 * Defines tests for manipulating multi-valued references and association links
 * with multi-valued ends.
 */
@SuppressWarnings( "nls" )
public class MvReferenceAccess extends ReferenceAccess {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, MvReferenceAccess.class );

    protected String linkRemoveMethod;

    protected String referenceRemoveMethod;

    private Collection<RefObject> newReferenceColl;

    private Collection<RefObject> existingReferenceColl;

    /**
     * Defines the refMvSetGet test. For details on the test and its parameters,
     * see the <a
     * href="../../../../../TestTypes/refMvSetGet.html">refMvSetGet</a>
     * 
     * @return the results of the test.
     */
    public Status mvSetAndGet( ) {

        logPurpose( "the set and subsequent get of a multi-valued reference of type " + referenceTypeName );

        if ( ( referenceSetMethod == null ) && ( linkSetMethod == null ) ) {
            String s = "Must specify either \"referenceSetMethod\" or " + "\"linkSetMethod\" parameters for this test";
            throw new TestErrorException( s );
        }

        newReferenceColl = makeReferenceCollection( );

        otherEnd = makeOtherEnd( );
        Method getMethod = getGetMethod( true );
        Method setMethod = getSetMethod( true );

        Object[] getParams = getGetParams( );

        String expectedSetException = getParam( "setException", false );
        String expectedGetException = getParam( "getException", false );

        ExMethod preStateGet = new ExMethod( getMethod, getGetTargetObject( ), getParams, null, trOut );
        trOut.println( "Accessing initial reference values" );
        Collection<?> resultOfGet = (Collection<?>) preStateGet.executeMethod( );
        existingReferenceColl = new ArrayList<RefObject>( resultOfGet.size( ) );
        for ( Object resultObject : resultOfGet ) {
            existingReferenceColl.add( (RefObject) resultObject );
        }
        Collection<RefObject> initialColl = new ArrayList<RefObject>( existingReferenceColl );
        Status status = preStateGet.getStatus( );
        if ( !status.isPassed( ) ) {
            return status.augment( "Could not retrieve the initial reference values" );
        } else {
            trOut.println( "Before reference is set, initial value of " + showLink( initialColl ) );
        }
        trOut.println( "Will add " + newReferenceColl.size( ) + " reference elements to the reference" );
        for ( Iterator<RefObject> i = newReferenceColl.iterator( ); i.hasNext( ); ) {
            RefObject reference = i.next( );
            Object[] setParams = getSetParams( reference );

            ExMethod set = new ExMethod( setMethod, getSetTargetObject( ), setParams, expectedSetException, trOut );
            StringBuffer action = new StringBuffer( "add a reference of " + Util.refBaseObjectAsString( otherEnd ) + " to " + Util.refBaseObjectAsString( reference ) + " using " );
            if ( isLinkSet( ) ) {
                action.append( " method " + linkSetMethod + " on association " + associationName );
            } else {
                action.append( " method " + referenceSetMethod + " on type " + otherEndTypeName );
            }
            action.append( ( ( isReflectiveTest( ) ) ? " via JMI reflection" : "" ) );

            trOut.println( "Will " + action );
            set.executeMethod( );
            status = set.getStatus( );
            if ( !status.isPassed( ) ) {
                status = status.augment( "Unsuccessful attempt to " + action );
                if ( expectedSetException != null ) {
                    status = status.augment( " Expected exception " + expectedSetException + " was not thrown" );
                }
                return status;
            }
        }

        Collection<RefObject> expectedValue;
        if ( expectedSetException != null ) {
            expectedValue = initialColl;
            trOut.println( "Expected exception " + expectedSetException + " caught" );

        } else {
            expectedValue = new ArrayList<RefObject>( initialColl );
            expectedValue.addAll( newReferenceColl );
            trOut.println( "Expectng reference to now contain " + expectedValue.size( ) + " elements" );
        }
        ExMethod get = new ExMethod( getMethod, getGetTargetObject( ), getParams, expectedGetException, trOut );
        trOut.println( "Will access the reference to determine the current " + "value, using method " + nameOfGetMethod( ) + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) );
        resultOfGet = (Collection<?>) get.executeMethod( );
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
                if ( expectedSetException != null ) {
                    status = Status.failed( msg + " Must retain initial state for " + "failed operation" );
                }
            }
        }
        return status;
    }

    /**
     * Defines the refMvRemove test. For details on the test and its parameters,
     * see the <a
     * href="../../../../../TestTypes/refMvRemove.html">refMvRemove</a>
     * 
     * @return the results of the test.
     */
    public Status mvRemove( ) {

        logPurpose( "the removal of a link (or a reference) " + "of type " + referenceTypeName );

        linkRemoveMethod = getParam( "linkRemoveMethod", false );
        referenceRemoveMethod = getParam( "referenceRemoveMethod", false );
        if ( ( referenceRemoveMethod == null ) && ( linkRemoveMethod == null ) ) {
            String s = "Must specify either \"referenceRemoveMethod\" or " + "\"linkRemoveMethod\" parameters for this test";
            throw new TestErrorException( s );
        }

        // assumes the otherEnd already has links
        otherEnd = makeOtherEnd( );
        Method getMethod = getGetMethod( true );
        Method removeMethod = getReferenceRemoveMethod( );

        Object[] getParams = getGetParams( );

        String expectedRemoveException = getParam( "removeException", false );
        String expectedGetException = getParam( "getException", false );

        ExMethod preStateGet = new ExMethod( getMethod, getGetTargetObject( ), getParams, null, trOut );
        trOut.println( "Accessing initial reference values" );
        Collection<?> resultOfGet = (Collection<?>) preStateGet.executeMethod( );
        existingReferenceColl = new ArrayList<RefObject>( resultOfGet.size( ) );
        for ( Object resultObject : resultOfGet ) {
            existingReferenceColl.add( (RefObject) resultObject );
        }
        Collection<RefObject> initialColl = new ArrayList<RefObject>( existingReferenceColl );
        Status status = preStateGet.getStatus( );
        if ( !status.isPassed( ) ) {
            return status.augment( "Could not retrieve initial reference values" );
        } else {
            trOut.println( "Before reference removal, initial value of " + showLink( initialColl ) );
        }
        if ( existingReferenceColl.isEmpty( ) ) {
            return Status.error( "Test setup must provide an object with one or " + "more existing references (or links) before " + "remove can be tested" );
        }
        RefObject toRemove = existingReferenceColl.iterator( ).next( );

        trOut.println( "Will remove reference " + Util.refBaseObjectAsString( toRemove ) + " from the references of " + Util.refBaseObjectAsString( otherEnd ) );

        Object[] removeParams = getRemoveParams( toRemove );

        ExMethod remove = new ExMethod( removeMethod, getRemoveTargetObject( ), removeParams, expectedRemoveException, trOut );
        StringBuffer action = new StringBuffer( "remove reference " + Util.refBaseObjectAsString( toRemove ) + " from " + Util.refBaseObjectAsString( otherEnd ) + " using " );
        if ( isLinkSet( ) ) {
            action.append( " the remove method on association " + associationName );
        } else {
            action.append( " the remove method on the Collection returned from " + otherEndTypeName );
        }
        action.append( ( ( isReflectiveTest( ) ) ? " via JMI reflection" : "" ) );

        trOut.println( "Will " + action );
        boolean changed = ( (Boolean) remove.executeMethod( ) ).booleanValue( );
        status = remove.getStatus( );
        if ( !status.isPassed( ) ) {
            status = status.augment( "Unsuccessful attempt to " + action );
            if ( expectedRemoveException != null ) {
                status = status.augment( " Expected exception " + expectedRemoveException + " was not thrown" );
            }
            return status;
        }

        Collection<RefObject> expectedValue;
        if ( expectedRemoveException != null ) {
            if ( changed ) {
                return Status.failed( "Attemt to remove reference (or link) " + "raised the expected " + expectedRemoveException + " but the method " + "returned true, indicating that the " + "references (or links) were changed" );
            }
            expectedValue = initialColl;
            trOut.println( "Expected exception " + expectedRemoveException + " caught" );
        } else {
            if ( !changed ) {
                return Status.failed( "The remove method returned without an " + "exception, but the method " + "returned false, indicating that the " + "references (or links) were not changed" );
            }
            expectedValue = initialColl;
            expectedValue.remove( toRemove );
            trOut.println( "Expectng reference to now contain " + expectedValue.size( ) + " elements" );
        }
        ExMethod get = new ExMethod( getMethod, getGetTargetObject( ), getParams, expectedGetException, trOut );
        trOut.println( "Will access the reference to determine the current " + "value, using method " + nameOfGetMethod( ) + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) );
        resultOfGet = null;
        Object obj = get.executeMethod( );
        try {
            resultOfGet = (Collection<?>) obj;
        } catch ( ClassCastException cce ) {
            log.trace( cce, MoinSeverity.ERROR, "" );
            return Status.failed( "Expected method " + nameOfGetMethod( ) + " to return a Collection, but it returned a " + obj.getClass( ).getName( ) );
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

            status = status.augment( sb + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) + " after removing a link/reference" );

        } else {
            trOut.print( "After the operation, " + showLink( resultOfGet ) );
            boolean areEqual = equalValues( expectedValue, resultOfGet );

            String msg = "After the operation, " + showLink( resultOfGet ) + " which is " + ( ( areEqual ) ? "equal" : "not equal" ) + " to "
                         + ( ( expectedRemoveException == null ) ? " the expecte value after the remove method " + ( ( isReflectiveTest( ) ) ? " using JMI reflection" : "" ) : " the initial link/reference (operation not " + " completed due to caught " + expectedRemoveException + ")" );
            if ( areEqual ) {
                status = Status.passed( msg + " As Expected" );
            } else {
                if ( expectedRemoveException != null ) {
                    status = Status.failed( msg + " Must retain initial state for " + "failed operation" );
                }
            }
        }
        return status;
    }

    protected String showLink( Collection<?> references ) {

        StringBuffer sb = new StringBuffer( );
        if ( isLinkGet( ) ) {
            sb.append( references.size( ) + " links of association " + associationName + " that include ther ehd " + Util.refBaseObjectAsString( otherEnd ) + " have ends: " );
        } else {
            sb.append( "reference of object " + Util.refBaseObjectAsString( otherEnd ) + " is a collection of " + references.size( ) + " elements :" );
        }
        sb.append( Util.EOL );
        for ( Iterator<?> i = references.iterator( ); i.hasNext( ); ) {
            sb.append( "     " + Util.refBaseObjectAsString( (RefBaseObject) i.next( ) ) + Util.EOL );
        }
        return sb.toString( );
    }

    protected Method getReferenceRemoveMethod( ) {

        if ( linkRemoveMethod != null ) {
            if ( isReflectiveTest( ) ) {
                return getRefRemoveLinkMethod( );
            } else {
                return findMethod( getAssoc( ), Boolean.TYPE, "remove" );
            }
        } else {
            // no reflective version -- using Collection method, not JMI Method
            return getRemoveMethod( );
        }
    }

    @Override
    protected Object[] getSetParams( RefObject reference ) {

        List<RefObject> params = new ArrayList<RefObject>( );
        if ( !isLinkSet( ) ) {
            params.add( reference );
        } else {
            boolean referenceIsFirstEnd = getBooleanParam( "referenceIsFirstEnd", true );
            if ( referenceIsFirstEnd ) {
                params.add( reference );
                params.add( otherEnd );
            } else {
                params.add( otherEnd );
                params.add( reference );
            }
        }
        return params.toArray( new Object[] {} );
    }

    protected Object[] getRemoveParams( RefObject reference ) {

        List<RefObject> params = new ArrayList<RefObject>( );
        if ( linkRemoveMethod == null ) {
            params.add( reference );
        } else {
            boolean referenceIsFirstEnd = getBooleanParam( "referenceIsFirstEnd", true );
            if ( referenceIsFirstEnd ) {
                params.add( reference );
                params.add( otherEnd );
            } else {
                params.add( otherEnd );
                params.add( reference );
            }
        }
        return params.toArray( new Object[] {} );
    }

    protected Collection<RefObject> makeReferenceCollection( ) {

        Collection<RefObject> answer = new ArrayList<RefObject>( );
        referenceType = Util.getType( referenceTypeName );
        String strReferenceInits = getParam( "referenceInitializer", false );
        String referenceCreator = getParam( "referenceCreator", false );
        String referenceEndXmi = getParam( "referenceXmi", false );
        if ( referenceEndXmi == null ) {
            RefObject ro = (RefObject) makeRefObject( referenceType, strReferenceInits, referenceCreator, referenceEndXmi );
            answer.add( ro );
        } else {
            Collection<?> objectsFromXmi = objectsFromXmi( referenceEndXmi, rp );
            for ( Iterator<?> i = objectsFromXmi.iterator( ); i.hasNext( ); ) {
                RefObject ele = (RefObject) i.next( );
                if ( referenceType.isInstance( ele ) ) {
                    answer.add( ele );
                }
            }
        }
        return answer;
    }

    @Override
    protected Object getSetTargetObject( ) {

        if ( isLinkSet( ) ) {
            return getAssoc( );
        } else {
            return existingReferenceColl;
        }
    }

    protected Object getRemoveTargetObject( ) {

        if ( linkRemoveMethod != null ) {
            return getAssoc( );
        } else {
            return existingReferenceColl;
        }
    }
}
