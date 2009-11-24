package com.sap.junit;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.runner.Runner;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Suite;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

import com.sap.tc.moin.test.fw.MoinTestHelperSelector;

/**
 * copied from junit runner Parameterized and adapted to own requirements
 */
public class MoinParameterizedRunner extends Suite implements
        RunnerProxy {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public static @interface ParametersDescription {
    }

    public static Collection<Object[]> eachOne(Object... params) {

        List<Object[]> results = new ArrayList<Object[]>();
        for (Object param : params) {
            results.add(new Object[] { param });
        }
        return results;
    }

    private class MoinTestClassRunnerForParameters extends BlockJUnit4ClassRunner {
        private final int fParameterSetNumber;
        
        private final String fParametersDescription;

        private final List<Object[]> fParameterList;

        MoinTestClassRunnerForParameters(Class<?> type,
                List<Object[]> parameterList, String parametersDescription, int i) throws InitializationError {
            super(type);
            fParameterList = parameterList;
            fParametersDescription = parametersDescription;
            fParameterSetNumber = i;
        }

        @Override
        public Object createTest() throws Exception {
            return getTestClass().getOnlyConstructor().newInstance(
                    computeParams());
        }

        private Object[] computeParams() throws Exception {
            try {
                return fParameterList.get(fParameterSetNumber);
            } catch (ClassCastException e) {
                throw new Exception(String.format(
                        "%s.%s() must return a Collection of arrays.",
                        getTestClass().getName(), getParametersMethod(
                                getTestClass()).getName()));
            }
        }

        @Override
        protected String getName() {
            if ( fParametersDescription == null || fParametersDescription.length( ) == 0 ) {
                return String.format( "[%s]", fParameterSetNumber ); //$NON-NLS-1$
            }
            // the '(' and ')' signs make problems, so replace them
            return String.format( "[%s] %s", fParameterSetNumber, fParametersDescription.replace( '(', '-' ).replace( ')', '-' ) ); //$NON-NLS-1$
        }

        @Override
        protected String testName(final FrameworkMethod method) {
            return String.format("%s[%s]", method.getName(),
                    fParameterSetNumber);
        }

        @Override
        protected void validateZeroArgConstructor(List<Throwable> errors) {
            // constructor can, nay, should have args.
        }

        @Override
        protected Statement classBlock(RunNotifier notifier) {
            return childrenInvoker(notifier);
        }
    }

    private final ArrayList<Runner> runners = new ArrayList<Runner>();

    /**
     * Only called reflectively. Do not use programmatically.
     */
    public MoinParameterizedRunner(Class<?> klass) throws Throwable {
        super(klass, Collections.<Runner> emptyList());
        List<Object[]> parametersList = getParametersList(getTestClass());
        List<String> parametersDescriptionList = ensureFilledParametersDescriptionList( getParametersDescriptionList( getTestClass() ), parametersList );
        for (int i = 0; i < parametersList.size(); i++)
            runners.add(new MoinTestClassRunnerForParameters(getTestClass()
                    .getJavaClass(), parametersList, parametersDescriptionList.get( i ), i));
    }

    @Override
    protected List<Runner> getChildren() {
        return runners;
    }
    
    @SuppressWarnings( "unchecked" )
    private List<String> getParametersDescriptionList( TestClass klass ) throws IllegalAccessException, InvocationTargetException, Exception {

        FrameworkMethod method = getParametersDescriptionMethod( klass );
        if ( method != null ) {
            Object returnValue = method.getMethod().invoke( null );
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


    @SuppressWarnings("unchecked")
    private List<Object[]> getParametersList(TestClass klass) throws Throwable {
        return (List<Object[]>) getParametersMethod(klass).invokeExplosively(
                null);
    }

    private FrameworkMethod getParametersMethod(TestClass testClass)
            throws Exception {
        List<FrameworkMethod> methods = testClass
                .getAnnotatedMethods(Parameters.class);
        for (FrameworkMethod each : methods) {
            int modifiers = each.getMethod().getModifiers();
            if (Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers))
                return each;
        }

        throw new Exception("No public static parameters method on class "
                + testClass.getName());
    }
    
    private FrameworkMethod getParametersDescriptionMethod(TestClass testClass) throws Exception {

        for ( FrameworkMethod each : testClass.getAnnotatedMethods(ParametersDescription.class) ) {
            if ( Modifier.isStatic( each.getMethod().getModifiers( ) ) ) {
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
    
    @Override
    public void run( RunNotifier notifier ) {

        MoinTestHelperSelector.getScenarioSpecificTestHelper( ).setTestExecutionEnvironment( this, notifier );
    }

    public void realRun( RunNotifier notifier ) {

        RunListener listener = new Junit4AdditionalListener( );
        notifier.addListener( listener );
        super.run( notifier );

    }
}