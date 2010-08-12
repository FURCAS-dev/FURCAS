package com.sap.ide.refactoring.core.execution;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import com.sap.ide.refactoring.core.RefactoringCoreException;
import com.sap.ide.refactoring.core.execution.CommandUndoRedoHelper;
import com.sap.ide.refactoring.test.RefactoringBaseTest;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.PartitionOperation;


public class TestCommandUndoRedoHelper extends RefactoringBaseTest {


    private static class NullCommand extends Command {
	protected NullCommand(Connection connection, String description) {
	    super(connection, description);
	}
	@Override
	public boolean canExecute() {
	    return true;
	}
	@Override
	public void doExecute() {
	   // do nothing
	}
	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
	    return Collections.emptyList();
	}
	@Override
	public String toString() {
	    return "CMD<"+getDescription()+">";
	}
    }

    /**
     * System under test
     */
    private CommandUndoRedoHelper sut;

    @Before
    public void setup() {
	sut = new CommandUndoRedoHelper(connection);
    }

    @Test
    public void testInitialEmptyStacks() {
	assertNull("Undo stack must be empty", sut.peekUndoStack());
	assertNull("Redo stack must be empty", sut.peekRedoStack());
    }

    @Test
    public void testPeekStacks() {
	Command cmd1 = new NullCommand(connection, "1");
	Command cmd2 = new NullCommand(connection, "2");
	Command cmd3 = new NullCommand(connection, "3");

	CommandHandle handle1 = cmd1.execute();
	CommandHandle handle2 = cmd2.execute();
	CommandHandle handle3 = cmd3.execute();

	assertEquals("Last executed command must be ontop of the undo stack", handle3, sut.peekUndoStack());
	connection.getCommandStack().undo(); // undo handle 3
	assertEquals("Just undone command must be ontop of the redo stack", handle3, sut.peekRedoStack());
	connection.getCommandStack().undo(); // undo handle 2
	assertEquals("Just undone command must be ontop of the redo stack", handle2, sut.peekRedoStack());
	connection.getCommandStack().undo(); // undo handle 1
	assertEquals("UndoStack must no be empty", null, sut.peekUndoStack());
	assertEquals("Just undone command must be ontop of the redo stack", handle1, sut.peekRedoStack());

	connection.getCommandStack().redo();
	assertEquals("Redone cmd must now be on the undo stack", handle1, sut.peekUndoStack());

    }

    @Test
    public void testUndoSingleCommand() throws RefactoringCoreException {
	Command cmd = new NullCommand(connection, "A Refactoring");
	CommandHandle handle = cmd.execute();
	sut.undoRefactoring(handle);
	assertNull("Undo stack must be empty", sut.peekUndoStack());
	assertEquals(sut.peekRedoStack(),  handle);
    }

    @Test
    public void testRedoSingleCommand() throws RefactoringCoreException {
	Command cmd = new NullCommand(connection, "A Refactoring");
	CommandHandle handle = cmd.execute();
	sut.undoRefactoring(handle);
	sut.redoRefactoring(handle);
	assertNull("Redo stack must be empty", sut.peekRedoStack());
	assertEquals(sut.peekUndoStack(),  handle);
    }

    @Test
    public void testUndoSeveralCommands() throws RefactoringCoreException {
	Command cmd1 = new NullCommand(connection, "A Refactoring");
	Command cmd2 = new NullCommand(connection, "Triggered follow-up (1)");
	Command cmd3 = new NullCommand(connection, "Triggered follow-up (2)");

	CommandHandle handle1 = cmd1.execute();
	cmd2.execute();
	cmd3.execute();

	sut.undoRefactoring(handle1);
	assertEquals(sut.peekRedoStack(),  handle1);
	assertNull("There can't be anything more to undo", sut.peekUndoStack());
    }

    @Test
    public void testUndoRedoSeveralCommandsInContext() throws RefactoringCoreException {
	Command cmd0 = new NullCommand(connection, "Some other command (a)");
	Command cmd1 = new NullCommand(connection, "A Refactoring");
	Command cmd2 = new NullCommand(connection, "Triggered follow-up (1)");
	Command cmd3 = new NullCommand(connection, "Triggered follow-up (2)");
	Command cmd4 = new NullCommand(connection, "Triggered follow-up (3)");
	Command cmd5 = new NullCommand(connection, "Some other command (b)");


	CommandHandle oldOtherHandle = cmd0.execute();
	CommandHandle handle1 = cmd1.execute();
	cmd2.execute();
	cmd3.execute();
	CommandHandle handle4 = cmd4.execute();
	CommandHandle newOtherHandle = cmd5.execute();

	sut.undoRefactoring(handle1);
	assertEquals(sut.peekRedoStack(), handle1);
	assertEquals(sut.peekUndoStack(), oldOtherHandle);

	sut.redoRefactoring(handle4);
	assertEquals(sut.peekRedoStack(),  newOtherHandle);
	assertEquals(sut.peekUndoStack(), handle4);
    }

}
