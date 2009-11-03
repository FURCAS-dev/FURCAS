package com.sap.tc.moin.repository.test.commands;

import org.junit.Test;

import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;

public class TestExceptionHandling extends BaseCommandTest {

    @Test
    public void testCommandCancelledException( ) {

        stack.clear( );

        try {
            stack.execute( new AnonymousCommand( getMOINConnection( ), "Command1" ) {

                public void doExecute( ) {

                    stack.execute( new AnonymousCommand( getConnection( ), "Command2" ) {

                        public void doExecute( ) {

                            throw new ExecutionCancelledException( );
                        }
                    } );
                }
            } );
            assertFalseAndContinue( "No Exeption on cancelled command! ", true );
        } catch ( ExecutionCancelledException ccex ) {
            // OK!
            int i = 1;

        }
    };

    @Test
    public void testCommandExecutionException( ) {

        stack.clear( );

        try {
            stack.execute( new AnonymousCommand( getMOINConnection( ), "Command1" ) {

                public void doExecute( ) {

                    stack.execute( new AnonymousCommand( getConnection( ), "Command2" ) {

                        public void doExecute( ) {

                            throw new NullPointerException( );
                        }
                    } );
                }
            } );
            assertFalseAndContinue( "No Exeption runing command with error ", true );
        } catch ( NullPointerException ex ) {
            // OK!
            int i = 1;
        }
    };

    @Test
    public void testUnrecoverableTransactionException( ) {

        stack.clear( );

        try {
            stack.execute( new AnonymousCommand( getMOINConnection( ), "Command1" ) {

                public void doExecute( ) {

                    stack.execute( new AnonymousCommand( getConnection( ), "Command2" ) {

                        public void doExecute( ) {

                            throw new UnrecoverableExecutionException( (Throwable) null );
                        }
                    } );
                }
            } );
            assertFalseAndContinue( "No Exeption runing command with unrecoverable error!", true );
        } catch ( UnrecoverableExecutionException ccex ) {
            // OK!
            int i = 1;
        }
    };

}
