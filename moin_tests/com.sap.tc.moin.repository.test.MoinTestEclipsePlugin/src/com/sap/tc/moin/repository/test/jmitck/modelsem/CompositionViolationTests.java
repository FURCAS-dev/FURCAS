package com.sap.tc.moin.repository.test.jmitck.modelsem;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.xmi.XmiReader;

import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;

/**
 * Defines a parameterized test for using a single value to set multiple
 * attributes.
 */
@SuppressWarnings( "nls" )
public class CompositionViolationTests extends FeatureAccess {

    private String attrTypeName;

    @Override
    public void init( ClassLoader loader, TestDescription td, PrintWriter trOut, List<RefPackage> refPackageList, String prefix, XmiReader xmiReader ) {

        super.init( loader, td, trOut, refPackageList, prefix, xmiReader );
        this.attrTypeName = getParam( "attrTypeName", false );
    }

    /**
     * Defines the svAttrComposition test type. For details about the test and
     * its parameters, see the <a
     * href="../../../../../TestTypes/svAttrComposition.html"
     * >svAttrComposition</a>
     * 
     * @return the results of the test
     */
    public Status shareAnObjInstance( ) {

        String attrParentType1 = getParam( "attrParentType1", true );
        String attrParentType2 = getParam( "attrParentType2", true );
        String expectedSetException1 = getParam( "setException1", false );
        String expectedSetException2 = getParam( "setException2", false );
        String expectedGetException2 = getParam( "getException2", false );
        String setMethodName1 = getParam( "setMethodName1", true );
        String setMethodName2 = getParam( "setMethodName2", true );
        String getMethodName2 = getParam( "getMethodName2", true );

        String attrParentInits1 = getParam( "parentInitializers1", false );
        String attrParentInits2 = getParam( "parentInitializers2", false );
        Class<?> parentClass1 = null;
        Class<?> parentClass2 = null;
        try {
            parentClass1 = Class.forName( attrParentType1 );
        } catch ( ClassNotFoundException cnfe ) {
            throw new TestErrorException( "Specified attribute owner class " + attrParentType1 + " not found" );
        }
        try {
            parentClass2 = Class.forName( attrParentType2 );
        } catch ( ClassNotFoundException cnfe ) {
            throw new TestErrorException( "Specified attribute owner class " + attrParentType2 + " not found" );
        }

        String parentCreator1 = getParam( "parentCreator1", false );
        String parentCreator2 = getParam( "parentCreator2", false );

        RefObject owner1 = null;
        if ( parentCreator1 != null ) {
            ObjectCreator oc = makeCreatorInstance( parentCreator1 );
            owner1 = (RefObject) oc.createObject( attrParentInits1, instanceFactory.getRepRoot( ) );
        } else {
            owner1 = (RefObject) instanceFactory.makeRefObject( parentClass1, ( ( attrParentInits1 == null ) ? "" : attrParentInits1 ) );
        }
        RefObject owner2 = null;
        if ( parentCreator2 != null ) {
            ObjectCreator oc = makeCreatorInstance( parentCreator2 );
            owner2 = (RefObject) oc.createObject( attrParentInits2, instanceFactory.getRepRoot( ) );
        } else {
            owner2 = (RefObject) instanceFactory.makeRefObject( parentClass2, ( ( attrParentInits2 == null ) ? "" : attrParentInits2 ) );
        }

        String attrInits = getParam( "complexAttrInitializers", false );

        Class<?> attrType = Util.getType( attrTypeName );
        String attrCreator = getParam( "attrValueCreator", false );
        Object sharedAttr = null;
        if ( attrCreator != null ) {
            ObjectCreator oc = makeCreatorInstance( attrCreator );
            sharedAttr = oc.createObject( attrInits, instanceFactory.getRepRoot( ) );
        } else {
            if ( RefObject.class.isAssignableFrom( attrType ) ) {
                sharedAttr = instanceFactory.makeRefObject( attrType, attrInits );
            } else {
                sharedAttr = instanceFactory.makeValue( attrType, attrInits );
            }
        }

        Method setMethod1 = findMethod( parentClass1, Void.TYPE, setMethodName1 );
        Method setMethod2 = findMethod( parentClass2, Void.TYPE, setMethodName2 );
        Method getMethod2 = findMethod( parentClass2, attrType, getMethodName2 );

        boolean initialValueAvailable = false;
        Object initialValue2 = null;
        if ( expectedSetException2 != null ) {
            ExMethod preStateGet2 = new ExMethod( getMethod2, owner2, new Object[] {}, null, trOut );
            initialValue2 = preStateGet2.executeMethod( );
            if ( !preStateGet2.getStatus( ).isPassed( ) ) {
                trOut.println( "Could not determine initial state of attribute, " + "which may be needed to determine whether " + "pre-operation state was maintained if " + expectedSetException2 + " is caught" );
            } else {
                trOut.println( "Before attribute of second instance is set, " + "initial value of " + " attribute is " + initialValue2 );
                initialValueAvailable = true;
            }
        }

        ExMethod set1 = new ExMethod( setMethod1, owner1, new Object[] { sharedAttr }, expectedSetException1, trOut );
        set1.executeMethod( );
        Status status = set1.getStatus( );
        if ( !status.isPassed( ) ) {
            status = status.augment( "Unsuccessful attempt to set attribute of " + "instance 1 of " + attrParentType1 + " using method " + setMethodName1 + " to the value " + sharedAttr );
            return status;
        }
        ExMethod set2 = new ExMethod( setMethod2, owner2, new Object[] { sharedAttr }, expectedSetException2, trOut );
        set2.executeMethod( );
        status = set2.getStatus( );
        if ( !status.isPassed( ) ) {
            status = status.augment( "Unsuccessful attempt to set attribute of " + "instance 2 of " + attrParentType2 + " using method " + setMethodName2 + " to the value " + sharedAttr );
            if ( expectedSetException2 != null ) {
                status = status.augment( " Expected exception " + expectedSetException2 + " was not thrown" );
            }
            return status;
        }
        Object expectedValue;
        if ( expectedSetException2 != null ) {
            if ( !initialValueAvailable ) {
                throw new TestErrorException( "Could not determine whether the previous state had been " + "maintained after " + expectedSetException2 + " was caught.  Initial value of the attribute could not " + "be accessed" );
            }
            expectedValue = initialValue2;
            trOut.println( "Expected exception " + expectedSetException2 + " caught" );
        } else {
            expectedValue = sharedAttr;
            trOut.println( "Set the attribute of a " + attrParentType2 + " to the value " + sharedAttr + " using method " + setMethodName2 );
        }

        ExMethod get2 = new ExMethod( getMethod2, owner2, new Object[] {}, expectedGetException2, trOut );
        Object resultOfGet = get2.executeMethod( );
        status = get2.getStatus( );
        if ( !status.isPassed( ) ) {
            status = status.augment( "Unsuccessful attempt to get attribute of " + attrParentType2 + " using method " + getMethodName2 + " after setting" );
        } else {

            trOut.println( "The attribute of a " + attrParentType2 + " has the value " + resultOfGet + " accessed using method " + getMethodName2 );
            boolean areEqual = equalValues( expectedValue, resultOfGet );
            String msg = "Value returned by second owner " + attrParentType2 + " using method " + getMethodName2 + " is " + ( ( areEqual ) ? "equal" : "not equal" ) + " to "
                         + ( ( expectedSetException2 == null ) ? " the value set by method " + setMethodName2 : " the initial attribute value (operation not " + " completed due to caught " + expectedSetException2 + ")" );
            if ( areEqual ) {
                status = Status.passed( msg + " As Expected" );
            } else {
                status = Status.failed( msg );
            }
        }
        return status;
    }
}
