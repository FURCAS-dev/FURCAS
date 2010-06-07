package com.sap.ide.refactoring.core;

import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.CommandStack;

public abstract class TextBlockAwareRefactoringCommand extends Command {

    protected RefactoringEditorFacade facade;

    private String preExecutionText;
    private String postExecutionText;
    private RefactoringResult result;

    private CommandHandle selfExecutionHandle;

    public TextBlockAwareRefactoringCommand(RefactoringEditorFacade facade, String description) {
	super(facade.getConnection(), description);
	this.facade = facade;
    }

    /**
     * Do what is necessary so that {@link #getTextualPostExecutionRepresentation()} reflects the desired changes.
     *
     * @return A change object describing the performed changes.
     * The workspace remains unchanged until {@link Change#perform} is called.
     */
    public RefactoringResult runRefactoringForPreview() {
	System.out.println("-- Enter preview routine");
	// Execute this refactoring to generate and gather the preview content
	// Afterwards rollback the command, including all automatically, subsequently issued
	// commands like the delayed reference re-resolving
	runRefactoring();

	CommandStack stack = facade.getConnection().getCommandStack();

	CommandHandle lastUndoneCmd = null;
	while (stack.canUndo() && !selfExecutionHandle.equals(lastUndoneCmd)) {
	    lastUndoneCmd = stack.getUndoStack().get(stack.getUndoStack().size()-1);
	    System.out.println("   Undo refactoring: " + lastUndoneCmd.getDescription());
	    stack.undo();
	}

	if (lastUndoneCmd != selfExecutionHandle) {
	    throw new RefactoringCoreException("Unable to undo refactoring command issued for preview.");
	}

	// provide our caller with the previously gathered preview information
	System.out.println("-- Exit preview routine");
	return result;
    }

    /**
     * Perform the refactoring and apply it to the workspace.
     *
     */
    public RefactoringResult runRefactoring() {
	System.out.println("   Run refactoring: " + this.getDescription());
	selfExecutionHandle = facade.getConnection().getCommandStack().execute(this);
	assert result != null : "Refactoring command must provide result";
	return result;
    }

    /**
     * Called by the MOIN command system when the command is run.
     * Do not run this directly!.
     */
    @Override
    public void doExecute() {
	preExecutionText = facade.getContentAsText();
	performRefactoring();
	RefactoringStatus status = validateChanges();
	Change change = createChange();
	postExecutionText = facade.getContentAsText();
	result = new RefactoringResult(change, status);
    }

    /**
     * Do everything that is needed to transform the domain and the textblocks model.
     * This is run within the command context.
     */
    protected abstract void performRefactoring();

    /**
     * Post-Validate the performed changes (e.g. show warning due to potential name conflicts).
     * This is run within the command context; immediately before {@link #createChange()}.
     */
    protected abstract RefactoringStatus validateChanges();

    /**
     * Change Factory Method. Can be subclassed by clients if needed.
     * This is run within the command context; immediately after {@link #validateChanges()}
     */
    protected Change createChange() {
	return new TextBlockAwareModelChange(facade, this);
    }

    public String getTextualPreExecutionRepresentation() {
        return preExecutionText;
    }

    public String getTextualPostExecutionRepresentation() {
        return postExecutionText;
    }

}
