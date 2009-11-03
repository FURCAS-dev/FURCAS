package com.sap.tc.moin.repository.core.jmifitting;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import javax.jmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.AttributeValuesWrapper;
import com.sap.tc.moin.repository.core.JmiListWrapper;
import com.sap.tc.moin.repository.mmi.reflect.AlreadyExistsException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefException;

@SuppressWarnings( { "unchecked", "nls" } )
public abstract class ComplianceFitting {

    protected final class WrappingIterator implements Iterator {

        private final Iterator origI;

        Object last = null;

        private final boolean readOnly;

        public WrappingIterator( Iterator origI, boolean readOnly ) {

            this.origI = origI;
            this.readOnly = readOnly;
        }

        public boolean hasNext( ) {

            return origI.hasNext( );
        }

        public Object next( ) {

            last = origI.next( );
            return convertToJmi( last );
        }

        public void remove( ) {

            if ( readOnly ) {
                throw new UnsupportedOperationException( );
            }
            origI.remove( );
        }
    }

    public abstract Object getOriginal( );

    public static Object convertToJmi( final Object ret ) {

        if ( ret == null ) {
            return ret;
        }
        int extentId = ExtentHelper.getCurrentExtentId( );
        if ( ret instanceof com.sap.tc.moin.repository.mmi.reflect.RefBaseObject ) {
            if ( ret instanceof com.sap.tc.moin.repository.mmi.reflect.RefPackage ) {
                return RefPackageFitting.getRefPackage( (com.sap.tc.moin.repository.mmi.reflect.RefPackage) ret, extentId );
            } else if ( ret instanceof com.sap.tc.moin.repository.mmi.reflect.RefClass ) {
                return RefClassFitting.getRefClass( (com.sap.tc.moin.repository.mmi.reflect.RefClass) ret, extentId );
            } else if ( ret instanceof com.sap.tc.moin.repository.mmi.reflect.RefAssociation ) {
                return RefAssociationFitting.getRefAssociation( (com.sap.tc.moin.repository.mmi.reflect.RefAssociation) ret, extentId );
            } else {
                return RefObjectFitting.getRefObject( (com.sap.tc.moin.repository.mmi.reflect.RefObject) ret, extentId );
            }
        }
        if ( ret instanceof RefEnum ) {
            return convertEnumValue( ret, MmiToJmiNameMapping.convertNameToJmi( ret.getClass( ).getCanonicalName( ) ) );
        }
        if ( ret instanceof com.sap.tc.moin.repository.core.jmi.reflect.RefStructImpl ) {
            return RefStructFitting.getRefStruct( (com.sap.tc.moin.repository.mmi.reflect.RefStruct) ret );
        }
        if ( ret instanceof JmiListWrapper ) {
            return JmiListFitting.getJmiList( (JmiListWrapper) ret, extentId );
        }
        if ( ret instanceof JmiException ) {
            return convertToJmiException( (JmiException) ret );
        }
        if ( ret instanceof AttributeValuesWrapper ) {
            return AttributeValuesFitting.getAttributeValues( (AttributeValuesWrapper) ret );
        }
        if ( ret instanceof Collection ) {
            return convertCollection( (Collection) ret );
        }
        if ( ret.getClass( ).isArray( ) ) {
            return convertArray( (Object[]) ret );
        }
        return ret;
    }

    public static Object convertArray( Object[] array ) {

        if ( array.length == 0 ) {
            return array;
        }
        Object[] result = new Object[array.length];
        for ( int i = 0; i < array.length; i++ ) {
            result[i] = convertToJmi( array[i] );
        }
        return result;
    }

    protected Object[] convertArgsToMmi( Object[] args ) {

        if ( args == null ) {
            return new Object[] {};
        }
        Object[] ret = new Object[args.length];
        for ( int i = 0; i < ret.length; i++ ) {
            ret[i] = convertToMmi( args[i] );
        }
        return ret;
    }

