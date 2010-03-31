package com.sap.tc.moin.repository.test.jmitck.modelsem;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.xmi.XmiReader;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.Status;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;

/**
 * Defines parameterized tests for the manipulation of static and instance
 * attribvutes.
 */
@SuppressWarnings( "nls" )
public class AttributeAccess extends FeatureAccess {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, AttributeAccess.class );

    private String attrTypeName;

    private boolean isStatic;

    @Override
    public void init( ClassLoader loader, TestDescription td, PrintWriter trOut, List<RefPackage> refPackageList, String prefix, XmiReader xmiReader ) {

        super.init( loader, td, trOut, refPackageList, prefix, xmiReader );
        // this.repId = getParam("repId", true);
        this.isStatic = getBooleanParam( "isStatic", false );
        this.attrTypeName = getParam( "attrTypeName", true );
    }

    /**
     * Defines the svSetGet test. For details on the test and its parameters,
     * see the <a href="../../../../../TestTypes/svSetGet.html">svSetGet</a>
     * documentation.
     * 
     * @return the results of the test.
     */
    public Status svSetAndGet( ) {

        logPurpose( "the set and subsequent get of a single-valued attribute " + "of type " + attrTypeName );

        String attrParentType = getParam( "attrParentType", true );

        String expectedSetException = getParam( "setException", false );
        String expectedGetException = getParam( "getException", false );

        String setMethodName = getParam( "setMethodName", true );
        String getMethodName = getParam( "getMethodName", true );

        Class<?> parentClass = null;
        try {
            parentClass = Class.forName( attrParentType );
        } catch ( ClassNotFoundException cnfe ) {
            throw new TestErrorException( "Specified attribute owner class " + attrParentType + " not found" );
        }

        RefBaseObject obj = makeOwningObject( parentClass );

        Class<?> attrType = Util.getType( attrTypeName );
        Object newValue = makeValue( attrType );

        Method setMethod = null;
        Method getMethod = null;
        Object[] setParams = null;
        Object[] getParams = null;
        if ( isReflectiveTest( ) ) {
            // parameter required -- if it is a reflective test
            String metaAttr = getParam( "metaAttribute", true );
            setMethod = getRefSetValueMethod( isStrReflectiveTest );
            getMethod = getRefGetValueMethod( isStrReflectiveTest );
            Object metaAttrDesignator = null;
            if ( isStrReflectiveTest ) {
                metaAttrDesignator = Util.simpleNameOf( metaAttr );
            } else {
                metaAttrDesignator = Util.getMetaFeature( obj, metaAttr );
            }
            setParams = new Object[] { metaAttrDesignator, newValue };
            getParams = new Object[] { metaAttrDesignator };
        } else {
            setMethod = findMethod( parentClass, Void.TYPE, setMethodName );
            getMethod = findMethod( parentClass, attrType, getMethodName );
            setParams = new Object[] { newValue };
            getParams = new Object[] {};
        }

        boolean initialValueAvailable = false;
        Object initialValue = null;
        if ( expectedSetException != null ) {
            ExMethod preStateGet = new ExMethod( getMethod, obj, getParams, null, trOut );
            trOut.println( "Accessing initial attribute value, to later insure " + "the value us maintained if the operation is not completed" );
            initialValue = preStateGet.executeMethod( );
            if ( !preStateGet.getStatus( ).isPassed( ) ) {
                trOut.println( "Could not determine initial state of attribute, " + "which may be needed to determine whether " + "pre-operation state was maintained if " + expectedSetException + " is caught" );
            } else {
                trOut.println( "Before attribute is set, initial value of " + " attribute is " + initialValue );
                initialValueAvailable = true;
            }
        }
        ExMethod set = new ExMethod( setMethod, obj, setParams, expectedSetException, trOut );
        trOut.println( "Will set the attribute of a " + attrParentType + " to the value " + newValue + " using method " + setMethodName + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) );
        set.executeMethod( );
        Status status = set.getStatus( );
        if ( !status.isPassed( ) ) {
            status = status.augment( "Unsuccessful attempt to set attribute of " + attrParentType + " to the value " + newValue + " using method " + setMethodName + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) );
            if ( expectedSetException != null ) {
                status = status.augment( " Expected exception " + expectedSetException + " was not thrown" );
            }
        } else {
            Object expectedValue;
            if ( expectedSetException != null ) {
                if ( !initialValueAvailable ) {
                    throw new TestErrorException( "Could not determine whether the previous state had been " + "maintained after " + expectedSetException + " was caught.  Initial value of the attribute could not " + "be accessed" );
                }
                expectedValue = initialValue;
                trOut.println( "Expected exception " + expectedSetException + " caught" );

            } else {
                expectedValue = newValue;
                trOut.println( "Attribute was set to the value " + newValue );
            }
            ExMethod get = new ExMethod( getMethod, obj, getParams, expectedGetException, trOut );
            trOut.println( "Will access the attribute to determine the current " + "value, using method " + getMethodName + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) );
            Object resultOfGet = get.executeMethod( );
            status = get.getStatus( );
            if ( !status.isPassed( ) ) {
                status = status.augment( "Unsuccessful attempt to get attribute of " + attrParentType + " using method " + getMethodName + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) + " after setting attribute" );

            } else {
                trOut.println( "The attribute of a " + attrParentType + " after operation has the value " + resultOfGet );
                boolean areEqual = equalValues( expectedValue, resultOfGet );

                String msg = "Value returned by " + attrParentType + " using method " + getMethodName + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) + " is " + ( ( areEqual ) ? "equal" : "not equal" ) + " to "
                             + ( ( expectedSetException == null ) ? " the value set by method " + setMethodName + ( ( isReflectiveTest( ) ) ? " using JMI reflection" : "" ) : " the initial attribute value (operation not " + " completed due to caught " + expectedSetException + ")" );
                if ( areEqual ) {
                    status = Status.passed( msg + " As Expected" );
                } else {
                    status = Status.failed( msg + " Must retain initial state for " + "failed operation" );
                }
            }
        }
        return status;
    }

    /**
     * Defines the mvSetGet test. For details on the test and its parameters,
     * see the <a href="../../../../../TestTypes/mvSetGet.html">mvSetGet</a>
     * documentation.
     * 
     * @return the results of the test.
     */
    public Status mvSetAndGet( ) {

        logPurpose( "the set and subsequent get of a multi-valued attribute " + "of type " + attrTypeName );
        String attrParentType = getParam( "attrParentType", true );
        String expectedSetException = getParam( "setException", false );
        String expectedGetException = getParam( "getException", false );

        String getMethodName = getParam( "getMethodName", true );

        Class<?> parentClass = null;
        try {
            parentClass = Class.forName( attrParentType );
        } catch ( ClassNotFoundException cnfe ) {
            throw new TestErrorException( "Specified Class " + attrParentType + " not found" );
        }

        RefBaseObject obj = makeOwningObject( parentClass );

        Class<?> attrType = Util.getType( attrTypeName );
        Object newValue = makeValue( attrType );

        String attrMultType = getParam( "returnMult", false );
        Class<?> collectionType = getCollType( attrMultType );

        Method getMethod = null;
        Object[] getParams = null;
        if ( isReflectiveTest( ) ) {
            String metaAttr = getParam( "metaAttribute", true );
            getMethod = getRefGetValueMethod( isStrReflectiveTest );
            Object metaAttrDesignator = null;
            if ( isStrReflectiveTest ) {
                metaAttrDesignator = Util.simpleNameOf( metaAttr );
            } else {
                metaAttrDesignator = Util.getMetaFeature( obj, metaAttr );
            }
            getParams = new Object[] { metaAttrDesignator };
        } else {
            getMethod = findMethod( parentClass, collectionType, getMethodName );
            getParams = new Object[] {};
        }
        ExMethod get = new ExMethod( getMethod, obj, getParams, null, // no exception expected on first get
                                     trOut );
        Status status = null;
        Collection<?> c = null;
        trOut.println( "Will access the collection holding the multivalued " + "attribute value, using method " + getMethodName + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) );
        try {
            c = (Collection<?>) get.executeMethod( );
            status = get.getStatus( );
        } catch ( ClassCastException cce ) {
            log.trace( cce, MoinSeverity.INFO, "Caught in test: " + getTestId( ) );
            status = Status.failed( "Multivalued access method must return " + "a collection; method " + getMethodName + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) + " did not" );
        }
        if ( !status.isPassed( ) ) {
            status = status.augment( "Unsuccessful attempt to get attribute of " + attrParentType + " using method " + getMethodName + ( ( isReflectiveTest( ) ) ? " using JMI reflection" : "" ) );
        } else {
            int preCount = countValues( c, newValue );
            trOut.println( "Retrieved the multivalued attribute" );
            showCollectionValues( c, "attribute" );
            trOut.println( "Before update, the value/instance " + newValue + " appears " + preCount + " times" );

            ExMethod add = new ExMethod( getAddMethod( ), c, new Object[] { newValue }, expectedSetException, trOut );
            trOut.println( "Will update the multivalued attribute by adding an " + "element to the " + Util.simpleNameOf( collectionType.getName( ) ) + "attribute value, using the add method" );
            status = add.getStatus( );
            if ( !status.isPassed( ) ) {
                status = status.augment( "Test failed on add of value " + newValue + " to the current values of the attribute" );
                if ( expectedSetException != null ) {
                    status = status.augment( " Expected exception " + expectedSetException + " was not thrown" );
                }
            } else {
                int expectedPostCount;
                if ( expectedSetException != null ) {
                    expectedPostCount = preCount;
                    // expected exception thrown
                    trOut.println( "Expected exception " + expectedSetException + " caught" );

                } else {
                    expectedPostCount = preCount + 1;
                    trOut.println( "Added the value " + newValue + " to the collection" );
                }

                trOut.println( "To examine update result, will access the " + "multivalued attribute value, using method " + getMethodName + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) );
                // need a second representation of method
                get = new ExMethod( getMethod, obj, getParams, expectedGetException, trOut );
                c = (Collection<?>) get.executeMethod( );
                status = get.getStatus( );
                if ( !status.isPassed( ) ) {
                    status = status.augment( "Unsuccessful attempt to get attribute of " + attrParentType + " using method " + getMethodName + ( ( isReflectiveTest( ) ) ? " using JMI reflection" : "" ) + " after collection update" );
                } else {
                    trOut.println( "Retrieved the multivalued attribute after the add operation" );

                    int postCount = countValues( c, newValue );

                    showCollectionValues( c, "attribute" );
                    trOut.println( "After update, the value/instance " + newValue + " appears " + postCount + " times" );

                    String msg = "The value " + newValue + " appeared  " + preCount + " times before the add, and " + postCount + " times after the add" + ( ( expectedSetException != null ) ? " (operation not completed due to caught " + expectedSetException + ")" : "" );

                    if ( expectedPostCount != postCount ) {
                        status = Status.failed( msg + " expected value to appear " + expectedPostCount + " times" );
                    } else {
                        status = Status.passed( msg + ", as expected" );
                    }
                }
            }
        }
        return status;
    }

    /**
     * Defines the mvRemoveFirst test. For details on the test and its
     * parameters, see the <a
     * href="../../../../../TestTypes/mvRemoveFirst.html">mvRemoveFirst</a>
     * documentation.
     * 
     * @return the results of the test.
     */
    public Status mvRemoveFirst( ) {

        logPurpose( "the removal of the first element of a multi-valued " + "attribute of type " + attrTypeName );

        String attrParentType = getParam( "attrParentType", true );
        String expectedGetException = getParam( "getException", false );
        String expectedRemoveException = getParam( "removeException", false );

        String getMethodName = getParam( "getMethodName", true );

        Class<?> parentClass = null;
        try {
            parentClass = Class.forName( attrParentType );
        } catch ( ClassNotFoundException cnfe ) {
            throw new TestErrorException( "Specified Class " + attrParentType + " not found" );
        }

        RefBaseObject obj = makeOwningObject( parentClass );

        String attrMultType = getParam( "returnMult", false );
        Class<?> collectionType = getCollType( attrMultType );

        Method getMethod = null;
        Object[] getParams = null;
        if ( isReflectiveTest( ) ) {
            String metaAttr = getParam( "metaAttribute", true );
            getMethod = getRefGetValueMethod( isStrReflectiveTest );
            Object metaAttrDesignator = null;
            if ( isStrReflectiveTest ) {
                metaAttrDesignator = Util.simpleNameOf( metaAttr );
            } else {
                metaAttrDesignator = Util.getMetaFeature( obj, metaAttr );
            }
            getParams = new Object[] { metaAttrDesignator };
        } else {
            getMethod = findMethod( parentClass, collectionType, getMethodName );
            getParams = new Object[] {};
        }

        ExMethod get = new ExMethod( getMethod, obj, getParams, null, // no exception expected on first get
                                     trOut );
        Status status = null;
        Collection<?> c = null;
        trOut.println( "Will access the collection holding the multivalued " + "attribute value, using method " + getMethodName + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) );
        try {
            c = (Collection<?>) get.executeMethod( );
            status = get.getStatus( );
        } catch ( ClassCastException cce ) {
            log.trace( cce, MoinSeverity.INFO, "Caught in test: " + getTestId( ) );
            status = Status.failed( "Multivalued access method must return " + "a collection; method " + getMethodName + " did not" );
        }
        if ( !status.isPassed( ) ) {
            status = status.augment( "Unsuccessful attempt to get attribute of " + attrParentType + " to test remove, prior to removing the element" );
        } else {

            if ( !c.iterator( ).hasNext( ) ) {
                throw new TestErrorException( "Test setup must have at least one " + " value in multivalued attribute " + " before removal" );
            }
            Object first = c.iterator( ).next( );
            trOut.println( "Retrieved the multivalued attribute for update " + "(element removal)" );
            showCollectionValues( c, "attribute" );
            trOut.println( "Will remove one instance of the value " + first + " from the multivalued attribute values" );
            int preCount = countValues( c, first );
            trOut.println( "Before update, the value/instance " + first + " appears " + preCount + " times" );
            ExMethod remove = new ExMethod( getRemoveMethod( ), c, new Object[] { first }, expectedRemoveException, trOut );
            trOut.println( "Will update the multivalued attribute by removing an " + "element from the " + Util.simpleNameOf( collectionType.getName( ) ) + "attribute value, using the remove method" );
            Object result = remove.executeMethod( );
            status = remove.getStatus( );
            if ( status.isPassed( ) ) {
                // if an exception wasn't expected, insure the return value is "true"
                if ( expectedRemoveException == null ) {
                    if ( ( result == null ) || !( (Boolean) result ).booleanValue( ) ) {
                        status = Status.failed( "Successful removal of an element " + "requires the remove method to " + "return \"true\"" );
                    }
                }
            }
            if ( !status.isPassed( ) ) {
                if ( expectedRemoveException != null ) {
                    status = status.augment( " Expected exception " + expectedRemoveException + " was not thrown" );
                } else {
                    status = status.augment( "Test failed on removal of value " + first + " from the current values of " + "the attribute" );
                }
            } else {
                int expectedPostCount;
                if ( expectedRemoveException != null ) {
                    expectedPostCount = preCount;
                    // expected exception thrown
                    trOut.println( "Expected exception " + expectedRemoveException + " caught" );

                } else {
                    expectedPostCount = preCount - 1;
                    trOut.println( "Removed the value " + first + " from the collection" );
                }
                // need a second representation of method
                get = new ExMethod( getMethod, obj, getParams, expectedGetException, trOut );
                c = (Collection<?>) get.executeMethod( );
                status = get.getStatus( );
                if ( !status.isPassed( ) ) {
                    status = status.augment( "Unsuccessful attempt to get attribute of " + attrParentType + " after collection remove" + " using method " + getMethodName + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) );
                } else {
                    trOut.println( "Retrieved the multivalued attribute after removing a value" );

                    int postCount = countValues( c, first );

                    showCollectionValues( c, "attribute" );
                    trOut.println( "After removal, the value/instance " + first + " appears " + postCount + " times" );

                    String msg = "The value " + first + " appeared  " + preCount + " times before the remove, and " + postCount + " times after the remove" + ( ( expectedRemoveException != null ) ? " (operation not completed due to caught " + expectedRemoveException + ")" : "" );

                    if ( expectedPostCount != postCount ) {
                        status = Status.failed( msg + " expected value to appear " + expectedPostCount + " times" );
                    } else {
                        status = Status.passed( msg + ", as expected" );
                    }

                }
            }
        }
        return status;
    }

    /**
     * Defines the mvClear method, to test the
     * <code>java.utilCollection.clear</code> method on the collection returned
     * from a multi-valued attribute. Unfortunately, the test is not currently
     * used.
     * 
     * @return the results of the test
     */
    public Status mvClear( ) {

        logPurpose( "the removal of all the elements of a multivalued " + "attribute of type " + attrTypeName );

        String attrParentType = getParam( "attrParentType", true );
        String expectedGetException = getParam( "getException", false );
        String expectedClearException = getParam( "clearException", false );

        String getMethodName = getParam( "getMethodName", true );

        Class<?> parentClass = null;
        try {
            parentClass = Class.forName( attrParentType );
        } catch ( ClassNotFoundException cnfe ) {
            throw new TestErrorException( "Specified Class " + attrParentType + " not found" );
        }

        RefBaseObject obj = makeOwningObject( parentClass );

        String attrMultType = getParam( "returnMult", false );
        Class<?> collectionType = getCollType( attrMultType );

        Method getMethod = null;
        Object[] getParams = null;
        if ( isReflectiveTest( ) ) {
            String metaAttr = getParam( "metaAttribute", true );
            getMethod = getRefGetValueMethod( isStrReflectiveTest );
            Object metaAttrDesignator = null;
            if ( isStrReflectiveTest ) {
                metaAttrDesignator = Util.simpleNameOf( metaAttr );
            } else {
                metaAttrDesignator = Util.getMetaFeature( obj, metaAttr );
            }
            getParams = new Object[] { metaAttrDesignator };
        } else {
            getMethod = findMethod( parentClass, collectionType, getMethodName );
            getParams = new Object[] {};
        }

        ExMethod get = new ExMethod( getMethod, obj, getParams, null, // no exception expected on first get
                                     trOut );
        Status status = null;
        Collection<?> c = null;
        trOut.println( "Will access the collection holding the multivalued " + "attribute value, using method " + getMethodName + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) );
        try {
            c = (Collection<?>) get.executeMethod( );
            status = get.getStatus( );
        } catch ( ClassCastException cce ) {
            log.trace( cce, MoinSeverity.INFO, "Caught in test: " + getTestId( ) );
            status = Status.failed( "Multivalued access method must return " + "a collection; method " + getMethodName + " did not" );
        }
        if ( !status.isPassed( ) ) {
            status = status.augment( "Unsuccessful attempt to get attribute of " + attrParentType + " to test clear, prior to removing the element" );
        } else {

            if ( !c.iterator( ).hasNext( ) ) {
                throw new TestErrorException( "Test setup must have at least one " + " value in multivalued attribute " + " before removal" );
            }
            Object first = c.iterator( ).next( );
            trOut.println( "Retrieved the multivalued attribute for update " + "(element removal)" );
            showCollectionValues( c, "attribute" );
            trOut.println( "Will clear all instances of the attribute value: " + Util.asString( first ) );
            int preCount = c.size( );
            trOut.println( "Before update, the multivalued attribute contained " + preCount + " values" );
            ExMethod clear = new ExMethod( getClearMethod( ), c, new Object[] { first }, expectedClearException, trOut );
            trOut.println( "Will update the multivalued attribute by clearing " + "all elements from the " + Util.simpleNameOf( collectionType.getName( ) ) + "attribute value, using the clear method" );
            status = clear.getStatus( );
            if ( !status.isPassed( ) ) {
                if ( expectedClearException != null ) {
                    status = status.augment( " Expected exception " + expectedClearException + " was not thrown" );
                } else {
                    status = status.augment( "Test failed on clearing all the " + "current values of the attribute" );
                }
            } else {
                int expectedPostCount;
                if ( expectedClearException != null ) {
                    expectedPostCount = preCount;
                    // expected exception thrown
                    trOut.println( "Expected exception " + expectedClearException + " caught" );

                } else {
                    expectedPostCount = 0;
                    trOut.println( "Cleard the values from the collection" );
                }
                // need a second representation of method
                get = new ExMethod( getMethod, obj, getParams, expectedGetException, trOut );
                c = (Collection<?>) get.executeMethod( );
                status = get.getStatus( );
                if ( !status.isPassed( ) ) {
                    status = status.augment( "Unsuccessful attempt to get attribute of " + attrParentType + " after collection clear" + " using method " + getMethodName + ( ( isReflectiveTest( ) ) ? " via the JMI reflective method" : "" ) );
                } else {
                    trOut.println( "Retrieved the multivalued attribute after " + "clearing all values" );

                    int postCount = c.size( );

                    showCollectionValues( c, "attribute" );
                    trOut.println( "After removal, the attribute has " + postCount + " values" );
                    String msg = "The attribute value contained " + preCount + " elements before the clear, and " + postCount + " elements after the clear" + ( ( expectedClearException != null ) ? " (operation not completed due to caught " + expectedClearException + ")" : "" );

                    if ( expectedPostCount != postCount ) {
                        status = Status.failed( msg + " expected attribute to now " + "have " + expectedPostCount + " elements" );
                    } else {
                        status = Status.passed( msg + ", as expected" );
                    }

                }
            }
        }
        return status;
    }

    private static Method getRefSetValueMethod( boolean isStringArg ) {

        Class<?> designator = ( isStringArg ) ? String.class : RefObject.class;

        try {
            return RefFeatured.class.getMethod( "refSetValue", new Class[] { designator, Object.class } );
        } catch ( NoSuchMethodException nsme ) {
            log.trace( nsme, MoinSeverity.INFO, "" );
            return null;
        }
    }

    private static Method getRefGetValueMethod( boolean isStringArg ) {

        Class<?> designator = ( isStringArg ) ? String.class : RefObject.class;

        try {
            return RefFeatured.class.getMethod( "refGetValue", new Class[] { designator } );
        } catch ( NoSuchMethodException nsme ) {
            log.trace( nsme, MoinSeverity.INFO, "" );
            return null;
        }
    }

    private int countValues( Collection<?> c, Object val ) {

        int count = 0;
        for ( Iterator<?> i = c.iterator( ); i.hasNext( ); ) {
            if ( val.equals( i.next( ) ) ) {
                count++;
            }
        }
        return count;
    }

    private RefBaseObject makeOwningObject( Class<?> cls ) {

        if ( isStatic ) {
            String parentCreator = getParam( "parentCreator", true );
            return makeRefObject( cls, "", parentCreator, "" );
        }
        String attrParentInitializers = getParam( "parentInitializers", false );
        if ( attrParentInitializers == null ) {
            attrParentInitializers = "";
        }
        String parentCreator = getParam( "parentCreator", false );
        String parentXmi = getParam( "parentXmi", false );

        return makeRefObject( cls, attrParentInitializers, parentCreator, parentXmi );
    }

    protected Object makeValue( Class<?> type ) {

        String strAttrValue = getParam( "attrValue", false );
        if ( strAttrValue == null ) {
            String attrCreator = getParam( "attrValueCreator", true );
            String attrInitializers = getParam( "complexAttrInitializers", false );
            ObjectCreator oc = makeCreatorInstance( attrCreator );
            return oc.createObject( attrInitializers, instanceFactory.getRepRoot( ) );
        } else {
            return instanceFactory.makeValue( type, strAttrValue );
        }
    }

}
