package com.sap.junit;

import static org.junit.Assert.assertEquals;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.internal.runners.CompositeRunner;
import org.junit.internal.runners.MethodValidator;
import org.junit.internal.runners.TestClassRunner;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Parameterized.Parameters;

import com.sap.junit.MoinRunner.MoinClassMethodRunner;
import com.sap.tc.moin.test.fw.MoinTestHelperSelector;

/**
 * copied from junit runner Parameterized and adapted to own requirements
 */
public class MoinParameterizedRunner extends TestClassRunner implements RunnerProxy {

    @Retention( RetentionPolicy.RUNTIME )
    @Target( ElementType.METHOD )
    public static @interface ParametersDescription {
    }

    public static Collection<Object[]> eachOne( Object... params ) {

        List<Object[]> results = new ArrayList<Object[]>( );
        for ( Object param : params ) {
            results.add( new Object[] { param } );
        }
        return results;
    }

    // TODO: single-class this extension

    private static class MoinTestClassRunnerForParameters extends MoinClassMethodRunner {

        private final Object[] fParameters;

        private final String fParametersDescription;

        private final int fParameterSetNumber;

        private final Constructor<?> fConstructor;

        private MoinTestClassRunnerForParameters( Class<?> klass, Object[] parameters, String parametersDescription, int i ) {

            super( klass );
            fParameters = parameters;
            fParametersDescription = parametersDescription;
            fParameterSetNumber = i;
            fConstructor = getOnlyConstructor( );
        }

        @Override
        protected Object createTest( ) throws Exception {

            return fConstructor.newInstance( fParameters );
        }

        @Override
        protected String getName( ) {

            if ( fParametersDescription == null || fParametersDescription.length( ) == 0 ) {
                return String.format( "[%s]", fParameterSetNumber ); //$NON-NLS-1$
            }
            // the '(' and ')' signs make problems, so replace them
            return String.format( "[%s] %s", fParameterSetNumber, fParametersDescription.replace( '(', '-' ).replace( ')', '-' ) ); //$NON-NLS-1$
        }

        @Override
        protected String testName( final Method method ) {
            return String.format( "%s [%s]", super.testName( method ), fParameterSetNumber ); //$NON-NLS-1$
        }

        private Constructor<?> getOnlyConstructor( ) {

            Constructor<?>[] constructors = getTestClass( ).getConstructors( );
            assertEquals( 1, constructors.length );
            return constructors[0];
        }
    }

    // TODO: I think this now eagerly reads parameters, which was never the point.

    public static class MoinRunAllParameterMethods extends CompositeRunner {

        private final Class<?> fKlass;

        public MoinRunAllParameterMethods( Class<?> klass ) throws Exception {

            super( klass.getName( ) );
            fKlass = klass;
            int i = 0;
            List<?> parametersList = getParametersList( );
            List<String> parametersDescriptionList = ensureFilledParametersDescriptionList( getParametersDescriptionList( ), parametersList );
            for ( final Object each : parametersList ) {
                if ( each instanceof Object[] ) {
                    Object o = parametersDescriptionList.get( i );
                    super.add( new MoinTestClassRunnerForParameters( klass, (Object[]) each, parametersDescriptionList.get( i ), i++ ) );
                } else {
                    throw new Exception( String.format( "%s.%s() must return a Collection of arrays.", fKlass.getName( ), getParametersMethod( ).getName( ) ) ); //$NON-NLS-1$
                }
            }
        }

        private List<?> getParametersList( ) throws IllegalAccessException, InvocationTargetException, Exception {

            return (List<?>) getParametersMethod( ).invoke( null );
        }

        @SuppressWarnings( "unchecked" )
        private List<String> getParametersDescriptionList( ) throws IllegalAccessException, InvocationTargetException, Exception {

            Method method = getParametersDescriptionMethod( );
            if ( method != null ) {
                Object returnValue = method.invoke( null );
                if ( returnValue != null && returnValue instanceof List ) {
                    return (List<String>) returnValue;
                }
                return null;
            }
            return null;
        }

        private List<String> ensureFilledParametersDescriptionList( List<String> parametersDescriptionList, List<?> parametersList ) {
            String[] sArray = new String[parametersList.size( )];
            Arrays.fill( sArray, "" ); //$NON-NLS-1$
            if ( parametersDescriptionList != null ) {
                for ( int i = 0; i < Math.min( parametersDescriptionList.size( ), parametersList.size( ) ); i++ ) {
                    sArray[i] = parametersDescriptionList.get( i );
                }
            }
            return Arrays.asList( sArray );
        }

        private Method getParametersMethod( ) throws Exception {

            for ( Method each : fKlass.getMethods( ) ) {
                if ( Modifier.isStatic( each.getModifiers( ) ) ) {
                    Annotation[] annotations = each.getAnnotations( );
                    for ( Annotation annotation : annotations ) {
                        if ( annotation.annotationType( ) == Parameters.class ) {
                            return each;
                        }
                    }
                }
            }
            throw new Exception( "No public static parameters method on class " + getName( ) ); //$NON-NLS-1$
        }

        private Method getParametersDescriptionMethod( ) throws Exception {

            for ( Method each : fKlass.getMethods( ) ) {
                if ( Modifier.isStatic( each.getModifiers( ) ) ) {
                    Annotation[] annotations = each.getAnnotations( );
                    for ( Annotation annotation : annotations ) {
                        if ( annotation.annotationType( ) == ParametersDescription.class ) {
                            return each;
                        }
                    }
                }
            }
            return null;
        }
    }

    public MoinParameterizedRunner( final Class<?> klass ) throws Exception {

        super( klass, new MoinRunAllParameterMethods( klass ) );
    }

    @Override
    public void run( RunNotifier notifier ) {

        MoinTestHelperSelector.getScenarioSpecificTestHelper( ).setTestExecutionEnvironment( this, notifier );
    }

    public void realRun( RunNotifier notifier ) {

        RunListener listener = new Junit4AdditionalListener( );
        notifier.addListener( listener );
        super.run( notifier );

    }

    @Override
    protected void validate( MethodValidator methodValidator ) {

        methodValidator.validateStaticMethods( );
        methodValidator.validateInstanceMethods( );
    }
}
