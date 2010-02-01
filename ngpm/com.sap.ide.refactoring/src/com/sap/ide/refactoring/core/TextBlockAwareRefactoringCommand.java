package com.sap.ide.refactoring.core;

import org.eclipse.ltk.core.refactoring.Change;

import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.tc.moin.repository.commands.Command;

public abstract class TextBlockAwareRefactoringCommand extends Command {

    protected RefactoringEditorFacade facade;
    private String preExecutionContent;
    private String postExecutionContent;

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
    public Change runRefactoringForPreview() {
	Change change = runRefactoring();
	
	facade.getConnection().getCommandStack().undo();	
	
	return change;
    }
    
    /**
     * Perform the refactoring and apply it to the workspace. 
     * 
     */
    public Change runRefactoring() {
	facade.getConnection().getCommandStack().execute(this);
	return createChange();
    }

    /**
     * Called by the MOIN command system when the command is run.
     */
    @Override
    public void doExecute() {
	preExecutionContent = facade.getContentAsText();
	performRefactoring();
	postExecutionContent = facade.getContentAsText();
    }
    
    /**
     * Do everything that is needed to transform the domain and the textblocks model.
     */
    protected abstract void performRefactoring();    
    
    /**
     * Change Factory Method. Can be subclassed by clients if needed. 
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
