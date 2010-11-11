package com.sap.ide.refactoring.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import com.sap.ide.refactoring.core.execution.RefactoringCommandExecutor;
import com.sap.ide.refactoring.core.execution.RefactoringResult;
import com.sap.ide.refactoring.core.execution.participation.AbstractCommandExecutionParticipant;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;

/**
 * Base class for all refactorings. Serves as a glue layer between Eclipse (see {@link Refactoring}) and
 * FURCAS/MOIN (see {@link AbstractRefactoringCommand}
 * 
 * @author Stephan Erb (d049157)
 */
public abstract class AbstractModelRefactoring extends Refactoring {

    
    protected final RefactoringEditorFacade facade;
    protected RefactoringResult refactoringResult;
    
    public AbstractModelRefactoring(RefactoringEditorFacade facade) {
	this.facade = facade;
    }

    @Override
    public RefactoringStatus checkFinalConditions(final IProgressMonitor pm) throws OperationCanceledException {
	final AbstractRefactoringCommand cmd = createExecutableRefactoringCommand();
	RefactoringCommandExecutor executor = createRefactoringCommandExecutor(cmd);
	try {
	    refactoringResult = executor.runRefactoring(pm);
	    return refactoringResult.status;
	} catch (RefactoringCoreException e) {
	    return e.asRefactoringStatus(RefactoringSeverity.FATAL);
	}
    }

    /**
     * Factoring method. Only needs to be overwritten if a refactoring desires a custom set of
     * {@link AbstractCommandExecutionParticipant}s.  
     */
    protected RefactoringCommandExecutor createRefactoringCommandExecutor(final AbstractRefactoringCommand cmd) {
	RefactoringCommandExecutor executor = new RefactoringCommandExecutor(facade, cmd);
	return executor;
    }
    
    @Override
    public Change createChange(IProgressMonitor pm) throws OperationCanceledException {
	assert refactoringResult != null : "LTK must have called checkFinalConditions atleast once.";
	return refactoringResult.change;
    }
    
    /**
     * Checks some initial conditions based on the element to be refactored
     * (e.g. check if the selected text for this refactoring is suitable)
     * 
     * The method is automatically called when the initiation refactoring wizard is opened.
     * This method might be called more than once. 
     */
    @Override
    public abstract RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws CoreException, OperationCanceledException;
    
    /**
     * Returns the command that is meant to perform the actual refactoring operations.
     * @return
     */
    protected abstract AbstractRefactoringCommand createExecutableRefactoringCommand();

}
