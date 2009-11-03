/**
 * 
 */
package com.sap.junit;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.junit.Test;
import org.junit.internal.runners.InitializationError;
import org.junit.internal.runners.TestClassMethodsRunner;
import org.junit.internal.runners.TestClassRunner;
import org.junit.internal.runners.TestIntrospector;
import org.junit.internal.runners.TestMethodRunner;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

import com.sap.junit.Staged.StageLevel;
import com.sap.tc.moin.test.fw.MoinTestHelperSelector;

/**
 * The class runner for MOIN tests
 * 
 * @author D048997
 */
@SuppressWarnings( "nls" )
public class MoinRunner extends TestClassRunner implements RunnerProxy {

    public MoinRunner( Class<?> clazz ) throws InitializationError {

        super( clazz, new MoinClassMethodRunner( clazz ) );
    }

    @Override
    public void run( RunNotifier notifier ) {

        MoinTestHelperSelector.getScenarioSpecificTestHelper( ).setTestExecutionEnvironment( this, notifier );
    }

    public void realRun( RunNotifier notifier ) {

        super.run( notifier );
    }

    /**
     * The method runner used in the class runner for MOIN tests
     * 
     * @author D048997
     */
    public static class MoinClassMethodRunner extends TestClassMethodsRunner implements RunnerProxy {

        private final List<Method> fTestMethods;

        public MoinClassMethodRunner( Class<?> clazz ) {

            super( clazz );
            fTestMethods = new TestIntrospector( getTestClass( ) ).getTestMethods( Test.class );
//            filterTests( fTestMethods );
        }

        @Override
        protected String testName( Method method ) {

            Staged staged = method.getAnnotation( Staged.class );
            String result;
            if ( staged != null ) {
                result = "STAGED - " + super.testName( method );
            } else {
                result = super.testName( method );
            }
            return result;
        }

        @Override
        public Description getDescription( ) {

            Description spec = Description.createSuiteDescription( getName( ) );
            List<Method> testMethods = fTestMethods;
            for ( Method method : testMethods ) {
                Repeat repeat = method.getAnnotation( Repeat.class );
                if ( repeat != null ) {
                    Description desc = Description.createSuiteDescription( testName( method ) + " [repeat=" + repeat.value( ) + "]" );
                    for ( int i = 0; i < repeat.value( ); i++ ) {
                        desc.addChild( methodDescription( method, i ) );
                    }
                    spec.addChild( desc );
                } else {
                    spec.addChild( methodDescription( method ) );
                }
            }
            return spec;
        }

        protected Description methodDescription( Method method, int rep ) {

            return Description.createTestDescription( getClass( ), testName( method ) + " [" + rep + "]" );
        }

        protected TestMethodRunner createMethodRunner( final Object test, final Method method, final RunNotifier notifier, final Description desc ) {

            return new TestMethodRunner( test, method, notifier, desc ) {

                @Override
                public void run( ) {

                    boolean doExecute = true;

                    StageLevel paramStageType = getStageTypeParameterValue( );
                    Staged staged = method.getAnnotation( Staged.class );
                    StageLevel annotStageType = ( staged == null ) ? StageLevel.CENTRAL : staged.value( );

                    // check method should be invoked
                    if ( paramStageType != StageLevel.ALL ) {
                        if ( annotStageType != paramStageType ) {
                            doExecute = false;
                        }
                    }

                    CheckPropertyFile usePropertyFile = method.getAnnotation( CheckPropertyFile.class );

                    if ( usePropertyFile == null ) {
                        // ignore it
                    } else if ( !loadPropertyFile( usePropertyFile ) ) {
                        // file has been required but could not be found
                        doExecute = false;
                    }

                    if ( doExecute ) {
                        super.run( );
                    } else {
                        notifier.fireTestIgnored( desc );
                    }
                }
            };
        }

        @Override
        public void run( RunNotifier notifier ) {

            MoinTestHelperSelector.getScenarioSpecificTestHelper( ).setTestExecutionEnvironment( this, notifier );
        }

        public void realRun( RunNotifier notifier ) {

            RunListener listener = new Junit4AdditionalListener( );
            notifier.addListener( listener );
            if ( fTestMethods.isEmpty( ) ) {
                notifier.fireTestIgnored( getDescription( ) );
            }
            for ( Method method : fTestMethods ) {
                invokeTestMethod( method, notifier );
            }
        }

        @Override
        protected void invokeTestMethod( Method method, RunNotifier notifier ) {

            int methodReps = calcMethodRepetitions( method );
            if ( methodReps == 1 ) {
                invokeTestMethodOnce( method, notifier );
            } else {
                invokeTestMethodMultiple( method, notifier, methodReps );
            }
        }

        private void invokeTestMethodOnce( Method method, RunNotifier notifier ) {

            Object test;
            try {
                test = createTest( );
            } catch ( InvocationTargetException e ) {
                notifier.testAborted( methodDescription( method ), e.getCause( ) );
                return;
            } catch ( Exception e ) {
                notifier.testAborted( methodDescription( method ), e );
                return;
            }
            this.createMethodRunner( test, method, notifier, methodDescription( method ) ).run( );
        }

