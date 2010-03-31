package com.sap.tc.moin.repository.test.jmitck.modelsem;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;

/**
 * Defines tests covering manipulation of features - attributes and references.
 * Provides support for the specific tests on attributes and references. Note
 * that operations, although features, are not supported.
 */
@SuppressWarnings( "nls" )
public class FeatureAccess extends SemModelTests {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, FeatureAccess.class );

    protected void logPurpose( String activity ) {

        trOut.print( "Testing " + activity + " using " );
        if ( isStrReflectiveTest ) {
            trOut.println( "JMI reflection methods, with String metamodel " + "designators" );
        } else if ( isObjReflectiveTest ) {
            trOut.println( "JMI reflection methods, with RefObject metamodel " + "designators" );
        } else {
            trOut.println( "metamodel-specific methods" );
        }
    }

    protected static Method getAddMethod( ) {

        try {
            return Collection.class.getMethod( "add", new Class[] { Object.class } );
        } catch ( NoSuchMethodException nsme ) {
            log.trace( nsme, MoinSeverity.INFO, "" );
            return null;
        }
    }

    protected static Method getRemoveMethod( ) {

        try {
            return Collection.class.getMethod( "remove", new Class[] { Object.class } );
        } catch ( NoSuchMethodException nsme ) {
            log.trace( nsme, MoinSeverity.INFO, "" );
            return null;
        }
    }

    protected static Method getClearMethod( ) {

        try {
            return Collection.class.getMethod( "clear", new Class[] { Object.class } );
        } catch ( NoSuchMethodException nsme ) {
            log.trace( nsme, MoinSeverity.INFO, "" );
            return null;
        }
    }

    protected static Method findMethod( Object obj, Class<?> returnType, String methodName ) {

        Method m = Util.findMethod( obj, returnType, methodName );
        if ( m == null ) {
            throw new TestErrorException( "Could not find method " + methodName + " with return type " + returnType.getName( ) + " in " + obj.getClass( ).getName( ) );
        }
        return m;
    }

    protected static Method findMethod( Class<?> cls, Class<?> returnType, String methodName ) {

        Method m = Util.findMethod( cls, returnType, methodName );
        if ( m == null ) {
            throw new TestErrorException( "Could not find method " + methodName + " in " + cls.getName( ) );
        }
        return m;
    }

    protected static boolean equalValues( Object o1, Object o2 ) {

        // only one of o1 and o2 are null, return false;
        if ( ( o1 == null ) ^ ( o2 == null ) ) {
            return false;
        }
        // at this point, if o1 is null, then o2 is also
        if ( o1 == null ) {
            return true;
        } else {
            if ( ( o1 instanceof Collection ) && ( o2 instanceof Collection ) ) {
                return Util.equalCollections( (Collection<?>) o1, (Collection<?>) o2 );
            } else {
                return o1.equals( o2 );
            }
        }
    }

    protected RefBaseObject makeRefObject( Class<?> type, String initializers, String creatorCls, String creatorXmi ) {

        if ( creatorCls != null ) {
            ObjectCreator oc = makeCreatorInstance( creatorCls );
            log.trace( MoinSeverity.DEBUG, "Creating an instance of " + type.getClass( ) + " using the Creator class " + creatorCls );
            return (RefBaseObject) oc.createObject( initializers, instanceFactory.getRepRoot( ) );
        } else if ( creatorXmi != null ) {
            log.trace( MoinSeverity.DEBUG, "Creating an instance of " + type.getClass( ) + " using the XMI Resource " + creatorXmi );
            Collection<?> c = objectsFromXmi( creatorXmi, rp );
            for ( Iterator<?> i = c.iterator( ); i.hasNext( ); ) {
                Object element = i.next( );
                if ( type.isInstance( element ) ) {
                    return (RefObject) element;
                }
            }
            log.trace( MoinSeverity.INFO, "When using XMI to create a " + type.getClass( ) + " a null was returned" );
            return null;
        } else {
            return (RefObject) instanceFactory.makeRefObject( type, initializers );
        }
    }

    protected Collection<?> objectsFromXmi( String creatorXmi, RefPackage rpkg ) {

        try {
            InputStream is = XmiDictionary.getInstance( ).getStream( creatorXmi );
            if ( is == null ) {
                throw new TestErrorException( "Could not find resource named " + creatorXmi + " in classpath where class " + XmiDictionary.class.getName( ) + " was found" );
            }
            return xmiReader.read( is, creatorXmi, rpkg );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.ERROR, "Error on XMI input for test setup" );
            throw new TestErrorException( "Could not create test objects  with " + "XMI input using the XMI " + creatorXmi );
        }
    }

    protected void showCollectionValues( Collection<?> c, String item ) {

        trOut.print( "The current values of " + item + " are: " );
        if ( c == null ) {
            trOut.println( "[null collection]" );
        } else if ( c.isEmpty( ) ) {
            trOut.println( "[empty collection]" );
        } else {
            int cnt = 0;
            for ( Iterator<?> i = c.iterator( ); i.hasNext( ); cnt++ ) {
                if ( cnt > 0 ) {
                    trOut.print( "," );
                }
                trOut.print( i.next( ) );
            }
            trOut.println( );
        }
    }

    protected Class<?> getCollType( String multType ) {

        if ( ( multType == null ) || multType.equals( "coll" ) ) {
            return Collection.class;
        } else if ( multType.equals( "list" ) ) {
            return List.class;
        } else if ( multType.equals( "set" ) ) {
            return Set.class;
        } else {
            throw new TestErrorException( "Specified multiplicity type \"" + multType + "\" is not recognized" );
        }
    }

    protected static ObjectCreator makeCreatorInstance( String creatorImplClassName ) {

        ObjectCreator answer = null;
        try {
            answer = (ObjectCreator) Class.forName( creatorImplClassName ).newInstance( );
        } catch ( ClassNotFoundException cnfe ) {
            log.trace( cnfe, MoinSeverity.INFO, "" );
            System.out.println( cnfe.toString( ) );
            throw new TestErrorException( "Specified ObjectCreator class " + creatorImplClassName + " not found" );
        } catch ( InstantiationException ie ) {
            log.trace( ie, MoinSeverity.INFO, "" );
            System.out.println( ie.toString( ) );
            throw new TestErrorException( "Could not create instance of " + creatorImplClassName );
        } catch ( IllegalAccessException iae ) {
            log.trace( iae, MoinSeverity.INFO, "" );
            System.out.println( iae.toString( ) );
            throw new TestErrorException( "Could not create instance of " + creatorImplClassName );
        } catch ( ClassCastException cce ) {
            System.out.println( cce.toString( ) );
            throw new TestErrorException( "Class " + creatorImplClassName + " does not implement " + ObjectCreator.class.getName( ) );
        }

        return answer;
    }

}
