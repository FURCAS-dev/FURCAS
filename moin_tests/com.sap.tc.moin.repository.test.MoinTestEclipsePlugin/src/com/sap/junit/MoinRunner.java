/**
 * 
 */
package com.sap.junit;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import com.sap.junit.Staged.StageLevel;
import com.sap.tc.moin.test.fw.MoinTestHelperSelector;

/**
 * The class runner for MOIN tests
 * 
 * @author D048997
 */
@SuppressWarnings( { "nls", "restriction" } )
public class MoinRunner extends BlockJUnit4ClassRunner implements RunnerProxy {

    public MoinRunner( Class<?> clazz ) throws org.junit.runners.model.InitializationError {

        super( clazz );
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
    public static class MoinClassMethodRunner extends BlockJUnit4ClassRunner implements RunnerProxy {

private RunNotifier notifier;

//        private final List<Method> fTestMethods;

        public MoinClassMethodRunner( Class<?> clazz ) throws org.junit.runners.model.InitializationError {

            super( clazz );
//            fTestMethods = getTestClass( ). ).getTestMethods( Test.class );
//            filterTests( fTestMethods );
        }

        
        protected String testName( FrameworkMethod method ) {

            Staged staged = method.getAnnotation( Staged.class );
            String result;
            if ( staged != null ) {
                result = "STAGED - " + method.getName();
            } else {
                result = method.getName();
            }
            return result;
        }

        @Override
        public Description getDescription( ) {

            Description spec = Description.createSuiteDescription( getName( ) );
            List<FrameworkMethod> testMethods = getTestClass().getAnnotatedMethods(Test.class);
            for ( FrameworkMethod method : testMethods ) {
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

        protected Description methodDescription( FrameworkMethod method, int rep ) {

            return Description.createTestDescription( getClass( ), testName( method ) );
        }
        
        protected Description methodDescription(FrameworkMethod method) {
            return Description.createTestDescription(getTestClass().getJavaClass(), testName(method), method.getAnnotations());
        }

        protected Statement createMethodRunner( final Object test, final FrameworkMethod method ) {
            Statement statement= new MoinStatement( method, test, notifier, methodDescription( method ) );
            statement= possiblyExpectingExceptions(method, test, statement);
            statement= withPotentialTimeout(method, test, statement);
            statement= withBefores(method, test, statement);
            statement= withAfters(method, test, statement);
            return statement;
        }
        
        private Statement createMethodRunner(final Object test, final FrameworkMethod method, int repetitions) {
            return new MoinRepetitionStatement(createMethodRunner(test, method), repetitions);
        }

        @Override
        public void run( RunNotifier notifier ) {

            MoinTestHelperSelector.getScenarioSpecificTestHelper( ).setTestExecutionEnvironment( this, notifier );
        }

        public void realRun( RunNotifier notifier ) {

            RunListener listener = new Junit4AdditionalListener( );
            notifier.addListener( listener );
            if ( getTestClass().getAnnotatedMethods(Test.class).isEmpty( ) ) {
                notifier.fireTestIgnored( getDescription( ) );
            }
            for ( FrameworkMethod method : getTestClass().getAnnotatedMethods(Test.class) ) {
                runChild( method, notifier );
            }
        }

        
        
        @Override
        protected void runChild(FrameworkMethod method, RunNotifier notifier) {
            this.notifier = notifier;
            super.runChild(method, notifier);
        }


        @SuppressWarnings("restriction")
        @Override
        protected Statement methodBlock(FrameworkMethod method) {
            Object test = null;
            try {
                test = createTest();
            } catch (Throwable e) {
                    return new Fail(e);
            }

            int methodReps = calcMethodRepetitions( method );
            if ( methodReps == 1 ) {
                return this.createMethodRunner(test, method);
            } else {
                return this.createMethodRunner(test, method, methodReps);
            }
        }      
       


//        private void testAborted(RunNotifier notifier, Description description,
//                Throwable e) {
//            notifier.fireTestStarted(description);
//            notifier.fireTestFailure(new Failure(description, e));
//            notifier.fireTestFinished(description);
//        }
//        
        protected Object createTest() throws Exception {
            return getTestClass().getOnlyConstructor().newInstance();
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

        public static int calcMethodRepetitions( FrameworkMethod method ) {

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

        public static boolean loadPropertyFile( CheckPropertyFile useFile ) {

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