        private void invokeTestMethodMultiple( Method method, RunNotifier notifier, final int repetitions ) {

            for ( int i = 0; i < repetitions; i++ ) {
                Object test;
                try {
                    test = createTest( );
                } catch ( InvocationTargetException e ) {
                    notifier.testAborted( methodDescription( method, i ), e.getCause( ) );
                    return;
                } catch ( Exception e ) {
                    notifier.testAborted( methodDescription( method, i ), e );
                    return;
                }
                this.createMethodRunner( test, method, notifier, methodDescription( method, i ) ).run( );
            }
        }

//        private void filterTests( List<Method> methods ) {
//
//            StageLevel paramStageType = getStageTypeParameterValue( );
//            for ( Iterator<Method> it = methods.iterator( ); it.hasNext( ); ) {
//                // Staged annotation
//                Method method = it.next( );
//                Staged staged = method.getAnnotation( Staged.class );
//                StageLevel annotStageType = ( staged == null ) ? StageLevel.CENTRAL : staged.value( );
//
//                // check method should be invoked
//                if ( paramStageType != StageLevel.ALL ) {
//                    if ( annotStageType != paramStageType ) {
//                        it.remove( );
//                    }
//                }
//            }
//        }

        /* ####################### STATIC METHODS ######################### */

        public static int calcMethodRepetitions( Method method ) {

            int result;

            Repeat repeat = method.getAnnotation( Repeat.class );
            if ( repeat == null ) {
                result = 1;
            } else {
                result = repeat.value( );
            }
            return result;
        }

        public static StageLevel getStageTypeParameterValue( ) {

            String stage = System.getProperty( "com.sap.tc.moin.stagetest" );
            if ( stage == null ) {
                return StageLevel.CENTRAL;
            }
            if ( stage.equalsIgnoreCase( Staged.ISOLATED_STRING ) ) {
                return StageLevel.ISOLATED;
            }
            if ( stage.equalsIgnoreCase( Staged.OCCASIONAL_STRING ) ) {
                return StageLevel.OCCASIONAL;
            }
            if ( stage.equalsIgnoreCase( Staged.ALL_STRING ) ) {
                return StageLevel.ALL;
            }

            // else
            return StageLevel.CENTRAL;
        }

        private static boolean loadPropertyFile( CheckPropertyFile useFile ) {

            String[] propArr = useFile.value( );
            if ( propArr == null || propArr.length < 1 ) {
                return false;
            }
            String propKey = propArr[0];
            if ( propKey == null ) {
                // skip test
                return false;
            }
            String prefix = null;
            if ( propArr.length > 1 ) {
                prefix = propArr[1];
                if ( prefix == null ) {
                    // skip test
                    return false;
                }
            }

            String propKey2 = null;
            if ( propArr.length > 2 ) {
                propKey2 = propArr[2];
                if ( propKey2 == null ) {
                    // skip test
                    return false;
                }
            }

            String location = System.getProperty( propKey );
            if ( location == null || location.length( ) < 1 ) {
                // invalid location, skip test
                return false;
            }
            File file = new File( location );
            if ( file == null || !file.exists( ) ) {
                // invalid location, skip test
                return false;
            }

            if ( propKey2 != null && propKey2.length( ) > 0 ) {
                // evaluate redirection
                file = getRedirectedFile( file, propKey2 );
                if ( file == null || !file.exists( ) ) {
                    // invalid location, skip test
                    return false;
                }
            }

            try {
                FileInputStream fis = new FileInputStream( file );
                BufferedInputStream bis = new BufferedInputStream( fis );
                if ( bis == null ) {
                    return false;
                }
                Properties props = new Properties( );
                props.load( bis );
                bis.close( );
                fis.close( );
                if ( props.size( ) == 0 ) {
                    return false;
                }
                if ( prefix == null ) {
                    // no prefix filter
                    for ( Enumeration<Object> en = props.keys( ); en.hasMoreElements( ); ) {
                        Object keyObj = en.nextElement( );
                        String key = (String) keyObj;
                        if ( key != null && key.length( ) > 0 ) {
                            String value = props.getProperty( key );
                            if ( value != null ) {
                                System.setProperty( key, value );
                            } else {
                                System.clearProperty( key );
                            }
                        }
                    }
                } else {
                    for ( Enumeration<Object> en = props.keys( ); en.hasMoreElements( ); ) {
                        Object keyObj = en.nextElement( );
                        String key = (String) keyObj;
                        if ( key != null && key.length( ) > 0 && key.startsWith( prefix ) ) {
                            String value = props.getProperty( key );
                            if ( value != null ) {
                                System.setProperty( key, value );
                            } else {
                                System.clearProperty( key );
                            }
                        }
                    }
                }
                return true;
            } catch ( SecurityException e ) {
                return false;
            } catch ( IOException e ) {
                return false;
            }
        }

        private static File getRedirectedFile( File file, String propKey2 ) {

            // evaluate redirection
            try {
                FileInputStream fis = new FileInputStream( file );
                BufferedInputStream bis = new BufferedInputStream( fis );
                if ( bis == null ) {
                    // invalid location, skip test
                    return null;
                }
                Properties props = new Properties( );
                props.load( bis );
                bis.close( );
                fis.close( );
                if ( props.size( ) == 0 ) {
                    // invalid location, skip test
                    return null;
                }
                String location = props.getProperty( propKey2 );
                if ( location == null || location.length( ) < 1 ) {
                    // invalid location, skip test
                    return null;
                }
                File parent = file.getParentFile( );
                File file1 = new File( parent, location );
                if ( file1 == null || !file1.exists( ) ) {
                    // invalid location, skip test
                    return null;
                }
                return file1;

            } catch ( SecurityException e ) {
                return file;
            } catch ( IOException e ) {
                return file;
            }
        }
    }
}