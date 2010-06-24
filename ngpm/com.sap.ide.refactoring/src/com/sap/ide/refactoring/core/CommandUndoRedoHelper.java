package com.sap.ide.refactoring.core;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.CommandStack;

/**
 * Helper class used undo/redo sequences of commands.
 * 
 * Used by the {@link TextBlockAwareRefactoringCommandExecutor} to be able to not just undo a single
 * refactoring command, but to also undo all automatically triggered subsequent commands (e.g. pretty printing
 * or reference re-evalautions)
 * 
 * @author D049157
 *
 */
public class CommandUndoRedoHelper {

    private final Connection connection;

    public CommandUndoRedoHelper(Connection connection) {
	this.connection = connection;
    }
    
    public void undoRefactoring(CommandHandle handle) {
	undoRefactoring(handle, new NullProgressMonitor());
    }

    public void undoRefactoring(CommandHandle handle, IProgressMonitor pm) {
	if (handle == null) {
	    return;
	}
	CommandStack stack = connection.getCommandStack();
	pm.beginTask("Undo Refactoring Commands", stack.getUndoStack().size());
	CommandHandle lastUndoneCmd = null;
	while (stack.canUndo() && !handle.equals(lastUndoneCmd)) {
	    lastUndoneCmd = peekUndoStack();
	    System.out.println("   Undo refactoring: " + lastUndoneCmd.getDescription());
	    stack.undo();
	    pm.worked(1);
	}
	pm.done();

	if (lastUndoneCmd == null) {
	    throw new RefactoringCoreException("There was no command to undo");
	}

	if (lastUndoneCmd != handle) {
	    throw new RefactoringCoreException("Unable to undrefactoring command." +
		    	"Expected <" + handle.getDescription() + "> somehwere in the Undo stack. But last und-doable command was <" + lastUndoneCmd.getDescription() +">");
	}
    }

    public CommandHandle peekUndoStack() {
	CommandStack stack = connection.getCommandStack();
	if (stack.canUndo()) {
	    return stack.getUndoStack().get(stack.getUndoStack().size()-1);
	} else {
	    return null;
	}
    }
    
    public void redoRefactoring(CommandHandle handle) {
	redoRefactoring(handle, new NullProgressMonitor());
    }

    public void redoRefactoring(CommandHandle handle, IProgressMonitor pm) {
	CommandStack stack = connection.getCommandStack();
	pm.beginTask("Re-apply Refactoring Commands", stack.getRedoStack().size());
	
	CommandHandle lastRedoneCmd = null;
	while (stack.canRedo() && !handle.equals(lastRedoneCmd)) {
	    lastRedoneCmd = peekRedoStack();
	    System.out.println("   Redo refactoring: " + lastRedoneCmd.getDescription());
	    stack.redo();
	    pm.worked(1);
	};
	pm.done();
	
	if (lastRedoneCmd == null) {
	    throw new RefactoringCoreException("There was no command to redo");
	}
	if (lastRedoneCmd != handle) {
	    throw new RefactoringCoreException("Unable to re-apply refactoring command." +
	    	"Expected <" + handle.getDescription() + "> ontop of the Redo stack. But last re-doable command was <" + lastRedoneCmd.getDescription() +">");
	}
    }

    public CommandHandle peekRedoStack() {
	CommandStack stack = connection.getCommandStack();
	if (stack.canRedo()) {
	    return stack.getRedoStack().get(stack.getRedoStack().size()-1);
	} else {
	    return null;
    	}
    }


}
