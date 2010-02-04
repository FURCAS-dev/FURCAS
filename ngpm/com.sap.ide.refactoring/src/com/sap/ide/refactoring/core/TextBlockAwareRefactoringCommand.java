package com.sap.ide.refactoring.core;

import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.CommandStack;

public abstract class TextBlockAwareRefactoringCommand extends Command {

    protected RefactoringEditorFacade facade;
    
    private String preExecutionContent;
    private String postExecutionContent;
    private RefactoringResult result;
    
    private CommandHandle selfExecutionHandle;

    public TextBlockAwareRefactoringCommand(RefactoringEditorFacade facade, String description) {
	super(facade.getConnection(), description);
	this.facade = facade;
    }
    
    /**
     * Do what is necessary so that {@link #getPostExecutionContent()} reflects the desired changes.
     * 
     * @return A change object describing the performed changes.
     * The workspace remains unchanged until {@link Change#perform} is called.
     */
    public RefactoringResult runRefactoringForPreview() {
	// Execute this refactoring and gather the preview content
	runRefactoring();
	assert result != null : "Refactoring command must provide result";
	
	// rollback the changes to the workspace
	CommandStack stack = facade.getConnection().getCommandStack();
	assert stack.getUndoStack().get(stack.getUndoStack().size()-1).equals(selfExecutionHandle) :
	    "Refacotoring must be the most recent command .";
	stack.undo();
	
	// provide our caller with the previously gathered preview information
	return result;
    }
    
    /**
     * Perform the refactoring and apply it to the workspace. 
     * 
     */
    public RefactoringResult runRefactoring() {
	selfExecutionHandle = facade.getConnection().getCommandStack().execute(this);
	return result;
    }

    /**
     * Called by the MOIN command system when the command is run.
     * Do not run this directly!.
     */
    @Override
    public void doExecute() {
	preExecutionContent = facade.getContentAsText();
	performRefactoring();
	RefactoringStatus status = validateChanges();
	Change change = createChange();
	postExecutionContent = facade.getContentAsText();
	result = new RefactoringResult(change, status);
    }
    
    /**
     * Do everything that is needed to transform the domain and the textblocks model.
     * This is run within the command context.
     */
    protected abstract void performRefactoring();      
    
    /**
     * Validate the performed changes (e.g. show warning due to potential name conflicts).
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
    
    public String getPreExecutionContent() {
        return preExecutionContent;
    }

    public String getPostExecutionContent() {
        return postExecutionContent;
    }

}