    protected Object convertToMmi( Object arg ) {

        Object ret = null;
        if ( arg instanceof OriginalContainer ) {
            ret = ( (OriginalContainer) arg ).get___Original( );
        } else if ( arg instanceof Collection ) {
            try {
                Collection newCollection = (Collection) arg.getClass( ).newInstance( );
                for ( Object o : (Collection) arg ) {
                    newCollection.add( convertToMmi( o ) );
                }
                ret = newCollection;
            } catch ( Exception e ) {
                throw new RuntimeException( e );
            }
        } else if ( arg instanceof javax.jmi.reflect.RefEnum ) {
            ret = convertEnumValue( arg, MmiToJmiNameMapping.convertNameToMmi( arg.getClass( ).getCanonicalName( ) ) );
        } else {
            ret = arg;
        }
        return ret;
    }

    public static Object convertEnumValue( Object value, String toClassName ) {

        Field[] f = value.getClass( ).getDeclaredFields( );
        for ( Field field : f ) {
            if ( field.getType( ) == value.getClass( ) ) {
                try {
                    if ( value.equals( field.get( null ) ) ) {
                        String name = field.getName( );
                        Class targetClass = Class.forName( toClassName );
                        return targetClass.getDeclaredField( name ).get( null );
                    }
                } catch ( Exception e ) {
                    throw new RuntimeException( e );
                }
            }
        }
        throw new IllegalStateException( "No value found for: " + value );
    }


    protected Class[] convertArgTypesToMmi( Method method, Object[] args ) {

        if ( args == null || args.length == 0 ) {
            return null;
        }
        Class[] ret = new Class[args.length];
        Class[] orig = method.getParameterTypes( );
        for ( int i = 0; i < orig.length; i++ ) {
            if ( args[i] instanceof OriginalContainer ) {
                ret[i] = ( (OriginalContainer) args[i] ).get___Original( ).getClass( );
            } else if ( args[i] instanceof javax.jmi.reflect.RefEnum ) {
                ret[i] = convertEnumValue( args[i], MmiToJmiNameMapping.convertNameToMmi( args[i].getClass( ).getCanonicalName( ) ) ).getClass( );
            } else if ( args[i] instanceof javax.jmi.reflect.RefStruct ) {
                String mmiName = MmiToJmiNameMapping.convertNameToMmi( orig[i].getCanonicalName( ) );
                try {
                    ret[i] = Class.forName( mmiName );
                } catch ( ClassNotFoundException e ) {
                    ret[i] = orig[i];
                }
            } else {
                if ( args[i] == null ) {
                    if ( javax.jmi.reflect.RefEnum.class.isAssignableFrom( orig[i] ) ) {
                        // TODO
                    } else if ( javax.jmi.reflect.RefStruct.class.isAssignableFrom( orig[i] ) ) {
                        String mmiName = MmiToJmiNameMapping.convertNameToMmi( orig[i].getCanonicalName( ) );
                        try {
                            ret[i] = Class.forName( mmiName );
                        } catch ( ClassNotFoundException e ) {
                            ret[i] = orig[i];
                        }
                    } else if ( javax.jmi.reflect.RefObject.class.isAssignableFrom( orig[i] ) ) {
                        String mmiName = MmiToJmiNameMapping.convertNameToMmi( orig[i].getCanonicalName( ) );
                        try {
                            ret[i] = Class.forName( mmiName );
                        } catch ( ClassNotFoundException e ) {
                            ret[i] = orig[i];
                        }
                    } else {
                        ret[i] = orig[i];
                    }
                } else {
                    ret[i] = orig[i];
                }
            }
        }
        return ret;
    }

    protected Method findMethod( Object o, String name, Class[] argTypes ) {

        Class[] _argTypes = argTypes;
        if ( _argTypes == null ) {
            _argTypes = new Class[] {};
        }
        Method[] methods = o.getClass( ).getMethods( );
        mth: for ( Method m : methods ) {
            if ( m.getName( ).equals( name ) && m.getParameterTypes( ).length == _argTypes.length ) {
                int i = 0;
                for ( Class type : m.getParameterTypes( ) ) {
                    if ( !type.isAssignableFrom( _argTypes[i++] ) ) {
                        continue mth;
                    }
                }
                return m;
            }
        }
        throw new RuntimeException( "Methods not found: " + o.getClass( ).getCanonicalName( ) + "::" + name );
    }

