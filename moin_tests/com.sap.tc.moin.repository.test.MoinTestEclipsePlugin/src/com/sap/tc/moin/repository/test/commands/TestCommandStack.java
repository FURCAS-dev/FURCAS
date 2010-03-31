/**
 * 
 */
package com.sap.tc.moin.repository.test.commands;

import java.util.Collection;

import org.junit.Test;

import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.core.commands.CommandStackImpl;



/**
 * @author d045996
 */
public class TestCommandStack extends BaseCommandTest {


    private boolean canStackUndo( CommandStack stack, CommandHandle cmd ) {

        if ( stack.getUndoStack( ).size( ) == 0 ) {
            return false;
        }
        return stack.getUndoStack( ).get( stack.getUndoStack( ).size( ) - 1 ) == cmd;
    }

    private boolean canStackRedo( CommandStack stack, CommandHandle cmd ) {

        if ( stack.getRedoStack( ).size( ) == 0 ) {
            return false;
        }
        return stack.getRedoStack( ).get( stack.getRedoStack( ).size( ) - 1 ) == cmd;
    }

    /**
     * Test if successfully executed commands go into the undo stack And move to
     * the redo stack after undo And back to the undo stack after redo
     */
    @Test
    public void testUndoRedoStack( ) {

        stack.clear( );
        assertFalseAndContinue( "canUndo() after clear()", stack.canUndo( ) );
        assertFalseAndContinue( "canRedo() after clear()", stack.canRedo( ) );

        EmptyCommand cmd1 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand1" );
        CommandHandle cmd1h = stack.execute( cmd1 );
        assertTrueAndContinue( "canUndo() after executing cmd1", stack.canUndo( ) );
        assertTrueAndContinue( "canUndo(cmd1) after executing cmd1", canStackUndo( stack, cmd1h ) );
        assertFalseAndContinue( "canRedo() after executing cmd1", stack.canRedo( ) );
        assertFalseAndContinue( "canRedo(cmd1) after executing cmd1", canStackRedo( stack, cmd1h ) );

        EmptyCommand cmd2 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand2" );
        CommandHandle cmd2h = stack.execute( cmd2 );
        assertTrueAndContinue( "canUndo() after executing cmd2", stack.canUndo( ) );
        assertFalseAndContinue( "canUndo(cmd1) after executing cmd2", canStackUndo( stack, cmd1h ) );
        assertTrueAndContinue( "canUndo(cmd2) after executing cmd2", canStackUndo( stack, cmd2h ) );
        assertFalseAndContinue( "canRedo() after executing cmd2", stack.canRedo( ) );
        assertFalseAndContinue( "canRedo(cmd1) after executing cmd2", canStackRedo( stack, cmd1h ) );
        assertFalseAndContinue( "canRedo(cmd2) after executing cmd2", canStackRedo( stack, cmd2h ) );

        // Test Undo
        stack.undo( );
        assertTrueAndContinue( "canUndo() after undoing cmd2", stack.canUndo( ) );
        assertTrueAndContinue( "canUndo(cmd1) after undoing cmd2", canStackUndo( stack, cmd1h ) );
        assertFalseAndContinue( "canUndo(cmd2) after undoing cmd2", canStackUndo( stack, cmd2h ) );
        assertTrueAndContinue( "canRedo() after undoing cmd2", stack.canRedo( ) );
        assertFalseAndContinue( "canRedo(cmd1) after undoing cmd2", canStackRedo( stack, cmd1h ) );
        assertTrueAndContinue( "canRedo(cmd2) after undoing cmd2", canStackRedo( stack, cmd2h ) );

        // Test Redo
        stack.redo( );
        assertTrueAndContinue( "canUndo() after redoing cmd2", stack.canUndo( ) );
        assertFalseAndContinue( "canUndo(cmd1) after redoing cmd2", canStackUndo( stack, cmd1h ) );
        assertTrueAndContinue( "canUndo(cmd2) after redoing cmd2", canStackUndo( stack, cmd2h ) );
        assertFalseAndContinue( "canRedo() after redoing cmd2", stack.canRedo( ) );
        assertFalseAndContinue( "canRedo(cmd1) after redoing cmd2", canStackRedo( stack, cmd1h ) );
        assertFalseAndContinue( "canRedo(cmd2) after redoing cmd2", canStackRedo( stack, cmd2h ) );

        // Test Undo(cmd)
        stack.undo( );
        stack.undo( );
        assertFalseAndContinue( "canUndo() after undoing cmd1", stack.canUndo( ) );
        assertFalseAndContinue( "canUndo(cmd1) after undoing cmd1", canStackUndo( stack, cmd1h ) );
        assertFalseAndContinue( "canUndo(cmd2) after undoing cmd1", canStackUndo( stack, cmd2h ) );
        assertTrueAndContinue( "canRedo() after undoing cmd1", stack.canRedo( ) );
        assertTrueAndContinue( "canRedo(cmd1) after undoing cmd1", canStackRedo( stack, cmd1h ) );
        assertFalseAndContinue( "canRedo(cmd2) after undoing cmd1", canStackRedo( stack, cmd2h ) );

        // Test Redo(cmd2)
        stack.redo( );
        stack.redo( );
        assertTrueAndContinue( "canUndo() after undoing cmd2", stack.canUndo( ) );
        assertFalseAndContinue( "canUndo(cmd1) after undoing cmd2", canStackUndo( stack, cmd1h ) );
        assertTrueAndContinue( "canUndo(cmd2) after undoing cmd2", canStackUndo( stack, cmd2h ) );
        assertFalseAndContinue( "canRedo() after undoing cmd2", stack.canRedo( ) );
        assertFalseAndContinue( "canRedo(cmd1) after undoing cmd2", canStackRedo( stack, cmd1h ) );
        assertFalseAndContinue( "canRedo(cmd2) after undoing cmd2", canStackRedo( stack, cmd2h ) );

        // Test clear of redo stack when executing a cmd3
        stack.undo( );
        EmptyCommand cmd3 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand3" );
        CommandHandle cmd3h = stack.execute( cmd3 );
        assertTrueAndContinue( "canUndo() after executing cmd3", stack.canUndo( ) );
        assertFalseAndContinue( "canUndo(cmd1) after executing cmd3", canStackUndo( stack, cmd1h ) );
        assertFalseAndContinue( "canUndo(cmd2) after executing cmd3", canStackUndo( stack, cmd2h ) );
        assertTrueAndContinue( "canUndo(cmd3) after executing cmd3", canStackUndo( stack, cmd3h ) );
        assertFalseAndContinue( "canRedo() after executing cmd3", stack.canRedo( ) );
        assertFalseAndContinue( "canRedo(cmd1) after executing cmd3", canStackRedo( stack, cmd1h ) );
        assertFalseAndContinue( "canRedo(cmd2) after executing cmd3", canStackRedo( stack, cmd2h ) );
        assertFalseAndContinue( "canRedo(cmd3) after executing cmd3", canStackRedo( stack, cmd3h ) );

        // Test MaxUndoStackSize
        stack.setMaxUndoStackSize( 3 );
        EmptyCommand cmd4 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand4" );
        CommandHandle cmd4h = stack.execute( cmd4 );
        EmptyCommand cmd5 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand5" );
        CommandHandle cmd5h = stack.execute( cmd5 );
        assertTrueAndContinue( "canUndo() after executing cmd4&cmd5", stack.canUndo( ) );
        assertFalseAndContinue( "canUndo(cmd1) after executing cmd4&cmd5", canStackUndo( stack, cmd1h ) );
        assertFalseAndContinue( "canUndo(cmd2) after executing cmd4&cmd5", canStackUndo( stack, cmd2h ) );
        assertFalseAndContinue( "canUndo(cmd3) after executing cmd4&cmd5", canStackUndo( stack, cmd3h ) );
        assertFalseAndContinue( "canUndo(cmd4) after executing cmd4&cmd5", canStackUndo( stack, cmd4h ) );
        assertTrueAndContinue( "canUndo(cmd5) after executing cmd4&cmd5", canStackUndo( stack, cmd5h ) );
        assertFalseAndContinue( "canRedo() after executing cmd4&cmd5", stack.canRedo( ) );

        // Verify exact content of stacks!
        assertEqualsAndContinue( "Undo Stack Size after executing cmd4&cmd5", stackImpl.getUndoStackContent( ).size( ), 3 );
        assertEqualsAndContinue( "Redo Stack Size after executing cmd4&cmd5", stackImpl.getRedoStackContent( ).size( ), 0 );

        stack.clear( );
        assertFalseAndContinue( "canUndo() after clear()", stack.canUndo( ) );
        assertFalseAndContinue( "canRedo() after clear()", stack.canRedo( ) );

    };

