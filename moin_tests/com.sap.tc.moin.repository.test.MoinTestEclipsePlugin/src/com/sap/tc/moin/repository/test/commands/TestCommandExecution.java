package com.sap.tc.moin.repository.test.commands;

import org.junit.Test;

import com.sap.tc.moin.repository.core.commands.InternalExecutableCommand;

public class TestCommandExecution extends BaseCommandTest {

    /**
     * Test that doExecute is actually called when executing the command Test
     * that undo and redo of the Tx is called when undoing redoing the command
     */
    @Test
    public void testCommandExecutionUndoRedo( ) {

        stack.clear( );

        EmptyCommand cmd1 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand1" );
        InternalExecutableCommand ic = (InternalExecutableCommand) stack.execute( cmd1 );
        assertEqualsAndContinue( "Command execution times", cmd1.nOExecutions, 1 );

        assertNotEqualsAndContinue( "Command Handle after execution", ic, null );
        assertEqualsAndContinue( "InternalCommand state after execute", ic.getState( ), InternalExecutableCommand.CommandState.DONE );
        // if (mem!=null) {
        // assertEqualsAndContinue("EventManager state after execute", mem.getState(), EMState.POSTCOMMITTED);
        // }

        stack.undo( );
        assertEqualsAndContinue( "InternalCommand state after undo", ic.getState( ), InternalExecutableCommand.CommandState.UNDONE );
        // if (mem!=null) {
        // assertEqualsAndContinue("EventManager state after undo", mem.getState(), EMState.POSTCOMMITTED);
        // }

        stack.redo( );
        assertEqualsAndContinue( "InternalCommand state after redo", ic.getState( ), InternalExecutableCommand.CommandState.DONE );
        // if (mem!=null) {
        // assertEqualsAndContinue("EventManager state after redo", mem.getState(), EMState.POSTCOMMITTED);
        // }
    };

    /**
     * Test that by composite commands, all commands are executed Test that undo
     * and redo of the Tx is called when undoing redoing the command
     */
    @Test
    public void testCompositeCommandExecution( ) {

        stack.clear( );

        CompositeCommandOfEmpties cmd1 = new CompositeCommandOfEmpties( this.getMOINConnection( ) );
        InternalExecutableCommand ic = (InternalExecutableCommand) cmd1.execute( );
        assertEqualsAndContinue( "Command executions", cmd1.nOExecutions, 1 );
        assertEqualsAndContinue( "1. Sub Command executions", cmd1.ec1.nOExecutions, 1 );
        assertEqualsAndContinue( "2. Sub Command executions", cmd1.ec2.nOExecutions, 1 );
        assertEqualsAndContinue( "3. Sub Command executions", cmd1.ec3.nOExecutions, 1 );

        assertNotEqualsAndContinue( "Command Handle after execution", ic, null );
        assertEqualsAndContinue( "InternalCommand state after execute", ic.getState( ), InternalExecutableCommand.CommandState.DONE );

        stack.undo( );
        assertEqualsAndContinue( "InternalCommand state after undo", ic.getState( ), InternalExecutableCommand.CommandState.UNDONE );

        stack.redo( );
        assertEqualsAndContinue( "InternalCommand state after redo", ic.getState( ), InternalExecutableCommand.CommandState.DONE );

    };

    /**
     * Test that by composite commands, when there is an exception, that the
     * partially executed parts are reverted
     */
    @Test
    public void testCompositeCommandException( ) {

        stack.clear( );

        CompositeCommandWithError cmd1 = new CompositeCommandWithError( this.getMOINConnection( ) );
        InternalExecutableCommand ic = null;
        try {
            ic = (InternalExecutableCommand) cmd1.execute( );
            this.assertTrueAndContinue( "No exception thrown by CompositeCommandWithError execution", false );
        } catch ( RuntimeException rte ) {
            // Continue
        }
        // TODO: Check that partially executed commands were reverted!

        // Check that subcommands before error were executed
        assertEqualsAndContinue( "Command executions", cmd1.nOExecutions, 1 );
        assertEqualsAndContinue( "1. Sub Command executions", cmd1.ec1.nOExecutions, 1 );
        assertEqualsAndContinue( "2. Sub Command executions", cmd1.ec2.nOExecutions, 1 );
        assertEqualsAndContinue( "3. Sub Command executions", cmd1.ec3.nOExecutions, 1 );

        // Check Internal Commands state
        assertEqualsAndContinue( "Command Handle after execution with error", ic, null );
        // if (mem!=null) {
        // assertEqualsAndContinue("EventManager state after execute w/error", mem.getState(), EMState.CANCELLED);
        // }

    };

    /**
     * Test execution of deep composite commands
     */
    @Test
    public void testDeepCompositeCommandExecution( ) {

        stack.clear( );

        DeepCompositeCommand cmd1 = new DeepCompositeCommand( this.getMOINConnection( ) );
        InternalExecutableCommand ic = (InternalExecutableCommand) stack.execute( cmd1 );
        assertEqualsAndContinue( "Command executions", cmd1.nOExecutions, 1 );
        assertEqualsAndContinue( "1. Sub Command executions", cmd1.sub1NOExecutions, 1 );
        assertEqualsAndContinue( "2a. Sub Command executions", cmd1.sub2ANOExecutions, 1 );
        assertEqualsAndContinue( "2b. Sub Command executions", cmd1.sub2BNOExecutions, 1 );
        assertEqualsAndContinue( "3. Sub Command executions", cmd1.sub3NOExecutions, 1 );

        assertNotEqualsAndContinue( "Command Handle null after execution", ic, null );
        assertEqualsAndContinue( "InternalCommand bad state after execute", ic.getState( ), InternalExecutableCommand.CommandState.DONE );

        stack.undo( );
        assertEqualsAndContinue( "InternalCommand bad state after undo", ic.getState( ), InternalExecutableCommand.CommandState.UNDONE );

        stack.redo( );
        assertEqualsAndContinue( "InternalCommand bad state after redo", ic.getState( ), InternalExecutableCommand.CommandState.DONE );

    };

    /**
     * Test command group composition
     */
    @Test
    public void testCommandGroupComposition( ) {

        stack.clear( );
        EmptyCommand cmd1 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand1" );
        stack.execute( cmd1 );

        stack.openGroup( "TestGroup" );

        EmptyCommand cmd2 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand2" );
        stack.execute( cmd2 );

        stack.openGroup( "TestSubGroup" );

        EmptyCommand cmd3a = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand3a" );
        stack.execute( cmd3a );
        EmptyCommand cmd3b = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand3b" );
        stack.execute( cmd3b );

        stack.closeGroup( );

        EmptyCommand cmd4 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand4" );
        stack.execute( cmd4 );

        stack.closeGroup( );

        assertEqualsAndContinue( "Command cmd1 executions", cmd1.nOExecutions, 1 );
        assertEqualsAndContinue( "Command cmd2 executions", cmd2.nOExecutions, 1 );
        assertEqualsAndContinue( "Command cmd3a executions", cmd3a.nOExecutions, 1 );
        assertEqualsAndContinue( "Command cmd3b executions", cmd3b.nOExecutions, 1 );
        assertEqualsAndContinue( "Command cmd4 executions", cmd4.nOExecutions, 1 );
    }

}