    public static Collection convertCollection( Collection collection ) {

        Collection result;
        if ( collection instanceof List ) {
            result = new ArrayList( collection.size( ) );
        } else {
            result = new LinkedHashSet( );
        }
        for ( Iterator it = collection.iterator( ); it.hasNext( ); ) {
            Object obj = it.next( );
            result.add( convertToJmi( obj ) );
        }
        return result;
    }

    public static javax.jmi.reflect.JmiException convertToJmiException( com.sap.tc.moin.repository.mmi.reflect.JmiException exception ) {

        if ( exception instanceof com.sap.tc.moin.repository.mmi.reflect.WrongSizeException ) {
            return new javax.jmi.reflect.WrongSizeException( (javax.jmi.reflect.RefObject) convertToJmi( exception.getElementInError( ) ), exception.getMessage( ) );
        } else if ( exception instanceof com.sap.tc.moin.repository.mmi.reflect.CompositionCycleException ) {
            return new javax.jmi.reflect.CompositionCycleException( (javax.jmi.reflect.RefObject) convertToJmi( exception.getObjectInError( ) ), (javax.jmi.reflect.RefObject) convertToJmi( exception.getElementInError( ) ), exception.getMessage( ) );
        } else if ( exception instanceof com.sap.tc.moin.repository.mmi.reflect.CompositionViolationException ) {
            return new javax.jmi.reflect.CompositionViolationException( convertToJmi( exception.getObjectInError( ) ), (javax.jmi.reflect.RefObject) convertToJmi( exception.getElementInError( ) ), exception.getMessage( ) );
        } else if ( exception instanceof com.sap.tc.moin.repository.mmi.reflect.DuplicateException ) {
            return new javax.jmi.reflect.DuplicateException( convertToJmi( exception.getObjectInError( ) ), (javax.jmi.reflect.RefObject) convertToJmi( exception.getElementInError( ) ), exception.getMessage( ) );
        } else if ( exception instanceof com.sap.tc.moin.repository.mmi.reflect.ConstraintViolationException ) {
            return new javax.jmi.reflect.ConstraintViolationException( convertToJmi( exception.getObjectInError( ) ), (javax.jmi.reflect.RefObject) convertToJmi( exception.getElementInError( ) ), exception.getMessage( ) );
        } else if ( exception instanceof com.sap.tc.moin.repository.mmi.reflect.InvalidCallException ) {
            return new javax.jmi.reflect.InvalidCallException( convertToJmi( exception.getObjectInError( ) ), (javax.jmi.reflect.RefObject) convertToJmi( exception.getElementInError( ) ), exception.getMessage( ) );
        } else if ( exception instanceof com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException ) {
            //TODO map the "expected Type" back to JMI if necessary (but maybe the TCK doesn't check that in detail)
            return new javax.jmi.reflect.TypeMismatchException( ( (com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException) exception ).getExpectedType( ), convertToJmi( exception.getObjectInError( ) ), (javax.jmi.reflect.RefObject) convertToJmi( exception.getElementInError( ) ), exception
                .getMessage( ) );
        } else if ( exception instanceof com.sap.tc.moin.repository.mmi.reflect.AlreadyExistsException ) {
            com.sap.tc.moin.repository.mmi.reflect.AlreadyExistsException aee = (AlreadyExistsException) exception;
            return new javax.jmi.reflect.AlreadyExistsException( (RefObject) convertToJmi( aee.getExistingInstance( ) ) );
        }
        throw new RuntimeException( "Conversion (from mmi to jmi) problem: Couldn't convert JmiException " + exception.getClass( ).getCanonicalName( ) );
    }

    protected javax.jmi.reflect.RefException convertToRefException( RefException exception ) {

        if ( exception instanceof com.sap.tc.moin.repository.mmi.model.NameNotFoundException ) {
            return new javax.jmi.model.NameNotFoundException( ( (com.sap.tc.moin.repository.mmi.model.NameNotFoundException) exception ).getName( ) );
        }
        throw new RuntimeException( "Conversion (from mmi to jmi) problem: Couldn't convert RefException " + exception.getClass( ).getCanonicalName( ) );
    }
}