    /**
     * Test that an unexecutable command never ends in the stack
     */
    @Test
    public void testUnexecutableCommandInStack( ) {

        stack.clear( );
        assertFalseAndContinue( "canUndo() after clear()", stack.canUndo( ) );
        assertFalseAndContinue( "canRedo() after clear()", stack.canRedo( ) );

        UnexecutableCommand cmd1 = new UnexecutableCommand( this.getMOINConnection( ) );
        CommandHandle cmd1h = null;
        try {
            cmd1h = stack.execute( cmd1 );
            this.assertTrueAndContinue( "No exception thrown by UnexecutableCommand execution", false );
        } catch ( RuntimeException rte ) {
            // Continue
        }
        assertFalseAndContinue( "canUndo() after executing UnexecutableCommand", stack.canUndo( ) );
        assertFalseAndContinue( "canUndo(cmd1) after executing UnexecutableCommand", canStackUndo( stack, cmd1h ) );
        assertFalseAndContinue( "canRedo() after executing UnexecutableCommand", stack.canRedo( ) );
        assertFalseAndContinue( "canRedo(cmd1) after executing UnexecutableCommand", canStackRedo( stack, cmd1h ) );

        // Verify exact content of stacks!
        assertEqualsAndContinue( "Undo Stack Size after executing UnexecutableCommand", stackImpl.getUndoStackContent( ).size( ), 0 );
        assertEqualsAndContinue( "Redo Stack Size after executing UnexecutableCommand", stackImpl.getRedoStackContent( ).size( ), 0 );
    };

