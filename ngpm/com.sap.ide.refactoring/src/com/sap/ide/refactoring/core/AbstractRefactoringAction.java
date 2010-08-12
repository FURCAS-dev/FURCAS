package com.sap.ide.refactoring.core;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;


/**
 * Starts a refactoring and a refactoring wizard. Triggered via the editor context menu.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public abstract class AbstractRefactoringAction implements IEditorActionDelegate {

    protected Shell shell;
    protected RefactoringEditorFacade facade;

    @Override
    public void setActiveEditor(IAction action, IEditorPart targetEditor) {
	shell = null;
	facade = null;
	if (targetEditor != null && targetEditor.getSite() != null) {
	    if (targetEditor instanceof AbstractGrammarBasedEditor) {
	        AbstractGrammarBasedEditor grammarEditor = (AbstractGrammarBasedEditor) targetEditor;
	        facade = new RefactoringEditorFacade(grammarEditor);
	        shell = targetEditor.getSite().getShell();
	    }
	}
    }
    
    @Override
    public void selectionChanged(IAction action, ISelection selection) {
	// do nothing
    }

    @Override
    public void run(IAction action) {
        if (facade == null || shell == null) {
            return;
        }
        runAction(action);
    }

    /**
     * This method is called when the refactoring action is clicked.
     * It is meant to start a specific refactoring via {@link #startRefactoringWizard()}. 
     * 
     * @param action
     */
    protected abstract void runAction(IAction action);
    
    protected void startRefactoringWizard(RefactoringWizard wizard, String dialogTitle) {
	try {
	    RefactoringWizardOpenOperation operation = new RefactoringWizardOpenOperation(wizard);
	    operation.run(shell, dialogTitle);
	} catch (InterruptedException exception) {
	    // User canceled the operation. Do nothing.
	}
    }
	
 
}
