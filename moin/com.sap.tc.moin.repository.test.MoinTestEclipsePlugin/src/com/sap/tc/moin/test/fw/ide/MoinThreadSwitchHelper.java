package com.sap.tc.moin.test.fw.ide;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.runner.notification.RunNotifier;

import com.sap.junit.RunnerProxy;

@SuppressWarnings( "nls" )
public class MoinThreadSwitchHelper {

    private final RunnerProxy fEnclosedRunner;

    private Display display;

    private volatile boolean testsFinished = false;

    private Set<Shell> startShells = new HashSet<Shell>( );

    private MoinThreadSwitchHelper( RunnerProxy runner ) {

        this.fEnclosedRunner = runner;
    }

    public void run( final RunNotifier notifier ) {

        display = Display.getCurrent( );
        if ( display == null ) {
            throw new IllegalStateException( "The TestSuite must be run from an SWT UI thread" );
        }
        Shell[] currentShells = display.getShells( );
        this.startShells.addAll( Arrays.asList( currentShells ) );

        Thread t = new Thread( fEnclosedRunner.getDescription( ).getDisplayName( ) ) {

            @Override
            public void run( ) {

                System.out.println( "Switching JUnit test execution to thread " + Thread.currentThread( ).getName( ) );
                try {
                    MoinThreadSwitchHelper.this.fEnclosedRunner.realRun( notifier );
                } finally {
                    MoinThreadSwitchHelper.this.runFinished( );
                    testsFinished = true;
                    display.wake( );
                }
            }
        };
        t.setDaemon( true );
        t.start( );
        waitUntilFinished( );
    }

    private void waitUntilFinished( ) {

        while ( !this.testsFinished ) {
            try {
                if ( !display.readAndDispatch( ) ) {
                    display.sleep( );
                }
            } catch ( SWTException ex ) {
//                Activator.log( IStatus.ERROR, "An SWTException ocurred during waiting for the tests being finished in thread: " + Thread.currentThread( ).getName( ), ex );
                /*
                 * Do nothing: rethrowing errors leads to premature end of the
                 * WorkbenchTestable thread and the IDE subsequently not being
                 * shut down.
                 */
            } catch ( RuntimeException ex ) {
//                Activator.log( IStatus.ERROR, "A RuntimeException ocurred during waiting for the tests being finished in thread: " + Thread.currentThread( ).getName( ), ex );
            }
        }
    }

    /**
     * Closes all shells when finished.
     */
    private void runFinished( ) {

        Runnable closeShells = new Runnable( ) {

            public void run( ) {

                Shell[] openShells = display.getShells( );
                for ( Shell s : openShells ) {
                    if ( !MoinThreadSwitchHelper.this.startShells.contains( s ) ) {
                        MoinThreadSwitchHelper.closeShells( new Shell[] { s } );
                    }
                }
                //TODO close all open stuff eg. menues etc.
            }
        };
        display.syncExec( closeShells );
    }

    /**
     * Closes all shells and child shells of the given array recursively.
     * <p>
     * This is called after each TestCase to guarantee that no (blocking)
     * dialogs are still open. Does currently not work perfect and it is thus
     * highly recommended that this is done properly in TestCase.tearDown().
     * 
     * @param shells the shells to close.
     */
    private static void closeShells( final Shell[] shells ) {

        for ( int i = 0; i < shells.length; i++ ) {
            if ( !shells[i].isDisposed( ) ) {
                closeShells( shells[i].getShells( ) );
            }
            if ( !shells[i].isDisposed( ) ) {
                shells[i].close( );
                //shells[i].dispose();
            }
        }
    }

    public static void ensureExecutionInNonUIThread( RunnerProxy runner, RunNotifier notifier ) {

        // check if we are in a UI thread
//        if ( Display.getDefault( ).getThread( ) == Thread.currentThread( ) ) {
        if ( Display.getCurrent( ) != null ) {
            new MoinThreadSwitchHelper( runner ).run( notifier );
        } else {
            runner.realRun( notifier );
        }
    }
}