    /**
     * Test that by composite commands, only the outermost ends in the stack
     */
    @Test
    public void testCompositeCommandInStack( ) {

        stack.clear( );

        CompositeCommandOfEmpties cmd1 = new CompositeCommandOfEmpties( this.getMOINConnection( ) );
        CommandHandle cmd1h = stack.execute( cmd1 );
        assertTrueAndContinue( "canUndo() after executing cmd1", stack.canUndo( ) );
        assertTrueAndContinue( "canUndo(cmd1) after executing cmd1", canStackUndo( stack, cmd1h ) );
        assertFalseAndContinue( "canRedo() after executing cmd1", stack.canRedo( ) );
        assertFalseAndContinue( "canRedo(cmd1) after executing cmd1", canStackRedo( stack, cmd1h ) );

        // Verify exact content of stacks!
        assertEqualsAndContinue( "Undo Stack Size after executing composite", stackImpl.getUndoStackContent( ).size( ), 1 );
        assertEqualsAndContinue( "Redo Stack Size after executing composite", stackImpl.getRedoStackContent( ).size( ), 0 );

    };

    /**
     * Test that by composite commands with error, nothing ends in the stack
     */
    @Test
    public void testCompositeCommandWithErrorInStack( ) {

        stack.clear( );

        CompositeCommandWithError cmd1 = new CompositeCommandWithError( this.getMOINConnection( ) );
        CommandHandle cmd1h = null;
        try {
            cmd1h = stack.execute( cmd1 );
            this.assertTrueAndContinue( "No exception thrown by UnexecutableCommand execution", false );
        } catch ( RuntimeException rte ) {
            // Continue
        }

        assertFalseAndContinue( "canUndo() after executing composite w/error", stack.canUndo( ) );
        assertFalseAndContinue( "canUndo(cmd1) after executing composite w/error", canStackUndo( stack, cmd1h ) );
        assertFalseAndContinue( "canRedo() after executing composite w/error", stack.canRedo( ) );
        assertFalseAndContinue( "canRedo(cmd1) after executing composite w/error", canStackRedo( stack, cmd1h ) );

        // Verify exact content of stacks!
        assertEqualsAndContinue( "Undo Stack Size executing composite w/error", stackImpl.getUndoStackContent( ).size( ), 0 );
        assertEqualsAndContinue( "Redo Stack Size executing composite w/error", stackImpl.getRedoStackContent( ).size( ), 0 );

    };

    /**
     * Test that after closing a command group, only the group end in the stack,
     * and can be undone/redone
     */
    @Test
    public void testCommandGroupInStack( ) {

        stack.clear( );
        stack.openGroup( "TestGroup" );
        EmptyCommand cmd1 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand1" );
        stack.execute( cmd1 );
        EmptyCommand cmd2 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand2" );
        stack.execute( cmd2 );

        CommandHandle grp = stack.closeGroup( );

        assertTrueAndContinue( "canUndo() after closing group", stack.canUndo( ) );
        assertTrueAndContinue( "canUndo(grp) after closing group", canStackUndo( stack, grp ) );
        assertFalseAndContinue( "canRedo() after closing group", stack.canRedo( ) );
        assertFalseAndContinue( "canRedo(grp) after closing group", canStackRedo( stack, grp ) );

        // Verify exact content of stacks!
        assertEqualsAndContinue( "Undo Stack Size after closing group", stackImpl.getUndoStackContent( ).size( ), 1 );
        assertEqualsAndContinue( "Redo Stack Size after closing group", stackImpl.getRedoStackContent( ).size( ), 0 );

    }

