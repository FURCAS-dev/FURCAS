package com.sap.ide.refactoring.core;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class CommandUndoRedoHelper {

    private final ResourceSet connection;
    

    public CommandUndoRedoHelper(ResourceSet connection) {
	this.connection = connection;
    }

    public void undoRefactoring(CommandHandle handle) {
	if (handle == null) {
	    return;
	}
	CommandStack stack = connection.getCommandStack();
	CommandHandle lastUndoneCmd = null;
	while (stack.canUndo() && !handle.equals(lastUndoneCmd)) {
	    lastUndoneCmd = peekUndoStack();
	    System.out.println("   Undo refactoring: " + lastUndoneCmd.getDescription());
	    stack.undo();
	}

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
	CommandStack stack = connection.getCommandStack();
	CommandHandle lastRedoneCmd = null;
	while (stack.canRedo() && !handle.equals(lastRedoneCmd)) {
	    lastRedoneCmd = peekRedoStack();
	    System.out.println("   Redo refactoring: " + lastRedoneCmd.getDescription());
	    stack.redo();
	};

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