    /**
     * Test undo/redo stacks of the command group (when it is open)
     */
    @Test
    public void testOpenCommandGroupStack( ) {

        stack.clear( );
        EmptyCommand cmd1 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand1" );
        CommandHandle cmd1h = stack.execute( cmd1 );
        EmptyCommand cmd2 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand2" );
        CommandHandle cmd2h = stack.execute( cmd2 );
        EmptyCommand cmd3 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand3" );
        CommandHandle cmd3h = stack.execute( cmd3 );
        stack.undo( );

        stack.openGroup( "TestGroup" );
        EmptyCommand cmd4 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand4" );
        CommandHandle cmd4h = stack.execute( cmd4 );

        stack.undo( );
        // Verify exact content of stacks!
        assertEqualsAndContinue( "Undo Stack Size in group", stackImpl.getUndoStackContent( ).size( ), 0 );
        assertEqualsAndContinue( "Redo Stack Size in group", stackImpl.getRedoStackContent( ).size( ), 1 );

        stack.redo( );

        CommandHandle grp = stack.closeGroup( );

        assertEqualsAndContinue( "Undo Stack Size after closing group", stackImpl.getUndoStackContent( ).size( ), 3 );
        assertEqualsAndContinue( "Redo Stack Size after closing group", stackImpl.getRedoStackContent( ).size( ), 0 );
    }

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

        // Verify exact content of stacks!
        assertEqualsAndContinue( "Undo Stack Size in group", stackImpl.getUndoStackContent( ).size( ), 2 );
        assertEqualsAndContinue( "Redo Stack Size in group", stackImpl.getRedoStackContent( ).size( ), 0 );

        CommandHandle subGrp = stack.closeGroup( );

        EmptyCommand cmd4 = new EmptyCommand( this.getMOINConnection( ), "EmptyCommand4" );
        stack.execute( cmd4 );

        // Verify exact content of stacks!
        assertEqualsAndContinue( "Undo Stack Size in group", stackImpl.getUndoStackContent( ).size( ), 3 );
        assertEqualsAndContinue( "Redo Stack Size in group", stackImpl.getRedoStackContent( ).size( ), 0 );

        CommandHandle grp = stack.closeGroup( );

        // Verify exact content of stacks!
        assertEqualsAndContinue( "Undo Stack Size in group", stackImpl.getUndoStackContent( ).size( ), 2 );
        assertEqualsAndContinue( "Redo Stack Size in group", stackImpl.getRedoStackContent( ).size( ), 0 );

    }


    /**
     * Test command group composition
     */
    @Test
    public void testIsCommandRunningInCurrentThread( ) {

        // Before check: No Command running
        assertFalse( CommandStackImpl.isCommandRunningInCurrentThread( ) );
        Command cmd1 = new Command( this.getMOINConnection( ), "EmptyCommand1" ) {

            @Override
            public boolean canExecute( ) {

                return false;
            }

            @Override
            public void doExecute( ) {

                // Inside check: Command is running
                assertTrue( CommandStackImpl.isCommandRunningInCurrentThread( ) );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        stack.execute( cmd1 );
        // After check: No Command running
        assertFalse( CommandStackImpl.isCommandRunningInCurrentThread( ) );

        stack.openGroup( "TestGroup" );
        // Check in CommandGroup: No Command running
        assertFalse( CommandStackImpl.isCommandRunningInCurrentThread( ) );
        stack.closeGroup( );
    }

    /**
     * Test command group composition
     */
    @Test
    public void testIsCommandRunning( ) {

        final CommandStack commandStack = getMOINConnection( ).getCommandStack( );
        // Before check: No Command running
        assertFalse( commandStack.isCommandRunning( ) );
        Command cmd1 = new Command( this.getMOINConnection( ), "EmptyCommand1" ) {

            @Override
            public boolean canExecute( ) {

                return false;
            }

            @Override
            public void doExecute( ) {

                // Inside check: Command is running
                assertTrue( commandStack.isCommandRunning( ) );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        stack.execute( cmd1 );
        // After check: No Command running
        assertFalse( commandStack.isCommandRunning( ) );

        stack.openGroup( "TestGroup" );
        // Check in CommandGroup: No Command running
        assertFalse( commandStack.isCommandRunning( ) );
        stack.closeGroup( );
    }
}
